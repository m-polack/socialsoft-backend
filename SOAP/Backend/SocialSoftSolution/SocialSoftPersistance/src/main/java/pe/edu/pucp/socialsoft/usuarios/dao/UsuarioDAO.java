package pe.edu.pucp.socialsoft.usuarios.dao;

import pe.edu.pucp.socialsoft.dao.IDAO;
import pe.edu.pucp.socialsoft.model.usuarios.Usuario;

import java.sql.Connection;
import java.util.List;

public interface UsuarioDAO extends IDAO<Usuario> {
    public Usuario obtenerUsuarioPorId(int id, Connection con);
}
