package pe.edu.pucp.socialsoft.canales.dao;

import pe.edu.pucp.socialsoft.dao.IDAO;
import pe.edu.pucp.socialsoft.model.canales.Canal;

import java.sql.Connection;
import java.util.List;

public interface CanalDAO extends IDAO<Canal> {
    public Canal obtenerCanalPorId(int id, Connection con);
}
