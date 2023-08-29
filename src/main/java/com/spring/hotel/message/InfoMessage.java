package com.spring.hotel.message;

public class InfoMessage {
	private String message;
	InfoMessage(){
		
	}
	InfoMessage(String message){
		this.message = message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
}
