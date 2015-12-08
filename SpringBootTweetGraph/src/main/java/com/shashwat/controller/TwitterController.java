package com.shashwat.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shashwat.domain.Keyword;
import com.shashwat.service.GraphService;

@Controller
public class TwitterController {
	private final Twitter twitter;
    private final GraphService graphService;
    
    @Inject
    public TwitterController(Twitter twitter, GraphService graphService) {
        this.twitter = twitter;
        this.graphService = graphService;
    }
    
    @RequestMapping("/{handle}/friends")
    @ResponseBody
    public CursoredList<TwitterProfile>findFriends(@PathVariable("handle") String handle) {
    	return this.twitter.friendOperations().getFriends();
    }
    
    @RequestMapping("/keywords/relevants/{word}")
    @ResponseBody
    public Iterable<Keyword> findRelevantKeywords(@PathVariable("word") String word) {
        return graphService.findRelevantKeywords(word);
    }
    
    @RequestMapping("/keywords/top")
    @ResponseBody
    public List<Map> findTopKeywords() {
        return graphService.findTopKeywords();
    }
}
