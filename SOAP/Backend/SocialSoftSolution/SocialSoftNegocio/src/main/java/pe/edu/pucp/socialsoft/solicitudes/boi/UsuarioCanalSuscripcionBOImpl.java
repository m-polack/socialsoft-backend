package pe.edu.pucp.socialsoft.solicitudes.boi;

import pe.edu.pucp.socialsoft.canales.dao.CanalDAO;
import pe.edu.pucp.socialsoft.canales.impl.CanalImpl;
import pe.edu.pucp.socialsoft.config.DBManager;
import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;
import pe.edu.pucp.socialsoft.model.solicitudes.UsuarioCanalSuscripcion;
import pe.edu.pucp.socialsoft.planes.dao.PlanSuscripcionDAO;
import pe.edu.pucp.socialsoft.planes.impl.PlanSuscripcionImpl;
import pe.edu.pucp.socialsoft.solicitudes.bo.IUsuarioCanalSuscripcionBO;
import pe.edu.pucp.socialsoft.solicitudes.dao.UsuarioCanalSuscripcionDAO;
import pe.edu.pucp.socialsoft.solicitudes.impl.UsuarioCanalSuscripcionImpl;
import pe.edu.pucp.socialsoft.usuarios.dao.UsuarioDAO;
import pe.edu.pucp.socialsoft.usuarios.impl.UsuarioImpl;

import java.sql.Connection;
import java.util.List;

public class UsuarioCanalSuscripcionBOImpl implements IUsuarioCanalSuscripcionBO {
    private UsuarioCanalSuscripcionDAO suscripcionDAO;
    private CanalDAO canalDAO;
    private UsuarioDAO usuarioDAO;
    private PlanSuscripcionDAO planSuscripcionDAO;
    private Connection con;

    public UsuarioCanalSuscripcionBOImpl(){
        suscripcionDAO = new UsuarioCanalSuscripcionImpl();
        canalDAO = new CanalImpl();
        usuarioDAO = new UsuarioImpl();
        planSuscripcionDAO = new PlanSuscripcionImpl();
    }

    @Override
    public List<UsuarioCanalSuscripcion> listarSuscripcionesPorUsuario(int idUsuario) {
        List<UsuarioCanalSuscripcion> suscripciones = null;
        try{
            con = DBManager.getInstance().getConnection();
            suscripciones = suscripcionDAO.listarSuscripcionesPorUsuario(idUsuario, con);
            if (suscripciones != null) {
                for (UsuarioCanalSuscripcion suscripcion : suscripciones) {
                    suscripcion.setCanal(canalDAO.obtenerCanalPorId(suscripcion.getCanal().getId(), con));
                    suscripcion.setUsuario(usuarioDAO.obtenerUsuarioPorId(suscripcion.getUsuario().getId(), con));
                    suscripcion.setPlanSuscripcion(planSuscripcionDAO.obtenerPlanPorId(suscripcion.getPlanSuscripcion().getId(), con));
                }
            }
        }catch(Exception ex){
            System.out.println("Error al abrir conexión:  " + ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return suscripciones;
    }


    @Override
    public List<UsuarioCanalSuscripcion> listarTodos() throws Exception {
        return List.of();
    }
}
