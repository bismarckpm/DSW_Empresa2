import org.junit.*;
import org.junit.jupiter.api.Assertions;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.entidades.Subcategoria;

public class SubCategoriaAPI_Test {

    //Listar todos las subcategorias (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarSubcategorias(){

        ucab.dsw.servicio.SubCategoriaAPI servicio = new ucab.dsw.servicio.SubCategoriaAPI();

        try {
            Assertions.assertTrue(servicio.listarSubCategorias().size() > 0);

        } catch (Exception e) {

            Assertions.fail(e.getMessage());
        }

    }

    //Consultar una subcategoria (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaConsultarSubcategoria(){

        ucab.dsw.servicio.SubCategoriaAPI servicio = new ucab.dsw.servicio.SubCategoriaAPI();
        Subcategoria subcategoria_buscar = servicio.consultarSubCategoria(1L);

        try {
            Assertions.assertEquals(1, subcategoria_buscar.get_id());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    //Listar subcategorias activas (Esta forma fue realizada por Valentina)
    @Test
    public void pruebaListarSubcategoriasActivas(){

        try {
            Assertions.assertNotNull(new ucab.dsw.servicio.SubCategoriaAPI().subcategoriasActivas());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e.getCause());
        }
    }

    // Esta prueba permite insertar una subcategoria
    @Test
    public void pruebaInsertarSubCategoria() throws Exception{

        ucab.dsw.servicio.SubCategoriaAPI servicio = new ucab.dsw.servicio.SubCategoriaAPI();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();

        subcategoriaDto.setNombre("Perros calientes");
        subcategoriaDto.setDescripcion("Perros calientes con sabores raros");
        subcategoriaDto.set_estatus("Activo");
        // Recuerden que deben ver los id de los registros en la BD
        CategoriaDto categoriaDto = new CategoriaDto(2);
        subcategoriaDto.setCategoriaDto(categoriaDto);
        SubcategoriaDto resultado = servicio.addSubCategoria(subcategoriaDto);
        Assert.assertNotEquals( resultado.get_id(), 0 );
    }

    // Esta prueba permite actualizar el estatus de una subcategoria
    @Test
    public void pruebaModificarEstatusSubCategoria(){

        ucab.dsw.servicio.SubCategoriaAPI servicio = new ucab.dsw.servicio.SubCategoriaAPI();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();

        subcategoriaDto.set_estatus("Activo");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarEstatusSubcategoria(3L,subcategoriaDto);

    }

    // Esta prueba permite modificar una subcategoria
    @Test
    public void pruebaModificarSubCategoria(){

        ucab.dsw.servicio.SubCategoriaAPI servicio = new ucab.dsw.servicio.SubCategoriaAPI();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();
        subcategoriaDto.setNombre("Juguetes");
        subcategoriaDto.setDescripcion("Para diversion de los chicos");
        // Recuerden que deben ver los id de los registros en la BD
        servicio.modificarSubCategoria(3L,subcategoriaDto);

    }

    //Esta prueba permite eliminar una subcategoria
    @Test
    public void pruebaEliminarSubCategoria(){

        ucab.dsw.servicio.SubCategoriaAPI servicio = new ucab.dsw.servicio.SubCategoriaAPI();
        // Recuerden que deben ver los id de los registros en la BD
        servicio.eliminarSubCategoria(1L);

    }
}
