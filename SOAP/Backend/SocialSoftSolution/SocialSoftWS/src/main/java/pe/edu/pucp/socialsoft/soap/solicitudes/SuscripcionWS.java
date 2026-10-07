package pe.edu.pucp.socialsoft.soap.solicitudes;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import pe.edu.pucp.socialsoft.model.solicitudes.UsuarioCanalSuscripcion;
import pe.edu.pucp.socialsoft.solicitudes.bo.IUsuarioCanalSuscripcionBO;
import pe.edu.pucp.socialsoft.solicitudes.boi.UsuarioCanalSuscripcionBOImpl;

import java.util.List;

@WebService(
        serviceName = "SuscripcionWS",
        targetNamespace = "http://services.socialsoft.pucp.edu.pe/"
)
public class SuscripcionWS {
    private IUsuarioCanalSuscripcionBO suscripcionBO;

    public SuscripcionWS(){
        suscripcionBO = new UsuarioCanalSuscripcionBOImpl();
    }


    @WebMethod(operationName = "listarSuscripcionesPorUsuario")
    public List<UsuarioCanalSuscripcion> listarSuscripcionesPorUsuario(int idUsuario){
        List<UsuarioCanalSuscripcion> suscripciones = null;
        try{
            suscripciones = suscripcionBO.listarSuscripcionesPorUsuario(idUsuario);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return suscripciones;
    }
}
