package ucab.dsw.dtos;

public class UsuarioDto extends DtoBase{
    private String _nombreUsuario;
    private String _correo;
    private String _codigoRecuperacion;
    private RolDto _rol;
    private String _contrasena;

    public String get_contrasena() {
        return _contrasena;
    }

    public void set_contrasena(String _contrasena) {
        this._contrasena = _contrasena;
    }

    public RolDto get_rol() {
        return _rol;
    }

    public void set_rol(RolDto _rol) {
        this._rol = _rol;
    }

    public String get_codigoRecuperacion() {
        return _codigoRecuperacion;
    }

    public void set_codigoRecuperacion(String _codigoRecuperacion) {
        this._codigoRecuperacion = _codigoRecuperacion;
    }

    public String get_correo() {
        return _correo;
    }

    public void set_correo(String _correo) {
        this._correo = _correo;
    }

    public String get_nombreUsuario() {
        return _nombreUsuario;
    }

    public void set_nombreUsuario(String _nombreUsuario) {
        this._nombreUsuario = _nombreUsuario;
    }

    public UsuarioDto (long id) throws Exception{
        super(id);
    }

    public UsuarioDto (String estatus) throws Exception {
        super(estatus);
    }


    public String getNombreRol() {
        return _rol.get_nombre();
    }

    public UsuarioDto (){
        super();
    }


}

