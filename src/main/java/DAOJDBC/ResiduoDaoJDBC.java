package DAOJDBC;

import DTO.ResiduoDTO;
import JDBC.ConexionJDBC;
import java.sql.*;
import java.util.*;

public class ResiduoDaoJDBC implements DAO.ResiduoDao {

    private Connection conexionTransaccional;
    private static final String SQL_LIST = "SELECT * FROM residuos";
    private static final String SQL_INSERT = "INSERT INTO residuos (tipo, puntos) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE residuos SET tipo=?, puntos=? WHERE idResiduo=?";
    private static final String SQL_DELETE = "DELETE FROM residuos WHERE idresiduo=?";

    public ResiduoDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public ResiduoDaoJDBC() {
    }

    @Override
    public List<ResiduoDTO> listar() throws SQLException {

        List<ResiduoDTO> residuos = new ArrayList<>();
        Connection cx = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idResiduo = rs.getInt("idresiduo");
                int puntos = rs.getInt("puntos");
                String tipo = rs.getString("tipo");

                ResiduoDTO residuo = new ResiduoDTO(idResiduo, puntos, tipo);
                residuos.add(residuo);
            }
            return residuos;
        } finally {
            try {
                ConexionJDBC.cerraConexion(rs);
                ConexionJDBC.cerraConexion(stmt);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion: " + e.toString());
            }
            return residuos;
        }
    }

    @Override
    public void insertar(ResiduoDTO residuosDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;

        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_INSERT);
            stmt.setString(1, residuosDTO.getTipo());
            stmt.setInt(2, residuosDTO.getPuntos());
            stmt.executeUpdate();
        } finally {
            try {
                ConexionJDBC.cerraConexion(stmt);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar, error: " + e.toString());
            }
        }
    }

    @Override
    public void actualizar(ResiduoDTO residuosDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;
        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_UPDATE);
            stmt.setString(1, residuosDTO.getTipo());
            stmt.setInt(2, residuosDTO.getPuntos());
            stmt.setInt(3, residuosDTO.getIdResiduo());
            stmt.executeUpdate();
        } finally {
            try {
                ConexionJDBC.cerraConexion(stmt);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar, error: " + e.toString());
            }
        }
    }

    @Override
    public void eliminar(ResiduoDTO residuosDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;
        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_DELETE);
            stmt.setInt(1, residuosDTO.getIdResiduo());
            stmt.executeUpdate();
        } finally {
            try {
                ConexionJDBC.cerraConexion(stmt);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar, error: " + e.toString());
            }
        }
    }

}
