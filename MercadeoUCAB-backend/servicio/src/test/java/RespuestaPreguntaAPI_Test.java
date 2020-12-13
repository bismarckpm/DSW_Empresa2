import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.PreguntaEncuestaDto;
import ucab.dsw.dtos.RespuestaPreguntaDto;
import ucab.dsw.entidades.RespuestaPregunta;
import ucab.dsw.entidades.Tipo;

public class RespuestaPreguntaAPI_Test {

    //Listar todos los RespuestaPregunta (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarRespuestaPreguntaPregunta(){

        ucab.dsw.servicio.RespuestaPreguntaAPI servicio = new ucab.dsw.servicio.RespuestaPreguntaAPI();

        try {
            Assertions.assertTrue(servicio.listarRespuestas().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar una Respuesta (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarRespuestaPregunta(){

        ucab.dsw.servicio.RespuestaPreguntaAPI servicio = new ucab.dsw.servicio.RespuestaPreguntaAPI();
        RespuestaPregunta respuestaPregunta_buscar = servicio.encontrarRespuestaPregunta(1L);

        try {

            Assertions.assertEquals(1, respuestaPregunta_buscar.get_id());

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Listar Respuestas activas (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarRespuestaPreguntasActivas(){

        try {
            Assertions.assertNotNull(new ucab.dsw.servicio.RespuestaPreguntaAPI().respuestasActivas());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }


    // Esta prueba permite insertar una Respuesta a la BD
    @Test
    public void pruebaInsertarRespuestaPregunta() throws Exception{

        ucab.dsw.servicio.RespuestaPreguntaAPI servicio = new ucab.dsw.servicio.RespuestaPreguntaAPI();
        RespuestaPreguntaDto respuestaPreguntaDto = new RespuestaPreguntaDto();

        respuestaPreguntaDto.set_nombre("No muy buena la verdad");
        respuestaPreguntaDto.set_estatus("Inactivo");
        // Recuerden que deben ver los id de los registros en la BD
        PreguntaEncuestaDto preguntaEncuestaDto = new PreguntaEncuestaDto(1L);
        respuestaPreguntaDto.set_preguntaEncuestaDto(preguntaEncuestaDto);
        RespuestaPreguntaDto resultado = servicio.addRespuestaPregunta(respuestaPreguntaDto);
        Assert.assertNotEquals(resultado.get_id(), 0);
    }

    // Esta prueba permite actualizar el estatus
    @Test
    public void pruebaModificarEstatusRespuestaPregunta(){

        ucab.dsw.servicio.RespuestaPreguntaAPI servicio = new ucab.dsw.servicio.RespuestaPreguntaAPI();
        RespuestaPreguntaDto respuestaPreguntaDto = new RespuestaPreguntaDto();
        respuestaPreguntaDto.set_estatus("Activo");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarRespuestaPregunta(1L, respuestaPreguntaDto);
    }

    // Esta prueba permite modificar una Respuesta
    @Test
    public void pruebaModificarRespuestaPregunta(){

        ucab.dsw.servicio.RespuestaPreguntaAPI servicio = new ucab.dsw.servicio.RespuestaPreguntaAPI();
        RespuestaPreguntaDto respuestaPreguntaDto = new RespuestaPreguntaDto();
        respuestaPreguntaDto.set_nombre("No muy buena la verdad");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarRespuestaPregunta(1L, respuestaPreguntaDto);
    }

    // Esta prueba permite eliminar una Respuesta
    @Test
    public void pruebaEliminarRespuestaPregunta(){

        ucab.dsw.servicio.RespuestaPreguntaAPI servicio = new ucab.dsw.servicio.RespuestaPreguntaAPI();
        servicio.eliminarRespuestaPregunta(1L);
    }
}
