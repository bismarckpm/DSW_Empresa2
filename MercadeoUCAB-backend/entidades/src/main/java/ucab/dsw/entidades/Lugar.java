
package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "lugar" )
public class Lugar extends EntidadBase{
    
    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;
    
    @Column( name = "tipo" )
    private String _tipo;
    
    @Column( name = "categoriaSocioEconomica" )
    private String _categoriaSocioEconomica;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_lugar")
    private Lugar _lugar;
    
    //Getters, Setters, y otros metodos.


    public ucab.dsw.entidades.Lugar get_lugar() {
        return _lugar;
    }

    public void set_lugar(ucab.dsw.entidades.Lugar _lugar) {
        this._lugar = _lugar;
    }

    public String get_categoriaSocioEconomica() {
        return _categoriaSocioEconomica;
    }

    public void set_categoriaSocioEconomica(String _categoriaSocioEconomica) {
        this._categoriaSocioEconomica = _categoriaSocioEconomica;
    }

    public String get_tipo() {
        return _tipo;
    }

    public void set_tipo(String _tipo) {
        this._tipo = _tipo;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Lugar (long id){
        super(id);
    }

    public Lugar (String estatus) {
        super(estatus);
    }
    
    public Lugar (){
        super();
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "_nombre='" + _nombre + '\'' +
                ", _tipo='" + _tipo + '\'' +
                ", _categoriaSocioEconomica='" + _categoriaSocioEconomica + '\'' +
                ", _lugar=" + _lugar +
                '}';
    }
}
