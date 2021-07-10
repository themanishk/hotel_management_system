package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.room_info;
import com.demo2.demo2.model.rooms;

@Repository
public interface roominforepo extends JpaRepository<room_info, Integer> {
	
	public room_info findByRoomname(String name);

}
