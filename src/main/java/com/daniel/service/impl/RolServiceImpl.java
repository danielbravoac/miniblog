package com.daniel.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.daniel.dao.IRolDAO;
import com.daniel.model.Rol;
import com.daniel.model.Usuario;
import com.daniel.model.UsuarioRol;
import com.daniel.service.IRolService;

@Named
public class RolServiceImpl implements IRolService, Serializable {

    @EJB
    private IRolDAO dao;

    @Override
    public Integer registrar(Rol t) throws Exception {
        return dao.registrar(t);
    }

    @Override
    public Integer modificar(Rol t) throws Exception {
        return dao.modificar(t);
    }

    @Override
    public Integer eliminar(Rol t) throws Exception {
        return dao.eliminar(t);
    }

    @Override
    public List<Rol> listar() throws Exception {
        return dao.listar();
    }

    @Override
    public Rol listarPorId(Rol t) throws Exception {
        return dao.listarPorId(t);
    }

    @Override
    public Integer asignar(Usuario usuario, List<Rol> roles) {
        List<UsuarioRol> usuarioRoles= new ArrayList<UsuarioRol>();
        roles.forEach(r->{
            UsuarioRol ur= new UsuarioRol();
            ur.setUsuario(usuario);
            ur.setRol(r);
            usuarioRoles.add(ur);
        });
        return dao.asignar(usuario, usuarioRoles);
    }

}
