package DTO;

public class PremiosDTO {
    private int idPremio;
    private int puntos;
    private String nombre;

    public PremiosDTO() {
    }

    public PremiosDTO(int idPremio, int puntos, String nombre) {
        this.idPremio = idPremio;
        this.puntos = puntos;
        this.nombre = nombre;
    }

    public PremiosDTO(int puntos, String nombre) {
        this.puntos = puntos;
        this.nombre = nombre;
    }

    public PremiosDTO(int idPremio) {
        this.idPremio = idPremio;
    }

    public int getIdPremio() {
        return idPremio;
    }

    public void setIdPremio(int idPremio) {
        this.idPremio = idPremio;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
