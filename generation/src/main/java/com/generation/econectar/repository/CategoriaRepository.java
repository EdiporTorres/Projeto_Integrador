package com.generation.econectar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.econectar.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	public List<CategoriaModel> findAllBynomeCategoriaContainingIgnoreCase(@Param("nomeCategoria") String nomeCategoria);
	public List<CategoriaModel> findAllByDescricaoContainingIgnoreCase(@Param("descricao")String descricao);
}

