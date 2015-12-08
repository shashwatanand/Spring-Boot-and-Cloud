package com.shashwat.domain;

import java.util.Date;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Tweet {
	@GraphId
	Long id;
	
	private String text;
	private Date createdAt = new Date();
	private String languageCode;
	
	public Tweet() {}
	
	public Tweet(String text, Date createdAt, String languageCode) {
        this.text = text;
        this.createdAt = createdAt;
        this.languageCode = languageCode;
    }

	public String getText() {
		return text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getLanguageCode() {
		return languageCode;
	}
}
