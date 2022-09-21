package com.daniel.service;

import java.util.List;

import com.daniel.model.Rol;
import com.daniel.model.Usuario;

public interface IRolService extends IService<Rol>{ 
    Integer asignar(Usuario usuario, List<Rol> usuarioRol);

}
