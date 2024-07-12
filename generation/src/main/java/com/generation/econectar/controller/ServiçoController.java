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

import com.generation.econectar.model.Serviço;
import com.generation.econectar.model.Usuario;
import com.generation.econectar.repository.ServiçoRepository;

import jakarta.validation.Valid;
	
@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServiçoController {
	
	@Autowired
	private ServiçoRepository serviçorepository;
	
	@GetMapping
	public ResponseEntity<Page<Serviço>> getAll(Pageable pageble) {
		return ResponseEntity.ok(serviçorepository.findAll(pageble));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Serviço> getById( @PathVariable long id) {
		return serviçorepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeServico/{nomeServico}")
	public ResponseEntity<List<Serviço>> getByNomeServico(@PathVariable String nomeServico) {
		return ResponseEntity.ok(serviçorepository.findAllBynomeServicoContainingIgnoreCase(nomeServico));
	}
	
	@PostMapping
	public ResponseEntity<Serviço> post(@Valid @RequestBody Serviço serviço) {
		return ResponseEntity.status(201).body(serviçorepository.save(serviço));
	}
	
	@PutMapping("/{id}/comprar")
	public Serviço comprarServiço(@Valid @PathVariable long id, @RequestBody Usuario comprador) {
		Serviço serviço = serviçorepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
		serviço.setComprador(comprador);
		serviço.setStatus("Comprado");
		return serviçorepository.save(serviço);

	}
	@PutMapping("/{id}/vender")
	public Serviço venderServiço(@Valid  @PathVariable long id, @RequestBody Usuario vendedor) {
		Serviço serviço = serviçorepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
		serviço.setVendedor(vendedor);
		serviço.setStatus("Vendido");
		return serviçorepository.save(serviço);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Serviço> put(@Valid  @PathVariable long id, @RequestBody Serviço serviço) {
		serviço.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(serviçorepository.save(serviço));
	}
	

	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteServiço(@PathVariable long id) {
		Optional<Serviço> serviço = serviçorepository.findById(id);
		if (serviço.isPresent()) {
			serviçorepository.delete(serviço.get());
			
		}
	}

}
