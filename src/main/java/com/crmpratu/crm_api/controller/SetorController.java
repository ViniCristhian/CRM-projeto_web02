package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Setor;
import com.crmpratu.crm_api.repository.SetorRepository;
import com.crmpratu.crm_api.service.SetorService;
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
@RequestMapping("/setor")
public class SetorController {

	private final SetorRepository setorRepository;
	private final SetorService setorService;

	public SetorController(SetorRepository setorRepository, SetorService setorService) {
		this.setorRepository = setorRepository;
		this.setorService = setorService;
	}

	@GetMapping("/list")
	public List<Setor> findAll() {
		return setorRepository.findAll();
	}

	@PostMapping
	public Setor create(@Valid @RequestBody Setor setor) {
		return setorRepository.save(setor);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Setor> update(@PathVariable Long id, @Valid @RequestBody Setor setor) {
		return ResponseEntity.ok(setorService.update(id, setor));
	}

}
