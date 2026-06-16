package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Oportunidade;
import com.crmpratu.crm_api.repository.OportunidadeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/oportunidade")
public class OportunidadeController {

	private final OportunidadeRepository oportunidadeRepository;

	public OportunidadeController(OportunidadeRepository oportunidadeRepository) {
		this.oportunidadeRepository = oportunidadeRepository;
	}

	@GetMapping("/list")
	public List<Oportunidade> findAll() {
		return oportunidadeRepository.findAll();
	}

	@PostMapping
	public Oportunidade create(@Valid @RequestBody Oportunidade oportunidade) {
		return oportunidadeRepository.save(oportunidade);
	}

}
