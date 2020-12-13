package ucab.dsw.dtos;

public class MedioComunicacionDto extends DtoBase {

    private String _tipoDeMedio;
    private InformacionDto _informacionDto;
    private SolicitudEstudioDto _solicitudEstudioDto;

    public InformacionDto get_informacionDto() {
        return _informacionDto;
    }

    public void set_informacionDto(InformacionDto _informacionDto) {
        this._informacionDto = _informacionDto;
    }

    public SolicitudEstudioDto get_solicitudEstudioDto() {
        return _solicitudEstudioDto;
    }

    public void set_solicitudEstudioDto(SolicitudEstudioDto _solicitudEstudioDto) {
        this._solicitudEstudioDto = _solicitudEstudioDto;
    }

    public String get_tipoDeMedio() {
        return _tipoDeMedio;
    }

    public void set_tipoDeMedio(String _tipoDeMedio) {
        this._tipoDeMedio = _tipoDeMedio;
    }

    public MedioComunicacionDto (long id) throws Exception{
        super(id);
    }

    public MedioComunicacionDto (String estatus) throws Exception {
        super(estatus);
    }

    public MedioComunicacionDto (){
        super();
    }
}