package ucab.dsw.dtos;

public class RespuestaPreguntaDto extends DtoBase {
    private String _nombre;
    private PreguntaEncuestaDto _preguntaEncuestaDto;

    public String get_nombre() {
        return _nombre;
    }

    public PreguntaEncuestaDto get_preguntaEncuestaDto() {
        return _preguntaEncuestaDto;
    }

    public void set_preguntaEncuestaDto(PreguntaEncuestaDto _preguntaEncuestaDto) {
        this._preguntaEncuestaDto = _preguntaEncuestaDto;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public RespuestaPreguntaDto (long id) throws Exception{
        super(id);
    }

    public RespuestaPreguntaDto (String estatus) throws Exception {
        super(estatus);
    }

    public RespuestaPreguntaDto (){
        super();
    }
}