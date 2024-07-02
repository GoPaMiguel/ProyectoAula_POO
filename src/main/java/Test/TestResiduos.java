package Test;

import DAO.ResiduoDao;
import DAOJDBC.ResiduoDaoJDBC;
import DTO.ResiduoDTO;
import JDBC.ConexionJDBC;
import java.sql.*;
import java.util.List;

public class TestResiduos {

    public static void main(String[] args) {

        ResiduoDTO residuoNuevo = new ResiduoDTO(2, "plastico2");
        ResiduoDTO residuoNuevo2 = new ResiduoDTO(2, "Baterias");
        ResiduoDTO residuosEliminar = new ResiduoDTO(4);
        ResiduoDTO residuoAc = new ResiduoDTO(2);
        residuoAc.setPuntos(20);
        residuoAc.setTipo("Papel blanco");

        //Creando variables
        Connection cx = null;
        List<ResiduoDTO> residuos = null;

        try {

            //Instanciando clases 
            cx = ConexionJDBC.conectar();
            ResiduoDao residuoDao = new ResiduoDaoJDBC(cx);

            if (cx.getAutoCommit()) {
                cx.setAutoCommit(false);
            }

            //Metodos Dao
            //residuoDao.insertar(residuoNuevo);
            //residuoDao.insertar(residuoNuevo2);
            //residuoDao.actualizar(residuoAc);
            residuoDao.eliminar(residuosEliminar);
            residuos = residuoDao.listar();

            System.out.println("residuos = " + residuos.toString());

            cx.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                cx.rollback();
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollBack, error: " + ex.toString());
            }
            System.out.println("Error: " + e.toString());
        }

    }
}
