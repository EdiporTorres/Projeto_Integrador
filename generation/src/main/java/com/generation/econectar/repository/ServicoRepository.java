package com.generation.econectar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.econectar.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{
	public List<Servico> findAllBynomeServicoContainingIgnoreCase(@Param("nomeServico") String nomeServico);

}