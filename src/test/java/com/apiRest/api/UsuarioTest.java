package com.apiRest.api;

import com.apiRest.api.sinNombre.Usuario;
import org.junit.jupiter.api.Test;

import java.beans.Transient;

public class UsuarioTest {

    @Test
    public void newTest(){
        Usuario so=new Usuario(1,"sofia","alcaraz","sofiasdsd@dsafd.com");
        Usuario so1=new Usuario(3,"zzz","alcaraz","sofiasdsd@dsafd.com");
        Usuario so2=new Usuario(2,"mmm","alcaraz","sofiasdsd@dsafd.com");
        so.getApellido();
    }

    @Test
    public void newIdErroneoTest(){
        Usuario so=new Usuario(0,"sofia","alcaraz","sofiasdsd@dsafd.com");
        so.getApellido();
    }
    @Test
    public void newNUllTest(){
        Usuario so=new Usuario(0,null,"alcaraz","sofiasdsd@dsafd.com");
        so.getApellido();
    }



}
