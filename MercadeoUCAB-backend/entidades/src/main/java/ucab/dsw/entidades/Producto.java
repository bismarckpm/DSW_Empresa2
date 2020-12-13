package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "producto" )
public class Producto extends EntidadBase{
    
    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;
    
    @Column( name = "descripcion" )
    private String _descripcion;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_usuario")
    private Usuario _usuario;
    
    @ManyToOne
    @JoinColumn(name="fk_subcategoria")
    private Subcategoria _subcategoria;
    
    @ManyToOne
    @JoinColumn(name="fk_marca")
    private Marca _marca;
    
    //Getters, Setters, y otros metodos.


    public Marca get_marca() {
        return _marca;
    }

    public void set_marca(Marca _marca) {
        this._marca = _marca;
    }

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

    public Producto(long id){
        super(id);
    }

    public Producto (String estatus) {
        super(estatus);
    }
    
    public Producto(){
        super();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "_nombre='" + _nombre + '\'' +
                ", _descripcion='" + _descripcion + '\'' +
                ", _usuario=" + _usuario +
                ", _subcategoria=" + _subcategoria +
                ", _marca=" + _marca +
                '}';
    }
}
