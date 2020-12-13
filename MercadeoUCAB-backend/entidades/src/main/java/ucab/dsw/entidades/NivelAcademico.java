package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "nivel_academico" )
public class NivelAcademico extends EntidadBase{
    
    //Columnas
    
    @Column( name = "descripcion" )
    private String _descripcion;
    
    ////Getters, Setters, y otros metodos.


    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public NivelAcademico (long id){
        super(id);
    }

    public NivelAcademico (String estatus) {
        super(estatus);
    }
    
    public NivelAcademico (){
        super();
    }

    @Override
    public String toString() {
        return "NivelAcademico{" +
                "_descripcion='" + _descripcion + '\'' +
                '}';
    }
}
