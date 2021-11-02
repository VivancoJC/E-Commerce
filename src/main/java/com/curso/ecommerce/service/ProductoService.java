package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.curso.ecommerce.model.Producto;

public interface ProductoService {
	public Producto save( Producto producto);
	//optional permite validad  si el onjeto existe ono 
	public Optional<Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	public List<Producto> findAll();

}
