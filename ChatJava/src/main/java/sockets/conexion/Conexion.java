/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets.conexion;

import java.sql.*;

/**
 *
 * @author cesar
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost/chat";
    private static final String USER = " ";
    private static final String PASSWORD = " ";
    private static Conexion instancia;

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
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
