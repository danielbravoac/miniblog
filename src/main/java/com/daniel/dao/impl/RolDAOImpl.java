package com.daniel.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.daniel.dao.IRolDAO;
import com.daniel.model.Rol;
import com.daniel.model.Usuario;
import com.daniel.model.UsuarioRol;

@Stateless
public class RolDAOImpl implements IRolDAO, Serializable {

    @PersistenceContext(unitName = "blog-persitence-unit")
    private EntityManager entityManager;

    @Override
    public Integer registrar(Rol t) throws Exception {
        entityManager.persist(t);
        return t.getId();
    }

    @Override
    public Integer modificar(Rol t) throws Exception {
        // Merge es para realizar el update
        entityManager.merge(t);
        return t.getId();
    }

    @Override
    public Integer eliminar(Rol t) throws Exception {
        entityManager.remove(entityManager.merge(t));
        return 1;
    }

    @Override
    public List<Rol> listar() throws Exception {
        // JPQL= QueryLanguage
        Query q = entityManager.createQuery("SELECT r FROM Rol r");
        List<Rol> lista = (List<Rol>) q.getResultList();
        return lista;
    }

    @Override
    public Rol listarPorId(Rol t) throws Exception {
        // JPQL= QueryLanguage
        Query q = entityManager.createQuery("FROM Rol r WHERE r.id = ?1");
        q.setParameter(1, t.getId());
    
        List<Rol> lista = (List<Rol>) q.getResultList();
        return lista != null && !lista.isEmpty() ? lista.get(0) : new Rol();
    }

    @Override
    public Integer asignar(Usuario usuario, List<UsuarioRol> roles) {
        //SQL Tradicional
        Query q= entityManager.createNativeQuery("DELETE FROM usuario_rol ur WHERE ur.id_usuario=?1");
        q.setParameter(1,usuario.getPersona().getIdPersona());
        q.executeUpdate();

        int[] i={0};
        roles.forEach(r -> {
            entityManager.persist(r);
            //Limpiando el entityManager            
            if(i[0]%100==0){
                entityManager.flush();
                entityManager.clear();
            }
            i[0]++;
        });
        return i[0];
    }

}
