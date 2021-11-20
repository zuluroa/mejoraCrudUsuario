package com.sofka.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.demo.models.UsuarioModel;
import com.sofka.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/obtenerUsuario")
	public ArrayList<UsuarioModel> obtenerUsuario(){
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping("/guardar")
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
		return usuarioService.guardarUsuario(usuario);
	}
	
	@GetMapping(path = "/obtenerUsuario/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return usuarioService.obtenerPorId(id);
	}
	
	@GetMapping("/obtenerPorPrioriodad")
	public ArrayList<UsuarioModel> obtenerPorPrioriodad(@RequestParam("prioridad") Integer prioridad){
		return usuarioService.obtenerPorPrioridad(prioridad);
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	public String eliminarUsuarioPorId(@PathVariable("id")Long id){
		boolean ok = usuarioService.eliminarUsuario(id);
		if (ok) {
			return "Se elimino el usuario con el ID "+id;
		}
		return "No se elimino el usuario con el ID \"+id";
	}
	
	@PutMapping("/EditarUsuario")
	public UsuarioModel editarUsuario(@RequestBody UsuarioModel usuario){
		return usuarioService.guardarUsuario(usuario);
	}
	
}
