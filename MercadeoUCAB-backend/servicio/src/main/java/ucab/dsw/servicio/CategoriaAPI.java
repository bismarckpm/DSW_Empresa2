package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoSubcategoria;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Subcategoria;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path( "/categoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CategoriaAPI extends AplicacionBase {

    // Listar todas las categorias disponibles
    @GET
    @Path("/allCategoria")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Categoria> listarCategorias() throws NullPointerException {
        
        DaoCategoria categoriaDao = new DaoCategoria();

        try {
            return categoriaDao.findAll(Categoria.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Consultar una categoria en especifico
    @GET
    @Path ("/consultarCategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Categoria consultarCategoria(@PathParam("id") long id) throws NullPointerException {

        DaoCategoria categoriaDao = new DaoCategoria();

        try {
            return categoriaDao.find(id, Categoria.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Mostrar una lista de todas las categorias de estatus activas
    @GET
    @Path ("/mostrarCategoriasActivas")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Categoria> categoriasActivas() throws NullPointerException {

        DaoCategoria daoCategoria = new DaoCategoria();
        List<Categoria> listaCategorias = daoCategoria.findAll(Categoria.class);
        List<Categoria> listaCategoriasActivas = new ArrayList<Categoria>();

        try {

            for (Categoria categoria : listaCategorias) {

                if (categoria.get_estatus().equals("Activo")) {
                    listaCategoriasActivas.add(categoria);
                }
            }

            return listaCategoriasActivas;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    // Mostrar las subcategorias de una categoria
    @GET
    @Path("/mostrarSubcategoriasCategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Subcategoria> listarSubcategoriasDeCategoria(@PathParam("id") long id) throws NullPointerException{

        DaoSubcategoria daoSubcategoria = new DaoSubcategoria();
        List<Subcategoria> listaSubcategorias = daoSubcategoria.findAll(Subcategoria.class);
        List<Subcategoria> listaSubcategoriasCategoria = new ArrayList<Subcategoria>();

        try {

            for (Subcategoria subcategoria : listaSubcategorias) {

                if (subcategoria.get_categoria().get_id() == id) {
                    listaSubcategoriasCategoria.add(subcategoria);
                }
            }

            return listaSubcategoriasCategoria;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar una categoria
    @POST
    @Path("/addCategoria")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public CategoriaDto addCategoria(CategoriaDto categoriaDto)
    {
        CategoriaDto resultado = new CategoriaDto();

        try {

            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();

            categoria.set_nombre(categoriaDto.get_nombre());
            categoria.set_descripcion(categoriaDto.get_descripcion());
            categoria.set_estatus(categoriaDto.get_estatus());
            Categoria resul = dao.insert(categoria);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

        return resultado;
    }

    //Actualizar el estatus de categoria
    @PUT
    @Path("/estatusCategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusCategoria(@PathParam("id") long id, CategoriaDto categoriaDto){

        DaoCategoria daoCategoria = new DaoCategoria();
        Categoria categoria_modificar = daoCategoria.find(id, Categoria.class);

        if (categoria_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                categoria_modificar.set_estatus(categoriaDto.get_estatus());
                daoCategoria.update(categoria_modificar);
                DaoSubcategoria daoSubcategoria = new DaoSubcategoria();

                if (categoria_modificar.get_estatus() == "Inactivo") {

                    List<Subcategoria> listaSubcategorias = daoSubcategoria.findAll(Subcategoria.class);

                    for (Subcategoria subcategoria : listaSubcategorias) {

                        if (subcategoria.get_categoria().get_id() == id) {
                            subcategoria.set_estatus("Inactivo");
                            daoSubcategoria.update(subcategoria);
                        }
                    }
                } else if (categoria_modificar.get_estatus() == "Activo") {

                    List<Subcategoria> listaSubcategorias = daoSubcategoria.findAll(Subcategoria.class);

                    for (Subcategoria subcategoria : listaSubcategorias) {

                        if (subcategoria.get_categoria().get_id() == id) {
                            subcategoria.set_estatus("Activo");
                            daoSubcategoria.update(subcategoria);
                        }
                    }
                }

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(categoria_modificar).build();
    }

    // Modificar una categoria
    @PUT
    @Path("/updateCategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarCategoria(@PathParam("id") long id, CategoriaDto categoriaDto){
        
        DaoCategoria dao = new DaoCategoria();
        Categoria categoria_modificar = dao.find(id, Categoria.class);
        
        if (categoria_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();

        }

            try {

                categoria_modificar.set_nombre(categoriaDto.get_nombre());
                categoria_modificar.set_descripcion(categoriaDto.get_descripcion());
                dao.update(categoria_modificar);

            } catch (Exception ex) {

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(categoria_modificar).build();
    }

    //Eliminar una categoria
    @DELETE
    @Path("/deleteCategoria/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarCategoria(@PathParam("id") long id){
        
        DaoCategoria dao = new DaoCategoria();
        Categoria categoria_eliminar = dao.find(id, Categoria.class);

        if (categoria_eliminar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                dao.delete(categoria_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(categoria_eliminar).build();

    }
}
   
