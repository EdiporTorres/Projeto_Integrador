package com.generation.econectar.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.generation.econectar.model.Servico;
import com.generation.econectar.model.Usuario;
import com.generation.econectar.repository.ServicoRepository;

import jakarta.validation.Valid;
	
@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServiçoController {
	
	@Autowired
	private ServicoRepository servicorepository;
	
	@GetMapping
	public ResponseEntity<Page<Servico>> getAll(Pageable pageble) {
		return ResponseEntity.ok(servicorepository.findAll(pageble));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Servico> getById( @PathVariable long id) {
		return servicorepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeServico/{nomeServico}")
	public ResponseEntity<List<Servico>> getByNomeServico(@PathVariable String nomeServico) {
		return ResponseEntity.ok(servicorepository.findAllBynomeServicoContainingIgnoreCase(nomeServico));
	}
	
	@PostMapping
	public ResponseEntity<Servico> post(@Valid @RequestBody Servico servico) {
		return ResponseEntity.status(201).body(servicorepository.save(servico));
	}
	
	@PutMapping("/{id}/comprar")
	public Servico comprarServico(@Valid @PathVariable long id, @RequestBody Usuario comprador) {
		Servico servico = servicorepository.findById(id).orElseThrow(() -> new RuntimeException("Servico não encontrado"));
		servico.setComprador(comprador);
		servico.setStatus("Comprado");
		return servicorepository.save(servico);

	}
	@PutMapping("/{id}/vender")
	public Servico venderServico(@Valid  @PathVariable long id, @RequestBody Usuario vendedor) {
		Servico servico = servicorepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Servico não encontrado"));
		servico.setVendedor(vendedor);
		servico.setStatus("Vendido");
		return servicorepository.save(servico);
	}
	
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteServico(@PathVariable long id) {
		Optional<Servico> servico = servicorepository.findById(id);
		if (servico.isPresent()) {
			servicorepository.delete(servico.get());}
	}


}
