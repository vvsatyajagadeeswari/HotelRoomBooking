package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BookedRooms;
import com.example.service.BookedRoomsService;

@RestController
public class BookedRoomsController 
{
	@Autowired
	private BookedRoomsService bookedRoomsService; 
	
	@GetMapping("/getBookedRooms")
	ArrayList<BookedRooms> getBookedRooms()
	{
		return bookedRoomsService.getBookedRooms();	
	}
	
	@GetMapping("/bookedRooms/{bookingId}")
	BookedRooms getBookedRoomsById(@PathVariable int bookingId)
	{
		return bookedRoomsService.getBookedRoomsById(bookingId);
	}
	
	@PostMapping("/bookedRooms/addBooking")
	BookedRooms addBookedRooms(@RequestBody BookedRooms addBooking)
	{
		return bookedRoomsService.addBookedRooms(addBooking);
	}
	
	@PutMapping("/bookedRooms/updatebookedRooms/{bookingId}")
	BookedRooms updateBookedRooms(@PathVariable int bookingId,@RequestBody BookedRooms addBooking)
	{
		return bookedRoomsService.updateBookedRooms(bookingId, addBooking);
	}
	
	@DeleteMapping("/bookedRooms/{bookingId}")
	void deleteBookedRooms(int bookingId)
	{
		bookedRoomsService.deleteBookedRooms(bookingId);;
	}

}
