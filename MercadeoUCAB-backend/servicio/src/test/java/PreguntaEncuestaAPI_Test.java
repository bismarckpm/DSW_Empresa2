import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.PreguntaEncuestaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.PreguntaEncuesta;

public class PreguntaEncuestaAPI_Test {

    //Listar todos las preguntas (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarPreguntaEncuesta(){

        ucab.dsw.servicio.PreguntaEncuestaAPI servicio = new ucab.dsw.servicio.PreguntaEncuestaAPI();

        try {
            Assertions.assertTrue(servicio.listarPreguntas().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar una pregunta (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarPreguntaEncuesta(){

        ucab.dsw.servicio.PreguntaEncuestaAPI servicio = new ucab.dsw.servicio.PreguntaEncuestaAPI();
        PreguntaEncuesta preguntaEncuesta_buscar = servicio.encontrarPreguntaEncuesta(1L);

        try {
            Assertions.assertEquals(1, preguntaEncuesta_buscar.get_id());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Listar Preguntas activas (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarPreguntasEncuestaActivas(){

        try {
            Assertions.assertNotNull(new ucab.dsw.servicio.PreguntaEncuestaAPI().preguntasActivas());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    // Esta prueba permite insertar una Pregunta a la BD
    @Test
    public void pruebaInsertarPregunta() throws Exception{

        ucab.dsw.servicio.PreguntaEncuestaAPI servicio = new ucab.dsw.servicio.PreguntaEncuestaAPI();
        PreguntaEncuestaDto preguntaEncuestaDto = new PreguntaEncuestaDto();

        preguntaEncuestaDto.set_descripcion("Que te parece los perros calientes de arandanos?");
        preguntaEncuestaDto.set_tipoPregunta("Desarrollo");
        preguntaEncuestaDto.set_estatus("Activo");
        // Recuerden que deben ver los id de los registros en la BD
        UsuarioDto usuarioDto = new UsuarioDto(1L);
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto(5L);
        preguntaEncuestaDto.set_usuarioDto(usuarioDto);
        preguntaEncuestaDto.set_subcategoriaDto(subcategoriaDto);
        PreguntaEncuestaDto resultado = servicio.addPreguntaEncuesta(preguntaEncuestaDto);
        Assert.assertNotEquals(resultado.get_id(), 0);
    }

    // Esta prueba permite actualizar el estatus de Pregunta
    @Test
    public void pruebaModificarEstatusPregunta(){

        ucab.dsw.servicio.PreguntaEncuestaAPI servicio = new ucab.dsw.servicio.PreguntaEncuestaAPI();
        PreguntaEncuestaDto preguntaEncuestaDto = new PreguntaEncuestaDto();
        preguntaEncuestaDto.set_estatus("Activo");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarPreguntaEncuesta(1L, preguntaEncuestaDto);
    }

    // Esta prueba permite modificar una pregunta
    @Test
    public void pruebaModificarPregunta(){

        ucab.dsw.servicio.PreguntaEncuestaAPI servicio = new ucab.dsw.servicio.PreguntaEncuestaAPI();
        PreguntaEncuestaDto preguntaEncuestaDto = new PreguntaEncuestaDto();
        preguntaEncuestaDto.set_descripcion("Que te parece los perros calientes de arandanos?");
        preguntaEncuestaDto.set_tipoPregunta("Desarrollo");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarPreguntaEncuesta(1L, preguntaEncuestaDto);

    }

    //Esta prueba permite eliminar una pregunta
    @Test
    public void pruebaEliminarPregunta(){

        ucab.dsw.servicio.PreguntaEncuestaAPI servicio = new ucab.dsw.servicio.PreguntaEncuestaAPI();
        // Recuerden que deben ver los id de los registros en la BD
        servicio.eliminarPreguntaEncuesta(1L);
    }
}
