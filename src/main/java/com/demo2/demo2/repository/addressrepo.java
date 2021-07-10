package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.address;

@Repository
public interface addressrepo extends JpaRepository<address, Integer> {

}
