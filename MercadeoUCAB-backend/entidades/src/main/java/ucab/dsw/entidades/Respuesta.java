package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "respuesta" )
public class Respuesta extends EntidadBase {
    
    //Columnas
    
    @Column( name = "respuestaAbierta" )
    private String _respuestaAbierta;
    
    @Column( name = "escala" )
    private String _escala;
    
    @Column( name = "verdaderoFalso" )
    private String _verdaderoFalso;
    
    @Column( name = "respuestaSimple" )
    private String _respuestaSimple;
    
    @Column( name = "respuestaMultiple" )
    private String _respuestaMultiple;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_usuario")
    private Usuario _usuario;
    
    @ManyToOne
    @JoinColumn(name="fk_preguntas_estudio")
    private PreguntaEstudio _preguntaEstudio;
    
    //Getters, Setters, y otros metodos.


    public PreguntaEstudio get_preguntaEstudio() {
        return _preguntaEstudio;
    }

    public void set_preguntaEstudio(PreguntaEstudio _preguntaEstudio) {
        this._preguntaEstudio = _preguntaEstudio;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public String get_respuestaMultiple() {
        return _respuestaMultiple;
    }

    public void set_respuestaMultiple(String _respuestaMultiple) {
        this._respuestaMultiple = _respuestaMultiple;
    }

    public String get_respuestaSimple() {
        return _respuestaSimple;
    }

    public void set_respuestaSimple(String _respuestaSimple) {
        this._respuestaSimple = _respuestaSimple;
    }

    public String get_verdaderoFalso() {
        return _verdaderoFalso;
    }

    public void set_verdaderoFalso(String _verdaderoFalso) {
        this._verdaderoFalso = _verdaderoFalso;
    }

    public String get_escala() {
        return _escala;
    }

    public void set_escala(String _escala) {
        this._escala = _escala;
    }

    public String get_respuestaAbierta() {
        return _respuestaAbierta;
    }

    public void set_respuestaAbierta(String _respuestaAbierta) {
        this._respuestaAbierta = _respuestaAbierta;
    }

    public Respuesta(long id){
        super(id);
    }

    public Respuesta (String estatus) {
        super(estatus);
    }
    
    public Respuesta (){
        super();
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "_respuestaAbierta='" + _respuestaAbierta + '\'' +
                ", _escala='" + _escala + '\'' +
                ", _verdaderoFalso='" + _verdaderoFalso + '\'' +
                ", _respuestaSimple='" + _respuestaSimple + '\'' +
                ", _respuestaMultiple='" + _respuestaMultiple + '\'' +
                ", _usuario=" + _usuario +
                ", _preguntaEstudio=" + _preguntaEstudio +
                '}';
    }
}
