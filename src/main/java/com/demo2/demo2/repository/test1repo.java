package com.demo2.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.demo2.model.test1;

@Repository
public interface test1repo extends JpaRepository<test1, Integer> {

}
