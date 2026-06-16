package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.EstagioVenda;
import com.crmpratu.crm_api.repository.EstagioVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/estagio-venda")
public class EstagioVendaController {

	private final EstagioVendaRepository estagioVendaRepository;

	public EstagioVendaController(EstagioVendaRepository estagioVendaRepository) {
		this.estagioVendaRepository = estagioVendaRepository;
	}

	@GetMapping("/list")
	public List<EstagioVenda> findAll() {
		return estagioVendaRepository.findAll();
	}

}
