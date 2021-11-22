package com.proyecto.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.pi.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
