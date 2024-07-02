package DAOJDBC;

import DTO.PersonaDTO;
import JDBC.ConexionJDBC;
import JDBC.ConexionJDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoJDBC implements DAO.PersonaDao {

    private Connection conexionTransaccional;
    private static final String SQL_LIST = "SELECT * FROM personas;";
    private static final String SQL_INSERT = "INSERT INTO personas (cedula, nombre, apellido, carrera, puntos) VALUES (?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE personas SET nombre=?, apellido=?, carrera=?, puntos=? WHERE idPersona=?;";
    private static final String SQL_DELETE = "DELETE FROM personas WHERE idpersona=? ";

    public PersonaDaoJDBC() {
    }

    public PersonaDaoJDBC(Connection CONEXIONTRASACCIONAL) {
        this.conexionTransaccional = CONEXIONTRASACCIONAL;
    }

    @Override
    public List<PersonaDTO> listar() throws SQLException {

        List<PersonaDTO> personas = new ArrayList<>();
        Connection cx = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("idPersona");
                int puntos = rs.getInt("puntos");
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String carrera = rs.getString("carrera");
                PersonaDTO persona = new PersonaDTO(idPersona, puntos, nombre, apellido, cedula, carrera);
                personas.add(persona);
            }
        } finally {
            try {
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
                ConexionJDBC.cerraConexion(stmt);
                ConexionJDBC.cerraConexion(rs);
            } catch (SQLException ex) {
                System.out.println("Error en cerrar la conexion, error: " + ex.toString());
            }
        }
        return personas;
    }

    @Override
    public void insertar(PersonaDTO personaDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;

        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_INSERT);
            stmt.setString(1, personaDTO.getCedula());
            stmt.setString(2, personaDTO.getNombre());
            stmt.setString(3, personaDTO.getApellido());
            stmt.setString(4, personaDTO.getCarrera());
            stmt.setInt(5, personaDTO.getPuntos());
            stmt.executeUpdate();
        } finally {
            try {
                ConexionJDBC.cerraConexion(stmt);
                if (conexionTransaccional == null) {
                    ConexionJDBC.cerraConexion(cx);
                }
            } catch (SQLException ex) {
                System.out.println("Error en cerrar la conexion, error: " + ex.toString());
            }
        }

    }

    @Override
    public void actualizar(PersonaDTO personaDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;

        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_UPDATE);
            stmt.setString(1, personaDTO.getNombre());
            stmt.setString(2, personaDTO.getApellido());
            stmt.setString(3, personaDTO.getCarrera());
            stmt.setInt(4, personaDTO.getPuntos());
            stmt.setInt(5, personaDTO.getIdPersona());
            stmt.executeUpdate();
        } finally {
            ConexionJDBC.cerraConexion(stmt);
            if (conexionTransaccional == null) {
                ConexionJDBC.cerraConexion(cx);
            }
        }
    }

    @Override
    public void eliminar(PersonaDTO personaDTO) throws SQLException {
        Connection cx = null;
        PreparedStatement stmt = null;

        try {
            cx = conexionTransaccional != null ? conexionTransaccional : ConexionJDBC.conectar();
            stmt = cx.prepareCall(SQL_DELETE);
            stmt.setInt(1, personaDTO.getIdPersona());
            stmt.executeUpdate();
        } finally {
            ConexionJDBC.cerraConexion(stmt);
            if (conexionTransaccional == null) {
                ConexionJDBC.cerraConexion(cx);
            }
        }

    }

}
