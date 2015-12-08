package com.shashwat.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shashwat.domain.Tweet;

@RepositoryRestResource(collectionResourceRel = "tweets", path = "tweets")
public interface TweetRepository extends GraphRepository<Tweet>,
		RelationshipOperationsRepository<Tweet> {

}
