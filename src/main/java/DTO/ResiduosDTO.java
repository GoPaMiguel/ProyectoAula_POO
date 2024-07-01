package DTO;

public class ResiduosDTO {

    private int  idResiduo;
    private int puntos;
    private String tipo;

    public ResiduosDTO(int idResiduo, int puntos, String tipo) {
        this.idResiduo = idResiduo;
        this.puntos = puntos;
        this.tipo = tipo;
    }

    public ResiduosDTO(int idResiduo) {
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
