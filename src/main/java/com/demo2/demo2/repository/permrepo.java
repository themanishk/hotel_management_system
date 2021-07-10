package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.permission;
import com.demo2.demo2.model.position;


@Repository
public interface permrepo extends CrudRepository<permission, Integer> {
	
	public  permission findByPertype(String per_type) ;


}
