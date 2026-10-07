package pe.edu.pucp.socialsoft.dao;

import java.sql.Connection;
import java.util.List;

public interface IDAO <T> {
    List<T> listarTodos(Connection con);
}
