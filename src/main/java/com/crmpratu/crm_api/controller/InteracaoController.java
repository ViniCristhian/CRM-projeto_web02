package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Interacao;
import com.crmpratu.crm_api.repository.InteracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/interacao")
public class InteracaoController {

	private final InteracaoRepository interacaoRepository;

	public InteracaoController(InteracaoRepository interacaoRepository) {
		this.interacaoRepository = interacaoRepository;
	}

	@GetMapping("/list")
	public List<Interacao> findAll() {
		return interacaoRepository.findAll();
	}

}
