package ucab.dsw.servicio;

import ucab.dsw.accesodatos.*;
import ucab.dsw.dtos.ProductoDto;
import ucab.dsw.entidades.*;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/producto" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ProductoAPI extends AplicacionBase{

    //Listar productos
    @GET
    @Path("/allProductos")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Producto> listarProductos() throws NullPointerException{

        DaoProducto daoProducto = new DaoProducto();

        try {
            return daoProducto.findAll(Producto.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Consultar un producto
    @GET
    @Path("/consultarProducto/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Producto consultarProducto(@PathParam("id") long id) throws NullPointerException{

        DaoProducto daoProducto = new DaoProducto();

        try {
            return daoProducto.find(id, Producto.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Mostrar productos activos
    @GET
    @Path("/mostrarProductosActivos")
    @Produces( MediaType.APPLICATION_JSON )
    public List<Producto> productosActivos() throws NullPointerException{

        DaoProducto daoProducto = new DaoProducto();
        List<Producto> listaProducto = daoProducto.findAll(Producto.class);
        List<Producto> listaProductosActivos = new ArrayList<Producto>();

        try {

            for (Producto producto : listaProducto) {

                if (producto.get_estatus().equals("Activo")) {
                    listaProductosActivos.add(producto);
                }
            }
            return listaProductosActivos;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;
        }
    }

    //Agregar un producto
    @POST
    @Path("/addProducto")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public ProductoDto addProducto(ProductoDto productoDto){

        ProductoDto resultado = new ProductoDto();

        try {


            DaoProducto daoProducto = new DaoProducto();
            Producto producto = new Producto();

            producto.set_nombre(productoDto.getNombre());
            producto.set_descripcion(productoDto.getDescripcion());
            producto.set_estatus(productoDto.get_estatus());
            Usuario usuario = new Usuario(productoDto.getUsuarioDto().get_id());
            Subcategoria subcategoria = new Subcategoria(productoDto.getSubcategoriaDto().get_id());
            Marca marca = new Marca(productoDto.getMarcaDto().get_id());
            producto.set_usuario(usuario);
            producto.set_subcategoria(subcategoria);
            producto.set_marca(marca);
            Producto resul = daoProducto.insert(producto);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar estatus de un producto
    @PUT
    @Path("/estatusProducto/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusProducto(@PathParam("id") long id, ProductoDto productoDto){

        DaoProducto daoProducto = new DaoProducto();
        Producto producto_modificar = daoProducto.find(id, Producto.class);

        if (producto_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                producto_modificar.set_estatus(productoDto.get_estatus());
                daoProducto.update(producto_modificar);
                DaoTipo daoTipo = new DaoTipo();
                DaoPresentacion daoPresentacion = new DaoPresentacion();

                if (producto_modificar.get_estatus() == "Inactivo") {

                    List<Tipo> listaTipo = daoTipo.findAll(Tipo.class);
                    List<Presentacion> listaPresentacion = daoPresentacion.findAll(Presentacion.class);

                    for (Tipo tipo : listaTipo) {

                        if (tipo.get_producto().get_id() == id) {
                            tipo.set_estatus("Inactivo");
                            daoTipo.update(tipo);
                        }
                    }

                    for (Presentacion presentacion : listaPresentacion) {

                        if (presentacion.get_producto().get_id() == id) {
                            presentacion.set_estatus("Inactivo");
                            daoPresentacion.update(presentacion);
                        }
                    }

                } else if (producto_modificar.get_estatus() == "Activo") {

                    List<Tipo> listaTipo = daoTipo.findAll(Tipo.class);
                    List<Presentacion> listaPresentacion = daoPresentacion.findAll(Presentacion.class);

                    for (Tipo tipo : listaTipo) {

                        if (tipo.get_producto().get_id() == id) {
                            tipo.set_estatus("Activo");
                            daoTipo.update(tipo);
                        }
                    }

                    for (Presentacion presentacion : listaPresentacion) {

                        if (presentacion.get_producto().get_id() == id) {
                            presentacion.set_estatus("Activo");
                            daoPresentacion.update(presentacion);
                        }
                    }

                }

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(producto_modificar).build();

    }

    //Actualizar Producto
    @PUT
    @Path("/updateProducto/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarProducto(@PathParam("id") long id, ProductoDto productoDto){

        DaoProducto daoProducto = new DaoProducto();
        Producto producto_modificar = daoProducto.find(id, Producto.class);

        if (producto_modificar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                producto_modificar.set_nombre(productoDto.getNombre());
                producto_modificar.set_descripcion(productoDto.getDescripcion());
                daoProducto.update(producto_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(producto_modificar).build();

    }

    // Eliminar un producto
    @DELETE
    @Path("/deleteProducto/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response deleteProducto(@PathParam("id") long id){

        DaoProducto daoProducto = new DaoProducto();
        Producto producto_eliminar = daoProducto.find(id, Producto.class);

        if(producto_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                daoProducto.delete(producto_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(producto_eliminar).build();

    }
}
