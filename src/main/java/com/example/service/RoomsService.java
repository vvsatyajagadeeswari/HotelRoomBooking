package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Rooms;
import com.example.repository.RoomsJpaRepository;
import com.example.repository.RoomsRepository;

@Service
public class RoomsService implements RoomsRepository
{
	@Autowired
	private RoomsJpaRepository roomsJpaRepository;
	
	@Override
	public ArrayList<Rooms> getRooms() 
	{
		List<Rooms> roomsList=roomsJpaRepository.findAll();
		ArrayList<Rooms> rooms=new ArrayList<>(roomsList);
		return rooms;
	}

	@Override
	public Rooms getRoomsById(int roomId) 
	{
		try
		{
			Rooms rooms=roomsJpaRepository.findById(roomId).get();
			return rooms;
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Rooms addRooms(Rooms addRooms) 
	{
		roomsJpaRepository.save(addRooms);
		return addRooms;
	}

	@Override
	public Rooms updateRooms(int roomId, Rooms addRooms) 
	{
		try
		{
			Rooms existingRooms=roomsJpaRepository.findById(roomId).get();
			if(addRooms.getRoomPrice()!=null)
			{
				existingRooms.setRoomPrice(addRooms.getRoomPrice());
			}
			if(addRooms.getRoomType()!=null)
			{
				existingRooms.setRoomType(addRooms.getRoomType());
			}
			roomsJpaRepository.save(existingRooms);
			return existingRooms;	
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteRooms(int roomId) 
	{
		try
		{
			Rooms rooms=roomsJpaRepository.findById(roomId).get();
			if(rooms!=null)
			{
				roomsJpaRepository.deleteById(roomId);
			}
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
}
