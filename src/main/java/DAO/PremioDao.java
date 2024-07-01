package DAO;

import DTO.PremioDTO;
import java.sql.SQLException;
import java.util.List;

public interface PremioDao {

    public List<PremioDTO> listar();

    public void insertar(PersonaDao personaDao) throws SQLException;

    public void actualizar(PersonaDao personaDao) throws SQLException;

    public void eliminar(PersonaDao personaDao) throws SQLException;
}
