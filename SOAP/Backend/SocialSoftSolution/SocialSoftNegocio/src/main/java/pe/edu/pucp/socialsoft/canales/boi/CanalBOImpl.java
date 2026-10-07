package pe.edu.pucp.socialsoft.canales.boi;

import pe.edu.pucp.socialsoft.canales.bo.ICanalBO;
import pe.edu.pucp.socialsoft.canales.dao.CanalDAO;
import pe.edu.pucp.socialsoft.canales.impl.CanalImpl;
import pe.edu.pucp.socialsoft.config.DBManager;
import pe.edu.pucp.socialsoft.model.canales.Canal;

import java.sql.Connection;
import java.util.List;

public class CanalBOImpl implements ICanalBO {

    private Connection con;
    private CanalDAO canalDAO;

    public CanalBOImpl(){
        canalDAO = new CanalImpl();
    }


    @Override
    public Canal obtenerCanalPorId(int id) {
        Canal canal = null;
        try{
            con = DBManager.getInstance().getConnection();
            canal = canalDAO.obtenerCanalPorId(id,con);
        }catch(Exception ex){
            System.out.println("Error al abrir conexión:  " + ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return canal;
    }


    @Override
    public List<Canal> listarTodos() throws Exception {
        return List.of();
    }
}
