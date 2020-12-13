package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "rol" )
public class Rol extends EntidadBase{

    //Columnas

    @Column( name = "nombre" )
    private String _nombre;

    //Getters, setters y otros metodos


    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Rol (long id){
        
        super( id );
    }

    public Rol (String estatus) {
        super(estatus);
    }
    
    public Rol () {
        super();
    }

    @Override
    public String toString() {
        return "Rol{" +
                "_nombre='" + _nombre + '\'' +
                '}';
    }
}
