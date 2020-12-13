import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.PreguntaEstudioDto;
import ucab.dsw.dtos.RespuestaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Respuesta;
import ucab.dsw.entidades.Tipo;

public class RespuestaAPI_Test {

    //Listar todas las respuestas (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarRespuestas(){

        ucab.dsw.servicio.RespuestaAPI servicio = new ucab.dsw.servicio.RespuestaAPI();

        try {
            Assertions.assertTrue(servicio.listarRespuestas().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar una respuesta (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarRespuesta(){

        ucab.dsw.servicio.RespuestaAPI servicio = new ucab.dsw.servicio.RespuestaAPI();
        Respuesta respuesta_buscar = servicio.consultarRespuesta(1L);

        try {
            Assertions.assertEquals(1, respuesta_buscar.get_id());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Listar respuestas activas (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarRespuestasActivas(){

        try {
            Assertions.assertNotNull(new ucab.dsw.servicio.RespuestaAPI().respuestasActivas());

        } catch (Exception e) {

            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    // Prueba insertar una respuesta
    @Test
    public void pruebaInsertarRespuesta() throws Exception {

        ucab.dsw.servicio.RespuestaAPI servicio = new ucab.dsw.servicio.RespuestaAPI();
        RespuestaDto respuestaDto = new RespuestaDto();

        respuestaDto.set_respuestaAbierta("");
        respuestaDto.set_escala("");
        respuestaDto.set_verdaderoFalso("");
        respuestaDto.set_respuestaSimple("");
        respuestaDto.set_respuestaMultiple("");
        respuestaDto.set_estatus("Activo");
        //Estar mosca con los ID de la BD
        PreguntaEstudioDto preguntaEstudioDto = new PreguntaEstudioDto(1L);
        UsuarioDto usuarioDto = new UsuarioDto(1L);
        respuestaDto.set_preguntaEstudioDto(preguntaEstudioDto);
        respuestaDto.set_usuarioDto(usuarioDto);
        RespuestaDto resultado = servicio.addRespuesta(respuestaDto);
        Assert.assertNotEquals( resultado.get_id(), 0 );

    }

    // Prueba actualizar estatus
    @Test
    public void pruebaModificarEstatusRespuesta(){

        ucab.dsw.servicio.RespuestaAPI servicio = new ucab.dsw.servicio.RespuestaAPI();
        RespuestaDto respuestaDto = new RespuestaDto();

        respuestaDto.set_estatus("Activo");
        //Estar mosca con los ID de la BD
        servicio.modificarEstatusRespuesta(1L, respuestaDto);
    }

    // Prueba actualizar estatus
    @Test
    public void pruebaModificarRespuesta(){

        ucab.dsw.servicio.RespuestaAPI servicio = new ucab.dsw.servicio.RespuestaAPI();
        RespuestaDto respuestaDto = new RespuestaDto();

        respuestaDto.set_respuestaAbierta("");
        respuestaDto.set_escala("");
        respuestaDto.set_verdaderoFalso("");
        respuestaDto.set_respuestaSimple("");
        respuestaDto.set_respuestaMultiple("");
        //Estar mosca con los ID de la BD
        servicio.updateRespuesta(1L, respuestaDto);
    }

    // Prueba eliminar una respuesta
    @Test
    public void pruebaEliminarRespuesta(){

        ucab.dsw.servicio.RespuestaAPI servicio = new ucab.dsw.servicio.RespuestaAPI();
        //Estar mosca con los ID de la BD
        servicio.eliminarRespuesta(1L);

    }

}
