package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.TipoInteracao;
import com.crmpratu.crm_api.repository.TipoInteracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/tipo-interacao")
public class TipoInteracaoController {

	private final TipoInteracaoRepository tipoInteracaoRepository;

	public TipoInteracaoController(TipoInteracaoRepository tipoInteracaoRepository) {
		this.tipoInteracaoRepository = tipoInteracaoRepository;
	}

	@GetMapping("/list")
	public List<TipoInteracao> findAll() {
		return tipoInteracaoRepository.findAll();
	}

}
