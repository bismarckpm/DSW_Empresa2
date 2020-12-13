package ucab.dsw.entidades;


import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "historico_estado" )
public class HistoricoEstado extends EntidadBase{
    
    //Columnas
    
    @Column( name = "fechaInicio" )
    private Date _fechaInicio;
    
    @Column( name = "fechaFin" )
    private Date _fechaFin;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_usuario")
    private Usuario _usuario;
    
    //Getters, Setters, y otros metodos.


    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Date get_fechaFin() {
        return _fechaFin;
    }

    public void set_fechaFin(Date _fechaFin) {
        this._fechaFin = _fechaFin;
    }

    public Date get_fechaInicio() {
        return _fechaInicio;
    }

    public void set_fechaInicio(Date _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }

    public HistoricoEstado(long id){
        super(id);
    }

    public HistoricoEstado (String estatus) {
        super(estatus);
    }

    @Override
    public String toString() {
        return "HistoricoEstado{" +
                "_fechaInicio=" + _fechaInicio +
                ", _fechaFin=" + _fechaFin +
                ", _usuario=" + _usuario +
                '}';
    }

    public HistoricoEstado(){
        super();
    }
   
}
