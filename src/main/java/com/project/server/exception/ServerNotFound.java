package com.project.server.exception;

public class ServerNotFound extends Exception {
	private String message;

	public ServerNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
