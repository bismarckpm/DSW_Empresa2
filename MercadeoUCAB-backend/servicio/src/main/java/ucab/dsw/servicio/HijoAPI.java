package ucab.dsw.servicio;

import org.eclipse.persistence.internal.sessions.DirectCollectionChangeRecord;
import ucab.dsw.accesodatos.DaoHijo;
import ucab.dsw.dtos.HijoDto;
import ucab.dsw.entidades.Hijo;
import ucab.dsw.entidades.Informacion;


import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/hijo" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class HijoAPI extends AplicacionBase{

    // Listar todos los hijos
    @GET
    @Path("/allHijos")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Hijo> listarHijos() throws NullPointerException {

        DaoHijo daoHijo = new DaoHijo();

        try {
            return daoHijo.findAll(Hijo.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Consultar un hijo
    @GET
    @Path("/consultarHijo/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Hijo consultarHijo(@PathParam("id") long id) throws NullPointerException {

        DaoHijo daoHijo = new DaoHijo();

        try {
            return daoHijo.find(id, Hijo.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Agregar un hijo
    @POST
    @Path("/addHijo")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public HijoDto addHijo(HijoDto hijoDto){

        HijoDto resultado = new HijoDto();

        try {

            DaoHijo daoHijo = new DaoHijo();
            Hijo hijo = new Hijo();

            hijo.set_fechaNacimiento(hijoDto.get_fechaNacimiento());
            hijo.set_genero(hijoDto.get_genero());
            hijo.set_estatus("Activo");
            Informacion informacion = new Informacion(hijoDto.get_informacionDto().get_id());
            hijo.set_informacion(informacion);
            Hijo resul = daoHijo.insert(hijo);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);

        }

            return resultado;
    }

    //Actualizar un hijo
    @PUT
    @Path("/updateHijo/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateHijo(@PathParam("id") long id, HijoDto hijoDto){

        DaoHijo daoHijo = new DaoHijo();
        Hijo hijo_modificar = daoHijo.find(id, Hijo.class);

        if(hijo_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();

        }

            try {

                hijo_modificar.set_fechaNacimiento(hijoDto.get_fechaNacimiento());
                hijo_modificar.set_genero(hijoDto.get_genero());
                hijo_modificar.set_estatus("Activo");
                daoHijo.update(hijo_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(hijo_modificar).build();

    }

    // Eliminar un hijo
    @DELETE
    @Path("/deleteHijo/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response deleteHijo(@PathParam("id") long id){

        DaoHijo daoHijo = new DaoHijo();
        Hijo hijo_eliminar = daoHijo.find(id, Hijo.class);

        if(hijo_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                daoHijo.delete(hijo_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok().entity(hijo_eliminar).build();

    }
}
