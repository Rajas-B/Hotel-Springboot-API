package com.spring.hotel.entities;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int resId;
	
	@Column(name="booking_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date bookingDate;
	private double rate;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	public Reservation() {
		
	}
	
	public Reservation(int resId, Date bookingDate, double rate, Hotel hotel) {
		this.resId = resId;
		this.bookingDate = bookingDate;
		this.rate = rate;
		this.hotel = hotel;
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
	
	public Hotel getHotel() {
		return this.hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	public static List<Reservation> filterBetweenRates(List<Reservation> reservations, double lowerRate, double higherRate){
		return reservations.stream()
				.filter(reservation -> reservation.rate >= lowerRate && reservation.rate <= higherRate)
				.collect(Collectors.toList());
	}
	
}
