package ucab.dsw.dtos;

public class PresentacionDto extends DtoBase{
    private String _nombre;
    private String _caracteristicas;
    private ProductoDto _productoDto;

    public String get_caracteristicas() {
        return _caracteristicas;
    }

    public void set_caracteristicas(String _caracteristicas) {
        this._caracteristicas = _caracteristicas;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public ProductoDto get_productoDto() {
        return _productoDto;
    }

    public void set_productoDto(ProductoDto _productoDto) {
        this._productoDto = _productoDto;
    }

    public PresentacionDto (long id) throws Exception{
        super(id);
    }

    public PresentacionDto (String estatus) throws Exception {
        super(estatus);
    }

    public PresentacionDto (){
        super();
    }
}