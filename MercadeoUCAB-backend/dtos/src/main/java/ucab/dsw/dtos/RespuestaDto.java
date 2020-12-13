package ucab.dsw.dtos;

public class RespuestaDto extends DtoBase {
    private String _respuestaAbierta;
    private String _escala;
    private String _verdaderoFalso;
    private String _respuestaSimple;
    private String _respuestaMultiple;
    private PreguntaEstudioDto _preguntaEstudioDto;
    private UsuarioDto _usuarioDto;

    public String get_escala() {
        return _escala;
    }

    public PreguntaEstudioDto get_preguntaEstudioDto() {
        return _preguntaEstudioDto;
    }

    public String get_respuestaAbierta() {
        return _respuestaAbierta;
    }

    public String get_respuestaMultiple() {
        return _respuestaMultiple;
    }

    public String get_respuestaSimple() {
        return _respuestaSimple;
    }

    public UsuarioDto get_usuarioDto() {
        return _usuarioDto;
    }

    public String get_verdaderoFalso() {
        return _verdaderoFalso;
    }

    public void set_verdaderoFalso(String _verdaderoFalso) {
        this._verdaderoFalso = _verdaderoFalso;
    }

    public void set_usuarioDto(UsuarioDto _usuarioDto) {
        this._usuarioDto = _usuarioDto;
    }

    public void set_respuestaSimple(String _respuestaSimple) {
        this._respuestaSimple = _respuestaSimple;
    }

    public void set_respuestaMultiple(String _respuestaMultiple) {
        this._respuestaMultiple = _respuestaMultiple;
    }

    public void set_respuestaAbierta(String _respuestaAbierta) {
        this._respuestaAbierta = _respuestaAbierta;
    }

    public void set_preguntaEstudioDto(PreguntaEstudioDto _preguntaEstudioDto) {
        this._preguntaEstudioDto = _preguntaEstudioDto;
    }

    public void set_escala(String _escala) {
        this._escala = _escala;
    }

    public RespuestaDto (long id) throws Exception{
        super(id);
    }

    public RespuestaDto (String estatus) throws Exception {
        super(estatus);
    }

    public RespuestaDto (){
        super();
    }
}