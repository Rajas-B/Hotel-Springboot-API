package com.spring.hotel.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// WebRequest object removed from argument

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Object> handleHotelNotFoundException(HotelNotFoundException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Hotels do not exist");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        
    }
    
    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<Object> handleReservationNotFoundException(ReservationNotFoundException ex){
    	Map<String, Object> body = new LinkedHashMap<>();
    	body.put("timestamp", LocalDateTime.now());
    	body.put("message", "Reservations not found");
    	
    	return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(HotelNotFoundById.class)
    public ResponseEntity<Object> handleHotelNotFoundByIdException(HotelNotFoundById ex){
    	Map<String, Object> body = new LinkedHashMap<>();
    	body.put("Timestamp", LocalDateTime.now());
    	body.put("Message", "Hotel with this id not found");
    	
    	return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ReservationNotFoundById.class)
    public ResponseEntity<Object> handleReservationNotFoundByIdException(HotelNotFoundById ex){
    	Map<String, Object> body = new LinkedHashMap<>();
    	body.put("Timestamp", LocalDateTime.now());
    	body.put("Message", "Reservation with this id not found");
    	
    	return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}