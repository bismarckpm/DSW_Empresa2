package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "ocupacion" )
public class Ocupacion extends EntidadBase {
    
    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;
    
    //Getters, Setters, y otros metodos.


    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Ocupacion(long id){
        super(id);
    }

    public Ocupacion (String estatus) {
        super(estatus);
    }
    
    public Ocupacion(){
        super();
    }

    @Override
    public String toString() {
        return "Ocupacion{" +
                "_nombre='" + _nombre + '\'' +
                '}';
    }
}
