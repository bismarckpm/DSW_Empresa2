package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoPreguntaEncuesta;
import ucab.dsw.accesodatos.DaoRespuestaPregunta;
import ucab.dsw.dtos.PreguntaEncuestaDto;
import ucab.dsw.entidades.PreguntaEncuesta;
import ucab.dsw.entidades.RespuestaPregunta;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/preguntasEncuesta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PreguntaEncuestaAPI extends AplicacionBase{

    //Listar preguntas
    @GET
    @Path("/allPreguntasEncuesta")
    @Produces( MediaType.APPLICATION_JSON )
    public List<PreguntaEncuesta> listarPreguntas() throws NullPointerException{
        DaoPreguntaEncuesta daoPreguntaEncuesta = new DaoPreguntaEncuesta();

        try {
            return daoPreguntaEncuesta.findAll(PreguntaEncuesta.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Consultar una pregunta
    @GET
    @Path("/consultarPreguntaEncuesta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public PreguntaEncuesta encontrarPreguntaEncuesta(@PathParam("id") long id) throws NullPointerException{
        DaoPreguntaEncuesta daoPreguntaEncuesta = new DaoPreguntaEncuesta();

        try {
            return daoPreguntaEncuesta.find(id, PreguntaEncuesta.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Mostrar las preguntas activas
    @GET
    @Path("/mostrarPreguntasActivas")
    @Produces( MediaType.APPLICATION_JSON )
    public List<PreguntaEncuesta> preguntasActivas() throws NullPointerException{
        DaoPreguntaEncuesta daoPreguntaEncuesta = new DaoPreguntaEncuesta();
        List<PreguntaEncuesta> listaPreguntas = daoPreguntaEncuesta.findAll(PreguntaEncuesta.class);
        List<PreguntaEncuesta> listaPreguntasActivas = new ArrayList<PreguntaEncuesta>();

        try {

            for (PreguntaEncuesta preguntaEncuesta : listaPreguntas) {

                if (preguntaEncuesta.get_estatus().equals("Activo")) {
                    listaPreguntasActivas.add(preguntaEncuesta);
                }
            }
            return listaPreguntasActivas;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar una pregunta
    @POST
    @Path("/addPreguntaEncuesta")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public PreguntaEncuestaDto addPreguntaEncuesta(PreguntaEncuestaDto preguntaEncuestaDto){

        PreguntaEncuestaDto resultado = new PreguntaEncuestaDto();

        try {

            DaoPreguntaEncuesta daoPreguntaEncuesta = new DaoPreguntaEncuesta();
            PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta();

            preguntaEncuesta.set_descripcion(preguntaEncuestaDto.get_descripcion());
            preguntaEncuesta.set_tipoPregunta(preguntaEncuestaDto.get_tipoPregunta());
            preguntaEncuesta.set_estatus(preguntaEncuestaDto.get_estatus());
            Usuario usuario = new Usuario(preguntaEncuestaDto.get_usuarioDto().get_id());
            preguntaEncuesta.set_usuario(usuario);
            Subcategoria subcategoria = new Subcategoria(preguntaEncuestaDto.get_subcategoriaDto().get_id());
            preguntaEncuesta.set_subcategoria(subcategoria);
            PreguntaEncuesta resul = daoPreguntaEncuesta.insert(preguntaEncuesta);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar estatus de pregunta
    @PUT
    @Path("/estatusPregunta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusPregunta(@PathParam("id") long id, PreguntaEncuestaDto preguntaEncuestaDto){

        DaoPreguntaEncuesta daoPreguntaEncuesta = new DaoPreguntaEncuesta();
        PreguntaEncuesta preguntaEncuesta_modificar = daoPreguntaEncuesta.find(id, PreguntaEncuesta.class);

        if (preguntaEncuesta_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                preguntaEncuesta_modificar.set_estatus(preguntaEncuestaDto.get_estatus());
                daoPreguntaEncuesta.update(preguntaEncuesta_modificar);
                DaoRespuestaPregunta daoRespuestaPregunta = new DaoRespuestaPregunta();

                if (preguntaEncuesta_modificar.get_estatus() == "Inactivo") {

                    List<RespuestaPregunta> listaRespuesta = daoRespuestaPregunta.findAll(RespuestaPregunta.class);

                    for (RespuestaPregunta respuestaPregunta : listaRespuesta) {

                        if (respuestaPregunta.get_preguntaEncuesta().get_id() == id) {
                            respuestaPregunta.set_estatus("Inactivo");
                            daoRespuestaPregunta.update(respuestaPregunta);
                        }
                    }
                } else if (preguntaEncuesta_modificar.get_estatus() == "Activo") {

                    List<RespuestaPregunta> listaRespuesta = daoRespuestaPregunta.findAll(RespuestaPregunta.class);

                    for (RespuestaPregunta respuestaPregunta : listaRespuesta) {

                        if (respuestaPregunta.get_preguntaEncuesta().get_id() == id) {
                            respuestaPregunta.set_estatus("Activo");
                            daoRespuestaPregunta.update(respuestaPregunta);
                        }
                    }
                }

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(preguntaEncuesta_modificar).build();

    }

    //Actualizar pregunta
    @PUT
    @Path("/updatePreguntaEncuesta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarPreguntaEncuesta(@PathParam("id") long id, PreguntaEncuestaDto preguntaEncuestaDto){

        DaoPreguntaEncuesta daoPreguntaEncuesta = new DaoPreguntaEncuesta();
        PreguntaEncuesta preguntaEncuesta_modificar = daoPreguntaEncuesta.find(id, PreguntaEncuesta.class);

        if (preguntaEncuesta_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                preguntaEncuesta_modificar.set_descripcion(preguntaEncuestaDto.get_descripcion());
                preguntaEncuesta_modificar.set_tipoPregunta(preguntaEncuestaDto.get_tipoPregunta());
                daoPreguntaEncuesta.update(preguntaEncuesta_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(preguntaEncuesta_modificar).build();

    }

    //Eliminar una pregunta
    @DELETE
    @Path("/deletePreguntaEncuesta/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarPreguntaEncuesta(@PathParam("id") long id){

        DaoPreguntaEncuesta daoPreguntaEncuesta = new DaoPreguntaEncuesta();
        PreguntaEncuesta preguntaEncuesta_eliminar = daoPreguntaEncuesta.find(id, PreguntaEncuesta.class);

        if (preguntaEncuesta_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                daoPreguntaEncuesta.delete(preguntaEncuesta_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(preguntaEncuesta_eliminar).build();

    }
}
