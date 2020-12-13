package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPresentacion;
import ucab.dsw.dtos.PresentacionDto;
import ucab.dsw.entidades.Presentacion;
import ucab.dsw.entidades.Producto;

import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path( "/presentacion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PresentacionAPI extends AplicacionBase{

    //Listar presentaciones
    @GET
    @Path("/allPresentacion")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Presentacion> listarPresentaciones() throws NullPointerException {
        DaoPresentacion daoPresentacion = new DaoPresentacion();

        try {
            return daoPresentacion.findAll(Presentacion.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Consultar presentaciones
    @GET
    @Path("/consultarPresentacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Presentacion consultarPresentacion(@PathParam("id") long id) throws NullPointerException{
        DaoPresentacion daoPresentacion = new DaoPresentacion();

        try {
            return daoPresentacion.find(id, Presentacion.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Mostrar presentaciones activas
    @GET
    @Path("/mostrarPresentacionesActivas")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Presentacion> presentacionesActivas() throws NullPointerException{

        DaoPresentacion daoPresentacion = new DaoPresentacion();
        List<Presentacion> listaPresentacion = daoPresentacion.findAll(Presentacion.class);
        List<Presentacion> listaPresentacionActivas = new ArrayList<Presentacion>();

        try {

            for (Presentacion presentacion : listaPresentacion) {

                if (presentacion.get_estatus().equals("Activo")) {
                    listaPresentacionActivas.add(presentacion);
                }
            }
            return listaPresentacionActivas;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar una presentacion
    @POST
    @Path("/addPresentacion")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public PresentacionDto addPresentacion(PresentacionDto presentacionDto){

        PresentacionDto resultado = new PresentacionDto();

        try {

            DaoPresentacion daoPresentacion = new DaoPresentacion();
            Presentacion presentacion = new Presentacion();

            presentacion.set_nombre(presentacionDto.get_nombre());
            presentacion.set_caracteristicas(presentacionDto.get_caracteristicas());
            presentacion.set_estatus(presentacionDto.get_estatus());
            Producto producto = new Producto(presentacionDto.get_productoDto().get_id());
            presentacion.set_producto(producto);
            Presentacion resul = daoPresentacion.insert(presentacion);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar estatus de presentacion
    @PUT
    @Path("/estatusPresentacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusPresentacion(@PathParam("id") long id, PresentacionDto presentacionDto){

        DaoPresentacion daoPresentacion = new DaoPresentacion();
        Presentacion presentacion_modificar = daoPresentacion.find(id, Presentacion.class);

        if(presentacion_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                presentacion_modificar.set_estatus(presentacionDto.get_estatus());
                daoPresentacion.update(presentacion_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(presentacion_modificar).build();

    }

    //Actualizar Presentacion
    @PUT
    @Path("/updatePresentacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updatePresentacion(@PathParam("id") long id, PresentacionDto presentacionDto){

        DaoPresentacion daoPresentacion = new DaoPresentacion();
        Presentacion presentacion_modificar = daoPresentacion.find(id, Presentacion.class);

        if(presentacion_modificar != null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                presentacion_modificar.set_nombre(presentacionDto.get_nombre());
                presentacion_modificar.set_caracteristicas(presentacionDto.get_caracteristicas());
                daoPresentacion.update(presentacion_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(presentacion_modificar).build();
    }

    //Eliminar una presentacion
    @DELETE
    @Path("/deletePresentacion/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarPresentacion(@PathParam("id") long id){

        DaoPresentacion daoPresentacion = new DaoPresentacion();
        Presentacion presentacion_eliminar = daoPresentacion.find(id, Presentacion.class);

        if(presentacion_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                daoPresentacion.delete(presentacion_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(presentacion_eliminar).build();

    }

}
