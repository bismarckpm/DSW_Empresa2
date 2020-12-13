package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.entidades.*;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/estudio" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EstudioAPI extends AplicacionBase {

    // Listar todos los estudios
    @GET
    @Path("/allEstudio")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Estudio> listarEstudios() throws NullPointerException {

        DaoEstudio daoEstudio = new DaoEstudio();

        try {
            return daoEstudio.findAll(Estudio.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Consultar un estudio en especifico
    @GET
    @Path("/consultarEstudio/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Estudio consultarEstudio(@PathParam("id") long id) throws NullPointerException{

        DaoEstudio daoEstudio = new DaoEstudio();

        try {
            return daoEstudio.find(id, Estudio.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
        
    }

    // Muestra los estudios activos
    @GET
    @Path("/mostrarEstudiosActivos")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Estudio> estudiosActivos() throws NullPointerException{
        DaoEstudio daoEstudio = new DaoEstudio();
        List<Estudio> listaEstudios = daoEstudio.findAll(Estudio.class);
        List<Estudio> listaEstudiosActivos = new ArrayList<Estudio>();
        
        try {

            for (Estudio estudio : listaEstudios) {

                if (estudio.get_estatus().equals("Activo")) {
                    listaEstudiosActivos.add(estudio);
                }
            }
            return listaEstudiosActivos;
            
        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar un estudio
    @POST
    @Path("/addEstudio")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public EstudioDto addEstudios(EstudioDto estudioDto){

        EstudioDto resultado = new EstudioDto();
        
        try {

            DaoEstudio daoEstudio = new DaoEstudio();
            Estudio estudio = new Estudio();

            estudio.set_nombre(estudioDto.get_nombre());
            estudio.set_tipoInstrumento(estudioDto.get_tipoInstrumento());
            estudio.set_fechaInicio(estudioDto.get_fechaInicio());
            estudio.set_fechaFin(estudioDto.get_fechaFin());
            estudio.set_estatus(estudioDto.get_estatus());
            SolicitudEstudio solicitudEstudio = new SolicitudEstudio(estudioDto.get_solicitudEstudioDto().get_id());
            Usuario usuario = new Usuario(estudioDto.get_usuarioDto().get_id());
            estudio.set_solicitudEstudio(solicitudEstudio);
            estudio.set_usuario(usuario);
            Estudio resul = daoEstudio.insert(estudio);
            resultado.set_id(resul.get_id());
            
        } catch (Exception ex){
            
            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

        return resultado;

    }

    //Actualizar el estatus de estudio
    @PUT
    @Path("/estatusEstudio/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusEstudio(@PathParam("id") long id, EstudioDto estudioDto){

        DaoEstudio daoEstudio = new DaoEstudio();
        Estudio estudio_modificar = daoEstudio.find(id, Estudio.class);

        if(estudio_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();

        }

            try {

                estudio_modificar.set_estatus(estudioDto.get_estatus());
                daoEstudio.update(estudio_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(estudio_modificar).build();

    }

    // Actualizar un estudio
    @PUT
    @Path("/updateEstudio/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstudio(@PathParam("id") long id, EstudioDto estudioDto){

        DaoEstudio daoEstudio = new DaoEstudio();
        Estudio estudio_modificar = daoEstudio.find(id, Estudio.class);

        if(estudio_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                estudio_modificar.set_nombre(estudioDto.get_nombre());
                estudio_modificar.set_tipoInstrumento(estudioDto.get_tipoInstrumento());
                estudio_modificar.set_fechaInicio(estudioDto.get_fechaInicio());
                estudio_modificar.set_fechaFin(estudioDto.get_fechaFin());
                daoEstudio.update(estudio_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();

            }

            return Response.ok().entity(estudio_modificar).build();

    }

    //Eliminar un Estudio
    @DELETE
    @Path("/deleteEstudio/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarEstudio(@PathParam("id") long id){

        DaoEstudio daoEstudio = new DaoEstudio();
        Estudio estudio_eliminar = daoEstudio.find(id, Estudio.class);

        if(estudio_eliminar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();

        }
            try {

                daoEstudio.delete(estudio_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(estudio_eliminar).build();

    }
}
