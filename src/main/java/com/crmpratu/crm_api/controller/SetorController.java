package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Setor;
import com.crmpratu.crm_api.repository.SetorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/setor")
public class SetorController {

	private final SetorRepository setorRepository;

	public SetorController(SetorRepository setorRepository) {
		this.setorRepository = setorRepository;
	}

	@GetMapping("/list")
	public List<Setor> findAll() {
		return setorRepository.findAll();
	}

	@PostMapping
	public Setor create(@Valid @RequestBody Setor setor) {
		return setorRepository.save(setor);
	}

}
