package com.daniel.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.daniel.dao.IPersonaDAO;
import com.daniel.model.Persona;
//Aqui estamos reservando una instancia en memoria de esta 
//@Named
//Dispoisición para transacciones
@Stateless
public class PersonaDAOImpl  implements IPersonaDAO, Serializable{
    //Maneja las entidades
    @PersistenceContext(unitName="blog-persitence-unit")
    private EntityManager entityManager;


    @Override
    public Integer registrar(Persona persona) throws Exception {
        try {
            //Con esto hemos realizado la inserción
            //entityManager.getTransaction().begin();
            entityManager.persist(persona);
            //entityManager.getTransaction().commit();
        } catch (Exception e) {
            //entityManager.getTransaction().rollback();
        }
        return persona.getIdPersona();
    }

    @Override
    public Integer modificar(Persona persona) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer eliminar(Persona persona) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> lista= new ArrayList<>();
        Persona persona=new Persona();
        persona.setNombres("Jose");
        persona.setApellidos("Calvario");
        persona.setIdPersona(1);
        lista.add(persona);
        return lista;
    }

    @Override
    public Persona listarPorId(Persona persona) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
}
