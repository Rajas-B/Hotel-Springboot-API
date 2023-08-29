package com.spring.hotel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.hotel.entities.*;
//import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
//	@Query("select r from reservation r where r.rate = :rate")
	List<Reservation> findByRate(double rate);
	
	List<Reservation> findByBookingDate(Date bookingDate);
	
	void  deleteByBookingDate(Date bookingDate);
	
	@Query("select r from Reservation r where r.rate <= :rate")
	List<Reservation> getReservationLowerThan(@Param("rate") double rate);
	
	@Query("select r from Hotel h, Reservation r where h.hotelId = r.hotel"
			+ " and h.city = :city and DATE(r.bookingDate) = '2023-07-27'")
	List<Reservation> getTodayResOfCity(@Param("city") String city);

	@Query("select r from Hotel h, Reservation r where h.hotelId = r.hotel"
			+ " and h.city = :city and r.rate >= :lowerRate and r.rate <= :higherRate")
	List<Reservation> getCityRates(@Param("city") String city, @Param("lowerRate") double lowerRate, @Param("higherRate") double higherRate);
	
}
