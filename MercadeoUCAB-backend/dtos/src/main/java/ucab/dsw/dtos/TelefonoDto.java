package ucab.dsw.dtos;

import ucab.dsw.dtos.DtoBase;
import ucab.dsw.dtos.InformacionDto;

public class TelefonoDto extends DtoBase {

    private int _numero;
    private InformacionDto _informacion;

    public int get_numero() {
        return _numero;
    }

    public void set_numero(int _numero) {
        this._numero = _numero;
    }

    public InformacionDto get_informacion() {
        return _informacion;
    }

    public void set_informacion(InformacionDto _informacion) {
        this._informacion = _informacion;
    }

    public TelefonoDto (long id) throws Exception{
        super(id);
    }

    public TelefonoDto (String estatus) throws Exception {
        super(estatus);
    }

    public TelefonoDto (){
        super();
    }
}