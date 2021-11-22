package com.proyecto.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.pi.entities.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findByMailAndPassword(String mail, String password);
    Users findById (int id);
}
