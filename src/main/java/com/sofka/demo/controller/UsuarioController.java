package com.sofka.demo.controller;

import java.util.ArrayList;
import java.util.Map;
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

import com.sofka.demo.Utils;
import com.sofka.demo.models.UsuarioModel;
import com.sofka.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/obtenerUsuario")
	public Map<String, Object> obtenerUsuario() {
		ArrayList<UsuarioModel> listaUsuarios = usuarioService.obtenerUsuarios();
		if (listaUsuarios != null) {
			return Utils.mapear(true, "Consulta exitosa!! ", listaUsuarios);
		}
		return Utils.mapear(false, "Fallo la consulta ", null);
	}

	@PostMapping("/guardar")
	public Map<String, Object> guardarUsuario(@RequestBody UsuarioModel usuario) {
		UsuarioModel usuarioModelo = usuarioService.guardarUsuario(usuario);
		if (usuarioModelo != null) {
			return Utils.mapear(true, "Se guardo el usuario con exito!! ", usuarioModelo);
		}
		return Utils.mapear(false, "Fallo al  guardar el usuario ", null);
	}

	@GetMapping(path = "/obtenerUsuario/{id}")
	public Map<String, Object> obtenerUsuarioPorId(@PathVariable("id") Long id) {
		Optional<UsuarioModel> usuarioModelo = usuarioService.obtenerPorId(id);
		if (usuarioModelo != null) {
			return Utils.mapear(true, "Se guardo el usuario con exito!! ", usuarioModelo);
		}
		return Utils.mapear(false, "Fallo al  guardar el usuario ", null);
	}

	@GetMapping("/obtenerPorPrioriodad")
	public Map<String, Object> obtenerPorPrioriodad(@RequestParam("prioridad") Integer prioridad) {
		ArrayList<UsuarioModel> listaUsuarios =  usuarioService.obtenerPorPrioridad(prioridad);
		usuarioService.obtenerUsuarios();
		if (listaUsuarios != null) {
			return Utils.mapear(true, "Consulta exitosa!! ", listaUsuarios);
		}
		return Utils.mapear(false, "Fallo la consulta ", null);
	}

	@DeleteMapping("/eliminarUsuario/{id}")
	public Map<String, Object> eliminarUsuarioPorId(@PathVariable("id") Long id) {
		boolean ok = usuarioService.eliminarUsuario(id);
		if (ok) {
			return Utils.mapear(true, "Se elimino el usuario !! ", null);
		}
		return Utils.mapear(false, "No se elimino el usuario con el ID \\ "+id, null);
	}

	@PutMapping("/EditarUsuario")
	public Map<String, Object> editarUsuario(@RequestBody UsuarioModel usuario) {
		UsuarioModel usuarioModelo = usuarioService.guardarUsuario(usuario);
		if (usuarioModelo != null) {
			return Utils.mapear(true, "Se edito el usuario con exito!! ", usuarioModelo);
		}
		return Utils.mapear(false, "Fallo al  editar el usuario ", null);
	}

	@GetMapping("/obtenerUsuarioPorEmail")
	public Map<String, Object> obtenerUsuarioPorEmail(@RequestBody UsuarioModel usuario) {
		UsuarioModel usuarioModelo = usuarioService.obtenerporEmail(usuario);
		if (usuarioModelo != null) {
			return Utils.mapear(true, "Consulta exitosa!! ", usuarioModelo);
		}
		return Utils.mapear(false, "Fallo la consulta ", null);
	}

}
