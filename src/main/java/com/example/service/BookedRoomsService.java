package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.BookedRooms;
import com.example.repository.BookedRoomsJpaRepository;
import com.example.repository.BookedRoomsRepository;

@Service
public class BookedRoomsService implements BookedRoomsRepository 
{
	@Autowired
	private BookedRoomsJpaRepository bookedRoomsJpaRepository;
	
	@Override
	public ArrayList<BookedRooms> getBookedRooms() 
	{
		List<BookedRooms> bookedRoomsList=bookedRoomsJpaRepository.findAll();
		ArrayList<BookedRooms> bookedRooms=new ArrayList<>(bookedRoomsList);
		return bookedRooms;
	}

	@Override
	public BookedRooms getBookedRoomsById(int bookingId) 
	{
		try
		{
			BookedRooms bookedRooms=bookedRoomsJpaRepository.findById(bookingId).get();
			return bookedRooms;
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public BookedRooms addBookedRooms(BookedRooms addBooking) 
	{
		bookedRoomsJpaRepository.save(addBooking);
		return addBooking;
	}

	@Override
	public BookedRooms updateBookedRooms(int bookingId, BookedRooms addBooking) 
	{
		try
		{
			BookedRooms existingBookedRooms=bookedRoomsJpaRepository.findById(bookingId).get();
			if(addBooking.getCheckInDate()!=null)
			{
				existingBookedRooms.setCheckInDate(addBooking.getCheckInDate());
			}
			if(addBooking.getCheckOutDate()!=null)
			{
				existingBookedRooms.setCheckOutDate(addBooking.getCheckOutDate());
			}
			if(addBooking.getNumOfAudults()!=-1)
			{
				existingBookedRooms.setNumOfAudults(addBooking.getNumOfAudults());
			}
			if(addBooking.getNumOfChildren()!=-1)
			{
				existingBookedRooms.setCheckOutDate(addBooking.getCheckOutDate());
			}
			bookedRoomsJpaRepository.save(existingBookedRooms);
			return existingBookedRooms;	
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteBookedRooms(int bookingId) 
	{
		try
		{
			BookedRooms bookedRooms=bookedRoomsJpaRepository.findById(bookingId).get();
			if(bookedRooms!=null)
			{
				bookedRoomsJpaRepository.deleteById(bookingId);
			}
			
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
