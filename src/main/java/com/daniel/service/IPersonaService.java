package com.daniel.service;

import java.util.List;

import com.daniel.model.Persona;

public interface IPersonaService {
    public Integer registrar(Persona persona) throws Exception;
    public Integer modificar(Persona persona) throws Exception;
    public Integer eliminar(Persona persona) throws Exception;
    public List<Persona> listar() throws Exception;
    public Persona listarPorId(Persona persona) throws Exception;
}
