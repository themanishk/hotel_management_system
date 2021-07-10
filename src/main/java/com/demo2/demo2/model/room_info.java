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
@Table(name = "room_info")
public class room_info {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_type")
	private int id;
	
	
	@Column(name = "total_bed")
	private int bed;
	
	@Column(name = "ac")
	@Type(type="org.hibernate.type.NumericBooleanType")
	private boolean ac;
	
	@Column(name = "tv")
	@Type(type="org.hibernate.type.NumericBooleanType")
	private boolean tv;
	
	
	@Column(name = "price_per_night")
	private int price;
	
	@Column(name = "room_name")
	private String roomname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBed() {
		return bed;
	}

	public void setBed(int bed) {
		this.bed = bed;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	@Override
	public String toString() {
		return "room_info [id=" + id + ", bed=" + bed + ", ac=" + ac + ", tv=" + tv + ", price=" + price + ", roomname="
				+ roomname + "]";
	}
	
	
	
	
}
