package com.shashwat;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

@Configuration
public class Neo4JConfig {
	
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService(final @Value("${neo4j.uri}") String neo4jUri) {
		return new SpringRestGraphDatabase(neo4jUri);
	}

}
