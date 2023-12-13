package com.example.repository;

import java.util.ArrayList;
import com.example.model.Rooms;

public interface RoomsRepository 
{
	ArrayList<Rooms> getRooms();
	Rooms getRoomsById(int roomId);
	Rooms addRooms(Rooms addRooms);
	Rooms updateRooms(int roomId, Rooms addRooms);
	void deleteRooms(int roomId);
}
