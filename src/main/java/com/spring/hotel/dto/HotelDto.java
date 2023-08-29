package com.spring.hotel.dto;

import com.spring.hotel.entities.*;

import java.util.List;
import java.util.stream.Collectors;

public class HotelDto {
	private int hotelId;
	private String hotelName;
	private String city;
	
	public HotelDto() {
		
	}
	
	public HotelDto(int hotelId, String hotelName, String city) {
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
	
	public static HotelDto fromHotel(Hotel hotel) {
		return new HotelDto(
					hotel.getHotelId(),
					hotel.getHotelName(),
					hotel.getCity()
				);
	}
	
	public static List<HotelDto> fromHotels(List<Hotel> hotels){
		return hotels.stream()
				.map(HotelDto::fromHotel)
				.collect(Collectors.toList());
	}
}
