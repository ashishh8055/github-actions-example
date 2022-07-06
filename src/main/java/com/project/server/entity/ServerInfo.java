package com.project.server.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ServerInfo")
public class ServerInfo {

	private Integer id;
	private String name;
	private String language;
	private String framework;

	

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public String getFramework() {
		return framework;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

}
