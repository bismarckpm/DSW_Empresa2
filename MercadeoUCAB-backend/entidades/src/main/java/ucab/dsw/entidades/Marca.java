
package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "marca" )
public class Marca extends EntidadBase{
    
    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;

    @Column( name = "descripcion")
    private String _descripcion;
    
    //Getters, Setters, y otros metodos.

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public Marca (long id){
        super(id);
    }

    public Marca (String estatus) {
        super(estatus);
    }
    
    public Marca (){
        super();
    }

    @Override
    public String toString() {
        return "Marca{" +
                "_nombre='" + _nombre + '\'' +
                ", _descripcion='" + _descripcion + '\'' +
                '}';
    }
}
