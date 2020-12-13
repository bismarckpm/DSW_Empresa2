package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoOcupacion;
import ucab.dsw.dtos.OcupacionDto;
import ucab.dsw.entidades.Ocupacion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path( "/ocupacion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class OcupacionAPI extends AplicacionBase {

    //Listar ocupaciones
    @GET
    @Path("/allOcupacion")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Ocupacion> listarOcupacion() throws NullPointerException{
        DaoOcupacion daoOcupacion = new DaoOcupacion();

        try {
            return daoOcupacion.findAll(Ocupacion.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Consultar una ocupacion
    @GET
    @Path("/consultarOcupacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Ocupacion consultarOcupacion(@PathParam("id") long id) throws NullPointerException{
        DaoOcupacion daoOcupacion = new DaoOcupacion();

        try {
            return daoOcupacion.find(id, Ocupacion.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Agregar una ocupacion
    @POST
    @Path("/addOcupacion")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public OcupacionDto addOcupacion(OcupacionDto ocupacionDto){

        OcupacionDto resultado = new OcupacionDto();

        try {

            DaoOcupacion daoOcupacion = new DaoOcupacion();
            Ocupacion ocupacion = new Ocupacion();

            ocupacion.set_nombre(ocupacionDto.get_nombre());
            ocupacion.set_estatus(ocupacionDto.get_estatus());
            Ocupacion resul = daoOcupacion.insert(ocupacion);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    // Actualizar una ocupacion
    @PUT
    @Path("/updateOcupacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateOcupacion(@PathParam("id") long id, OcupacionDto ocupacionDto){

        DaoOcupacion daoOcupacion = new DaoOcupacion();
        Ocupacion ocupacion_modificar = daoOcupacion.find(id, Ocupacion.class);

        if (ocupacion_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                ocupacion_modificar.set_nombre(ocupacionDto.get_nombre());
                ocupacion_modificar.set_estatus(ocupacionDto.get_estatus());
                daoOcupacion.update(ocupacion_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(ocupacion_modificar).build();

    }

    // Eliminar una ocupacion
    @DELETE
    @Path("/deleteOcupacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarOcupacion(@PathParam("id") long id){

        DaoOcupacion daoOcupacion = new DaoOcupacion();
        Ocupacion ocupacion_eliminar = daoOcupacion.find(id, Ocupacion.class);

        if (ocupacion_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                daoOcupacion.delete(ocupacion_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok().entity(ocupacion_eliminar).build();
    }
}
