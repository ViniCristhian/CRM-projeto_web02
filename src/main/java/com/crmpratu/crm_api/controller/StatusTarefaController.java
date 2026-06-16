package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.StatusTarefa;
import com.crmpratu.crm_api.repository.StatusTarefaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/status-tarefa")
public class StatusTarefaController {

	private final StatusTarefaRepository statusTarefaRepository;

	public StatusTarefaController(StatusTarefaRepository statusTarefaRepository) {
		this.statusTarefaRepository = statusTarefaRepository;
	}

	@GetMapping("/list")
	public List<StatusTarefa> findAll() {
		return statusTarefaRepository.findAll();
	}

	@PostMapping
	public StatusTarefa create(@Valid @RequestBody StatusTarefa statusTarefa) {
		return statusTarefaRepository.save(statusTarefa);
	}

}
