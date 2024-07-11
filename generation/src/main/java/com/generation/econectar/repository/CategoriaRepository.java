package com.generation.econectar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.econectar.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	public List<CategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);

}
