package com.spring.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.hotel.entities.*;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	List<Hotel> getHotelsByCity(String  city);

//	public Student update(Student student){
//		return HotelRepository.
//	}
	
	
}
