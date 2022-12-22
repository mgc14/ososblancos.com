package com.example.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer>{
	public ArrayList<UsuarioModel> findByPassword(String password);
	public ArrayList<UsuarioModel> findByCorreo(String correo);
}
