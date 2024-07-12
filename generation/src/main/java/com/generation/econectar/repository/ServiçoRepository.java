package com.generation.econectar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.econectar.model.Serviço;

public interface ServiçoRepository extends JpaRepository<Serviço, Long>{
	public List<Serviço> findAllBynomeServicoContainingIgnoreCase(@Param("nomeServico") String nomeServico);

}
