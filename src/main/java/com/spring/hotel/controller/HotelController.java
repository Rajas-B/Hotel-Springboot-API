package com.spring.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.spring.hotel.entities.*;
import com.spring.hotel.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	private final HotelService hotelService;
	
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	@GetMapping
	public List<Hotel> getAllHotels(){
		return hotelService.getAllHotels();
	}
	
	@PostMapping
	public Hotel saveHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	
	@GetMapping("/city/{city}")
	public List<Hotel> getHotelsByCity(@PathVariable String city){
		return hotelService.getHotelsByCity(city);
	}
	
//	@GetMaping("/filter")
//	public List<Hotel>
	
}
