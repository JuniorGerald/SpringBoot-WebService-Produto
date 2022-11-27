package com.educando.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educando.course.entities.Category;
import com.educando.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
