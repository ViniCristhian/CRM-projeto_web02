package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.StatusTarefa;
import com.crmpratu.crm_api.repository.StatusTarefaRepository;
import com.crmpratu.crm_api.service.StatusTarefaService;
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
@RequestMapping("/status-tarefa")
public class StatusTarefaController {

	private final StatusTarefaRepository statusTarefaRepository;
	private final StatusTarefaService statusTarefaService;

	public StatusTarefaController(StatusTarefaRepository statusTarefaRepository, StatusTarefaService statusTarefaService) {
		this.statusTarefaRepository = statusTarefaRepository;
		this.statusTarefaService = statusTarefaService;
	}

	@GetMapping("/list")
	public List<StatusTarefa> findAll() {
		return statusTarefaRepository.findAll();
	}

	@PostMapping
	public StatusTarefa create(@Valid @RequestBody StatusTarefa statusTarefa) {
		return statusTarefaRepository.save(statusTarefa);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<StatusTarefa> update(@PathVariable Long id, @Valid @RequestBody StatusTarefa statusTarefa) {
		return ResponseEntity.ok(statusTarefaService.update(id, statusTarefa));
	}

}
