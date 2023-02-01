package com.jaimecorg.examen.services;

import com.jaimecorg.examen.model.Permiso;

public interface PermisosServices {
    public Permiso findByID(int codigo);
    public void insert(Permiso permiso);
    public void update(Permiso permiso);
    public void delete(int codigo);
}
