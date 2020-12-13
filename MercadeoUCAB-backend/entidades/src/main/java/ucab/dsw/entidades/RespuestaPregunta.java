package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "respuesta_pregunta" )
public class RespuestaPregunta extends EntidadBase{
    
    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_pregunta_encuesta")
    private PreguntaEncuesta _preguntaEncuesta;
    
    //Getters, Setters, y otros metodos.

    public PreguntaEncuesta get_preguntaEncuesta() {
        return _preguntaEncuesta;
    }

    public void set_preguntaEncuesta(PreguntaEncuesta _preguntaEncuesta) {
        this._preguntaEncuesta = _preguntaEncuesta;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public RespuestaPregunta(long id){
        super(id);
    }

    public RespuestaPregunta (String estatus) {
        super(estatus);
    }
    
    public RespuestaPregunta (){
        super();
    }

    @Override
    public String toString() {
        return "RespuestaPregunta{" +
                "_nombre='" + _nombre + '\'' +
                ", _preguntaEncuesta=" + _preguntaEncuesta +
                '}';
    }
}
