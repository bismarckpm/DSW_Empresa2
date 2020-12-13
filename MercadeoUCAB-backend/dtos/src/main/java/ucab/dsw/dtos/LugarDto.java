package ucab.dsw.dtos;

public class LugarDto extends DtoBase{
    private String _nombre;
    private String _tipo;
    private String _categoriaSocioEconomica;
    private LugarDto _lugar;

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_categoriaSocioEconomica() {
        return _categoriaSocioEconomica;
    }

    public void set_categoriaSocioEconomica(String _categoriaSocioEconomica) {
        this._categoriaSocioEconomica = _categoriaSocioEconomica;
    }

    public LugarDto get_lugar() {
        return _lugar;
    }

    public void set_lugar(LugarDto _lugar) {
        this._lugar = _lugar;
    }

    public String get_tipo() {
        return _tipo;
    }

    public void set_tipo(String _tipo) {
        this._tipo = _tipo;
    }

    public LugarDto (long id) throws Exception{
        super(id);
    }

    public LugarDto (String estatus) throws Exception {
        super(estatus);
    }

    public LugarDto (){
        super();
    }
}