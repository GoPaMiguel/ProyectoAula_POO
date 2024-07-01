package JDBC;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionJDBC {

    private static final String user = Credenciales.USER.getArg();
    private static final String password = Credenciales.PASSWORD.getArg();
    private static final String bdname = Credenciales.DBNAME.getArg();
    private static final String puerto = "3306";
    private static final String ip = "localhost";
    private static final String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bdname;

    //Pool de conexion
    public static DataSource getDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl(cadena);
        bds.setUsername(user);
        bds.setPassword(password);
        bds.setInitialSize(4);
        return bds;
    }

    public static Connection conectar() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void cerraConexion(Connection cx) throws SQLException {
        cx.close();
    }

    public static void cerraConexion(PreparedStatement st) throws SQLException {
        st.close();
    }

    public static void cerraConexion(ResultSet rs) throws SQLException {
        rs.close();
    }
}
