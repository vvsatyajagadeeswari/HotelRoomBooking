package com.example.repository;

import java.util.ArrayList;

import com.example.model.BookedRooms;

public interface BookedRoomsRepository 
{
	ArrayList<BookedRooms> getBookedRooms();
	BookedRooms getBookedRoomsById(int bookingId);
	BookedRooms addBookedRooms(BookedRooms addBooking);
	BookedRooms updateBookedRooms(int bookingId, BookedRooms addBooking);
	void deleteBookedRooms(int bookingId);
}
