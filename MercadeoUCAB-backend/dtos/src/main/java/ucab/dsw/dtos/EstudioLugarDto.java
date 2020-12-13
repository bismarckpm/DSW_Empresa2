package ucab.dsw.dtos;

public class EstudioLugarDto extends DtoBase{

    private EstudioDto _estudioDto;
    private LugarDto _lugarDto;

    public EstudioDto get_estudioDto() {
        return _estudioDto;
    }

    public void set_estudioDto(EstudioDto _estudioDto) {
        this._estudioDto = _estudioDto;
    }

    public LugarDto get_lugarDto() {
        return _lugarDto;
    }

    public void set_lugarDto(LugarDto _lugarDto) {
        this._lugarDto = _lugarDto;
    }

    public EstudioLugarDto(long id) throws Exception {
        super(id);
    }

    public EstudioLugarDto (String estatus) throws Exception {
        super(estatus);
    }

    public EstudioLugarDto (){
        super();
    }
}
