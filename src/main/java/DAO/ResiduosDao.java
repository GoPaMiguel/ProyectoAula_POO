package DAO;

import DTO.ResiduosDTO;

public interface ResiduosDao {
    public  void selecionar(ResiduosDTO residuosDTO);
    public void insertar(ResiduosDTO residuosDTO);
    public void actualizar(ResiduosDTO residuosDTO);
    public void eliminar(ResiduosDTO residuosDTO);
}
