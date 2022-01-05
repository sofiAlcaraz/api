package com.apiRest.api.sinNombre;
import javax.persistence.*;

@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name= "idUser")
    private int idUser;
    @Column(name = "total")
    private float total;

    public Prestamo(){
    }
    public Prestamo(int id, int idUser){
        this.id=id;
        this.idUser=idUser;
    }
    public float getTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int  compareTo(Prestamo p){
        if(this.equals(p)){
            return 0;
        }
    return -1;
    }

}
