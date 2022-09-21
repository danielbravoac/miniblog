package com.daniel.dao;

import java.util.List;

import javax.ejb.Local;

import com.daniel.model.Rol;
import com.daniel.model.Usuario;
import com.daniel.model.UsuarioRol;

@Local
public interface IRolDAO extends ICRUD<Rol>{
    
    Integer asignar(Usuario usuario, List<UsuarioRol> usuarioRol);
}
