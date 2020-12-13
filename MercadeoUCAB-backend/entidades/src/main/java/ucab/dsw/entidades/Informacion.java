/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.dsw.entidades;

/**
 *
 * @author Emanuel
 */

import java.util.Date;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "informacion" )
public class Informacion extends EntidadBase {
    
    //Columnas
    
    @Column( name = "cedula" )
    private int _cedula;
    
    @Column( name = "primerNombre" )
    private String _primerNombre;
    
    @Column( name = "segundoNombre" )
    private String _segundoNombre;
    
    @Column( name = "primerApellido" )
    private String _primerApellido;
    
    @Column( name = "segundoApellido" )
    private String _segundoApellido;
    
    @Column( name = "genero" )
    private String _genero;
    
    @Column( name = "fechaNacimiento" )
    private Date _fechaNacimiento;
    
    @Column( name = "estadoCivil" )
    private String _estadoCivil;
    
    @Column( name = "disponibilidadEnLinea" )
    private String _disponibilidadEnLinea;
    
    @Column( name = "cantidadPersonas" )
    private int _cantidadPersonas;
    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_lugar")
    private Lugar _lugar;
    
    @ManyToOne
    @JoinColumn(name="fk_nivel_academico")
    private NivelAcademico _nivelAcademico;
    
    @ManyToOne
    @JoinColumn(name="fk_ocupacion")
    private Ocupacion _ocupacion;
    
    @ManyToOne
    @JoinColumn(name="fk_nivelEconomico")
    private NivelEconomico _nivelEconomico;

    @OneToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario _usuario;
    
    //Getters, Setters, y otros metodos.


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

    public Lugar get_lugar() {
        return _lugar;
    }

    public void set_lugar(Lugar _lugar) {
        this._lugar = _lugar;
    }

    public int get_cantidadPersonas() {
        return _cantidadPersonas;
    }

    public void set_cantidadPersonas(int _cantidadPersonas) {
        this._cantidadPersonas = _cantidadPersonas;
    }

    public String get_disponibilidadEnLinea() {
        return _disponibilidadEnLinea;
    }

    public void set_disponibilidadEnLinea(String _disponibilidadEnLinea) {
        this._disponibilidadEnLinea = _disponibilidadEnLinea;
    }

    public String get_estadoCivil() {
        return _estadoCivil;
    }

    public void set_estadoCivil(String _estadoCivil) {
        this._estadoCivil = _estadoCivil;
    }

    public Date get_fechaNacimiento() {
        return _fechaNacimiento;
    }

    public void set_fechaNacimiento(Date _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }

    public String get_genero() {
        return _genero;
    }

    public void set_genero(String _genero) {
        this._genero = _genero;
    }

    public String get_segundoApellido() {
        return _segundoApellido;
    }

    public void set_segundoApellido(String _segundoApellido) {
        this._segundoApellido = _segundoApellido;
    }

    public String get_primerApellido() {
        return _primerApellido;
    }

    public void set_primerApellido(String _primerApellido) {
        this._primerApellido = _primerApellido;
    }

    public String get_segundoNombre() {
        return _segundoNombre;
    }

    public void set_segundoNombre(String _segundoNombre) {
        this._segundoNombre = _segundoNombre;
    }

    public String get_primerNombre() {
        return _primerNombre;
    }

    public void set_primerNombre(String _primerNombre) {
        this._primerNombre = _primerNombre;
    }

    public int get_cedula() {
        return _cedula;
    }

    public void set_cedula(int _cedula) {
        this._cedula = _cedula;
    }

    public Informacion (String estatus) {
        super(estatus);
    }
    
    public Informacion( long id){
        super (id);
    }
    
    public Informacion(){
        super();
    }

    @Override
    public String toString() {
        return "Informacion{" +
                "_cedula=" + _cedula +
                ", _primerNombre='" + _primerNombre + '\'' +
                ", _segundoNombre='" + _segundoNombre + '\'' +
                ", _primerApellido='" + _primerApellido + '\'' +
                ", _segundoApellido='" + _segundoApellido + '\'' +
                ", _genero='" + _genero + '\'' +
                ", _fechaNacimiento=" + _fechaNacimiento +
                ", _estadoCivil='" + _estadoCivil + '\'' +
                ", _disponibilidadEnLinea='" + _disponibilidadEnLinea + '\'' +
                ", _cantidadPersonas=" + _cantidadPersonas +
                ", _lugar=" + _lugar +
                ", _nivelAcademico=" + _nivelAcademico +
                ", _ocupacion=" + _ocupacion +
                ", _nivelEconomico=" + _nivelEconomico +
                '}';
    }
}
