package com.apiRest.api.Dao;


import com.apiRest.api.sinNombre.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository //indica que es un Dao/para acceso a base de datos
public class DaoImplemetacion implements Dao{


    @Autowired
    private EntityManager manejador;

    @Override
    public void save(Usuario usu) {
        EntityManagerFactory manejador1= Persistence.createEntityManagerFactory("usuario");
        manejador=manejador1.createEntityManager();
    Session sesion=manejador.unwrap(Session.class);
    sesion.saveOrUpdate(usu);
    }
    /*ejecuta un trigger que borra todo o creo una funcion que lo cree y corra*/
    @Override
    public void deleteById(int identificador) {

        Session sesion=manejador.unwrap(Session.class);
      //  borrarPrestamos(identificador);
        Query unaQuery=sesion.createQuery("deleted from usuario where id:=idParam");
        unaQuery.setParameter("idParam",identificador);
        unaQuery.executeUpdate();

    }

    @Override
    public List<Usuario> findAll() {
        Session sesion =manejador.unwrap(Session.class);
        Query<Usuario> unaQuery=sesion.createQuery("select * from usuario;",Usuario.class);
        List<Usuario> usuarios= unaQuery.getResultList();

        return usuarios;
    }


    public Usuario findById(int id) {
        Session sesion=manejador.unwrap(Session.class);
        Usuario usu=sesion.get(Usuario.class,id);
        return usu;
    }

    /*private void borrarPrestamos(int identificador) {
        Session sesion=manejador.unwrap(Session.class);
        Query unaQuery=sesion.createQuery("deleted from prestamo where idUser:=idParam");
        unaQuery.setParameter("idParam",identificador);
        unaQuery.executeUpdate();
    }*/
}
