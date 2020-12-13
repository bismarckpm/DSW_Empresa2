package ucab.dsw.entidades;

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "solicitud_estudio" )
public class SolicitudEstudio extends EntidadBase{
    
    //Columnas

    @Column ( name = "descripcion")
    private String _descripcion;

    @Column ( name = "genero")
    private String _genero;

    @Column ( name = "edadMinima")
    private int _edadMinima;

    @Column ( name = "edadMaxima")
    private int _edadMaxima;

    @Column ( name = "estadoCivil")
    private String _estadoCivil;

    @Column ( name = "disponibilidadEnLinea")
    private String _disponibilidadEnLinea;

    @Column ( name = "cantidadPersonas")
    private int _cantidadPersonas;

    @Column ( name = "cantidadHijos")
    private int _cantidadHijos;

    @Column ( name = "generoHijos")
    private String _generoHijos;

    @Column ( name = "edadMinimaHijos")
    private int _edadMinimaHijos;

    @Column ( name = "edadMaximaHijos")
    private int _edadMaximaHijos;

    //Relaciones
    
    @ManyToOne
    @JoinColumn( name = "fk_usuario")
    private Usuario _usuario;
    
    @ManyToOne
    @JoinColumn( name = "fk_nivelEconomico")
    private NivelEconomico _nivelEconomico;
    
    @ManyToOne
    @JoinColumn( name = "fk_producto" )
    private Producto _producto;

    @ManyToOne
    @JoinColumn ( name ="fk_ocupacion")
    private Ocupacion _ocupacion;

    @ManyToOne
    @JoinColumn (name ="fk_nivelAcademico")
    private NivelAcademico _nivelAcademico;
    
    //Getters, Setters, y otros metodos.


    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String get_genero() {
        return _genero;
    }

    public void set_genero(String _genero) {
        this._genero = _genero;
    }

    public int get_edadMinima() {
        return _edadMinima;
    }

    public void set_edadMinima(int _edadMinima) {
        this._edadMinima = _edadMinima;
    }

    public int get_edadMaxima() {
        return _edadMaxima;
    }

    public void set_edadMaxima(int _edadMaxima) {
        this._edadMaxima = _edadMaxima;
    }

    public String get_estadoCivil() {
        return _estadoCivil;
    }

    public void set_estadoCivil(String _estadoCivil) {
        this._estadoCivil = _estadoCivil;
    }

    public String get_disponibilidadEnLinea() {
        return _disponibilidadEnLinea;
    }

    public void set_disponibilidadEnLinea(String _disponibilidadEnLinea) {
        this._disponibilidadEnLinea = _disponibilidadEnLinea;
    }

    public int get_cantidadPersonas() {
        return _cantidadPersonas;
    }

    public void set_cantidadPersonas(int _cantidadPersonas) {
        this._cantidadPersonas = _cantidadPersonas;
    }

    public int get_cantidadHijos() {
        return _cantidadHijos;
    }

    public void set_cantidadHijos(int _cantidadHijos) {
        this._cantidadHijos = _cantidadHijos;
    }

    public String get_generoHijos() {
        return _generoHijos;
    }

    public void set_generoHijos(String _generoHijos) {
        this._generoHijos = _generoHijos;
    }

    public int get_edadMinimaHijos() {
        return _edadMinimaHijos;
    }

    public void set_edadMinimaHijos(int _edadMinimaHijos) {
        this._edadMinimaHijos = _edadMinimaHijos;
    }

    public int get_edadMaximaHijos() {
        return _edadMaximaHijos;
    }

    public void set_edadMaximaHijos(int _edadMaximaHijos) {
        this._edadMaximaHijos = _edadMaximaHijos;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public NivelEconomico get_nivelEconomico() {
        return _nivelEconomico;
    }

    public void set_nivelEconomico(NivelEconomico _nivelEconomico) {
        this._nivelEconomico = _nivelEconomico;
    }

    public Producto get_producto() {
        return _producto;
    }

    public void set_producto(Producto _producto) {
        this._producto = _producto;
    }

    public Ocupacion get_ocupacion() {
        return _ocupacion;
    }

    public void set_ocupacion(Ocupacion _ocupacion) {
        this._ocupacion = _ocupacion;
    }

    public NivelAcademico get_nivelAcademico() {
        return _nivelAcademico;
    }

    public void set_nivelAcademico(NivelAcademico _nivelAcademico) {
        this._nivelAcademico = _nivelAcademico;
    }

    public SolicitudEstudio(long id){
        super (id);
    }

    public SolicitudEstudio (String estatus) {
        super(estatus);
    }
    
    public SolicitudEstudio(){
        super();
    }

    @Override
    public String toString() {
        return "SolicitudEstudio{" +
                "_descripcion='" + _descripcion + '\'' +
                ", _genero='" + _genero + '\'' +
                ", _edadMinima=" + _edadMinima +
                ", _edadMaxima=" + _edadMaxima +
                ", _estadoCivil='" + _estadoCivil + '\'' +
                ", _disponibilidadEnLinea='" + _disponibilidadEnLinea + '\'' +
                ", _cantidadPersonas=" + _cantidadPersonas +
                ", _cantidadHijos=" + _cantidadHijos +
                ", _generoHijos='" + _generoHijos + '\'' +
                ", _edadMinimaHijos=" + _edadMinimaHijos +
                ", _edadMaximaHijos=" + _edadMaximaHijos +
                ", _usuario=" + _usuario +
                ", _nivelEconomico=" + _nivelEconomico +
                ", _producto=" + _producto +
                ", _ocupacion=" + _ocupacion +
                ", _nivelAcademico=" + _nivelAcademico +
                '}';
    }
}
