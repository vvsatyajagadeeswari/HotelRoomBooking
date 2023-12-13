package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookedRooms 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(name="check_In")
	private LocalDate checkInDate;
	
	@Column(name="check_Out")
	private LocalDate checkOutDate;
	
	/*@Column(name="customer_Fullname")
	private String customerName;
	
	@Column(name="customer_Email")
	private String customerEmail;*/
	
	@Column(name="adults")
	private int numOfAudults;
	
	@Column(name="children")
	private int numOfChildren;
	
	@Column(name="total_Customers")
	private int totalNumOfCustomers;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roomId")
	private Rooms rooms;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public void calculateTotalNumOfCustomers()
	{
		this.totalNumOfCustomers=this.numOfAudults+this.numOfChildren;
	}


	public void setNumOfAudults(int numOfAudults) {
		this.numOfAudults = numOfAudults;
		calculateTotalNumOfCustomers();
	}


	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
		calculateTotalNumOfCustomers();
	}

}
