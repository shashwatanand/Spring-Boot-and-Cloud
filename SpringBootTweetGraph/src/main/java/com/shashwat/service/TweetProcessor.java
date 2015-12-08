package com.shashwat.service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shashwat.domain.Profile;

import org.springframework.social.twitter.api.Entities;
import org.springframework.social.twitter.api.MentionEntity;
import org.springframework.social.twitter.api.Tweet;

public class TweetProcessor implements Runnable {
	private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");

	private GraphService graphService;
	private final BlockingQueue<Tweet> queue;

	public TweetProcessor(GraphService graphService, BlockingQueue<Tweet> queue) {
		this.graphService = graphService;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Tweet tweet = queue.take();
				processTweet(tweet);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void processTweet(Tweet tweetElement) {
		String lang = tweetElement.getLanguageCode();
		String text = tweetElement.getText();

		// filter non-English tweets:
		if (!"en".equals(lang)) {
			return;
		}
		
		Set<String> hashtags = hashtagsFromTweet(text);
		// filter tweets without hashtags:
        if (hashtags.isEmpty()) {
            return;
        }
        com.shashwat.domain.Tweet tweet = new com.shashwat.domain.Tweet(tweetElement.getText(), 
        		tweetElement.getCreatedAt(), tweetElement.getLanguageCode());
        Profile author = this.graphService.createProfile(tweetElement.getFromUser());
        tweet = this.graphService.createTweet(tweet);
        this.graphService.connectTweetWithAuthor(tweet, author);
        int mentions = connectTweetWithMentions(tweetElement, tweet);
        
        String[] words = connectTweetWithTags(tweet, hashtags);
        System.out.printf("%d - %d - %s%n", mentions, words.length, text);
	}

	private int connectTweetWithMentions(Tweet tweetElement,
			com.shashwat.domain.Tweet tweet) {
		int mentions = 0;
		Entities entitiles;
		if ((entitiles = tweetElement.getEntities()) != null) {
			mentions = entitiles.getMentions().size();
			for (MentionEntity mentionEntity : entitiles.getMentions()) {
				Profile profile = this.graphService.createProfile(mentionEntity.getScreenName());
				this.graphService.connectTweetWithMention(tweet, profile);
			}
		}
		return mentions;
	}

	private String[] connectTweetWithTags(com.shashwat.domain.Tweet tweet,
			Set<String> hashtags) {
		String[] words = hashtags.toArray(new String[hashtags.size()]);
		for (String word : words) {
			this.graphService.connectTweetWithTag(tweet, word);
		}
		return words;
	}

	private Set<String> hashtagsFromTweet(String text) {
		Set<String> hashtags = new HashSet<>();
		Matcher matcher = HASHTAG_PATTERN.matcher(text);
		while (matcher.find()) {
			String handle = matcher.group();
			// removing '#' prefix
            hashtags.add(handle.substring(1));
		}
		return hashtags;
	}
}
