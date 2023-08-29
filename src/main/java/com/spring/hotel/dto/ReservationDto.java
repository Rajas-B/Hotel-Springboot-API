package com.spring.hotel.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.hotel.entities.*;

public class ReservationDto {
	private int resId;
	private Date bookingDate;
	private double rate;
	
	private Hotel hotel;
	
	public ReservationDto() {
		
	}
	
	public ReservationDto(int resId, Date bookingDate, double rate, Hotel hotel) {
		this.resId = resId;
		this.bookingDate = bookingDate;
		this.rate = rate;
		this.hotel = hotel;
	}
	
	// Getters and setters
	
	public void setResId(int resId) {
		this.resId = resId;
	}
	
	public double getResId() {
		return this.resId;
	}
	
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public Date getBookingDate() {
		return this.bookingDate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public double getRate() {
		return this.rate;
	}
	
	public Hotel getHotel() {
		return this.hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public static ReservationDto fromReservation(Reservation reservation) {
		return new ReservationDto(
				reservation.getResId(),
				reservation.getBookingDate(),
				reservation.getRate(),
				reservation.getHotel()
				);
	}
	
	public static List<ReservationDto> fromReservations(List<Reservation> reservations){
		return reservations.stream()
				.map(ReservationDto::fromReservation)
				.collect(Collectors.toList());
	}
}
