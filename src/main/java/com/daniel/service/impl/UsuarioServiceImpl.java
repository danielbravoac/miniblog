package com.daniel.service.impl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.daniel.dao.IUsuarioDAO;
import com.daniel.model.Usuario;
import com.daniel.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService, Serializable {


    @EJB
    private IUsuarioDAO dao;

    @Override
    public Usuario login(Usuario us) {
        String clave=us.getContrasena();
        String claveHash=dao.traerPassHashed(us.getUsuario());

        if(BCrypt.checkpw(clave, claveHash)){
            return dao.leerPorNombreUsuario(us.getUsuario());
        }

        return new Usuario();
    }
    
}
