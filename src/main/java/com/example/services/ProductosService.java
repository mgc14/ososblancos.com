package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.ProductosModel;
import com.example.repositories.ProductosRepository;

@Service
public class ProductosService {
	@Autowired
	ProductosRepository productoRepositorio;
	public ArrayList<ProductosModel> obtenerProductos(){
		return (ArrayList<ProductosModel>) productoRepositorio.findAll();
	}
	
}
