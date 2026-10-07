package pe.edu.pucp.socialsoft.solicitudes.dao;

import pe.edu.pucp.socialsoft.dao.IDAO;
import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;
import pe.edu.pucp.socialsoft.model.solicitudes.UsuarioCanalSuscripcion;

import java.sql.Connection;
import java.util.List;

public interface UsuarioCanalSuscripcionDAO extends IDAO<UsuarioCanalSuscripcion> {
    int registrarSuscripcion(UsuarioCanalSuscripcion suscripcion, Connection con);
}
