package com.jaimecorg.examen.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.examen.model.Grupo;
import com.jaimecorg.examen.repository.GrupoRepository;
import com.jaimecorg.examen.services.GruposServices;

@Service
public class GruposServiceImpl implements GruposServices {

    @Autowired
    GrupoRepository repository;


    @Override
    public Grupo findByID(int codigo) {
        Optional<Grupo> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Grupo grupo) {
        repository.save(grupo);   
    }

    @Override
    public void update(Grupo grupo) {
        repository.save(grupo);
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);
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
