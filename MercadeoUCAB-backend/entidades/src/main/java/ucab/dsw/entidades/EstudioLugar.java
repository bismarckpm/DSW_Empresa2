package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "estudio_lugar")
public class EstudioLugar extends EntidadBase {

    //Relaciones

    @ManyToOne
    @JoinColumn ( name = "fk_estudio")
    private Estudio _estudio;

    @ManyToOne
    @JoinColumn ( name = "fk_lugar")
    private Lugar _lugar;

    //Getters, setters y otros metodos

    public Estudio get_estudio() {
        return _estudio;
    }

    public void set_estudio(Estudio _estudio) {
        this._estudio = _estudio;
    }

    public Lugar get_lugar() {
        return _lugar;
    }

    public void set_lugar(Lugar _lugar) {
        this._lugar = _lugar;
    }

    public EstudioLugar(long id) {
        super(id);
    }

    public EstudioLugar (String estatus){
        super(estatus);
    }

    public EstudioLugar (){
        super();
    }

    @Override
    public String toString() {
        return "EstudioLugar{" +
                "_estudio=" + _estudio +
                ", _lugar=" + _lugar +
                '}';
    }
}
