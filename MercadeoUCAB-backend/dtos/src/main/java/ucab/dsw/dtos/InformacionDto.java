package ucab.dsw.dtos;
import java.util.Date;

public class InformacionDto extends DtoBase {
    private int _cedula;
    private String _primerNombre;
    private String _segundoNombre;
    private String _primerApellido;
    private String _segundoApellido;
    private String _genero;
    private Date _fechaNacimiento;
    private String _estadoCivil;
    private String _disponibilidadEnLinea;
    private int _cantidadPersonas;
    private NivelEconomicoDto _nivelEconomicoDto;
    private UsuarioDto _usuarioDto;
    private LugarDto _lugarDto;
    private NivelAcademicoDto _nivelAcademicoDto;
    private OcupacionDto _ocupacionDto;


    public int get_cantidadPersonas() {
        return _cantidadPersonas;
    }

    public void set_cantidadPersonas(int _cantidadPersonas) {
        this._cantidadPersonas = _cantidadPersonas;
    }

    public NivelAcademicoDto get_nivelAcademicoDto() {
        return _nivelAcademicoDto;
    }

    public NivelEconomicoDto get_nivelEconomicoDto() {
        return _nivelEconomicoDto;
    }

    public String get_primerApellido() {
        return _primerApellido;
    }

    public String get_primerNombre() {
        return _primerNombre;
    }

    public String get_segundoApellido() {
        return _segundoApellido;
    }

    public String get_segundoNombre() {
        return _segundoNombre;
    }

    public UsuarioDto get_usuarioDto() {
        return _usuarioDto;
    }

    public void set_usuarioDto(UsuarioDto _usuarioDto) {
        this._usuarioDto = _usuarioDto;
    }

    public void set_segundoNombre(String _segundoNombre) {
        this._segundoNombre = _segundoNombre;
    }

    public void set_segundoApellido(String _segundoApellido) {
        this._segundoApellido = _segundoApellido;
    }

    public void set_primerNombre(String _primerNombre) {
        this._primerNombre = _primerNombre;
    }

    public void set_primerApellido(String _primerApellido) {
        this._primerApellido = _primerApellido;
    }

    public void set_nivelEconomicoDto(NivelEconomicoDto _nivelEconomicoDto) {
        this._nivelEconomicoDto = _nivelEconomicoDto;
    }

    public void set_nivelAcademicoDto(NivelAcademicoDto _nivelAcademicoDto) {
        this._nivelAcademicoDto = _nivelAcademicoDto;
    }

    public LugarDto get_lugarDto() {
        return _lugarDto;
    }

    public void set_lugarDto(LugarDto _lugarDto) {
        this._lugarDto = _lugarDto;
    }

    public String get_genero() {
        return _genero;
    }

    public void set_genero(String _genero) {
        this._genero = _genero;
    }

    public Date get_fechaNacimiento() {
        return _fechaNacimiento;
    }

    public void set_fechaNacimiento(Date _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
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

    public int get_cedula() {
        return _cedula;
    }

    public void set_cedula(int _cedula) {
        this._cedula = _cedula;
    }

    public InformacionDto (long id) throws Exception{
        super(id);
    }

    public InformacionDto (String estatus) throws Exception {
        super(estatus);
    }

    public InformacionDto (){
        super();
    }
}
