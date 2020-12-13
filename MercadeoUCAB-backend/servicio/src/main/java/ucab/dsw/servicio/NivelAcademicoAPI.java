package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoNivelAcademico;
import ucab.dsw.dtos.NivelAcademicoDto;
import ucab.dsw.entidades.NivelAcademico;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path( "/nivelAcademico" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class NivelAcademicoAPI extends AplicacionBase{

    //Listar niveles academicos
    @GET
    @Path("/allNivelAcademico")
    @Produces( MediaType.APPLICATION_JSON )
    public List<NivelAcademico> listarNivelAcademico() throws NullPointerException{
        DaoNivelAcademico daoNivelAcademico = new DaoNivelAcademico();

        try {
            return daoNivelAcademico.findAll(NivelAcademico.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }
    }

    //Consultar un nivel academico
    @GET
    @Path("/consultarNivelAcademico/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public NivelAcademico consultarNivelAcademico(@PathParam("id") long id) throws NullPointerException{
        DaoNivelAcademico daoNivelAcademico = new DaoNivelAcademico();

        try {
            return daoNivelAcademico.find(id, NivelAcademico.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }
    }

    //Agregar un nivel academico
    @POST
    @Path("/addNivelAcademico")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public NivelAcademicoDto addNivelAcademico(NivelAcademicoDto nivelAcademicoDto){

        NivelAcademicoDto resultado = new NivelAcademicoDto();

        try {

            DaoNivelAcademico daoNivelAcademico = new DaoNivelAcademico();
            NivelAcademico nivelAcademico = new NivelAcademico();

            nivelAcademico.set_descripcion(nivelAcademicoDto.get_descripcion());
            nivelAcademico.set_estatus(nivelAcademicoDto.get_estatus());
            NivelAcademico resul = daoNivelAcademico.insert(nivelAcademico);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);

        }

            return resultado;
    }

    //Actualizar un nivel academico
    @PUT
    @Path("/updateNivelAcademico/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response updateNivelAcademico(@PathParam("id") long id, NivelAcademicoDto nivelAcademicoDto){

        DaoNivelAcademico daoNivelAcademico = new DaoNivelAcademico();
        NivelAcademico nivelAcademico_modificar = daoNivelAcademico.find(id, NivelAcademico.class);

        if (nivelAcademico_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

                try {
                    nivelAcademico_modificar.set_descripcion(nivelAcademicoDto.get_descripcion());
                    nivelAcademico_modificar.set_estatus(nivelAcademicoDto.get_estatus());
                    daoNivelAcademico.update(nivelAcademico_modificar);

                } catch (Exception ex){

                    return Response.status(Response.Status.EXPECTATION_FAILED).build();
                }

                return Response.ok().entity(nivelAcademico_modificar).build();

    }

    // Eliminar un nivel academico
    @DELETE
    @Path("/deleteNivelAcademico/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarNivelAcademico(@PathParam("id") long id){

        DaoNivelAcademico daoNivelAcademico = new DaoNivelAcademico();
        NivelAcademico nivelAcademico_eliminar = daoNivelAcademico.find(id, NivelAcademico.class);

        if(nivelAcademico_eliminar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                daoNivelAcademico.delete(nivelAcademico_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok().entity(nivelAcademico_eliminar).build();
    }
}
