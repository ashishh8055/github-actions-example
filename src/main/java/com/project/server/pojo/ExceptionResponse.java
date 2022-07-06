package com.project.server.pojo;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private LocalDateTime localDateTime;
	private String message;

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
