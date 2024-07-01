package DTO;

public class ResiduoDTO {

    private int idResiduo;
    private int puntos;
    private String tipo;

    public ResiduoDTO() {
    }
    
    
    public ResiduoDTO(int idResiduo, int puntos, String tipo) {
        this.idResiduo = idResiduo;
        this.puntos = puntos;
        this.tipo = tipo;
    }

    public ResiduoDTO(int puntos, String tipo) {
        this.puntos = puntos;
        this.tipo = tipo;
    }

    public ResiduoDTO(int idResiduo) {
        this.idResiduo = idResiduo;
    }

    public int getIdResiduo() {
        return idResiduo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
