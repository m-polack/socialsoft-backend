package pe.edu.pucp.socialsoft.usuarios.bo;

import pe.edu.pucp.socialsoft.bo.IBaseBO;
import pe.edu.pucp.socialsoft.model.usuarios.Usuario;

import java.util.List;

public interface IUsuarioBO extends IBaseBO<Usuario> {
    public Usuario obtenerUsuarioPorId(int id);
}
