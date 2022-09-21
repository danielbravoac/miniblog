package com.daniel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import com.daniel.model.Persona;
import com.daniel.model.Rol;
import com.daniel.model.Usuario;
import com.daniel.service.IPersonaService;
import com.daniel.service.IRolService;

@Named
//Para mantener con estados de la página y AJAX
@ViewScoped
public class RegistroBean implements Serializable {

    private Persona persona;
    private Usuario usuario;
    @Inject
    private IPersonaService personaService;
    @Inject
    private IRolService rolService;


    @PostConstruct
    public void init(){
        this.persona = new Persona();
        this.usuario = new Usuario();
    }

    //Esta anotación apoya a la integridad de datos, si algo sale mal en el camino no se inserta, el bloque de código se vuelve uno solo
    @Transactional
    public String registrar(){
        String redireccion="";
        try {
            String clave=this.usuario.getContrasena();
            String claveHash=BCrypt.hashpw(clave, BCrypt.gensalt());
            this.usuario.setContrasena(claveHash);
            this.usuario.setPersona(this.persona);
            this.persona.setUsuario(this.usuario);
            this.personaService.registrar(this.persona);
            
            List<Rol> roles = new ArrayList<>();
            Rol r = new Rol();
            r.setId(1);
            roles.add(r);
            this.rolService.asignar(this.usuario, roles);
            redireccion="index?faces-redirect=true";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return redireccion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
}
