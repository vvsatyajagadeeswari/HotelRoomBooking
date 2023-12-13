package com.example.repository;

import java.util.ArrayList;
import com.example.model.Hotel;

public interface HotelRepository 
{
	ArrayList<Hotel> getHotel();
	Hotel getHotelById(int hotelId);
	Hotel addHotel(Hotel addHotel);
	Hotel updateHotel(int hotelId, Hotel addHotel);
	void deleteHotel(int hotelId);
}
