package com.educando.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educando.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
