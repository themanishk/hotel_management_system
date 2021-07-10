package com.demo2.demo2.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "rooms")
public class rooms {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private int id;
	
	

	
	@Column(name = "room_no")
	private int roomno;
	
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_type", nullable = false)
    private room_info roominfo;
    
	@Column(name = "availability")
	@Type(type="org.hibernate.type.NumericBooleanType")
	private boolean avail;
    
    

	public boolean isAvail() {
		return avail;
	}

	public void setAvail(boolean avail) {
		this.avail = avail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public room_info getRoominfo() {
		return roominfo;
	}

	public void setRoominfo(room_info roominfo) {
		this.roominfo = roominfo;
	}

	@Override
	public String toString() {
		return "rooms [id=" + id + ", roomno=" + roomno + ", roominfo=" + roominfo + "]";
	}
    
    
    
	
}
