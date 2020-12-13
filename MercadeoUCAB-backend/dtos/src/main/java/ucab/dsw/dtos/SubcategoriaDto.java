package ucab.dsw.dtos;

public class SubcategoriaDto extends DtoBase{
    
    private String _nombre;
    private String _descripcion;
    private CategoriaDto _categoriaDto;

    public String getNombre() {
        return _nombre;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public CategoriaDto getCategoriaDto() {
        return _categoriaDto;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public void setCategoriaDto(CategoriaDto _categoriaDto) {
        this._categoriaDto = _categoriaDto;
    }

    public SubcategoriaDto (long id) throws Exception{
        super(id);
    }

    public SubcategoriaDto (String estatus) throws Exception {
        super(estatus);
    }

    public SubcategoriaDto (){
        super();
    }
    
}
