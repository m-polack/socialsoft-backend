package pe.edu.pucp.socialsoft.solicitudes.boi;

import pe.edu.pucp.socialsoft.config.DBManager;
import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;
import pe.edu.pucp.socialsoft.model.solicitudes.UsuarioCanalSuscripcion;
import pe.edu.pucp.socialsoft.solicitudes.bo.IUsuarioCanalSuscripcionBO;
import pe.edu.pucp.socialsoft.solicitudes.dao.UsuarioCanalSuscripcionDAO;
import pe.edu.pucp.socialsoft.solicitudes.impl.UsuarioCanalSuscripcionImpl;


import java.sql.Connection;
import java.util.List;

public class UsuarioCanalSuscripcionBOImpl implements IUsuarioCanalSuscripcionBO {
    private UsuarioCanalSuscripcionDAO suscripcionDAO;
    private Connection con;

    public UsuarioCanalSuscripcionBOImpl(){
        suscripcionDAO = new UsuarioCanalSuscripcionImpl();
    }

    @Override
    public int registrarSuscripcion(UsuarioCanalSuscripcion suscripcion) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            con.setAutoCommit(false);
            resultado = suscripcionDAO.registrarSuscripcion(suscripcion, con);
            con.commit();
        }catch(Exception ex){
            try{ con.rollback(); }catch(Exception ex1){ System.out.println(ex1.getMessage()); }
            System.out.println("Error al abrir conexión: " + ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }


    @Override
    public List<UsuarioCanalSuscripcion> listarTodos() throws Exception {
        return List.of();
    }
}
