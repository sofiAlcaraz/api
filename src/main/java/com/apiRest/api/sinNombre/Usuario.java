package com.apiRest.api.sinNombre;

import org.apache.tomcat.jni.User;

import javax.persistence.*;
import java.util.LinkedList;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;

    private LinkedList<Prestamo>prestamos;

    public Usuario(){
    }
    public Usuario(int id, String nombre, String apellido, String email) {
        if(id<=0 && nombreInvalido(nombre) && apellidoInvalido(apellido) && emailInvalido(email) ){
             throw new IllegalArgumentException("Los argumentos son invalidos");
        }
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        prestamos=new LinkedList<>();
    }

    private boolean nombreInvalido(String nombre) {
        return (nombre.equals(null)) ;
    }

    private boolean emailInvalido(String email) {
        return email.equals(null);
    }

    private boolean apellidoInvalido(String apellido) {
        return apellido.equals(null);
    }

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void agregarPrestamo(Prestamo prest){
        if(prest.equals(null) || prestamos.contains(prest)){
            throw new IllegalArgumentException("prestamo invalido");
        }
        prestamos.add(prest);
    }
    public void eliminarPrestamo(Prestamo prest){
        if(prestamos.contains(prest)){
            prestamos.remove(prest);
        }
    }
    @Override
    public String toString(){
        return "nombre: "+nombre+"apellido: "+apellido+"id: "+id+"email: "+email;
    }
}
