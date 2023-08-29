package com.spring.hotel.exception;

public class ReservationNotFoundById extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4791083269191494411L;
	
	public ReservationNotFoundById(int id) {
		super("Reservation with id: " + id + " not found.");
	}
}
