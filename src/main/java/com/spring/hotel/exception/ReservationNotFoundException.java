package com.spring.hotel.exception;

public class ReservationNotFoundException extends RuntimeException {

	/**
	 What is this?? 
	 */
	private static final long serialVersionUID = 5621446401036992700L;
	
	public ReservationNotFoundException(String str) {
		super(str);
	}
	
}
