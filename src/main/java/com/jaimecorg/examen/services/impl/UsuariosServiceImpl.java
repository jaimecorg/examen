package com.jaimecorg.examen.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.examen.model.Usuario;
import com.jaimecorg.examen.repository.UsuarioRepository;
import com.jaimecorg.examen.services.UsuariosServices;


@Service
public class UsuariosServiceImpl implements UsuariosServices {

    @Autowired
    UsuarioRepository repository;


    @Override
    public Usuario findByID(int codigo) {
        Optional<Usuario> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Usuario usuario) {
        repository.save(usuario);   
    }

    @Override
    public void update(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    /* CON DAO

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public Page<Cliente> findAll(Pageable page) {
        return clientesDAO.findAll(page);
    }

    @Override
    public Cliente findByID(int codigo){
        return clientesDAO.findByID(codigo);
    }

    @Override
    public void insert(Cliente cliente){
        clientesDAO.insert(cliente);
    }

    @Override
    public void update(Cliente cliente){
        clientesDAO.update(cliente);
    }

    @Override
    public void delete(int codigo){
        clientesDAO.delete(codigo);
    }
    */
}
