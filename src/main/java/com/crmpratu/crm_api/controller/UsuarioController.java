package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Usuario;
import com.crmpratu.crm_api.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;

	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/list")
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@PostMapping
	public Usuario create(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
