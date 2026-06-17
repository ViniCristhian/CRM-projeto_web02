package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Conta;
import com.crmpratu.crm_api.repository.ContaRepository;
import com.crmpratu.crm_api.service.ContaService;
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
@RequestMapping("/conta")
public class ContaController {

	private final ContaRepository contaRepository;
	private final ContaService contaService;

	public ContaController(ContaRepository contaRepository, ContaService contaService) {
		this.contaRepository = contaRepository;
		this.contaService = contaService;
	}

	@GetMapping("/list")
	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

	@PostMapping
	public Conta create(@Valid @RequestBody Conta conta) {
		return contaRepository.save(conta);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Conta> update(@PathVariable Long id, @Valid @RequestBody Conta conta) {
		return ResponseEntity.ok(contaService.update(id, conta));
	}

}
