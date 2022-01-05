package com.apiRest.api.Dao;

import com.apiRest.api.sinNombre.Usuario;

import java.util.List;

/*un objeto de acceso a datos(DAO) es un componente de software
que suministra una interfaz común entre la aplicación y uno o más dispositivos de almacenamiento de
datos,como una Base de datos o un archivo.*/
public interface Dao {

    public List<Usuario> findAll();

    public void  save(Usuario usu);

    public void deleteById(int id);

    public Usuario findById(int id);

}
