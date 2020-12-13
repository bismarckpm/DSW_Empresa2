package ucab.dsw.dtos;

public class NivelAcademicoDto extends DtoBase{
    private String _descripcion;

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public NivelAcademicoDto (long id) throws Exception{
        super(id);
    }

    public NivelAcademicoDto (String estatus) throws Exception {
        super(estatus);
    }

    public NivelAcademicoDto (){
        super();
    }
}