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
    public List<UsuarioCanalSuscripcion> listarSuscripcionesPorUsuario(int idUsuario, Connection con) {
        List<UsuarioCanalSuscripcion> suscripciones = null;
        try{
            cs = con.prepareCall("{call listarSuscripcionesPorUsuario(?)}");
            cs.setInt("p_id_usuario", idUsuario);
            rs = cs.executeQuery();
            while(rs.next()){
                if(suscripciones==null) suscripciones = new ArrayList<>();
                suscripciones.add(cargarSuscripcion(rs));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{if(cs!=null)cs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{if(rs!=null)rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return suscripciones;
    }


    private UsuarioCanalSuscripcion cargarSuscripcion(ResultSet rs) throws SQLException {
        UsuarioCanalSuscripcion suscripcion = new UsuarioCanalSuscripcion();
        suscripcion.setId(rs.getInt("id"));
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id_usuario"));
        suscripcion.setUsuario(usuario);
        Canal canal = new Canal();
        canal.setId(rs.getInt("id_canal"));
        suscripcion.setCanal(canal);
        PlanSuscripcion plan = new PlanSuscripcion();
        plan.setId(rs.getInt("id_plan_suscripcion"));
        suscripcion.setPlanSuscripcion(plan);
        Timestamp fechaRegistro = rs.getTimestamp("fecha_registro");
        if(fechaRegistro != null) suscripcion.setFechaRegistro(fechaRegistro.toLocalDateTime());
        suscripcion.setEstado(rs.getString("estado"));
        return suscripcion;
    }

    @Override
    public List<UsuarioCanalSuscripcion> listarTodos(Connection con) {
        return List.of();
    }
}
