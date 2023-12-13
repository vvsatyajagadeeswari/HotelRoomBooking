package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Hotel;
import com.example.repository.HotelJpaRepository;
import com.example.repository.HotelRepository;

@Service
public class HotelService implements HotelRepository
{
	@Autowired
	private HotelJpaRepository hotelJpaRepository;
	
	@Override
	public ArrayList<Hotel> getHotel() 
	{
		List<Hotel> hotelList=hotelJpaRepository.findAll();
		ArrayList<Hotel> hotel=new ArrayList<>(hotelList);
		return hotel;
	}

	@Override
	public Hotel getHotelById(int hotelId) 
	{
		try
		{
			Hotel hotel=hotelJpaRepository.findById(hotelId).get();
			return hotel;
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Hotel addHotel(Hotel addHotel) 
	{
		hotelJpaRepository.save(addHotel);
		return addHotel;
	}

	@Override
	public Hotel updateHotel(int hotelId, Hotel addHotel) 
	{
		try
		{
			Hotel existingHotel=hotelJpaRepository.findById(hotelId).get();
			if(addHotel.getHotelName()!=null)
			{
				existingHotel.setHotelName(addHotel.getHotelName());
			}
			if(addHotel.getHotelLocation()!=null)
			{
				existingHotel.setHotelLocation(addHotel.getHotelLocation());
			}
			hotelJpaRepository.save(existingHotel);
			return existingHotel;	
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteHotel(int hotelId) 
	{
		try
		{
			Hotel hotel=hotelJpaRepository.findById(hotelId).get();
			if(hotel!=null)
			{
				hotelJpaRepository.deleteById(hotelId);
			}
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
