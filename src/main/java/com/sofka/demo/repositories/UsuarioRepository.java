package com.sofka.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sofka.demo.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
	public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);

	public abstract UsuarioModel findByEmail(String email);
}
