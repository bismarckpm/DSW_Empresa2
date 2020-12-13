package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "nivel_economico" )
public class NivelEconomico extends EntidadBase{
    
    //Columnas
    
    @Column( name = "descripcion" )
    private String _descripcion;
    
    //Getters, Setters, y otros metodos.


    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public NivelEconomico (long id){
        super(id);
    }

    public NivelEconomico (String estatus) {
        super(estatus);
    }
    
    public NivelEconomico (){
        super();
    }

    @Override
    public String toString() {
        return "NivelEconomico{" +
                "_descripcion='" + _descripcion + '\'' +
                '}';
    }
}
