package sockets.conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class NewMain {

    public static void main(String[] args) {
        try {
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conectar(); 
            if (conn != null) {
                conexion.desconectar(conn);
                System.out.println("Desconexión exitosa.");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la conexión: " + e.getMessage());
        }
    }
}
