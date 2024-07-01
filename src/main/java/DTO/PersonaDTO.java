package DTO;

public class PersonaDTO {

    private int idPersona;
    private int puntos;
    private String nombre;
    private String apellido;
    private String cedula;
    private String carrera;

    public PersonaDTO() {
    }

    public PersonaDTO(int idPersona, int puntos, String nombre, String apellido, String cedula, String carrera) {
        this.idPersona = idPersona;
        this.puntos = puntos;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.carrera = carrera;
    }

    public PersonaDTO(int idPersona) {
        this.idPersona = idPersona;
    }

    public PersonaDTO(int idPersona, int puntos, String nombre, String apellido, String carrera) {
        this.idPersona = idPersona;
        this.puntos = puntos;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    public PersonaDTO(String nombre, String apellido, String cedula, String carrera) {
        this.puntos = 0;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.carrera = carrera;
    }

    public int getIdPersona() {
        return idPersona;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonaDTO{");
        sb.append("idPersona=").append(idPersona);
        sb.append(", puntos=").append(puntos);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", cedula=").append(cedula);
        sb.append(", carrera=").append(carrera);
        sb.append('}');
        return sb.toString();
    }
}
