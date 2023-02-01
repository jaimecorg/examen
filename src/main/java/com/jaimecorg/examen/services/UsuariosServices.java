package com.jaimecorg.examen.services;

import java.util.List;

import com.jaimecorg.examen.model.Usuario;


public interface UsuariosServices {
    public Usuario findByID(int codigo);
    public List<Usuario> findAll();

    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int codigo);
}
