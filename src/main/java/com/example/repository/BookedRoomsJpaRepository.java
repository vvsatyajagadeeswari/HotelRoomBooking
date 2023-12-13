package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.BookedRooms;

public interface BookedRoomsJpaRepository extends JpaRepository<BookedRooms, Integer>
{
	
}
