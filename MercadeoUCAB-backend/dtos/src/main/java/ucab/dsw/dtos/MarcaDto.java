package ucab.dsw.dtos;

public class MarcaDto extends DtoBase {
    
    private String _nombre;
    private String _descripcion;

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public MarcaDto (long id) throws Exception{
        super(id);
    }

    public MarcaDto (String estatus) throws Exception {
        super(estatus);
    }

    public MarcaDto (){
        super();
    }
}
