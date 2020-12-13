package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "preguntas_estudio" )
public class PreguntaEstudio extends EntidadBase{
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_estudio")
    private Estudio _estudio;
    
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

    public Estudio get_estudio() {
        return _estudio;
    }

    public void set_estudio(Estudio _estudio) {
        this._estudio = _estudio;
    }

    public PreguntaEstudio (long id){
        super(id);
    }

    public PreguntaEstudio (String estatus) {
        super(estatus);
    }
    
    public PreguntaEstudio (){
        super();
    }

    @Override
    public String toString() {
        return "PreguntaEstudio{" +
                "_estudio=" + _estudio +
                ", _preguntaEncuesta=" + _preguntaEncuesta +
                '}';
    }
}
