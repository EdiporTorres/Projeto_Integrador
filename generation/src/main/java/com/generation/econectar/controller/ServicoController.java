package com.generation.econectar.controller;

import com.generation.econectar.model.ServicoModel;
import com.generation.econectar.repository.ServicoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public ResponseEntity<List<ServicoModel>> getAll() {
        return ResponseEntity.ok(servicoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoModel> getById(@PathVariable Long id) {
        return servicoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nomeservico/{nomeservico}")
    public ResponseEntity<List<ServicoModel>> getByNomeServico(@PathVariable String nomeservico) {
        return ResponseEntity.ok(servicoRepository.findAllByNomeServicoContaingIgnoreCase(nomeservico));
    }
}
