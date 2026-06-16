package com.crmpratu.crm_api.repository;

import com.crmpratu.crm_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
