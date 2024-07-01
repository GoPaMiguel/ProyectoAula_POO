package DAO;

import DTO.PersonaDTO;
import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {

    public List<PersonaDTO> listar() throws SQLException;

    public void insertar(PersonaDTO personaDTO) throws SQLException ;

    public void actualizar(PersonaDTO personaDTO) throws SQLException;

    public void eliminar(PersonaDTO personaDTO) throws SQLException;
}
