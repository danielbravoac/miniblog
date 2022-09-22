package com.daniel.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.daniel.model.Rol;
import com.daniel.service.IRolService;

@Named
@ViewScoped
public class RolBean implements Serializable{
    
    private List<Rol> lista;
    @Inject
    private IRolService service;

    @PostConstruct
    public void init(){
        this.listar();
    }

    public void listar(){
        try {
            lista= service.listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Rol> getLista() {
        return lista;
    }

    public void setLista(List<Rol> lista) {
        this.lista = lista;
    }

}
