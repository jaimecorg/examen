package com.jaimecorg.examen.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.examen.model.Permiso;
import com.jaimecorg.examen.repository.PermisoRepository;
import com.jaimecorg.examen.services.PermisosServices;

@Service
public class PermisosServiceImpl implements PermisosServices {

    @Autowired
    PermisoRepository repository;

    @Override
    public Permiso findByID(int codigo) {
        Optional<Permiso> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Permiso permiso) {
        repository.save(permiso);   
    }

    @Override
    public void update(Permiso permiso) {
        repository.save(permiso);
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
