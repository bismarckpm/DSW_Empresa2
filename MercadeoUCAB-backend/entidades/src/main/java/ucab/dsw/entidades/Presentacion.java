package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "presentacion" )
public class Presentacion extends EntidadBase{
    
    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;
    
    @Column( name = "caracteristicas" )
    private String _caracteristicas;
    
    //Relaciones
    @ManyToOne
    @JoinColumn(name="fk_producto")
    private Producto _producto;
    
    //Getters, Setters, y otros metodos.


    public Producto get_producto() {
        return _producto;
    }

    public void set_producto(Producto _producto) {
        this._producto = _producto;
    }

    public String get_caracteristicas() {
        return _caracteristicas;
    }

    public void set_caracteristicas(String _caracteristicas) {
        this._caracteristicas = _caracteristicas;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Presentacion (long id){
        super(id);
    }

    public Presentacion (String estatus) {
        super(estatus);
    }
    
    public Presentacion(){
        super();
    }

    @Override
    public String toString() {
        return "Presentacion{" +
                "_nombre='" + _nombre + '\'' +
                ", _caracteristicas='" + _caracteristicas + '\'' +
                ", _producto=" + _producto +
                '}';
    }
}
