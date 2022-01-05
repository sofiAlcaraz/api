package com.apiRest.api.servicio;

import com.apiRest.api.sinNombre.Usuario;

public interface ServiceIntermediario {
    /*interemediario entre el DAO y el controlador(La
    clase que gestionará las peticiones de la API.*/
    public void  save(Usuario usu);

    public void deleteById(int id);

    public Usuario findById(int id);

}
