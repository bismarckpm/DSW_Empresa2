import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.PresentacionDto;
import ucab.dsw.dtos.ProductoDto;
import ucab.dsw.entidades.Presentacion;

public class PresentacionAPI_Test {

    //Listar todas las presentaciones (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarPresentaciones(){

        ucab.dsw.servicio.PresentacionAPI servicio = new ucab.dsw.servicio.PresentacionAPI();

        try {
            Assertions.assertTrue(servicio.listarPresentaciones().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar una presentacion (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarPresentacion(){

        ucab.dsw.servicio.PresentacionAPI servicio = new ucab.dsw.servicio.PresentacionAPI();
        Presentacion presentacion_buscar = servicio.consultarPresentacion(1L);

        try {
            Assertions.assertEquals(1, presentacion_buscar.get_id());

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    // Listar presentaciones activas (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarPresentacionesActivas(){

        try {
            Assertions.assertNotNull(new ucab.dsw.servicio.PresentacionAPI().presentacionesActivas());

        } catch (Exception e) {

            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    // Prueba insertar una presentacion
    @Test
    public void pruebaInsertarPresentacion() throws Exception {

        ucab.dsw.servicio.PresentacionAPI servicio = new ucab.dsw.servicio.PresentacionAPI();
        PresentacionDto presentacionDto = new PresentacionDto();

        presentacionDto.set_nombre("");
        presentacionDto.set_caracteristicas("");
        presentacionDto.set_estatus("Activo");
        ProductoDto productoDto = new ProductoDto(1L);
        presentacionDto.set_productoDto(productoDto);
        PresentacionDto resultado = servicio.addPresentacion(presentacionDto);
        Assert.assertNotEquals( resultado.get_id(), 0 );

    }

    // Prueba actualizar estatus
    @Test
    public void pruebaModificarEstatusPresentacion(){

        ucab.dsw.servicio.PresentacionAPI servicio = new ucab.dsw.servicio.PresentacionAPI();
        PresentacionDto presentacionDto = new PresentacionDto();

        presentacionDto.set_estatus("Activo");
        // Estar mosca con los id de la bd
        servicio.modificarEstatusPresentacion(1L, presentacionDto);

    }

    // Prueba para modificar presentacion
    @Test
    public void pruebaModificarPresentacion(){

        ucab.dsw.servicio.PresentacionAPI servicio = new ucab.dsw.servicio.PresentacionAPI();
        PresentacionDto presentacionDto = new PresentacionDto();

        presentacionDto.set_nombre("");
        presentacionDto.set_caracteristicas("");
        // Estar mosca con los id de la bd
        servicio.updatePresentacion(1L, presentacionDto);

    }

    // Prueba para eliminar presentacion
    @Test
    public void pruebaEliminarPresentacion(){

        ucab.dsw.servicio.PresentacionAPI servicio = new ucab.dsw.servicio.PresentacionAPI();
        // Estar mosca con los id de la bd
        servicio.eliminarPresentacion(1L);

    }

}
