package com.proyecto.pi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CartProps {
    @Id
    private int cartid;
    private int pid;
    private String img1;
    private String title;
    private String price;
    private int quantity;
}
