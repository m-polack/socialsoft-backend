package pe.edu.pucp.socialsoft.planes.boi;

import pe.edu.pucp.socialsoft.config.DBManager;
import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;
import pe.edu.pucp.socialsoft.planes.bo.IPlanSuscripcionBO;
import pe.edu.pucp.socialsoft.planes.dao.PlanSuscripcionDAO;
import pe.edu.pucp.socialsoft.planes.impl.PlanSuscripcionImpl;

import java.sql.Connection;
import java.util.List;

public class PlanSuscripcionBOImpl implements IPlanSuscripcionBO {
    private Connection con;
    private PlanSuscripcionDAO planSuscripcionDAO;

    public PlanSuscripcionBOImpl(){
        planSuscripcionDAO = new PlanSuscripcionImpl();
    }

    @Override
    public PlanSuscripcion obtenerPlanPorId(int id) {
        PlanSuscripcion plan = null;
        try{
            con = DBManager.getInstance().getConnection();
            plan = planSuscripcionDAO.obtenerPlanPorId(id,con);
        }catch(Exception ex){
            System.out.println("Error al abrir conexión:  " + ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return plan;
    }


    @Override
    public List<PlanSuscripcion> listarTodos() throws Exception {
        return List.of();
    }
}
