package com.demo2.demo2.repository;
import com.demo2.demo2.model.test2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface test2repo extends JpaRepository<test2, Integer> {
	

}
