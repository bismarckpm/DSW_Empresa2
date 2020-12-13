package ucab.dsw.dtos;

public class CategoriaDto extends DtoBase{
    
    private String _nombre;

    private String _descripcion;

    public String get_descripcion() {
        return _descripcion;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public CategoriaDto (long id) throws Exception{
        super(id);
    }

    public CategoriaDto (String estatus) throws Exception {
        super(estatus);
    }

    public CategoriaDto (){
        super();
    }
}
