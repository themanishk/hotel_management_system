package com.demo2.demo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "booking")
public class booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int id;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "total_guest")
	private int totalguest;
	
	@Column(name = "booking_date")
	private String bookdate;
	
	@Column(name = "departure_date")
	private String depdate;
	
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private payment payment;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private rooms room;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable=true)
    private user user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTotalguest() {
		return totalguest;
	}

	public void setTotalguest(int totalguest) {
		this.totalguest = totalguest;
	}

	public String getBookdate() {
		return bookdate;
	}

	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}

	public String getDepdate() {
		return depdate;
	}

	public void setDepdate(String depdate) {
		this.depdate = depdate;
	}

	public payment getPayment() {
		return payment;
	}

	public void setPayment(payment payment) {
		this.payment = payment;
	}

	public rooms getRoom() {
		return room;
	}

	public void setRoom(rooms room) {
		this.room = room;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "booking [id=" + id + ", phone=" + phone + ", totalguest=" + totalguest + ", bookdate=" + bookdate
				+ ", depdate=" + depdate + ", payment=" + payment + ", room=" + room + ", user=" + user + "]";
	}
    
    
    
    
    
	
}
