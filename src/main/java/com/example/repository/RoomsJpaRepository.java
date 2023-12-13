package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Rooms;

public interface RoomsJpaRepository extends JpaRepository<Rooms, Integer>
{
	
}
