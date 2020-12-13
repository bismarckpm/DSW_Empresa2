import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.OcupacionDto;
import ucab.dsw.entidades.Ocupacion;

public class OcupacionAPI_Test {

    //Listar todos las ocupaciones (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarOcupaciones(){

        ucab.dsw.servicio.OcupacionAPI servicio = new ucab.dsw.servicio.OcupacionAPI();

        try {
            Assertions.assertTrue(servicio.listarOcupacion().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar una ocupacion (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarOcupacion(){

        ucab.dsw.servicio.OcupacionAPI servicio = new ucab.dsw.servicio.OcupacionAPI();
        Ocupacion ocupacion_buscar = servicio.consultarOcupacion(1L);

        try {
            Assertions.assertEquals(1, ocupacion_buscar.get_id());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Prueba insertar una ocupacion
    @Test
    public void pruebaInsertarOcupacion(){

        ucab.dsw.servicio.OcupacionAPI servicio = new ucab.dsw.servicio.OcupacionAPI();
        OcupacionDto ocupacionDto = new OcupacionDto();

        ocupacionDto.set_nombre("Medico");
        ocupacionDto.set_estatus("Activo");
        OcupacionDto resultado = servicio.addOcupacion(ocupacionDto);
        Assert.assertNotEquals( resultado.get_id(), 0 );

    }

    //Prueba modificar una ocupacion
    @Test
    public void pruebaModificarOcupacion(){

        ucab.dsw.servicio.OcupacionAPI servicio = new ucab.dsw.servicio.OcupacionAPI();
        OcupacionDto ocupacionDto = new OcupacionDto();

        ocupacionDto.set_nombre("");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.updateOcupacion(1L, ocupacionDto);

    }

    //Prueba eliminar una ocupacion
    @Test
    public void pruebaEliminarOcupacion(){

        ucab.dsw.servicio.OcupacionAPI servicio = new ucab.dsw.servicio.OcupacionAPI();
        // Recuerden que deben ver los id de los registros en la BD
        servicio.eliminarOcupacion(2L);

    }
}
