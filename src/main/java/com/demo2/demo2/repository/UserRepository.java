package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.user;




@Repository
public interface UserRepository extends JpaRepository<user, Integer> {

	public user findByMobile(String mobile);
	
	public user findById(int id);
	
	
}
  

