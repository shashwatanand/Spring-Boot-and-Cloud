package com.shashwat.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shashwat.domain.Profile;

@RepositoryRestResource(collectionResourceRel = "profiles", path = "profiles")
public interface ProfileRepository extends GraphRepository<Profile>, RelationshipOperationsRepository<Profile> {
    Profile findByScreenName(String screenName);
}