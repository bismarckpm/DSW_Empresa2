package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoMarca;
import ucab.dsw.dtos.MarcaDto;
import ucab.dsw.entidades.Marca;

import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path( "/marca" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class MarcaAPI extends AplicacionBase{

    // Listar marcas
    @GET
    @Path("/allMarca")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Marca> listarMarcas() throws NullPointerException{
        DaoMarca daoMarca = new DaoMarca();

        try {
            return daoMarca.findAll(Marca.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Consultar una marca
    @GET
    @Path("/consultarMarca/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Marca consultarMarca(@PathParam("id") long id) throws NullPointerException{
        DaoMarca daoMarca = new DaoMarca();

        try {
            return daoMarca.find(id, Marca.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }

    }


    // Mostrar las marcas activas
    @GET
    @Path("/mostrarMarcasActivas")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Marca> marcasActivas() throws NullPointerException{

        DaoMarca daoMarca = new DaoMarca();
        List<Marca> listaMarca = daoMarca.findAll(Marca.class);
        List<Marca> listaMarcaActivas = new ArrayList<Marca>();

        try {

            for (Marca marca : listaMarca) {

                if (marca.get_estatus().equals("Activo")) {
                    listaMarcaActivas.add(marca);
                }
            }

            return listaMarcaActivas;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Agregar una marca
    @POST
    @Path("/addMarca")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public MarcaDto addMarca(MarcaDto marcaDto){

        MarcaDto resultado = new MarcaDto();

        try {

            DaoMarca daoMarca = new DaoMarca();
            Marca marca = new Marca();

            marca.set_nombre(marcaDto.getNombre());
            marca.set_estatus(marcaDto.get_estatus());
            marca.set_descripcion(marcaDto.get_descripcion());
            daoMarca.insert(marca);
            Marca resul = daoMarca.insert(marca);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar el estatus de marca
    @PUT
    @Path("/estatusMarca/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusMarca(@PathParam("id") long id, MarcaDto marcaDto){

        DaoMarca daoMarca = new DaoMarca();
        Marca marca_modificar = daoMarca.find(id, Marca.class);

        if (marca_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                marca_modificar.set_estatus(marcaDto.get_estatus());
                daoMarca.update(marca_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(marca_modificar).build();

    }

    //Actualizar la marca
    @PUT
    @Path("/updateMarca/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateMarca(@PathParam("id") long id, MarcaDto marcaDto){

        DaoMarca daoMarca = new DaoMarca();
        Marca marca_modificar = daoMarca.find(id, Marca.class);

        if (marca_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();

        }

            try {

                marca_modificar.set_nombre(marcaDto.getNombre());
                marca_modificar.set_descripcion(marcaDto.get_descripcion());
                daoMarca.update(marca_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(marca_modificar).build();

    }

    // Eliminar una Marca
    @DELETE
    @Path("/deleteMarca/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response deleteMarca(@PathParam("id") long id){

        DaoMarca daoMarca = new DaoMarca();
        Marca marca_eliminar = daoMarca.find(id, Marca.class);

        if(marca_eliminar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();

        }

            try {
                daoMarca.delete(marca_eliminar);

            } catch (Exception ex) {

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(marca_eliminar).build();


        }
}
