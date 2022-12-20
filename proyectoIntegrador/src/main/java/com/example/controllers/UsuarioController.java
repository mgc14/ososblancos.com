package com.example.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.models.UsuarioModel;
import com.example.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioServicio;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios() {
		return usuarioServicio.obtenerUsuario();
	}
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioServicio.guardarUsuario(usuario);
	}
	
	@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorCorreo(@RequestParam("correo") String correo) {
		return this.usuarioServicio.obtenerPorCorreo(correo);
	}
	
	/*@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPassword(@RequestParam("prioridad") String password) {
		return this.usuarioServicio.obtenerPorPassword(password);
	}*/
	
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
		return this.usuarioServicio.obtenerPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public String eliminarPorId(@PathVariable("id") Integer id) {
		boolean check=this.usuarioServicio.eliminarPorId(id);
		if (check) {
			return "Se elimino el usuario " + id;
		} else {
			return "No se pudo eliminar el usuario " + id;
		}

	}


}
