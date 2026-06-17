package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Tarefa;
import com.crmpratu.crm_api.repository.TarefaRepository;
import com.crmpratu.crm_api.service.TarefaService;
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
@RequestMapping("/tarefa")
public class TarefaController {

	private final TarefaRepository tarefaRepository;
	private final TarefaService tarefaService;

	public TarefaController(TarefaRepository tarefaRepository, TarefaService tarefaService) {
		this.tarefaRepository = tarefaRepository;
		this.tarefaService = tarefaService;
	}

	@GetMapping("/list")
	public List<Tarefa> findAll() {
		return tarefaRepository.findAll();
	}

	@PostMapping
	public Tarefa create(@Valid @RequestBody Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Tarefa> update(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
		return ResponseEntity.ok(tarefaService.update(id, tarefa));
	}

}
