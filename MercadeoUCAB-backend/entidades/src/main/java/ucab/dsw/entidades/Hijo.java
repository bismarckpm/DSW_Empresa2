
package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "hijo" )
public class Hijo extends EntidadBase{
    
    //Columnas
    
    @Column( name = "fechaNacimiento" )
    private Date _fechaNacimiento;
    
    @Column( name = "genero" )
    private String _genero;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_informacion")
    private Informacion _informacion;
    
    ////Getters, Setters, y otros metodos.


    public Informacion get_informacion() {
        return _informacion;
    }

    public void set_informacion(Informacion _informacion) {
        this._informacion = _informacion;
    }

    public String get_genero() {
        return _genero;
    }

    public void set_genero(String _genero) {
        this._genero = _genero;
    }

    public Date get_fechaNacimiento() {
        return _fechaNacimiento;
    }

    public void set_fechaNacimiento(Date _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }

    public Hijo (long id){
        super(id);
    }

    public Hijo (String estatus) {
        super(estatus);
    }

    @Override
    public String toString() {
        return "Hijo{" +
                "_fechaNacimiento=" + _fechaNacimiento +
                ", _genero='" + _genero + '\'' +
                ", _informacion=" + _informacion +
                '}';
    }

    public Hijo(){
        super();
    }
}
