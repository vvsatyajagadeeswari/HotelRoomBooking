package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Hotel;

public interface HotelJpaRepository extends JpaRepository<Hotel, Integer> 
{

}
