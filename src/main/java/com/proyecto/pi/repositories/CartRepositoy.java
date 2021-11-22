package com.proyecto.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.pi.entities.Cart;

public interface CartRepositoy extends JpaRepository<Cart,Integer> {
}
