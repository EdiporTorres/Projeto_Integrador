package com.generation.econectar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.econectar.model.Categorial;

public interface CategoriaRepository extends JpaRepository<Categorial, Long> {
	public List<Categorial> findAllBynomeCategoriaContainingIgnoreCase(@Param("nomeCategoria") String nomeCategoria);
	public List<Categorial> findAllByDescricaoContainingIgnoreCase(@Param("descricao")String descricao);
}

