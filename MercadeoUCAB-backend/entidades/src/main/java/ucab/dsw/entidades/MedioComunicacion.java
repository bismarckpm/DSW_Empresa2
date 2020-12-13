package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "medio_comunicacion" )
public class MedioComunicacion extends EntidadBase{
    
    //Columnas
    
    @Column( name = "tipoDeMedio" )
    private String _tipoDeMedio;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_informacion")
    private Informacion _informacion;
    
    @ManyToOne
    @JoinColumn(name="fk_solicitud_estudio")
    private SolicitudEstudio _solicitudEstudio;
    
    //Getters, Setters, y otros metodos.


    public SolicitudEstudio get_solicitudEstudio() {
        return _solicitudEstudio;
    }

    public void set_solicitudEstudio(SolicitudEstudio _solicitudEstudio) {
        this._solicitudEstudio = _solicitudEstudio;
    }

    public Informacion get_informacion() {
        return _informacion;
    }

    public void set_informacion(Informacion _informacion) {
        this._informacion = _informacion;
    }

    public String get_tipoDeMedio() {
        return _tipoDeMedio;
    }

    public void set_tipoDeMedio(String _tipoDeMedio) {
        this._tipoDeMedio = _tipoDeMedio;
    }

    public MedioComunicacion (long id){
        super(id);
    }

    public MedioComunicacion (String estatus) {
        super(estatus);
    }
    
    public MedioComunicacion (){
        super();
    }

    @Override
    public String toString() {
        return "MedioComunicacion{" +
                "_tipoDeMedio='" + _tipoDeMedio + '\'' +
                ", _informacion=" + _informacion +
                ", _solicitudEstudio=" + _solicitudEstudio +
                '}';
    }
}
