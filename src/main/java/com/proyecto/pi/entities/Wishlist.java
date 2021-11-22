package com.proyecto.pi.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int wid;
    private int uid;
    private int pid;
}
