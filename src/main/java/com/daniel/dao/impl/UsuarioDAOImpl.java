package com.daniel.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.daniel.dao.IUsuarioDAO;
import com.daniel.model.Usuario;

@Stateless
public class UsuarioDAOImpl implements IUsuarioDAO, Serializable{

    @PersistenceContext(unitName = "blog-persitence-unit")
    private EntityManager entityManager;

    @Override
    public Integer registrar(Usuario t) throws Exception {
        entityManager.persist(t);
        return t.getPersona().getIdPersona();
    }

    @Override
    public Integer modificar(Usuario t) throws Exception {
        entityManager.merge(t);
        return t.getPersona().getIdPersona();
    }

    @Override
    public Integer eliminar(Usuario t) throws Exception {
        entityManager.remove(entityManager.merge(t));
        return 1;
    }

    @Override
    public List<Usuario> listar() throws Exception {
        List<Usuario> lista= new ArrayList<Usuario>();
        try {
            Query q = entityManager.createQuery("SELECT u FROM Usuario u");
            lista = (List<Usuario>) q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return lista;

    }

    @Override
    public Usuario listarPorId(Usuario t) throws Exception {

        Usuario us= new Usuario();
        List<Usuario> lista= new ArrayList<Usuario>();
        try {
            // JPQL= QueryLanguage
        Query q = entityManager.createQuery("FROM Usuario u WHERE u.id = ?1");
        q.setParameter(1, t.getId());

        lista = (List<Usuario>) q.getResultList();
        if(lista != null && !lista.isEmpty()){
            us=lista.get(0); 
        }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return us;
    }

    @Override
    public String traerPassHashed(String usuario) {

        Usuario us = new Usuario();
        try {
            Query q = entityManager.createQuery("FROM Usuario u WHERE u.usuario=?1");
            q.setParameter(1, usuario);

            List<Usuario> lista=q.getResultList();
            if(!lista.isEmpty()) {
                us=lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return us!=null && us.getId()!=null ? us.getContrasena():"";
    }

    @Override
    public Usuario leerPorNombreUsuario(String us) {

        Usuario usuario= new Usuario();
        List<Usuario> lista= new ArrayList<Usuario>();
        try {
            // JPQL= QueryLanguage
        Query q = entityManager.createQuery("FROM Usuario u WHERE u.usuario = ?1");
        q.setParameter(1, us);

        lista = (List<Usuario>) q.getResultList();
        if(lista != null && !lista.isEmpty()){
            usuario=lista.get(0); 
        }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return usuario;
    }
    
}
