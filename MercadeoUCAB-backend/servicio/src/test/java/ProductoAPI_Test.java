import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.MarcaDto;
import ucab.dsw.dtos.ProductoDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Producto;
import ucab.dsw.entidades.Tipo;
import ucab.dsw.servicio.ProductoAPI;

public class ProductoAPI_Test {

    //Listar todos los productos (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarProductos(){

        ucab.dsw.servicio.ProductoAPI servicio = new ucab.dsw.servicio.ProductoAPI();

        try {
            Assertions.assertTrue(servicio.listarProductos().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar un producto (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarProducto(){

        ucab.dsw.servicio.ProductoAPI servicio = new ucab.dsw.servicio.ProductoAPI();
        Producto producto_buscar = servicio.consultarProducto(1L);

        try {
            Assertions.assertEquals(1, producto_buscar.get_id());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Listar productos activos (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarProductosActivos(){

        try {
            Assertions.assertNotNull(new ucab.dsw.servicio.ProductoAPI().productosActivos());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    //Prueba para insertar un Producto
    @Test
    public void pruebaInsertarProducto() throws Exception {

        ucab.dsw.servicio.ProductoAPI servicio = new ucab.dsw.servicio.ProductoAPI();
        ProductoDto productoDto = new ProductoDto();

        productoDto.setNombre("");
        productoDto.setDescripcion("");
        productoDto.set_estatus("Activo");
        //Revisar los ID de los registros de la BD
        UsuarioDto usuarioDto = new UsuarioDto(1L);
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto(1L);
        MarcaDto marcaDto = new MarcaDto(1L);
        productoDto.setUsuarioDto(usuarioDto);
        productoDto.setSubcategoriaDto(subcategoriaDto);
        productoDto.setMarcaDto(marcaDto);
        ProductoDto resultado = servicio.addProducto(productoDto);
        Assert.assertNotEquals( resultado.get_id(), 0 );

    }

    //Actualizar el estatus de producto
    @Test
    public void pruebaModificarEstatusProducto(){

        ucab.dsw.servicio.ProductoAPI servicio = new ucab.dsw.servicio.ProductoAPI();
        ProductoDto productoDto = new ProductoDto();

        productoDto.set_estatus("Activo");
        //Revisar los ID de los registros de la BD
        servicio.modificarEstatusProducto(1L,productoDto);

    }

    //Modificar el producto
    @Test
    public void pruebaModificarProducto(){

        ucab.dsw.servicio.ProductoAPI servicio = new ucab.dsw.servicio.ProductoAPI();
        ProductoDto productoDto = new ProductoDto();

        productoDto.setNombre("");
        productoDto.setDescripcion("");
        //Revisar los ID de los registros de la BD
        servicio.modificarProducto(1L,productoDto);


    }

    //Eliminar el producto
    @Test
    public void pruebaEliminarProducto(){

        ucab.dsw.servicio.ProductoAPI servicio = new ucab.dsw.servicio.ProductoAPI();
        //Revisar los ID de los registros de la BD
        servicio.deleteProducto(1L);

    }

}
