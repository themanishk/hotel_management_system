package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.log_in;




@Repository
public interface loginrepo extends JpaRepository<log_in, Integer> {

	log_in findByUsername(String username);

	
}
