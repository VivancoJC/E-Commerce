package com.proyecto.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.pi.entities.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {

}
