package ucab.dsw.dtos;


public class PreguntaEncuestaDto extends DtoBase {
    private String _descripcion;
    private String _tipoPregunta;
    private UsuarioDto _usuarioDto;
    private SubcategoriaDto _subcategoriaDto;

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public SubcategoriaDto get_subcategoriaDto() {
        return _subcategoriaDto;
    }

    public void set_subcategoriaDto(SubcategoriaDto _subcategoriaDto) {
        this._subcategoriaDto = _subcategoriaDto;
    }

    public String get_tipoPregunta() {
        return _tipoPregunta;
    }

    public void set_tipoPregunta(String _tipoPregunta) {
        this._tipoPregunta = _tipoPregunta;
    }

    public UsuarioDto get_usuarioDto() {
        return _usuarioDto;
    }

    public void set_usuarioDto(UsuarioDto _usuarioDto) {
        this._usuarioDto = _usuarioDto;
    }

    public PreguntaEncuestaDto (long id) throws Exception{
        super(id);
    }

    public PreguntaEncuestaDto (String estatus) throws Exception {
        super(estatus);
    }

    public PreguntaEncuestaDto (){
        super();
    }
}
