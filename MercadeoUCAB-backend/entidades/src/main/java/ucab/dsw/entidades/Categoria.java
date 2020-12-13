/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "categoria" )
public class Categoria extends EntidadBase{
    
    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;

    @Column (name = "descripcion")
    private String _descripcion;
    
    //Getters, Setters, y otros metodos.

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Categoria (long id){
        super(id);
    }

    public Categoria (String estatus) {
        super(estatus);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "_nombre='" + _nombre + '\'' +
                ", _descripcion='" + _descripcion + '\'' +
                '}';
    }

    public Categoria(){
        super();
    }
}

