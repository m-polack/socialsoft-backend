package pe.edu.pucp.socialsoft.canales.impl;

import pe.edu.pucp.socialsoft.canales.dao.CanalDAO;
import pe.edu.pucp.socialsoft.model.canales.Canal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanalImpl implements CanalDAO {
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public Canal obtenerCanalPorId(int id, Connection con) {
        Canal canal = null;
        try{
            cs = con.prepareCall("{call obtenerCanalPorId(?)}");
            cs.setInt("p_id", id);
            rs = cs.executeQuery();
            if(rs.next()){
                if(canal==null) canal = new Canal();
                canal.setId(rs.getInt("id"));
                canal.setNombre(rs.getString("nombre"));
                canal.setDescripcion(rs.getString("descripcion"));
                canal.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
                canal.setNumero_seguidores(rs.getInt("numero_seguidores"));
                canal.setCategoria(rs.getString("categoria"));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{if(cs!=null)cs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{if(rs!=null)rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return canal;
    }

    @Override
    public List<Canal> listarTodos(Connection con) {
        return List.of();
    }
}
