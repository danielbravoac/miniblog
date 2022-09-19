package com.daniel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.daniel.dao.IPersonaDAO;
import com.daniel.model.Persona;

public class PersonaDAOImpl  implements IPersonaDAO{

    @Override
    public Integer registrar(Persona persona) throws Exception {
        System.out.println(persona.getNombres());
        return 1;
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
