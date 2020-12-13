package ucab.dsw.dtos;

public class ProductoDto extends DtoBase{
    
    private String _nombre;
    private String _descripcion;
    private UsuarioDto _usuarioDto;
    private SubcategoriaDto _subcategoriaDto;
    private MarcaDto _marcaDto;

    public String getNombre() {
        return _nombre;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public UsuarioDto getUsuarioDto() {
        return _usuarioDto;
    }

    public SubcategoriaDto getSubcategoriaDto() {
        return _subcategoriaDto;
    }

    public MarcaDto getMarcaDto() {
        return _marcaDto;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public void setUsuarioDto(UsuarioDto _usuario) {
        this._usuarioDto = _usuario;
    }

    public void setSubcategoriaDto(SubcategoriaDto _subcategoria) {
        this._subcategoriaDto = _subcategoria;
    }

    public void setMarcaDto(MarcaDto _marca) {
        this._marcaDto = _marca;
    }

    public ProductoDto (long id) throws Exception{
        super(id);
    }

    public ProductoDto (String estatus) throws Exception {
        super(estatus);
    }

    public ProductoDto (){
        super();
    }
    
}
