package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Interacao;
import com.crmpratu.crm_api.repository.InteracaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/interacao")
public class InteracaoController {

	private final InteracaoRepository interacaoRepository;

	public InteracaoController(InteracaoRepository interacaoRepository) {
		this.interacaoRepository = interacaoRepository;
	}

	@GetMapping("/list")
	public List<Interacao> findAll() {
		return interacaoRepository.findAll();
	}

	@PostMapping
	public Interacao create(@Valid @RequestBody Interacao interacao) {
		return interacaoRepository.save(interacao);
	}

}
