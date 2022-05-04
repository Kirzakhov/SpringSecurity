package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SpringUser;

public interface UserRepository extends JpaRepository<SpringUser, Integer> {
	SpringUser findByName(String name);
}
