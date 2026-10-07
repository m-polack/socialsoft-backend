package pe.edu.pucp.socialsoft.bo;

import java.util.List;

public interface IBaseBO <T>{
    List<T> listarTodos() throws Exception;
}
