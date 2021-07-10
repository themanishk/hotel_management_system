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

@Entity
@Table(name = "payment")
public class payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int id;
	
	@Column(name = "payment_Desc")
	private String paydesc;
	
	@Column(name = "pay_date")
	private String date;
	
	@Column(name = "amount")
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaydesc() {
		return paydesc;
	}

	public void setPaydesc(String paydesc) {
		this.paydesc = paydesc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "payment [id=" + id + ", paydesc=" + paydesc + ", date=" + date + ", amount=" + amount + "]";
	}
	
	
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)

	
}
