package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "pregunta_encuesta" )
public class PreguntaEncuesta extends EntidadBase{
    
    //Columnas
    
    @Column( name = "descripcion" )
    private String _descripcion;
    
    @Column( name = "tipoPregunta" )
    private String _tipoPregunta;
     
   //Relaciones
    
   @ManyToOne
   @JoinColumn(name="fk_usuario")
   private Usuario _usuario;
   
   @ManyToOne
   @JoinColumn(name="fk_subcategoria")
   private Subcategoria _subcategoria;
   
   //Getters, Setters, y otros metodos.


    public Subcategoria get_subcategoria() {
        return _subcategoria;
    }

    public void set_subcategoria(Subcategoria _subcategoria) {
        this._subcategoria = _subcategoria;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public String get_tipoPregunta() {
        return _tipoPregunta;
    }

    public void set_tipoPregunta(String _tipoPregunta) {
        this._tipoPregunta = _tipoPregunta;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public PreguntaEncuesta(long id){
       super(id);
   }

    public PreguntaEncuesta (String estatus) {
        super(estatus);
    }
   
    public PreguntaEncuesta (){
        super();
    }

    @Override
    public String toString() {
        return "PreguntaEncuesta{" +
                "_descripcion='" + _descripcion + '\'' +
                ", _tipoPregunta='" + _tipoPregunta + '\'' +
                ", _usuario=" + _usuario +
                ", _subcategoria=" + _subcategoria +
                '}';
    }
}
