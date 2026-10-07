package pe.edu.pucp.socialsoft.canales.bo;

import pe.edu.pucp.socialsoft.bo.IBaseBO;
import pe.edu.pucp.socialsoft.model.canales.Canal;

import java.util.List;

public interface ICanalBO extends IBaseBO<Canal> {
    public Canal obtenerCanalPorId(int id);
}
