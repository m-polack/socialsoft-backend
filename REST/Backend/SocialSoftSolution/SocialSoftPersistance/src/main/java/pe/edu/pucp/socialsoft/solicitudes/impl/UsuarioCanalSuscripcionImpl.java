package pe.edu.pucp.socialsoft.solicitudes.impl;

import pe.edu.pucp.socialsoft.model.canales.Canal;
import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;
import pe.edu.pucp.socialsoft.model.solicitudes.UsuarioCanalSuscripcion;
import pe.edu.pucp.socialsoft.model.usuarios.Usuario;
import pe.edu.pucp.socialsoft.solicitudes.dao.UsuarioCanalSuscripcionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCanalSuscripcionImpl implements UsuarioCanalSuscripcionDAO {
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public int registrarSuscripcion(UsuarioCanalSuscripcion suscripcion, Connection con) {
        int resultado = 0;
        try{
            cs = con.prepareCall("{call insertarUsuarioCanalSuscripcion(?,?,?)}");
            cs.setInt("p_id_usuario", suscripcion.getUsuario().getId());
            cs.setInt("p_id_canal", suscripcion.getCanal().getId());
            cs.setInt("p_id_plan_suscripcion", suscripcion.getPlanSuscripcion().getId());
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{if(cs!=null)cs.close();}catch(Exception ex){System.out.println("ERROR: " + ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public List<UsuarioCanalSuscripcion> listarTodos(Connection con) {
        return List.of();
    }
}
