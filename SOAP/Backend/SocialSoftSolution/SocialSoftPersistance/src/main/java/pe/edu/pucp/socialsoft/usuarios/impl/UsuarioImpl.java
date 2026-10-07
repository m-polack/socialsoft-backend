package pe.edu.pucp.socialsoft.usuarios.impl;

import pe.edu.pucp.socialsoft.model.usuarios.Usuario;
import pe.edu.pucp.socialsoft.usuarios.dao.UsuarioDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioImpl implements UsuarioDAO {
    private CallableStatement cs;
    private ResultSet rs;


    @Override
    public Usuario obtenerUsuarioPorId(int id, Connection con) {
        Usuario usuario = null;
        try{
            cs = con.prepareCall("{call obtenerUsuarioPorId(?)}");
            cs.setInt("p_id", id);
            rs = cs.executeQuery();
            if(rs.next()){
                if(usuario==null){
                    usuario = cargarUsuario(rs);
                }
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{if(cs!=null)cs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{if(rs!=null)rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return usuario;
    }



    private Usuario cargarUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNombre_completo(rs.getString("nombre_completo"));
        usuario.setDni(rs.getString("dni"));
        usuario.setEdad(rs.getInt("edad"));
        usuario.setCiudad(rs.getString("ciudad"));
        usuario.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
        usuario.setTelefono(rs.getString("telefono"));
        usuario.setCorreo(rs.getString("correo"));
        usuario.setProfesion(rs.getString("profesion"));
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos(Connection con) {
        return List.of();
    }
}
