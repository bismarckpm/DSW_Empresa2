import org.junit.Test;
import ucab.dsw.dtos.RolDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.servicio.LoginServicio;

public class LoginServicio_Test {
    @Test
    public void loginTest(){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.set_correo( "greggspinetti@gmail.com" );
        usuarioDto.set_contrasena( "otraclave" );
        usuarioDto.set_estatus("Activo");
        RolDto rol = new RolDto();
        rol.set_nombre("Administrador");
        LoginServicio login = new LoginServicio();
        login.login(usuarioDto);
    }
}
