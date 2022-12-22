package com.example.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.UsuarioModel;
import com.example.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepositorio;
	public ArrayList<UsuarioModel> obtenerUsuario() {
		return (ArrayList<UsuarioModel>) usuarioRepositorio.findAll();
	}
	
	public UsuarioModel guardarUsuario(UsuarioModel usuario){
		return usuarioRepositorio.save(usuario);
	}
	
	public Optional<UsuarioModel> obtenerPorId(Integer id){
		return usuarioRepositorio.findById(id);
	}
	
	public ArrayList<UsuarioModel> obtenerPorCorreo(String correo){
		return usuarioRepositorio.findByPassword(correo);
	}
	
	public ArrayList<UsuarioModel> obtenerPorPassword(String password){
		return usuarioRepositorio.findByPassword(password);
	}
	
	
	
	
	
	public boolean eliminarPorId(Integer id) {
		if (usuarioRepositorio.findById(id).isPresent()) {
			usuarioRepositorio.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
