package pe.edu.pucp.socialsoft.planes.bo;

import pe.edu.pucp.socialsoft.bo.IBaseBO;
import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;

import java.util.List;

public interface IPlanSuscripcionBO extends IBaseBO<PlanSuscripcion> {
    public PlanSuscripcion obtenerPlanPorId(int id);
}
