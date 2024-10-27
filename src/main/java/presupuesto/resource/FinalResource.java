package presupuesto.resource;


import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import presupuesto.domain.Cliente;
import presupuesto.domain.Presupuesto;
import presupuesto.service.ClienteService;
import presupuesto.service.PresupuestoService;

@Path("/final")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FinalResource {
    
    @Inject
    PresupuestoService presupuestoService;
    
    @Inject
    ClienteService clienteService;

    @GET
    @Path("/presupuestos/count")
    public Response getPresupuestosCount() {
        return Response.ok(presupuestoService.count()).build();
    }

    @GET
    @Path("/presupuestos-mensual/{rangoInicial}/{rangoFinal}")
    public Response getPresupuestosPorRango(
            @PathParam("rangoInicial") Double rangoInicial,
            @PathParam("rangoFinal") Double rangoFinal) {
        List<Presupuesto> presupuestos = presupuestoService.findByMontoPresupuestadoBetween(rangoInicial, rangoFinal);
        if (presupuestos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No se encontraron presupuestos en el rango especificado")
                    .build();
        }
        return Response.ok(presupuestos).build();
    }

    @GET
    @Path("/presupuestos-mensual/mayor-presupuesto")
    public Response getMayorPresupuesto() {
        List<Presupuesto> presupuestos = presupuestoService.findHighestPresupuesto();
        if (presupuestos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No se encontraron presupuestos")
                    .build();
        }
        return Response.ok(presupuestos).build();
    }

    @GET
    @Path("/clientes/buscar")
    public Response buscarClientes(
            @QueryParam("nombres") String nombres,
            @QueryParam("apellidos") String apellidos) {
        List<Cliente> clientes = clienteService.buscarPorNombresYApellidos(nombres, apellidos);
        if (clientes.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No se encontraron clientes con los criterios especificados")
                    .build();
        }
        return Response.ok(clientes).build();
    }
}
