package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Conta;
import com.crmpratu.crm_api.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
