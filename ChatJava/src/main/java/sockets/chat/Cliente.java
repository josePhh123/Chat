/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets.chat;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author cesar
 */
public class Cliente implements Runnable{
    
    private int puerto;
    private String mensaje;
    
    public Cliente(int puerto, String mensaje){
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    
    
    @Override
    public void run(){
        final String HOST = "127.0.0.1";
        
        DataOutputStream salida;
        
        try{
            Socket socket = new Socket(HOST, puerto);
            salida = new DataOutputStream(socket.getOutputStream());
            
            salida.writeUTF(mensaje);
            
        }catch(IOException error){
            System.out.println(error);
        }
    }
    
}