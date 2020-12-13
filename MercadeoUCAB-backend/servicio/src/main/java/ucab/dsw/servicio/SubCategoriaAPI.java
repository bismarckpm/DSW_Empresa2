package ucab.dsw.servicio;
import java.util.ArrayList;
import java.util.List;

import ucab.dsw.accesodatos.DaoSubcategoria;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Subcategoria;

import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/subcategoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SubCategoriaAPI extends AplicacionBase{

    // Listar subcategorias
    @GET
    @Path("/allSubcategoria")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Subcategoria> listarSubCategorias() throws NullPointerException{

        DaoSubcategoria daoSubcategoria = new DaoSubcategoria();

        try {
            return daoSubcategoria.findAll(Subcategoria.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }
    }

    // Consultar una subcategoria
    @GET
    @Path ("/consultarSubCategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Subcategoria consultarSubCategoria(@PathParam("id") long id) throws NullPointerException{

        DaoSubcategoria daoSubcategoria = new DaoSubcategoria();

        try {
            return daoSubcategoria.find(id, Subcategoria.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }
    }

    //Mostrar subcategorias activas
    @GET
    @Path("/mostrarSubCategoriasActivas")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Subcategoria> subcategoriasActivas() throws NullPointerException{

        DaoSubcategoria daoSubcategoria = new DaoSubcategoria();
        List<Subcategoria> listaSubcategorias = daoSubcategoria.findAll(Subcategoria.class);
        List<Subcategoria> listaSubCategoriasActivas = new ArrayList<Subcategoria>();

        try {

            for (Subcategoria subcategoria : listaSubcategorias) {

                if (subcategoria.get_estatus().equals("Activo")) {
                    listaSubCategoriasActivas.add(subcategoria);
                }
            }

            return listaSubCategoriasActivas;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }

    }

    //Agregar una subcategoria
    @POST
    @Path("/addSubCategoria")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public SubcategoriaDto addSubCategoria(SubcategoriaDto subcategoriaDto)
    {
        SubcategoriaDto resultado = new SubcategoriaDto();

        try {

            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = new Subcategoria();

            subcategoria.set_nombre(subcategoriaDto.getNombre());
            subcategoria.set_descripcion(subcategoriaDto.getDescripcion());
            subcategoria.set_estatus(subcategoriaDto.get_estatus());
            Categoria categoria = new Categoria(subcategoriaDto.getCategoriaDto().get_id());
            subcategoria.set_categoria(categoria);
            Subcategoria resul = dao.insert(subcategoria);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

        return  resultado;
    }

    //Actualizar estatus de subcategoria
    @PUT
    @Path("/estatusSubcategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusSubcategoria(@PathParam("id") long id, SubcategoriaDto subcategoriaDto){

        DaoSubcategoria dao = new DaoSubcategoria();
        Subcategoria subcategoria_modificar = dao.find(id, Subcategoria.class);

        if (subcategoria_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                subcategoria_modificar.set_estatus(subcategoriaDto.get_estatus());
                dao.update(subcategoria_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(subcategoria_modificar).build();

    }

    //Actualizar una subcategoria
    @PUT
    @Path("/updateSubCategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarSubCategoria(@PathParam("id") long id, SubcategoriaDto subcategoriaDto){

        DaoSubcategoria dao = new DaoSubcategoria();
        Subcategoria subcategoria_modificar = dao.find(id, Subcategoria.class);

        if (subcategoria_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                subcategoria_modificar.set_nombre(subcategoriaDto.getNombre());
                subcategoria_modificar.set_descripcion(subcategoriaDto.getDescripcion());
                dao.update(subcategoria_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(subcategoria_modificar).build();

    }

    //Eliminar una subcategoria
    @DELETE
    @Path("/deleteSubCategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarSubCategoria(@PathParam("id") long id){

        DaoSubcategoria dao = new DaoSubcategoria();
        Subcategoria subcategoria_eliminar = dao.find(id, Subcategoria.class);

        if (subcategoria_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

                try {
                    dao.delete(subcategoria_eliminar);

                } catch (Exception ex){

                    return Response.status(Response.Status.EXPECTATION_FAILED).build();
                }
                return Response.ok().entity(subcategoria_eliminar).build();

    }
}


