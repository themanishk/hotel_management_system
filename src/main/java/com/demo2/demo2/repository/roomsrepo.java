package com.demo2.demo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.room_info;
import com.demo2.demo2.model.rooms;


@Repository
public interface roomsrepo extends JpaRepository<rooms, Integer> {

	public List<rooms> findByRoominfo(room_info roominfo);
	
	public rooms findByRoomno(int roomno);
	
	
	
}
