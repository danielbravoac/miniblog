package com.daniel.dao;

import javax.ejb.Local;

import com.daniel.model.Usuario;

@Local
public interface IUsuarioDAO extends ICRUD<Usuario>{
    
    String traerPassHashed(String usuario);

    Usuario leerPorNombreUsuario(String us);
}
