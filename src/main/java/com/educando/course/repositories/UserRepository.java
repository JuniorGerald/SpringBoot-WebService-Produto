package com.educando.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educando.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
