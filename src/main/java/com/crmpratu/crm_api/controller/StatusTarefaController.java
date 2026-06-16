package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.StatusTarefa;
import com.crmpratu.crm_api.repository.StatusTarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
