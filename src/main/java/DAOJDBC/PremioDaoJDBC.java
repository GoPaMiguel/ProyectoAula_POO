package DAOJDBC;

import DAO.PremioDao;
import DTO.PremioDTO;
import JDBC.ConexionJDBC;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PremioDaoJDBC implements PremioDao {

    private Connection conexionTransaccional;

    private static final String SQL_LIST = "SELECT * FROM premios";
    private static final String SQL_INSERT = "INSERT INTO premios (nombre, puntos) VALUES (?, ?);";
    private static final String SQL_UPDATE = "UPDATE premios SET nombre=?, puntos=? WHERE idpremio=?";
    private static final String SQL_DELETE = "DELETE FROM premios WHERE idpremio=?";

    public PremioDaoJDBC() {
    }

    public PremioDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<PremioDTO> listar() {
        List<PremioDTO> premios = new ArrayList<>();
        Connection cx = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idpremio = rs.getInt("idpremio");
                String nombre = rs.getString("nombre");
                int puntos = rs.getInt("puntos");

                PremioDTO premio = new PremioDTO(idpremio, puntos, nombre);
                premios.add(premio);
            }
        } finally {
            try {
                ConexionJDBC.cerraConexion(stmt);
                ConexionJDBC.cerraConexion(rs);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException ex) {
                System.out.println("Error en cerrar");
            }
            return premios;
        }
    }

    @Override
    public void insertar(PremioDTO premioDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;
        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_INSERT);
            stmt.setString(1, premioDTO.getNombre());
            stmt.setInt(2, premioDTO.getPuntos());
            stmt.executeUpdate();
        } finally {
            try {
                ConexionJDBC.cerraConexion(stmt);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException ex) {
                System.out.println("Error en cerrar");
            }
        }
    }

    @Override
    public void actualizar(PremioDTO premioDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;
        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_UPDATE);
            stmt.setString(1, premioDTO.getNombre());
            stmt.setInt(2, premioDTO.getPuntos());
            stmt.setInt(3, premioDTO.getIdPremio());
            stmt.executeUpdate();
        } finally {
            try {
                ConexionJDBC.cerraConexion(stmt);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException ex) {
                System.out.println("Error en cerrar");
            }
        }
    }

    @Override
    public void eliminar(PremioDTO premioDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;
        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_DELETE);
            stmt.setInt(1, premioDTO.getIdPremio());
            stmt.executeUpdate();
        } finally {
            try {
                ConexionJDBC.cerraConexion(stmt);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException ex) {
                System.out.println("Error en cerrar");
            }
        }
    }

}
