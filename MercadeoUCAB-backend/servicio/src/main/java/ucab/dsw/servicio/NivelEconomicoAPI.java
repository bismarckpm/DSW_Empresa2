package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoNivelEconomico;
import ucab.dsw.dtos.NivelEconomicoDto;
import ucab.dsw.entidades.NivelEconomico;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path( "/nivelEconomico" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class NivelEconomicoAPI extends AplicacionBase{

    // Listar Niveles economicos
    @GET
    @Path("/allNivelEconomico")
    @Produces( MediaType.APPLICATION_JSON )
    public List<NivelEconomico> listarNivelEconomico() throws NullPointerException{
        DaoNivelEconomico daoNivelEconomico = new DaoNivelEconomico();

        try {
            return daoNivelEconomico.findAll(NivelEconomico.class);

        }   catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }
    }

    // Consultar un nivel economico
    @GET
    @Path("/consultarNivelEconomico/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public NivelEconomico consultarNivelEconomico(@PathParam("id") long id) throws NullPointerException{
        DaoNivelEconomico daoNivelEconomico = new DaoNivelEconomico();

        try {
            return daoNivelEconomico.find(id, NivelEconomico.class);

        }   catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }
    }

    // Agregar un nivel economico
    @POST
    @Path("/addNivelEconomico")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public NivelEconomicoDto addNivelEconomico(NivelEconomicoDto nivelEconomicoDto){

        NivelEconomicoDto resultado = new NivelEconomicoDto();

        try {

            DaoNivelEconomico daoNivelEconomico = new DaoNivelEconomico();
            NivelEconomico nivelEconomico = new NivelEconomico();

            nivelEconomico.set_descripcion(nivelEconomicoDto.getDescripcion());
            nivelEconomico.set_estatus(nivelEconomicoDto.get_estatus());
            NivelEconomico resul = daoNivelEconomico.insert(nivelEconomico);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
        }

            return resultado;
    }

    //Actualizar un nivel economico
    @PUT
    @Path("/updateNivelEconomico/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateNivelEconomico(@PathParam("id") long id, NivelEconomicoDto nivelEconomicoDto){

        DaoNivelEconomico daoNivelEconomico = new DaoNivelEconomico();
        NivelEconomico nivelEconomico_modificar = daoNivelEconomico.find(id, NivelEconomico.class);

        if(nivelEconomico_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {

                nivelEconomico_modificar.set_descripcion(nivelEconomicoDto.getDescripcion());
                nivelEconomico_modificar.set_estatus(nivelEconomicoDto.get_estatus());
                daoNivelEconomico.update(nivelEconomico_modificar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(nivelEconomico_modificar).build();

    }

    //Eliminar un nivel economico
    @DELETE
    @Path("/deleteNivelEconomico/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarNivelEconomico(@PathParam("id") long id){

        DaoNivelEconomico daoNivelEconomico = new DaoNivelEconomico();
        NivelEconomico nivelEconomico_eliminar = daoNivelEconomico.find(id, NivelEconomico.class);

        if(nivelEconomico_eliminar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                daoNivelEconomico.delete(nivelEconomico_eliminar);

            } catch (Exception ex) {

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(nivelEconomico_eliminar).build();

    }
}
