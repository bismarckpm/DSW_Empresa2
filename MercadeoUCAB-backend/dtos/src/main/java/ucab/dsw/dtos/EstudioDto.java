package ucab.dsw.dtos;


import java.util.Date;

public class EstudioDto extends DtoBase {

    private String _nombre;
    private String _tipoInstrumento;
    private Date _fechaInicio;
    private Date _fechaFin;
    private SolicitudEstudioDto _solicitudEstudioDto;
    private UsuarioDto _usuarioDto;

    public Date get_fechaFin() {
        return _fechaFin;
    }

    public Date get_fechaInicio() {
        return _fechaInicio;
    }

    public String get_nombre() {
        return _nombre;
    }

    public SolicitudEstudioDto get_solicitudEstudioDto() {
        return _solicitudEstudioDto;
    }

    public String get_tipoInstrumento() {
        return _tipoInstrumento;
    }

    public UsuarioDto get_usuarioDto() {
        return _usuarioDto;
    }

    public void set_usuarioDto(UsuarioDto _usuarioDto) {
        this._usuarioDto = _usuarioDto;
    }

    public void set_tipoInstrumento(String _tipoInstrumento) {
        this._tipoInstrumento = _tipoInstrumento;
    }

    public void set_solicitudEstudioDto(SolicitudEstudioDto _solicitudEstudioDto) {
        this._solicitudEstudioDto = _solicitudEstudioDto;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void set_fechaInicio(Date _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }

    public void set_fechaFin(Date _fechaFin) {
        this._fechaFin = _fechaFin;
    }

    public EstudioDto (long id) throws Exception{
        super(id);
    }

    public EstudioDto (String estatus) throws Exception {
        super(estatus);
    }

    public EstudioDto (){
        super();
    }
}
