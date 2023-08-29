package com.spring.hotel.service;

import com.spring.hotel.entities.*;
import com.spring.hotel.repository.*;
import com.spring.hotel.exception.ReservationNotFoundById;
import com.spring.hotel.exception.ReservationNotFoundException;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;



@Service
public class ReservationService {
	
	private final ReservationRepository resRepository;
//	private final HotelRepository hotelRepository;
	
	ReservationService(ReservationRepository resRepository){
		this.resRepository = resRepository;
//		this.hotelRepository = hotelRepository;
	}
	public Reservation saveReservation(Reservation reservation) {
		return this.resRepository.save(reservation);
	}
	
	public List<Reservation> getAllReservations(){
		List<Reservation> reservations = (List<Reservation>) this.resRepository.findAll();
		if(reservations.size()>0) {
			return reservations;
		}
		else {
			throw new ReservationNotFoundException("No reservations found");
		}
	}
	
	public Reservation getReservationById(int resId) {
		return resRepository.findById(resId)
				.orElseThrow(() -> new ReservationNotFoundById(resId));
	}
	
	public List<Reservation> findByRate(double rate){
		List<Reservation> reservations = (List<Reservation>) this.resRepository.findByRate((double) rate);
		if(reservations.size()>0) {
			return reservations;
		}
		else {
			throw new ReservationNotFoundException("No reservations found with rate = " + rate + "₹");
		}
	}
	
	public List<Reservation> getReservationLowerThan(double rate){
		List<Reservation> reservations = (List<Reservation>) this.resRepository.getReservationLowerThan(rate);
		if(reservations.size()>0) {
			return reservations;
		}
		else {
			throw new ReservationNotFoundException("No reservations found with rate lower than " + rate + "₹");
		}
	}
	
	public List<Reservation> getTodayResOfCity(String city){
		return this.resRepository.getTodayResOfCity(city);
	}

	public List<Reservation> getCityRates(String city, double lowerRate, double higherRate){
		List<Reservation> reservations = (List<Reservation>) this.resRepository.getCityRates(city, lowerRate, higherRate);
		if(reservations.size()>0) {
			return reservations;
		}
		else {
			throw new ReservationNotFoundException("No reservations found in " + city + " with rates between " + lowerRate + "₹ and " + higherRate + "₹");
		}
	}
	
	
	// No error handling done
	public List<Reservation> findByBookingDate(Date bookingDate){
		return this.resRepository.findByBookingDate(bookingDate);
	}
	
	public void deleteById(int resId) {
		this.resRepository.deleteById(resId);
	}
	
	@Transactional
	public void deleteByBookingDate(Date bookingDate) {
		this.resRepository.deleteByBookingDate(bookingDate);
	}
	
	
}
