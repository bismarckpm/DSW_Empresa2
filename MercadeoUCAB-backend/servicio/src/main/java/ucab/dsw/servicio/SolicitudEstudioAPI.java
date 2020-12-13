package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.accesodatos.DaoSolicitudEstudio;
import ucab.dsw.dtos.SolicitudEstudioDto;
import ucab.dsw.entidades.*;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/solicitudEstudio" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SolicitudEstudioAPI extends AplicacionBase{

    // Listar solicitudes
    @GET
    @Path("/allSolicitudEstudio")
    @Produces( MediaType.APPLICATION_JSON )
    public List<SolicitudEstudio> listarSolicitudes() throws NullPointerException{
        DaoSolicitudEstudio daoSolicitudEstudio = new DaoSolicitudEstudio();

        try {
            return daoSolicitudEstudio.findAll(SolicitudEstudio.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Consultar solicitud
    @GET
    @Path("/consultarSolicitudEstudio/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public SolicitudEstudio consultarSolicitud(@PathParam("id") long id) throws NullPointerException{
        DaoSolicitudEstudio daoSolicitudEstudio = new DaoSolicitudEstudio();

        try {
            return daoSolicitudEstudio.find(id, SolicitudEstudio.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Mostrar solicitudes activas
    @GET
    @Path("/mostrarSolicitudesActivas")
    @Produces( MediaType.APPLICATION_JSON )
    public List<SolicitudEstudio> mostrarSolicitudesActivas() throws NullPointerException{
        DaoSolicitudEstudio daoSolicitudEstudio = new DaoSolicitudEstudio();
        List<SolicitudEstudio> listaSolicitud = daoSolicitudEstudio.findAll(SolicitudEstudio.class);
        List<SolicitudEstudio> listaSolicitudesActivas = new ArrayList<SolicitudEstudio>();

        try {

            for (SolicitudEstudio solicitudEstudio : listaSolicitud) {

                if (solicitudEstudio.get_estatus().equals("Activo")) {
                    listaSolicitudesActivas.add(solicitudEstudio);
                }
            }
            return listaSolicitudesActivas;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Agregar una solicitud
    @POST
    @Path("/addSolicitudEstudio")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public SolicitudEstudioDto addSolicitudEstudio(SolicitudEstudioDto solicitudEstudioDto){

        SolicitudEstudioDto resultado = new SolicitudEstudioDto();

        try {

            DaoSolicitudEstudio daoSolicitudEstudio = new DaoSolicitudEstudio();
            SolicitudEstudio solicitudEstudio = new SolicitudEstudio();

            solicitudEstudio.set_descripcion(solicitudEstudioDto.get_descripcion());
            solicitudEstudio.set_genero(solicitudEstudioDto.get_genero());
            solicitudEstudio.set_edadMaxima(solicitudEstudioDto.get_edadMaxima());
            solicitudEstudio.set_edadMinima(solicitudEstudioDto.get_edadMinima());
            solicitudEstudio.set_estadoCivil(solicitudEstudioDto.get_estadoCivil());
            solicitudEstudio.set_disponibilidadEnLinea(solicitudEstudioDto.get_disponibilidadEnLinea());
            solicitudEstudio.set_cantidadPersonas(solicitudEstudioDto.get_cantidadPersonas());
            solicitudEstudio.set_cantidadHijos(solicitudEstudioDto.get_cantidadHijos());
            solicitudEstudio.set_generoHijos(solicitudEstudioDto.get_generoHijos());
            solicitudEstudio.set_edadMinimaHijos(solicitudEstudioDto.get_edadMinimaHijos());
            solicitudEstudio.set_edadMaximaHijos(solicitudEstudioDto.get_edadMaximaHijos());
            solicitudEstudio.set_estatus(solicitudEstudioDto.get_estatus());
            NivelEconomico nivelEconomico = new NivelEconomico(solicitudEstudioDto.get_nivelEconomicoDto().get_id());
            Usuario usuario = new Usuario(solicitudEstudioDto.get_usuarioDto().get_id());
            Producto producto = new Producto(solicitudEstudioDto.get_productoDto().get_id());
            Ocupacion ocupacion = new Ocupacion(solicitudEstudioDto.get_ocupacionDto().get_id());
            NivelAcademico nivelAcademico = new NivelAcademico(solicitudEstudioDto.get_nivelAcademicoDto().get_id());
            solicitudEstudio.set_nivelEconomico(nivelEconomico);
            solicitudEstudio.set_usuario(usuario);
            solicitudEstudio.set_producto(producto);
            solicitudEstudio.set_ocupacion(ocupacion);
            solicitudEstudio.set_nivelAcademico(nivelAcademico);
            SolicitudEstudio resul = daoSolicitudEstudio.insert(solicitudEstudio);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar estatus de solicitud
    @PUT
    @Path("/estatusSolicitudEstudio/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusSolicitudEstudio(@PathParam("id") long id, SolicitudEstudioDto solicitudEstudioDto){

        DaoSolicitudEstudio daoSolicitudEstudio = new DaoSolicitudEstudio();
        SolicitudEstudio solicitudEstudio_modificar = daoSolicitudEstudio.find(id, SolicitudEstudio.class);

        if (solicitudEstudio_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                solicitudEstudio_modificar.set_estatus(solicitudEstudioDto.get_estatus());
                daoSolicitudEstudio.update(solicitudEstudio_modificar);
                DaoEstudio daoEstudio = new DaoEstudio();

                if (solicitudEstudio_modificar.get_estatus() == "Inactivo") {

                    List<Estudio> listaEstudio = daoEstudio.findAll(Estudio.class);

                    for (Estudio estudio : listaEstudio) {

                        if (estudio.get_solicitudEstudio().get_id() == id) {
                            estudio.set_estatus("Inactivo");
                            daoEstudio.update(estudio);
                        }
                    }
                } else if (solicitudEstudio_modificar.get_estatus() == "Activo") {

                    List<Estudio> listaEstudio = daoEstudio.findAll(Estudio.class);

                    for (Estudio estudio : listaEstudio) {

                        if (estudio.get_solicitudEstudio().get_id() == id) {
                            estudio.set_estatus("Activo");
                            daoEstudio.update(estudio);
                        }
                    }
                }

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(solicitudEstudio_modificar).build();

    }

    //Actualizar solicitud
    @PUT
    @Path("/updateSolicitudEstudio/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarSolicitudEstudio(@PathParam("id") long id, SolicitudEstudioDto solicitudEstudioDto){

        DaoSolicitudEstudio daoSolicitudEstudio = new DaoSolicitudEstudio();
        SolicitudEstudio solicitudEstudio_modificar = daoSolicitudEstudio.find(id, SolicitudEstudio.class);

        if (solicitudEstudio_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                solicitudEstudio_modificar.set_descripcion(solicitudEstudioDto.get_descripcion());
                solicitudEstudio_modificar.set_genero(solicitudEstudioDto.get_genero());
                solicitudEstudio_modificar.set_edadMaxima(solicitudEstudioDto.get_edadMaxima());
                solicitudEstudio_modificar.set_edadMinima(solicitudEstudioDto.get_edadMinima());
                solicitudEstudio_modificar.set_estadoCivil(solicitudEstudioDto.get_estadoCivil());
                solicitudEstudio_modificar.set_disponibilidadEnLinea(solicitudEstudioDto.get_disponibilidadEnLinea());
                solicitudEstudio_modificar.set_cantidadPersonas(solicitudEstudioDto.get_cantidadPersonas());
                solicitudEstudio_modificar.set_cantidadHijos(solicitudEstudioDto.get_cantidadHijos());
                solicitudEstudio_modificar.set_generoHijos(solicitudEstudioDto.get_generoHijos());
                solicitudEstudio_modificar.set_edadMinimaHijos(solicitudEstudioDto.get_edadMinimaHijos());
                solicitudEstudio_modificar.set_edadMaximaHijos(solicitudEstudioDto.get_edadMaximaHijos());
                daoSolicitudEstudio.update(solicitudEstudio_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(solicitudEstudio_modificar).build();

    }

    //Eliminar solicitud
    @DELETE
    @Path("/deleteSolicitudEstudio/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarSolicitudEstudio(@PathParam("id") long id){

        DaoSolicitudEstudio daoSolicitudEstudio = new DaoSolicitudEstudio();
        SolicitudEstudio solicitudEstudio = daoSolicitudEstudio.find(id, SolicitudEstudio.class);

        if(solicitudEstudio == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                daoSolicitudEstudio.delete(solicitudEstudio);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

        return Response.ok().entity(solicitudEstudio).build();
    }
}
