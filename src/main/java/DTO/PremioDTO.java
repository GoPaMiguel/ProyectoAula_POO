package DTO;

public class PremioDTO {
    private int idPremio;
    private int puntos;
    private String nombre;

    public PremioDTO() {
    }

    public PremioDTO(int idPremio, int puntos, String nombre) {
        this.idPremio = idPremio;
        this.puntos = puntos;
        this.nombre = nombre;
    }

    public PremioDTO(int puntos, String nombre) {
        this.puntos = puntos;
        this.nombre = nombre;
    }

    public PremioDTO(int idPremio) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PremioDTO{");
        sb.append("idPremio=").append(idPremio);
        sb.append(", puntos=").append(puntos);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }        
}
