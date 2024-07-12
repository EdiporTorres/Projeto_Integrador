package com.generation.econectar.repository;

import com.generation.econectar.model.ServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoRepository extends JpaRepository<ServicoModel, Long> {

    public List<ServicoModel> findAllByNomeServicoContaingIgnoreCase(@Param("nomeservico") String nomeservico);

}
