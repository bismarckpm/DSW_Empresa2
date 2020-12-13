package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoMedioComunicacion;
import ucab.dsw.dtos.MedioComunicacionDto;
import ucab.dsw.entidades.Informacion;
import ucab.dsw.entidades.MedioComunicacion;
import ucab.dsw.entidades.SolicitudEstudio;

import java.util.List;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/medioComunicacion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class MedioComunicacionAPI extends AplicacionBase{

    // Listar medios
    @GET
    @Path("/allMedioComunicacion")
    @Produces( MediaType.APPLICATION_JSON )
    public List<MedioComunicacion> listarMedioComunicacion() throws NullPointerException{
        DaoMedioComunicacion daoMedioComunicacion = new DaoMedioComunicacion();

        try {
            return daoMedioComunicacion.findAll(MedioComunicacion.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Consultar un medio
    @GET
    @Path("/consultarMedioComunicacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public MedioComunicacion consultarMedioComunicacion(@PathParam("id") long id) throws NullPointerException{
        DaoMedioComunicacion daoMedioComunicacion = new DaoMedioComunicacion();

        try {
            return daoMedioComunicacion.find(id, MedioComunicacion.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar un medio
    @POST
    @Path("/addMedioComunicacion")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public MedioComunicacionDto addMedioComunicacion(MedioComunicacionDto medioComunicacionDto){

        MedioComunicacionDto resultado = new MedioComunicacionDto();

        try {


            DaoMedioComunicacion daoMedioComunicacion = new DaoMedioComunicacion();
            MedioComunicacion medioComunicacion = new MedioComunicacion();

            medioComunicacion.set_tipoDeMedio(medioComunicacionDto.get_tipoDeMedio());
            medioComunicacion.set_estatus(medioComunicacionDto.get_estatus());
            Informacion informacion = new Informacion(medioComunicacionDto.get_informacionDto().get_id());
            SolicitudEstudio solicitudEstudio = new SolicitudEstudio(medioComunicacionDto.get_solicitudEstudioDto().get_id());
            medioComunicacion.set_informacion(informacion);
            medioComunicacion.set_solicitudEstudio(solicitudEstudio);
            MedioComunicacion resul = daoMedioComunicacion.insert(medioComunicacion);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);

        }

            return resultado;
    }

    //Actualizar un medio
    @PUT
    @Path("/updateMedioComunicacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateMedioComunicacion(@PathParam("id") long id, MedioComunicacionDto medioComunicacionDto){

        DaoMedioComunicacion daoMedioComunicacion = new DaoMedioComunicacion();
        MedioComunicacion medioComunicacion_modificar = daoMedioComunicacion.find(id, MedioComunicacion.class);

        if(medioComunicacion_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                medioComunicacion_modificar.set_tipoDeMedio(medioComunicacionDto.get_tipoDeMedio());
                medioComunicacion_modificar.set_estatus(medioComunicacionDto.get_estatus());
                daoMedioComunicacion.update(medioComunicacion_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(medioComunicacion_modificar).build();

    }

    // Eliminar un medio
    @DELETE
    @Path("/deleteMedioComunicacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarMedioComunicacion(@PathParam("id") long id){

        DaoMedioComunicacion daoMedioComunicacion = new DaoMedioComunicacion();
        MedioComunicacion medioComunicacion_eliminar = daoMedioComunicacion.find(id, MedioComunicacion.class);

        if (medioComunicacion_eliminar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                daoMedioComunicacion.delete(medioComunicacion_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(medioComunicacion_eliminar).build();

    }

}
