package pe.edu.pucp.socialsoft.solicitudes.bo;

import pe.edu.pucp.socialsoft.bo.IBaseBO;
import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;
import pe.edu.pucp.socialsoft.model.solicitudes.UsuarioCanalSuscripcion;

import java.util.List;

public interface IUsuarioCanalSuscripcionBO extends IBaseBO<UsuarioCanalSuscripcion> {
    List<UsuarioCanalSuscripcion> listarSuscripcionesPorUsuario(int idUsuario);
}
