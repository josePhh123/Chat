package sockets.dao;

import sockets.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConversacionImp implements ConversacionDAO{
    
    Conexion instanciaMySQL = Conexion.getInstance();
    
    @Override
    public void registrarConversacionA(String mensaje){
        PreparedStatement consulta;
        Connection conexion;
        
        try{
            conexion = instanciaMySQL.conectar();
            consulta = conexion.prepareStatement("insert into conversaciones(conversacionA) values (?)"); 
            consulta.setString(1,mensaje);
            consulta.executeUpdate();
            
        }catch(SQLException error){
            System.out.println(error);
        }     
    }
    
    @Override
    public void registrarConversacionB(String mensaje){
        PreparedStatement consulta;
        Connection conexion;
        
        try{
            conexion = instanciaMySQL.conectar();
            consulta = conexion.prepareStatement("insert into conversaciones(conversacionB) values (?)");
            consulta.setString(1,mensaje);
            consulta.executeUpdate();
            
        }catch(SQLException error){
            System.out.println(error);
        }
    }
    
}
