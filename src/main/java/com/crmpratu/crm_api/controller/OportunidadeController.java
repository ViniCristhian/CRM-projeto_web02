package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Oportunidade;
import com.crmpratu.crm_api.repository.OportunidadeRepository;
import com.crmpratu.crm_api.service.OportunidadeService;
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
@RequestMapping("/oportunidade")
public class OportunidadeController {

	private final OportunidadeRepository oportunidadeRepository;
	private final OportunidadeService oportunidadeService;

	public OportunidadeController(OportunidadeRepository oportunidadeRepository, OportunidadeService oportunidadeService) {
		this.oportunidadeRepository = oportunidadeRepository;
		this.oportunidadeService = oportunidadeService;
	}

	@GetMapping("/list")
	public List<Oportunidade> findAll() {
		return oportunidadeRepository.findAll();
	}

	@PostMapping
	public Oportunidade create(@Valid @RequestBody Oportunidade oportunidade) {
		return oportunidadeRepository.save(oportunidade);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Oportunidade> update(@PathVariable Long id, @Valid @RequestBody Oportunidade oportunidade) {
		return ResponseEntity.ok(oportunidadeService.update(id, oportunidade));
	}

}
