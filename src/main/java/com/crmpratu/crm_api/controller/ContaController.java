package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Conta;
import com.crmpratu.crm_api.repository.ContaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

	private final ContaRepository contaRepository;

	public ContaController(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@GetMapping("/list")
	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

	@PostMapping
	public Conta create(@Valid @RequestBody Conta conta) {
		return contaRepository.save(conta);
	}

}
