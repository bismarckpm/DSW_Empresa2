package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipo;
import ucab.dsw.dtos.TipoDto;
import ucab.dsw.entidades.Producto;
import ucab.dsw.entidades.Tipo;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path( "/tipo" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TipoAPI extends AplicacionBase{

    // Listar tipos
    @GET
    @Path("/allTipo")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Tipo> listarTipos() throws NullPointerException{
        DaoTipo daoTipo = new DaoTipo();

        try {
            return daoTipo.findAll(Tipo.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Consultar tipo
    @GET
    @Path("/consultarTipo/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Tipo consultarTipo(@PathParam("id") long id) throws NullPointerException{
        DaoTipo daoTipo = new DaoTipo();

        try {
            return daoTipo.find(id, Tipo.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Mostrar tipos activos
    @GET
    @Path("/mostrarTiposActivos")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Tipo> tiposActivos() throws NullPointerException{

        DaoTipo daoTipo = new DaoTipo();
        List<Tipo> listaTipo = daoTipo.findAll(Tipo.class);
        List<Tipo> listaTipoActivo = new ArrayList<Tipo>();

        try {

            for (Tipo tipo : listaTipo) {

                if (tipo.get_estatus().equals("Activo")) {
                    listaTipoActivo.add(tipo);
                }
            }
            return listaTipoActivo;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Agregar tipo
    @POST
    @Path("/addTipo")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public TipoDto addTipo(TipoDto tipoDto){

        TipoDto resultado = new TipoDto();

        try {

            DaoTipo daoTipo = new DaoTipo();
            Tipo tipo = new Tipo();

            tipo.set_nombre(tipoDto.get_nombre());
            tipo.set_descripcion(tipoDto.get_descripcion());
            tipo.set_estatus(tipoDto.get_estatus());
            Producto producto = new Producto(tipoDto.get_productoDto().get_id());
            tipo.set_producto(producto);
            Tipo resul = daoTipo.insert(tipo);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar estatus de tipo
    @PUT
    @Path("/estatusTipo/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusTipo(@PathParam("id") long id, TipoDto tipoDto){

        DaoTipo daoTipo = new DaoTipo();
        Tipo tipo_modificar = daoTipo.find(id, Tipo.class);

        if(tipo_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                tipo_modificar.set_estatus(tipoDto.get_estatus());
                daoTipo.update(tipo_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(tipo_modificar).build();

    }

    //Actualizar tipo
    @PUT
    @Path("/updateTipo/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateTipo(@PathParam("id") long id, TipoDto tipoDto){

        DaoTipo daoTipo = new DaoTipo();
        Tipo tipo_modificar = daoTipo.find(id, Tipo.class);

        if(tipo_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                tipo_modificar.set_nombre(tipoDto.get_nombre());
                tipo_modificar.set_descripcion(tipoDto.get_descripcion());
                daoTipo.update(tipo_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(tipo_modificar).build();

    }

    //Eliminar tipo
    @DELETE
    @Path("/deleteTipo/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarTipo(@PathParam("id") long id){

        DaoTipo daoTipo = new DaoTipo();
        Tipo tipo_eliminar = daoTipo.find(id, Tipo.class);

        if(tipo_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                daoTipo.delete(tipo_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(tipo_eliminar).build();

    }

}
