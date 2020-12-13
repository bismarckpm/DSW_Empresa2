/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;

public class CategoriaAPI_Test {

    //Listar Categorias (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarCategorias(){

        ucab.dsw.servicio.CategoriaAPI servicio = new ucab.dsw.servicio.CategoriaAPI();

        try {
            Assertions.assertTrue(servicio.listarCategorias().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Listar subcategorias de categoria (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarSubcategoriasCategoria(){

        ucab.dsw.servicio.CategoriaAPI servicio = new ucab.dsw.servicio.CategoriaAPI();

        try {
            Assertions.assertTrue(servicio.listarSubcategoriasDeCategoria(1L).size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar una Categoria (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarCategoria(){

        ucab.dsw.servicio.CategoriaAPI servicio = new ucab.dsw.servicio.CategoriaAPI();
        Categoria categoria_buscar = servicio.consultarCategoria(1L);

        try {
            Assertions.assertEquals(1, categoria_buscar.get_id());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Listar categorias activas
    @Test
    public void pruebaListarCategoriasActivas(){

        try {
            Assertions.assertNotNull(new ucab.dsw.servicio.CategoriaAPI().categoriasActivas());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    // Esta prueba permite insertar una categoria a la BD
    @Test
    public void pruebaInsertarCategoria() {

        ucab.dsw.servicio.CategoriaAPI servicio = new ucab.dsw.servicio.CategoriaAPI();
        CategoriaDto categoriaDto = new CategoriaDto();
        
        categoriaDto.set_nombre("Jabones express");
        categoriaDto.set_descripcion("Jabones rapidos");
        categoriaDto.set_estatus("Inactivo");
        CategoriaDto resultado = servicio.addCategoria(categoriaDto);
        Assert.assertNotEquals( resultado.get_id(), 0 );
    }

    //Modificar estatus de la categoria
    @Test
    public void pruebaModificarEstatusCategoria() throws Exception {

        ucab.dsw.servicio.CategoriaAPI servicio = new ucab.dsw.servicio.CategoriaAPI();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.set_estatus("Inactivo");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarEstatusCategoria(1L,categoriaDto);
    }

    // Este prueba permite modificar los campos de un registro
    @Test
    public void pruebaModificarCategoria() throws Exception {

        ucab.dsw.servicio.CategoriaAPI servicio = new ucab.dsw.servicio.CategoriaAPI();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.set_nombre("Comida");
        categoriaDto.set_descripcion("Perros calientes de arandanos");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarCategoria(1L,categoriaDto);

    }

    // Esta prueba permite eliminar una categoria
    @Test
    public void pruebaEliminarCategoria() throws Exception {

        ucab.dsw.servicio.CategoriaAPI servicio = new ucab.dsw.servicio.CategoriaAPI();
        // Recuerden que deben ver los id de los registros en la BD
        servicio.eliminarCategoria(1L);
    }
}
