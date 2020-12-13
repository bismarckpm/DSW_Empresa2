package ucab.dsw.dtos;

public class RolDto extends DtoBase{

    private String _nombre;

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public RolDto (long id) throws Exception{
        super(id);
    }

    public RolDto (String estatus) throws Exception {
        super(estatus);
    }

    public RolDto (){
        super();
    }
}
