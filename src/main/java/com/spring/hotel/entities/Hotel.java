package com.spring.hotel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
//import java.util.ArrayList;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;

@Entity
@Table(name="hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int hotelId;
	private String hotelName;
	private String city;
//
//	@OneToMany(targetEntity=Reservation.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinColumn(name="hotel_id", referencedColumnName="hotel_id")
//	private List<Reservation> reservations = new ArrayList<Reservation>();
//	
	public Hotel() {
		
	}
	
	public Hotel(int hotelId, String hotelName, String city) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
	}
	
	// Getters and setters
	
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
	
	public boolean equals(Hotel hotel) {
		if(this.getHotelId() == hotel.getHotelId() && this.getHotelName() == hotel.getHotelName() && this.getCity() == hotel.getCity())
			return true;
		else
			return false;
	}
}
