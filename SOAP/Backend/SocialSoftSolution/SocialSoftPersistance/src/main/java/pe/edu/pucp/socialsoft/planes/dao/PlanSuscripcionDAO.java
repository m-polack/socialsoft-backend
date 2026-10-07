package pe.edu.pucp.socialsoft.planes.dao;

import pe.edu.pucp.socialsoft.dao.IDAO;
import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;

import java.sql.Connection;
import java.util.List;

public interface PlanSuscripcionDAO extends IDAO<PlanSuscripcion> {
    public PlanSuscripcion obtenerPlanPorId(int id, Connection con);
}
