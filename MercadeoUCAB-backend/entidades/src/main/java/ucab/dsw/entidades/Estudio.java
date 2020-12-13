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
@Table( name = "estudio" )
public class Estudio extends EntidadBase{

    //Columnas
    
    @Column( name = "nombre" )
    private String _nombre;
    
    @Column( name = "tipoInstrumento" )
    private String _tipoInstrumento;
    
    @Column( name = "fechaInicio" )
    private Date _fechaInicio;
    
    @Column( name = "fechaFin" )
    private Date _fechaFin;

    
    //Relaciones
    
    @ManyToOne
    @JoinColumn(name="fk_usuario")
    private Usuario _usuario;
    
    @ManyToOne
    @JoinColumn(name="fk_solicitud_estudio")
    private SolicitudEstudio _solicitudEstudio;
    
    //Getters, Setters, y otros metodos.


    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_tipoInstrumento() {
        return _tipoInstrumento;
    }

    public void set_tipoInstrumento(String _tipoInstrumento) {
        this._tipoInstrumento = _tipoInstrumento;
    }

    public Date get_fechaInicio() {
        return _fechaInicio;
    }

    public void set_fechaInicio(Date _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }

    public Date get_fechaFin() {
        return _fechaFin;
    }

    public void set_fechaFin(Date _fechaFin) {
        this._fechaFin = _fechaFin;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public SolicitudEstudio get_solicitudEstudio() {
        return _solicitudEstudio;
    }

    public void set_solicitudEstudio(SolicitudEstudio _solicitudEstudio) {
        this._solicitudEstudio = _solicitudEstudio;
    }

    public Estudio(long id){
        super(id);
    }

    public Estudio (String estatus) {
        super(estatus);
    }

    @Override
    public String toString() {
        return "Estudio{" +
                "_nombre='" + _nombre + '\'' +
                ", _tipoInstrumento='" + _tipoInstrumento + '\'' +
                ", _fechaInicio=" + _fechaInicio +
                ", _fechaFin=" + _fechaFin +
                ", _usuario=" + _usuario +
                ", _solicitudEstudio=" + _solicitudEstudio +
                '}';
    }

    public Estudio(){
        super();
    } 
}
