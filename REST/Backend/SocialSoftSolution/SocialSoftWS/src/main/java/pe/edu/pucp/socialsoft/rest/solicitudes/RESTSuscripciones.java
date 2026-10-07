package pe.edu.pucp.socialsoft.rest.solicitudes;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pe.edu.pucp.socialsoft.model.solicitudes.UsuarioCanalSuscripcion;
import pe.edu.pucp.socialsoft.solicitudes.bo.IUsuarioCanalSuscripcionBO;
import pe.edu.pucp.socialsoft.solicitudes.boi.UsuarioCanalSuscripcionBOImpl;

@Path("RESTSuscripciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RESTSuscripciones {
    private IUsuarioCanalSuscripcionBO suscripcionBO;

    public RESTSuscripciones(){
        suscripcionBO = new UsuarioCanalSuscripcionBOImpl();
    }

    @POST
    @Path("/registrarSuscripcion")
    public int registrarSuscripcion(UsuarioCanalSuscripcion suscripcion){
        int resultado = 0;
        try{
            resultado = suscripcionBO.registrarSuscripcion(suscripcion);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
