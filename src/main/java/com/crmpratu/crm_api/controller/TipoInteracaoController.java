package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.TipoInteracao;
import com.crmpratu.crm_api.repository.TipoInteracaoRepository;
import com.crmpratu.crm_api.service.TipoInteracaoService;
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
@RequestMapping("/tipo-interacao")
public class TipoInteracaoController {

	private final TipoInteracaoRepository tipoInteracaoRepository;
	private final TipoInteracaoService tipoInteracaoService;

	public TipoInteracaoController(TipoInteracaoRepository tipoInteracaoRepository, TipoInteracaoService tipoInteracaoService) {
		this.tipoInteracaoRepository = tipoInteracaoRepository;
		this.tipoInteracaoService = tipoInteracaoService;
	}

	@GetMapping("/list")
	public List<TipoInteracao> findAll() {
		return tipoInteracaoRepository.findAll();
	}

	@PostMapping
	public TipoInteracao create(@Valid @RequestBody TipoInteracao tipoInteracao) {
		return tipoInteracaoRepository.save(tipoInteracao);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<TipoInteracao> update(@PathVariable Long id, @Valid @RequestBody TipoInteracao tipoInteracao) {
		return ResponseEntity.ok(tipoInteracaoService.update(id, tipoInteracao));
	}

}
