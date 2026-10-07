package pe.edu.pucp.socialsoft.usuarios.boi;

import pe.edu.pucp.socialsoft.config.DBManager;
import pe.edu.pucp.socialsoft.model.usuarios.Usuario;
import pe.edu.pucp.socialsoft.usuarios.bo.IUsuarioBO;
import pe.edu.pucp.socialsoft.usuarios.dao.UsuarioDAO;
import pe.edu.pucp.socialsoft.usuarios.impl.UsuarioImpl;

import java.sql.Connection;
import java.util.List;

public class UsuarioBOImpl implements IUsuarioBO {
    private UsuarioDAO usuarioDAO;
    private Connection con;
    public UsuarioBOImpl(){
        usuarioDAO = new UsuarioImpl();
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        try{
            con = DBManager.getInstance().getConnection();
            usuario = usuarioDAO.obtenerUsuarioPorId(id,con);
        }catch(Exception ex){
            System.out.println("Error al abrir conexión:  " + ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() throws Exception {
        return List.of();
    }
}
