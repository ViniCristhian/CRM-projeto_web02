package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Contato;
import com.crmpratu.crm_api.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	private final ContatoRepository contatoRepository;

	public ContatoController(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}

	@GetMapping("/list")
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}

}
