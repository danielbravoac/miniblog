package com.daniel.dao;

import java.util.List;

import javax.ejb.Local;

import com.daniel.model.Persona;
//Significa que el contexto de la JVM está en la misma computadora
@Local
public interface IPersonaDAO extends ICRUD<Persona>{

}
