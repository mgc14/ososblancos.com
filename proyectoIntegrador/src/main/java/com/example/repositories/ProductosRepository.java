package com.example.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.ProductosModel;

@Repository
public interface ProductosRepository extends CrudRepository<ProductosModel, Integer>{
	public ArrayList<ProductosModel> findByCategoria(String categoria);
}
