package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Tarefa;
import com.crmpratu.crm_api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	private final TarefaRepository tarefaRepository;

	public TarefaController(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}

	@GetMapping("/list")
	public List<Tarefa> findAll() {
		return tarefaRepository.findAll();
	}

}
