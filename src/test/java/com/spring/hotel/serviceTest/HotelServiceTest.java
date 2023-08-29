package com.spring.hotel.serviceTest;

import org.junit.Assert;
import org.junit.Test;

import com.spring.hotel.repository.HotelRepository;
import com.spring.hotel.service.HotelService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.spring.hotel.entities.Hotel;
import com.spring.hotel.exception.HotelNotFoundException;

//import static org.mockito.Mockito.then

public class HotelServiceTest {
	
	public HotelRepository hotelRepository;
	public HotelService hotelService;
	
	public HotelServiceTest() {
		hotelRepository = mock(HotelRepository.class);
		hotelService = new HotelService(hotelRepository);
	}
	
	
//	@Test
//	public void evaluateGetAllHotels() {
//		
//		int expected = 5;
//		
//		when(hotelRepository.findAll()).thenReturn(new ArrayList<Hotel>());
//		int actual = hotelService.getAllHotels().size();
//		
//		Assert.assertEquals(expected, actual);
//	}
	
	@Test
	public void evaluateFindById() {
		
		int expected = 1;
				
		when(hotelRepository.findById(expected)).thenReturn(Optional.of(new Hotel(1, "Novotel", "Thane")));
		
		Hotel hotel = hotelService.getHotelById(expected);
		
		Assert.assertNotNull(hotel);
		Assert.assertTrue(expected == hotel.getHotelId());
	}
	
	@Test(expected = HotelNotFoundException.class)
	public void evaluateFindHotelsByCity() {
		List<Hotel> expected = new ArrayList<> (List.of(new Hotel(1, "Novotel", "Thane")));
		
		when(hotelRepository.getHotelsByCity("Thane")).thenReturn(expected);
		
		List<Hotel> hotelsInCity = hotelService.getHotelsByCity("Thane");
		
		Assert.assertNotNull(hotelsInCity);
		Assert.assertTrue(hotelsInCity.equals(expected));
		
		when(hotelRepository.getHotelsByCity("Chennai")).thenReturn(null);
		
		hotelsInCity = hotelService.getHotelsByCity("Chennai");
		
		Assert.assertNull(hotelsInCity);
		
	}
	
//	@Test
//	public void 
}
