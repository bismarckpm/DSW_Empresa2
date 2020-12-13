package ucab.dsw.dtos;

import java.util.Date;

public class HijoDto extends DtoBase{
    private Date _fechaNacimiento;
    private String _genero;
    private InformacionDto _informacionDto;

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

    public InformacionDto get_informacionDto() {
        return _informacionDto;
    }

    public void set_informacionDto(InformacionDto _informacionDto) {
        this._informacionDto = _informacionDto;
    }

    public HijoDto (long id) throws Exception{
        super(id);
    }

    public HijoDto (String estatus) throws Exception {
        super(estatus);
    }

    public HijoDto (){
        super();
    }
}