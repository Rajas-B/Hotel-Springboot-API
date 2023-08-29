package com.spring.hotel.exception;

public class HotelNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 278463627992977154L;

	/**
	 * 
	 */
	
	public HotelNotFoundException(String str) {
		super(str);
	}
}
