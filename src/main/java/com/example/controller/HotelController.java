package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hotel;
import com.example.service.HotelService;

@RestController
@RequestMapping("/api/admin")
public class HotelController 
{
	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/hotels")
	ArrayList<Hotel> getHotel()
	{
		return hotelService.getHotel();
	}
	
	@GetMapping("/hotel/{hotelId}")
	Hotel getHotelById(@PathVariable int hotelId)
	{
		return hotelService.getHotelById(hotelId);
	}
	
	@PostMapping("/hotel/addHotel")
	Hotel addHotel(@RequestBody Hotel addHotel)
	{
		return hotelService.addHotel(addHotel);
	}
	
	@PutMapping("/hotel/addHotel/{hotelId}")
	Hotel updateHotel(int hotelId, Hotel addHotel)
	{
		return hotelService.updateHotel(hotelId, addHotel);
	}
	
	@DeleteMapping("/hotel/{hotelId}")
	void deleteHotel(int hotelId)
	{
		hotelService.deleteHotel(hotelId);
	}
	

}
