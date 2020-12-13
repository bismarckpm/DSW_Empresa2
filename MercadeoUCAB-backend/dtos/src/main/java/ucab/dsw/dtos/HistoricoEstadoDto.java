package ucab.dsw.dtos;
import java.util.Date;

public class HistoricoEstadoDto extends DtoBase {
    private Date _fechaInicio;
    private Date _fechaFin;
    private UsuarioDto _usuarioDto;

    public Date get_fechaFin() {
        return _fechaFin;
    }

    public void set_fechaFin(Date _fechaFin) {
        this._fechaFin = _fechaFin;
    }

    public Date get_fechaInicio() {
        return _fechaInicio;
    }

    public void set_fechaInicio(Date _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }

    public UsuarioDto get_usuarioDto() {
        return _usuarioDto;
    }

    public void set_usuarioDto(UsuarioDto _usuarioDto) {
        this._usuarioDto = _usuarioDto;
    }

    public HistoricoEstadoDto (long id) throws Exception{
        super(id);
    }

    public HistoricoEstadoDto (String estatus) throws Exception {
        super(estatus);
    }

    public HistoricoEstadoDto (){
        super();
    }
}