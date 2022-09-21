package com.daniel.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    private Integer id;

    //Comportamiento en cascada para reflejar lo que sucede en ambas tablas
    @OneToOne(cascade = CascadeType.ALL)
    //Viene a representar la duplicidad de llaves, que es foranea y primaria a la vez
    @MapsId
    //Campo para representar la llave foranea
    @JoinColumn(name = "id",nullable = false)
    private Persona persona;

    @Column(name = "usuario", nullable = false, length = 30)
    private String usuario;

    @Column(name = "contrasena", nullable = false, length = 80)
    private String contrasena;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado="A";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
