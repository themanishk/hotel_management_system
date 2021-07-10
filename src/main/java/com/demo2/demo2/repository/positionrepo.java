package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo2.demo2.model.booking;
import com.demo2.demo2.model.position;

public interface positionrepo extends JpaRepository<position, Integer> {

	
	public position findByPosname(String posname);
}
