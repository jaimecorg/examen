package com.jaimecorg.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.examen.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
