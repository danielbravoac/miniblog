package com.daniel.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import com.daniel.dao.IPersonaDAO;
import com.daniel.dao.impl.PersonaDAOImpl;
import com.daniel.model.Persona;
import com.daniel.service.IPersonaService;

@Named
public class PersonaServiceImpl implements IPersonaService, Serializable {

    //Inject reemplaza en constructor porque hace que exista una instancia de la implementación
    //La inyeccion de dependencias se usa porque se instancia con un patrón Singleton, solo se instancia una sola vez
    //@Inject

    //Representa mejor la inyección de lo que hay en el DAO, un EJB
    @EJB
    private IPersonaDAO dao;

    //Nos comunicamos con la capa DAO para evitar la refactorización en cuanto a cambios y para mejorar los métodos con su lógica en esta capa
   /*/ public PersonaServiceImpl(){
        dao= new PersonaDAOImpl();
    }*/
    @Override
    public Integer registrar(Persona persona) throws Exception {
        return dao.registrar(persona);
    }

    @Override
    public Integer modificar(Persona persona) throws Exception {
        return dao.modificar(persona);
    }

    @Override
    public Integer eliminar(Persona persona) throws Exception {
        return dao.eliminar(persona);
    }

    @Override
    public List<Persona> listar() throws Exception {
        return dao.listar();
    }

    @Override
    public Persona listarPorId(Persona persona) throws Exception {
        return dao.listarPorId(persona);
    }
    
}
