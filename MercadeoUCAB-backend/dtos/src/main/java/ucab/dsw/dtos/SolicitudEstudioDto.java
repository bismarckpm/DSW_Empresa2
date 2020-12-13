package ucab.dsw.dtos;

import java.util.Date;

public class SolicitudEstudioDto extends DtoBase{

    private String _descripcion;
    private String _genero;
    private int _edadMinima;
    private int _edadMaxima;
    private String _estadoCivil;
    private String _disponibilidadEnLinea;
    private int _cantidadPersonas;
    private int _cantidadHijos;
    private String _generoHijos;
    private int _edadMinimaHijos;
    private int _edadMaximaHijos;
    private UsuarioDto _usuarioDto;
    private NivelEconomicoDto _nivelEconomicoDto;
    private ProductoDto _productoDto;
    private OcupacionDto _ocupacionDto;
    private NivelAcademicoDto _nivelAcademicoDto;
    
    //Getters, Setters, y otros metodos.

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String get_genero() {
        return _genero;
    }

    public void set_genero(String _genero) {
        this._genero = _genero;
    }

    public int get_edadMinima() {
        return _edadMinima;
    }

    public void set_edadMinima(int _edadMinima) {
        this._edadMinima = _edadMinima;
    }

    public int get_edadMaxima() {
        return _edadMaxima;
    }

    public void set_edadMaxima(int _edadMaxima) {
        this._edadMaxima = _edadMaxima;
    }

    public String get_estadoCivil() {
        return _estadoCivil;
    }

    public void set_estadoCivil(String _estadoCivil) {
        this._estadoCivil = _estadoCivil;
    }

    public String get_disponibilidadEnLinea() {
        return _disponibilidadEnLinea;
    }

    public void set_disponibilidadEnLinea(String _disponibilidadEnLinea) {
        this._disponibilidadEnLinea = _disponibilidadEnLinea;
    }

    public int get_cantidadPersonas() {
        return _cantidadPersonas;
    }

    public void set_cantidadPersonas(int _cantidadPersonas) {
        this._cantidadPersonas = _cantidadPersonas;
    }

    public int get_cantidadHijos() {
        return _cantidadHijos;
    }

    public void set_cantidadHijos(int _cantidadHijos) {
        this._cantidadHijos = _cantidadHijos;
    }

    public String get_generoHijos() {
        return _generoHijos;
    }

    public void set_generoHijos(String _generoHijos) {
        this._generoHijos = _generoHijos;
    }

    public int get_edadMinimaHijos() {
        return _edadMinimaHijos;
    }

    public void set_edadMinimaHijos(int _edadMinimaHijos) {
        this._edadMinimaHijos = _edadMinimaHijos;
    }

    public int get_edadMaximaHijos() {
        return _edadMaximaHijos;
    }

    public void set_edadMaximaHijos(int _edadMaximaHijos) {
        this._edadMaximaHijos = _edadMaximaHijos;
    }

    public UsuarioDto get_usuarioDto() {
        return _usuarioDto;
    }

    public void set_usuarioDto(UsuarioDto _usuarioDto) {
        this._usuarioDto = _usuarioDto;
    }

    public NivelEconomicoDto get_nivelEconomicoDto() {
        return _nivelEconomicoDto;
    }

    public void set_nivelEconomicoDto(NivelEconomicoDto _nivelEconomicoDto) {
        this._nivelEconomicoDto = _nivelEconomicoDto;
    }

    public ProductoDto get_productoDto() {
        return _productoDto;
    }

    public void set_productoDto(ProductoDto _productoDto) {
        this._productoDto = _productoDto;
    }

    public OcupacionDto get_ocupacionDto() {
        return _ocupacionDto;
    }

    public void set_ocupacionDto(OcupacionDto _ocupacionDto) {
        this._ocupacionDto = _ocupacionDto;
    }

    public NivelAcademicoDto get_nivelAcademicoDto() {
        return _nivelAcademicoDto;
    }

    public void set_nivelAcademicoDto(NivelAcademicoDto _nivelAcademicoDto) {
        this._nivelAcademicoDto = _nivelAcademicoDto;
    }

    public SolicitudEstudioDto (long id) throws Exception{
        super(id);
    }

    public SolicitudEstudioDto (String estatus) throws Exception {
        super(estatus);
    }

    public SolicitudEstudioDto (){
        super();
    }
    
}
