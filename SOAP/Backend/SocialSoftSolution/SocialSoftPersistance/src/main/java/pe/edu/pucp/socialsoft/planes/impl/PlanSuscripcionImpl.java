package pe.edu.pucp.socialsoft.planes.impl;

import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;
import pe.edu.pucp.socialsoft.planes.dao.PlanSuscripcionDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanSuscripcionImpl implements PlanSuscripcionDAO {
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public PlanSuscripcion obtenerPlanPorId(int id, Connection con) {
        PlanSuscripcion plan = null;
        try{
            cs = con.prepareCall("{call obtenerPlanPorId(?)}");
            cs.setInt("p_id", id);
            rs = cs.executeQuery();
            if(rs.next()){
                if(plan==null) plan = new PlanSuscripcion();
                plan.setId(rs.getInt("id"));
                plan.setNombre(rs.getString("nombre"));
                plan.setCostoMensual(rs.getDouble("costo_mensual"));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{if(cs!=null)cs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{if(rs!=null)rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return plan;
    }

    @Override
    public List<PlanSuscripcion> listarTodos(Connection con) {
        return List.of();
    }
}
