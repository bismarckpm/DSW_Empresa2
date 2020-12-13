package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoHistoricoEstado;
import ucab.dsw.dtos.HistoricoEstadoDto;
import ucab.dsw.entidades.HistoricoEstado;
import ucab.dsw.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "/historicoEstado" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class HistoricoEstadoAPI extends AplicacionBase{

    // Listar el historico
    @GET
    @Path("/allHistoricoEstado")
    @Produces( MediaType.APPLICATION_JSON )
    public List<HistoricoEstado> listarHistoricos() throws NullPointerException {
        DaoHistoricoEstado daoHistoricoEstado = new DaoHistoricoEstado();

        try {
            return daoHistoricoEstado.findAll(HistoricoEstado.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }
    }

    //Consultar un historico en especifico
    @GET
    @Path("/consultarHistorioEstado/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public HistoricoEstado consultarHistorico(@PathParam("id") long id) throws NullPointerException{
        DaoHistoricoEstado daoHistoricoEstado = new DaoHistoricoEstado();

        try {
            return daoHistoricoEstado.find(id, HistoricoEstado.class);

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }

    }

    // Mostrar los historicos activos
    @GET
    @Path("/mostrarHistoricosActivos")
    @Produces( MediaType.APPLICATION_JSON )
    public List<HistoricoEstado> historicosActivos() throws NullPointerException{

        DaoHistoricoEstado daoHistoricoEstado = new DaoHistoricoEstado();
        List<HistoricoEstado> listaHistorico = daoHistoricoEstado.findAll(HistoricoEstado.class);
        List<HistoricoEstado> listaHistoricoActivos = new ArrayList<HistoricoEstado>();

        try {

            for (HistoricoEstado historicoEstado : listaHistorico) {

                if (historicoEstado.get_estatus().equals("Activos")) {
                    listaHistoricoActivos.add(historicoEstado);
                }
            }
            return listaHistoricoActivos;

        } catch (NullPointerException ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);
            return null;

        }
    }

    //Agregar un historico
    @POST
    @Path("/addHistorioEstado")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public HistoricoEstadoDto addHistoricoEstado(HistoricoEstadoDto historicoEstadoDto){

        HistoricoEstadoDto resultado = new HistoricoEstadoDto();

        try {

            DaoHistoricoEstado daoHistoricoEstado = new DaoHistoricoEstado();
            HistoricoEstado historicoEstado = new HistoricoEstado();

            historicoEstado.set_fechaInicio(historicoEstadoDto.get_fechaInicio());
            historicoEstado.set_fechaFin(historicoEstado.get_fechaFin());
            historicoEstado.set_estatus(historicoEstadoDto.get_estatus());
            Usuario usuario = new Usuario(historicoEstado.get_usuario().get_id());
            historicoEstado.set_usuario(usuario);
            HistoricoEstado resul = daoHistoricoEstado.insert(historicoEstado);
            resultado.set_id(resul.get_id());

        } catch (Exception ex){

            String mensaje = ex.getMessage();
            System.out.print(mensaje);

        }

            return resultado;
    }

    //Actualizar el estatus de un historico
    @PUT
    @Path("/estatusHistorico/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response modificarEstatusHistorico(@PathParam("id") long id, HistoricoEstadoDto historicoEstadoDto){

        DaoHistoricoEstado daoHistoricoEstado = new DaoHistoricoEstado();
        HistoricoEstado historicoEstado_modificar = daoHistoricoEstado.find(id, HistoricoEstado.class);

        if(historicoEstado_modificar == null) {

            return Response.status(Response.Status.NOT_FOUND).build();

        }
            try {

                historicoEstadoDto.set_estatus(historicoEstadoDto.get_estatus());
                daoHistoricoEstado.update(historicoEstado_modificar);

            } catch (Exception ex) {

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(historicoEstadoDto).build();
    }

    // Eliminar un historico
    @DELETE
    @Path("/deleteHistoricoEstado/{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response eliminarHistoricoEstado(@PathParam("id") long id){

        DaoHistoricoEstado daoHistoricoEstado = new DaoHistoricoEstado();
        HistoricoEstado historicoEstado_eliminar = daoHistoricoEstado.find(id, HistoricoEstado.class);

        if(historicoEstado_eliminar == null){

            return Response.status(Response.Status.NOT_FOUND).build();
        }

            try {
                daoHistoricoEstado.delete(historicoEstado_eliminar);

            } catch (Exception ex){

                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }

            return Response.ok().entity(historicoEstado_eliminar).build();

    }
}
