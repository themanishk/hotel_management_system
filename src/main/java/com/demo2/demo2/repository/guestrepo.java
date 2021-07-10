package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.booking;
import com.demo2.demo2.model.guest;

@Repository
public interface guestrepo extends JpaRepository<guest, Integer> {

	
	public guest findBybooking(booking booking);
}
