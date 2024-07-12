package com.generation.econectar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.generation.econectar.model.Categorial;
import com.generation.econectar.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categorias")

public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<Categorial>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categorial> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nomeCategoria/{nome_categoria}")
	public ResponseEntity<List<Categorial>> getByNomeCategoria(@PathVariable String nomeCategoria) {
		return ResponseEntity.ok(repository.findAllBynomeCategoriaContainingIgnoreCase(nomeCategoria));
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categorial>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Categorial> post(@Valid @RequestBody Categorial categoria) {
		return ResponseEntity.status(201).body(repository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Categorial> put(@Valid @RequestBody Categorial categoria) {
		return repository.findById(categoria.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria)))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Categorial> categoria = repository.findById(id);
		if (categoria.isPresent()) {
			repository.deleteById(id);
		}

	}
}