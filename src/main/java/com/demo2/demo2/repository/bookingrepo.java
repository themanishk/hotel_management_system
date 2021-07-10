package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.booking;
import com.demo2.demo2.model.user;

@Repository
public interface bookingrepo extends JpaRepository<booking, Integer> {

	public booking findById(int id);
}
