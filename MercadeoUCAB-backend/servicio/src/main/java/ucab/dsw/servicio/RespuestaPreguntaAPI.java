package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoRespuestaPregunta;
import ucab.dsw.dtos.RespuestaPreguntaDto;
import ucab.dsw.entidades.PreguntaEncuesta;
import ucab.dsw.entidades.RespuestaPregunta;
import ucab.dsw.entidades.Subcategoria;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/respuestaPregunta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class RespuestaPreguntaAPI extends AplicacionBase{

    //Listar posibles respuestas de pregunta
    @GET
    @Path("/allRespuestaPregunta")
    @Produces( MediaType.APPLICATION_JSON )
    public List<RespuestaPregunta> listarRespuestas() throws NullPointerException{
        DaoRespuestaPregunta daoRespuestaPregunta = new DaoRespuestaPregunta();

        try {
            return daoRespuestaPregunta.findAll(RespuestaPregunta.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Consultar una respuesta de pregunta
    @GET
    @Path("/consultarRespuestaPregunta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public RespuestaPregunta encontrarRespuestaPregunta(@PathParam("id") long id) throws NullPointerException{
        DaoRespuestaPregunta daoRespuestaPregunta = new DaoRespuestaPregunta();

        try {
            return daoRespuestaPregunta.find(id, RespuestaPregunta.class);

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
    public List<RespuestaPregunta> respuestasActivas() throws NullPointerException{
        DaoRespuestaPregunta daoRespuestaPregunta = new DaoRespuestaPregunta();
        List<RespuestaPregunta> listaRespuesta = daoRespuestaPregunta.findAll(RespuestaPregunta.class);
        List<RespuestaPregunta> listaRespuestaActivas = new ArrayList<RespuestaPregunta>();

        try {
            for (RespuestaPregunta respuestaPregunta : listaRespuesta) {

                if (respuestaPregunta.get_estatus().equals("Activo")) {
                    listaRespuestaActivas.add(respuestaPregunta);
                }
            }
            return listaRespuestaActivas;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar una respuesta de pregunta
    @POST
    @Path("/addRespuestaPregunta")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public RespuestaPreguntaDto addRespuestaPregunta(RespuestaPreguntaDto respuestaPreguntaDto){

        RespuestaPreguntaDto resultado = new RespuestaPreguntaDto();

        try {

            DaoRespuestaPregunta daoRespuestaPregunta = new DaoRespuestaPregunta();
            RespuestaPregunta respuestaPregunta = new RespuestaPregunta();

            respuestaPregunta.set_nombre(respuestaPreguntaDto.get_nombre());
            respuestaPregunta.set_estatus(respuestaPreguntaDto.get_estatus());
            PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta(respuestaPreguntaDto.get_preguntaEncuestaDto().get_id());
            respuestaPregunta.set_preguntaEncuesta(preguntaEncuesta);
            RespuestaPregunta resul = daoRespuestaPregunta.insert(respuestaPregunta);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar estatus de respuestas preguntas
    @PUT
    @Path("/estatusRespuestaPregunta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusRespuestaPregunta(@PathParam("id") long id, RespuestaPreguntaDto respuestaPreguntaDto){

        DaoRespuestaPregunta daoRespuestaPregunta = new DaoRespuestaPregunta();
        RespuestaPregunta respuestaPregunta_modificar = daoRespuestaPregunta.find(id, RespuestaPregunta.class);

        if (respuestaPregunta_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                respuestaPregunta_modificar.set_estatus(respuestaPreguntaDto.get_estatus());
                daoRespuestaPregunta.update(respuestaPregunta_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(respuestaPregunta_modificar).build();

    }

    //Actualizar respuesta pregunta
    @PUT
    @Path("/updateRespuestaPregunta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarRespuestaPregunta(@PathParam("id") long id, RespuestaPreguntaDto respuestaPreguntaDto){

        DaoRespuestaPregunta daoRespuestaPregunta = new DaoRespuestaPregunta();
        RespuestaPregunta respuestaPregunta_modificar = daoRespuestaPregunta.find(id, RespuestaPregunta.class);

        if (respuestaPregunta_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                respuestaPregunta_modificar.set_nombre(respuestaPreguntaDto.get_nombre());
                daoRespuestaPregunta.update(respuestaPregunta_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(respuestaPregunta_modificar).build();

    }

    //Eliminar respuesta pregunta
    @DELETE
    @Path("/deleteRespuestaPregunta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarRespuestaPregunta(@PathParam("id") long id){

        DaoRespuestaPregunta daoRespuestaPregunta = new DaoRespuestaPregunta();
        RespuestaPregunta respuestaPregunta_eliminar = daoRespuestaPregunta.find(id, RespuestaPregunta.class);

        if(respuestaPregunta_eliminar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                daoRespuestaPregunta.delete(respuestaPregunta_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(respuestaPregunta_eliminar).build();

    }

}
