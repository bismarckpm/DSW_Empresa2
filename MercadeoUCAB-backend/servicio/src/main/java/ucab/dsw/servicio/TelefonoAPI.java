package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTelefono;
import ucab.dsw.dtos.TelefonoDto;
import ucab.dsw.entidades.Informacion;
import ucab.dsw.entidades.Telefono;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/telefono" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TelefonoAPI extends AplicacionBase{

    //Listar telefonos
    @GET
    @Path("/allTelefono")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Telefono> listarTelefonos() throws NullPointerException{
        DaoTelefono daoTelefono = new DaoTelefono();

        try {
            return daoTelefono.findAll(Telefono.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Consultar un telefono
    @GET
    @Path("/consultarTelefono/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Telefono consultarTelefono(@PathParam("id") long id) throws NullPointerException{
        DaoTelefono daoTelefono = new DaoTelefono();

        try {
            return daoTelefono.find(id, Telefono.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar un telefono
    @POST
    @Path("/addTelefono")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public TelefonoDto addTelefono(TelefonoDto telefonoDto){

        TelefonoDto resultado = new TelefonoDto();

        try {

            DaoTelefono daoTelefono = new DaoTelefono();
            Telefono telefono = new Telefono();

            telefono.set_numero(telefonoDto.get_numero());
            telefono.set_estatus(telefonoDto.get_estatus());
            Informacion informacion = new Informacion(telefonoDto.get_informacion().get_id());
            telefono.set_informacion(informacion);
            Telefono resul = daoTelefono.insert(telefono);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar un telefono
    @PUT
    @Path("/updateTelefono/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateTelefono(@PathParam("id") long id, TelefonoDto telefonoDto){

        DaoTelefono daoTelefono = new DaoTelefono();
        Telefono telefono_modificar = daoTelefono.find(id, Telefono.class);

        if (telefono_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                telefono_modificar.set_numero(telefonoDto.get_numero());
                telefono_modificar.set_estatus(telefonoDto.get_estatus());
                daoTelefono.update(telefono_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(telefono_modificar).build();

    }

    //Eliminar telefono
    @DELETE
    @Path("/deleteTelefono/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarTelefono(@PathParam("id") long id){

        DaoTelefono daoTelefono = new DaoTelefono();
        Telefono telefono_eliminar = daoTelefono.find(id, Telefono.class);

        if (telefono_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                daoTelefono.delete(telefono_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(telefono_eliminar).build();

    }

}
