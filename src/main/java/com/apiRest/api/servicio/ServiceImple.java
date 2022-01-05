package com.apiRest.api.servicio;

import com.apiRest.api.Dao.DaoImplemetacion;
import com.apiRest.api.sinNombre.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImple implements ServiceIntermediario {
    /*@Service, para indicar que es un
     servicio y también de @Autowired para inyectar DAO usarlo*/
    @Autowired
    private DaoImplemetacion daoImp ;

    public ServiceImple(){
     daoImp=new DaoImplemetacion();
    }


    @Override
    public void save(Usuario usu) {
        daoImp.save(usu);
    }

    @Override
    public void deleteById(int id) {
        daoImp.deleteById(id);
    }


    @Override
    public Usuario findById(int id) {
       Usuario usu= daoImp.findById(id);
        return usu;
    }
}
