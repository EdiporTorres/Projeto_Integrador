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
public class ServicoController {
	
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
	public ResponseEntity<Servico> post(@Valid @RequestBody Servico serviço) {
		return ResponseEntity.status(201).body(servicorepository.save(serviço));
	}
	
	@PutMapping("/{id}/comprar")
	public Servico comprarServiço(@Valid @PathVariable long id, @RequestBody Usuario comprador) {
		Servico serviço = servicorepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
		serviço.setComprador(comprador);
		serviço.setStatus("Comprado");
		return servicorepository.save(serviço);

	}
	@PutMapping("/{id}/vender")
	public Servico venderServiço(@Valid  @PathVariable long id, @RequestBody Usuario vendedor) {
		Servico serviço = servicorepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
		serviço.setVendedor(vendedor);
		serviço.setStatus("Vendido");
		return servicorepository.save(serviço);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Servico> put(@Valid  @PathVariable long id, @RequestBody Servico serviço) {
		serviço.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(servicorepository.save(serviço));
	}
	

	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteServiço(@PathVariable long id) {
		Optional<Servico> serviço = servicorepository.findById(id);
		if (serviço.isPresent()) {
			servicorepository.delete(serviço.get());
			
		}
	}

}
