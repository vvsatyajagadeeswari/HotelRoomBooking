package com.example.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hotel")
public class Hotel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hotelId;
	
	private String hotelName;
	
	private String hotelLocation;
	
}
