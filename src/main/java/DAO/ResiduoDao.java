package DAO;

import DTO.ResiduoDTO;
import java.sql.SQLException;
import java.util.List;

public interface ResiduoDao {

    public List<ResiduoDTO> listar() throws SQLException;

    public void insertar(ResiduoDTO residuosDTO) throws SQLException;

    public void actualizar(ResiduoDTO residuosDTO) throws SQLException;

    public void eliminar(ResiduoDTO residuosDTO) throws SQLException;
}
