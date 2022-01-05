package com.apiRest.api.controller;

import com.apiRest.api.servicio.ServiceImple;
import com.apiRest.api.sinNombre.Usuario;
import org.springframework.web.bind.annotation.*;


//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
public class RestCOntroller {
    /*estionar las peticiones que se hagan a nuestra API*/
    private ServiceImple serviceImple;

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/users/  */
    @PostMapping("/users")
    public Usuario addUser(@RequestBody Usuario user) {
        //Este metodo guardará al usuario enviado
        serviceImple.save(user);
        return user;

    }

    @DeleteMapping("users/{userId}")
    public String deleteById(@PathVariable int id) {

        Usuario user = serviceImple.findById(id);

        if(user == null) {
            throw new RuntimeException("Usuario no encontrado con id-"+id);
        }
    //Este metodo borrará al usuario con id  y sus prestamos
        serviceImple.deleteById(id);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Usuario borrado - "+id;


    }

}
