package Test;

import DAO.PersonaDao;
import DTO.PersonaDTO;
import JDBC.ConexionJDBC;
import JDBC.PersonaDaoJDBC;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestPersona {

    public static void main(String[] args) {

        //Instanciando clases
        PersonaDTO persona = new PersonaDTO("PruebaValueDefault", "NNA4", "1212", "Ing");
        PersonaDTO personaModificada = new PersonaDTO(2);
        PersonaDTO personaEliminada = new PersonaDTO(3);
        personaModificada.setApellido("ProbandoConstructor1Arg");
        
        
        List<PersonaDTO> personas;
        Connection cx = null;

        try {
            cx = ConexionJDBC.conectar();
            //Establece la conexion
            PersonaDao personaDao = new PersonaDaoJDBC(cx);
            if (cx.getAutoCommit()) {
                cx.setAutoCommit(false);
            }

            //DAO
            // personaDao.insertar(persona);
            //personaDao.actualizar(personaModificada);
            //personaDao.eliminar(personaEliminada);
            personas = personaDao.listar();

            System.out.println("personas = " + personas);
            cx.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
            try {
                cx.rollback();
            } catch (SQLException ex1) {
                System.out.println("Error al hacer rollBack, error: " + ex1.toString());
            }
        }
    }

}
