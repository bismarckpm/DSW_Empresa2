package ucab.dsw.dtos;

public class PreguntaEstudioDto extends DtoBase{
    private PreguntaEncuestaDto _preguntaEncuestaDto;
    private EstudioDto _estudioDto;

    public EstudioDto get_estudioDto() {
        return _estudioDto;
    }

    public PreguntaEncuestaDto get_preguntaEncuestaDto() {
        return _preguntaEncuestaDto;
    }

    public void set_preguntaEncuestaDto(PreguntaEncuestaDto _preguntaEncuestaDto) {
        this._preguntaEncuestaDto = _preguntaEncuestaDto;
    }

    public void set_estudioDto(EstudioDto _estudioDto) {
        this._estudioDto = _estudioDto;
    }

    public PreguntaEstudioDto(long id) throws Exception{
        super(id);
    }

    public PreguntaEstudioDto (String estatus) throws Exception {
        super(estatus);
    }

    public PreguntaEstudioDto (){
        super();
    }
}