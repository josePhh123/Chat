package sockets.conexion;
import java.sql.*;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3308/chat";
    //private static final String URL = "jdbc:mysql://localhost:3306/chat";
    private static final String USER = "root";
    private static final String PASSWORD = "admin1";
    //private static final String PASSWORD = "root";
    private static Conexion instancia;

    public Connection conectar() throws SQLException {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión con la base de datos fue exitosa.");
            return conexion;
        } catch (SQLException error) {
            System.out.println("Error al conectar con la base de datos: " + error.getMessage());
            throw error;
        }
    }

    public void cerrarResultado(ResultSet resultado) {
        try {
            resultado.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }
    
    public void desconectar(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void cerrarStatement(PreparedStatement statement) {
        try {
            statement.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }
    
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}
