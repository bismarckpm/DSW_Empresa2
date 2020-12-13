package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "telefono" )
public class Telefono extends EntidadBase{
    
    //Columnas
    
    @Column( name = "numero" )
    private int _numero;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_informacion")
    private Informacion _informacion;
    
    //Getters, Setters, y otros metodos.


    public Informacion get_informacion() {
        return _informacion;
    }

    public void set_informacion(Informacion _informacion) {
        this._informacion = _informacion;
    }

    public int get_numero() {
        return _numero;
    }

    public void set_numero(int _numero) {
        this._numero = _numero;
    }

    public Telefono (long id){
        super(id);
    }

    public Telefono (String estatus) {
        super(estatus);
    }
    
    public Telefono (){
        super();
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "_numero=" + _numero +
                ", _informacion=" + _informacion +
                '}';
    }
}
