package com.jaimecorg.examen.services;

import com.jaimecorg.examen.model.Grupo;


public interface GruposServices {
    public Grupo findByID(int codigo);
    public void insert(Grupo grupo);
    public void update(Grupo grupo);
    public void delete(int codigo);
}
