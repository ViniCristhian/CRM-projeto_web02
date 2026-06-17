package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Interacao;
import com.crmpratu.crm_api.repository.InteracaoRepository;
import com.crmpratu.crm_api.service.InteracaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/interacao")
public class InteracaoController {

	private final InteracaoRepository interacaoRepository;
	private final InteracaoService interacaoService;

	public InteracaoController(InteracaoRepository interacaoRepository, InteracaoService interacaoService) {
		this.interacaoRepository = interacaoRepository;
		this.interacaoService = interacaoService;
	}

	@GetMapping("/list")
	public List<Interacao> findAll() {
		return interacaoRepository.findAll();
	}

	@PostMapping
	public Interacao create(@Valid @RequestBody Interacao interacao) {
		return interacaoRepository.save(interacao);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Interacao> update(@PathVariable Long id, @Valid @RequestBody Interacao interacao) {
		return ResponseEntity.ok(interacaoService.update(id, interacao));
	}

}
