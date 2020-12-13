import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudEstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Estudio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EstudioAPI_Test {

    //Listar todos los estudios (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarEstudios(){

        ucab.dsw.servicio.EstudioAPI servicio = new ucab.dsw.servicio.EstudioAPI();

        try {
            Assertions.assertTrue(servicio.listarEstudios().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar un Estudio (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarEstudio(){

        ucab.dsw.servicio.EstudioAPI servicio = new ucab.dsw.servicio.EstudioAPI();
        Estudio estudio_buscar = servicio.consultarEstudio(1L);

        try {
            Assertions.assertEquals(1, estudio_buscar.get_id());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Listar estudios activos (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarEstudiosActivos(){

        try {
            Assertions.assertNotNull(new ucab.dsw.servicio.EstudioAPI().estudiosActivos());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    // Esta prueba permite insertar un estudio a la BD
    @Test
    public void pruebaInsertarEstudio() throws Exception {

        ucab.dsw.servicio.EstudioAPI servicio = new ucab.dsw.servicio.EstudioAPI();
        EstudioDto estudioDto = new EstudioDto();

        estudioDto.set_nombre("Perros calientes raros parte 2");
        estudioDto.set_tipoInstrumento("Encuesta");
        String date1 = "2020-12-01";
        DateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = forma.parse(date1);
        estudioDto.set_fechaInicio(myDate);
        String date2 = "2021-01-21";
        DateFormat forma2 = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate2 = forma2.parse(date2);
        estudioDto.set_fechaFin(myDate2);
        estudioDto.set_estatus("Activo");
        // Revisar los registros de sus base de datos
        SolicitudEstudioDto solicitudEstudioDto = new SolicitudEstudioDto(1L);
        estudioDto.set_solicitudEstudioDto(solicitudEstudioDto);
        UsuarioDto usuarioDto = new UsuarioDto(1L);
        estudioDto.set_usuarioDto(usuarioDto);
        EstudioDto resultado = servicio.addEstudios(estudioDto);
        Assert.assertNotEquals(resultado.get_id(), 0);

    }

    //Actualizar el estado del estudio
    @Test
    public void pruebaModificarEstatusEstudio() throws ParseException {

        ucab.dsw.servicio.EstudioAPI servicio = new ucab.dsw.servicio.EstudioAPI();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.set_estatus("Activo");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarEstudio(1L, estudioDto);
    }


    // Esta prueba permite modificar un estudio
    @Test
    public void pruebaModificarEstudio() throws ParseException {

        ucab.dsw.servicio.EstudioAPI servicio = new ucab.dsw.servicio.EstudioAPI();
        EstudioDto estudioDto = new EstudioDto();
        estudioDto.set_nombre("Perros calientes raros parte 2");
        estudioDto.set_tipoInstrumento("Encuesta");
        String date1 = "2020-12-01";
        DateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = forma.parse(date1);
        estudioDto.set_fechaInicio(myDate);
        String date2 = "2021-01-21";
        DateFormat forma2 = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate2 = forma2.parse(date2);
        estudioDto.set_fechaFin(myDate2);
        estudioDto.set_estatus("Activo");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarEstudio(1L, estudioDto);
    }

    // Esta prueba permite eliminar un estudio
    @Test
    public void pruebaEliminarEstudio(){

        ucab.dsw.servicio.EstudioAPI servicio = new ucab.dsw.servicio.EstudioAPI();
        // Recuerden que deben ver los id de los registros en la BD
        servicio.eliminarEstudio(1L);

    }
}
