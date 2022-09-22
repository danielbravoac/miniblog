package com.daniel.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.daniel.model.Usuario;
import com.daniel.service.IUsuarioService;

@Named
@ViewScoped
public class indexBean implements Serializable{
    
    private Usuario usuario;

    @Inject
    private IUsuarioService usuarioService;

    @PostConstruct
    public void init(){
        this.usuario = new Usuario();
    }
    
    public String login(){
        String redireccion="";
        try {
            Usuario us= usuarioService.login(usuario);
            if(us!=null&&us.getEstado().equalsIgnoreCase("A")){
                //Almacener la sesion de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                redireccion="/protegido/roles?faces-redirect=true";
            }else{
                //Obtener la instancias de faces
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            // TODO: handle excepton
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));

        }
        return redireccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
