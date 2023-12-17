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

import com.example.model.Rooms;
import com.example.service.RoomsService;

@RestController
@RequestMapping("/api/admin")
public class RoomsController 
{
	@Autowired
	private RoomsService roomsService; 
	
	@GetMapping("/rooms")
	ArrayList<Rooms> getRooms()
	{
		return roomsService.getRooms();
	}

	@GetMapping("/rooms/{roomId}")
	Rooms getRoomsById(@PathVariable int roomId)
	{
		return roomsService.getRoomsById(roomId);
	}
	
	@PostMapping("/rooms/addrooms")
	Rooms addRooms(@RequestBody Rooms addRooms)
	{
		return roomsService.addRooms(addRooms);
	}
	
	@PutMapping("/rooms/updateRooms/{roomId}")
	Rooms updateRooms(int roomId, Rooms addRooms)
	{
		return roomsService.updateRooms(roomId, addRooms);
	}
	
	@DeleteMapping("/rooms/{roomId}")
	void deleteRooms(int roomId)
	{
		roomsService.deleteRooms(roomId);	
	}

	
}
