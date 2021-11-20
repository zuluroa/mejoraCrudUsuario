package com.sofka.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.demo.models.UsuarioModel;
import com.sofka.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
	}
	
	public UsuarioModel guardarUsuario(UsuarioModel usuario){
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioModel> obtenerPorId(Long id){
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
		return usuarioRepository.findByPrioridad(prioridad);
	}
}
