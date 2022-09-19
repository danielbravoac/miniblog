package com.daniel.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.daniel.model.Persona;
import com.daniel.service.IPersonaService;
import com.daniel.service.impl.PersonaServiceImpl;

@Named
@RequestScoped
public class PersonaBean implements Serializable {
    //Llamando al servicio
    private IPersonaService personaService;
    //Llamando a la entidad
    private Persona persona;

    private List<Persona> personaList;
    

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public PersonaBean(){
        this.persona = new Persona();
        this.personaService = new PersonaServiceImpl();
        this.listar();
    }

    public void registrar(){
        try {
            this.personaService.registrar(this.persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar(){
        try {
            this.personaList = this.personaService.listar();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    
}
