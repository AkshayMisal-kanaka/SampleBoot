package com.akshaymisal.sampleboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshaymisal.sampleboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
