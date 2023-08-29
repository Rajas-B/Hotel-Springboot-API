package com.spring.hotel.exception;

public class HotelNotFoundById extends RuntimeException{

	private static final long serialVersionUID = -4876727564935138097L;

	/**
	 * 
	 */
	public HotelNotFoundById(int id) {
		super("Hotel with id: " + id + " not found");
	}

	
}
