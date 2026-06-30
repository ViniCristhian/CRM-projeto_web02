package com.crmpratu.crm_api.service;

import com.crmpratu.crm_api.model.Usuario;
import com.crmpratu.crm_api.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public Usuario update(Long id, Usuario usuario) {
        BeanUtils.copyProperties(usuario, findUsuarioById(id), "id");
        return usuarioRepository.save(usuario);
    }

    public void updateActiveProperty(Long id, Boolean ativo) {
        Usuario usuarioSaved = findUsuarioById(id);
        usuarioSaved.setAtivo(ativo);
        usuarioRepository.save(usuarioSaved);
    }

}
