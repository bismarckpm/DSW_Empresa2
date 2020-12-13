package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoRespuesta;
import ucab.dsw.dtos.RespuestaDto;
import ucab.dsw.entidades.PreguntaEstudio;
import ucab.dsw.entidades.Respuesta;
import ucab.dsw.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/respuesta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class RespuestaAPI extends AplicacionBase{

    // Listar respuestas
    @GET
    @Path("/allRespuesta")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Respuesta> listarRespuestas() throws NullPointerException {
        DaoRespuesta daoRespuesta = new DaoRespuesta();

        try {
            return daoRespuesta.findAll(Respuesta.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }

    }

    // Consultar una respuesta
    @GET
    @Path("/consultarRespuesta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Respuesta consultarRespuesta(@PathParam("id") long id) throws NullPointerException {
        DaoRespuesta daoRespuesta = new DaoRespuesta();

        try {
            return daoRespuesta.find(id, Respuesta.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }

    }

    //Mostrar respuestas activas
    @GET
    @Path("/mostrarRespuestasActivas")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Respuesta> respuestasActivas() throws NullPointerException{

        DaoRespuesta daoRespuesta = new DaoRespuesta();
        List<Respuesta> listaRespuesta = daoRespuesta.findAll(Respuesta.class);
        List<Respuesta> listaRespuestaActivas = new ArrayList<Respuesta>();

        try {

            for (Respuesta respuesta : listaRespuesta) {

                if (respuesta.get_estatus().equals("Activo")) {
                    listaRespuestaActivas.add(respuesta);
                }
            }

            return listaRespuestaActivas;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar una respuesta
    @POST
    @Path("/addRespuesta")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public RespuestaDto addRespuesta(RespuestaDto respuestaDto){

        RespuestaDto resultado = new RespuestaDto();

        try {

            DaoRespuesta daoRespuesta = new DaoRespuesta();
            Respuesta respuesta = new Respuesta();

            respuesta.set_respuestaAbierta(respuestaDto.get_respuestaAbierta());
            respuesta.set_escala(respuestaDto.get_escala());
            respuesta.set_verdaderoFalso(respuestaDto.get_verdaderoFalso());
            respuesta.set_respuestaSimple(respuestaDto.get_respuestaSimple());
            respuesta.set_respuestaMultiple(respuestaDto.get_respuestaMultiple());
            respuesta.set_estatus(respuestaDto.get_estatus());
            PreguntaEstudio preguntaEstudio = new PreguntaEstudio(respuestaDto.get_preguntaEstudioDto().get_id());
            Usuario usuario = new Usuario(respuestaDto.get_usuarioDto().get_id());
            respuesta.set_preguntaEstudio(preguntaEstudio);
            respuesta.set_usuario(usuario);
            Respuesta resul = daoRespuesta.insert(respuesta);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar estatus de respuesta
    @PUT
    @Path("/estatusRespuesta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusRespuesta(@PathParam("id") long id, RespuestaDto respuestaDto){

        DaoRespuesta daoRespuesta = new DaoRespuesta();
        Respuesta respuesta_modificar = daoRespuesta.find(id, Respuesta.class);

        if(respuesta_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                respuesta_modificar.set_estatus(respuestaDto.get_estatus());
                daoRespuesta.update(respuesta_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

        return Response.ok().entity(respuesta_modificar).build();

    }

    //Actualizar respuesta
    @PUT
    @Path("/updateRespuesta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateRespuesta(@PathParam("id") long id, RespuestaDto respuestaDto){

        DaoRespuesta daoRespuesta = new DaoRespuesta();
        Respuesta respuesta_modificar = daoRespuesta.find(id, Respuesta.class);

        if(respuesta_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                respuesta_modificar.set_respuestaAbierta(respuestaDto.get_respuestaAbierta());
                respuesta_modificar.set_escala(respuestaDto.get_escala());
                respuesta_modificar.set_verdaderoFalso(respuestaDto.get_verdaderoFalso());
                respuesta_modificar.set_respuestaSimple(respuestaDto.get_respuestaSimple());
                respuesta_modificar.set_respuestaMultiple(respuestaDto.get_respuestaMultiple());
                daoRespuesta.update(respuesta_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(respuesta_modificar).build();

    }

    //Eliminar una respuesta
    @DELETE
    @Path("/deleteRespuesta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarRespuesta(@PathParam("id") long id){

        DaoRespuesta daoRespuesta = new DaoRespuesta();
        Respuesta respuesta_eliminar = daoRespuesta.find(id, Respuesta.class);

        if (respuesta_eliminar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                daoRespuesta.delete(respuesta_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(respuesta_eliminar).build();

    }

}
