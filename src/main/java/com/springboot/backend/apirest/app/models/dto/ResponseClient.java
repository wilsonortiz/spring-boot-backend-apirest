package com.springboot.backend.apirest.app.models.dto;

public class ResponseClient {

	private String message;
	private ClientDTO client;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

}
