package com.spring.hotel.entities;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class HotelReservation {
	private int hotelId;
	private String hotelName;
	private String city;
	
	private int resId;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date bookingDate;
	private double rate;
	
	public HotelReservation() {
		
	}
	
	public HotelReservation(int hotelId, String hotelName, String city, int resId, Date bookingDate, double rate) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
		this.resId = resId;
		this.bookingDate = bookingDate;
		this.rate = rate;
	}
	
	// Getters and setters
	public void setResId(int resId) {
		this.resId = resId;
	}
	
	public int getResId() {
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
	
	// Getters and setters for hotel
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	public int getHotelId() {
		return this.hotelId;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public String getHotelName() {
		return this.hotelName;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
}
