package com.spring.hotel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.hotel.entities.*;
//import com.spring.hotel.message.InfoMessage;
import com.spring.hotel.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	
	private final ReservationService resService;
	
	ReservationController(ReservationService resService){
		this.resService = resService;
	}
	
	@GetMapping
	public List<Reservation> getAllReservations(){
		return this.resService.getAllReservations();
	}
	
	@PostMapping
	public Reservation saveReservation(@RequestBody Reservation reservation) {
		return this.resService.saveReservation(reservation);
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable int resId) {
		return this.resService.getReservationById(resId);
	}
	
	@GetMapping("/rate/{rate}")
	public List<Reservation> findByRate(@PathVariable double rate){
		System.out.println("Rate recevied: " + rate);
		return this.resService.findByRate(rate);
	}
	
	@PostMapping("/lower-than")
	public List<Reservation> getReservationLowerThan(@RequestBody ObjectNode objectNode){
		return this.resService.getReservationLowerThan(objectNode.get("rate").asDouble());
	}
	
	@PostMapping("/res-city")
	public List<Reservation> getTodayResOfCity(@RequestBody ObjectNode objectNode){
		return this.resService.getTodayResOfCity(objectNode.get("city").asText());
	}
	
	@PostMapping("/city-rates")
	public List<Reservation> getCityRates(@RequestBody ObjectNode objectNode){
		return this.resService.getCityRates(objectNode.get("city").asText(), objectNode.get("lowerRate").asDouble(), objectNode.get("higherRate").asDouble());
	}
	
	@GetMapping("/dates/{bookingDate}")
	public List<Reservation> findByBookingDate(@PathVariable Date bookingDate){
		System.out.println(bookingDate);
		return this.resService.findByBookingDate(bookingDate);
	}
	
	@DeleteMapping("/dates/delete/{bookingDate}")
	public void deleteByBookingDate(@PathVariable Date bookingDate){
		this.resService.deleteByBookingDate(bookingDate);
	}
	
	@DeleteMapping("/{resId}")
	public void deleteById(@PathVariable int resId) {
		this.resService.deleteById(resId);
	}
}
