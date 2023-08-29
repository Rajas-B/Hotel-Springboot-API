package com.spring.hotel.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.spring.hotel.repository.*;
import com.spring.hotel.entities.Hotel;
import com.spring.hotel.exception.HotelNotFoundException;
import com.spring.hotel.exception.HotelNotFoundById;

@Service
public class HotelService {
	private final HotelRepository hotelRepository;
	
	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	public List<Hotel> getAllHotels() {
		List<Hotel> allHotels = (List<Hotel>) hotelRepository.findAll();
		if(allHotels.size() > 0) {
			return allHotels;
		}else {
			throw new HotelNotFoundException("No hotels exist in the database");
		}
	}
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	public Hotel getHotelById(int hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new HotelNotFoundById(hotelId));
	}
	
	public List<Hotel> getHotelsByCity(String city){
		List<Hotel> allHotels = (List<Hotel>) hotelRepository.getHotelsByCity(city);
		if(allHotels != null) {
			return allHotels;
		}else {
			throw new HotelNotFoundException("No hotels exist in that city");
		}
	}
	

}
