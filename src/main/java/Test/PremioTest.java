package Test;

import DAO.PremioDao;
import DAOJDBC.PremioDaoJDBC;
import DTO.PremioDTO;
import JDBC.ConexionJDBC;
import java.sql.*;
import java.util.List;

public class PremioTest {

    public static void main(String[] args) throws SQLException {

        //Creando Objetos
        PremioDTO premioNuevo = new PremioDTO(10, "Botella1");
        PremioDTO premioAC = new PremioDTO(3);
        premioAC.setNombre("ProbandoUpdate");
        PremioDTO premioElinado = new PremioDTO(3);

        //instancia a las clases
        Connection cx = null;
        List<PremioDTO> premios = null;

        try {
            cx = ConexionJDBC.conectar();
            PremioDao premioDao = new PremioDaoJDBC(cx);
            if (cx.getAutoCommit()) {
                cx.setAutoCommit(false);
            }

            //Metodos DAO
            //premioDao.insertar(premioNuevo);
            //premioDao.actualizar(premioAC);
            //premioDao.eliminar(premioElinado);
            premios = premioDao.listar();
            
            System.out.println("premios = " + premios.toString());
            cx.setAutoCommit(true);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            cx.rollback();
        }

    }
}
