package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "tipo" )
public class Tipo extends EntidadBase{
    
    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;
    
    @Column( name = "descripcion" )
    private String _descripcion;
    
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

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Tipo (String estatus) {
        super(estatus);
    }

    public Tipo (long id){
        super(id);
    }
    
    public Tipo (){
        super();
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "_nombre='" + _nombre + '\'' +
                ", _descripcion='" + _descripcion + '\'' +
                ", _producto=" + _producto +
                '}';
    }
}
