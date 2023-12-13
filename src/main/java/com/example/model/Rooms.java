package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="rooms")
public class Rooms 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roomId")
	private int roomId;
	
	private String roomType;
	
	private Float roomPrice;
	
	private boolean isBooked=false;
	
	
	@OneToMany(mappedBy="rooms",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<BookedRooms> bookings;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotelId")
	private Hotel  hotel;
	
	public Rooms()
	{
		this.bookings=new ArrayList<>();
	}
	
	public void addBooking(BookedRooms booking)
	{
		if(bookings==null)
		{
			bookings=new ArrayList<>();
		}
		bookings.add(booking);
		booking.setRooms(this);
		isBooked=true;
		
	}

	
}
