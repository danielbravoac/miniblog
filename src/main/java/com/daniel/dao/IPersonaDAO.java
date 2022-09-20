package com.daniel.dao;

import java.util.List;

import javax.ejb.Local;

import com.daniel.model.Persona;
//Significa que el contexto de la JVM está en la misma computadora
@Local
public interface IPersonaDAO {
    public Integer registrar(Persona persona) throws Exception;
    public Integer modificar(Persona persona) throws Exception;
    public Integer eliminar(Persona persona) throws Exception;
    public List<Persona> listar() throws Exception;
    public Persona listarPorId(Persona persona) throws Exception;
}
