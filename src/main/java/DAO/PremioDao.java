package DAO;

import DTO.PremioDTO;
import java.sql.SQLException;
import java.util.List;

public interface PremioDao {

    public List<PremioDTO> listar();

    public void insertar(PremioDTO premioDTO) throws SQLException;

    public void actualizar(PremioDTO premioDTO) throws SQLException;

    public void eliminar(PremioDTO premioDTO) throws SQLException;
}
