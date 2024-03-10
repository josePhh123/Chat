package sockets.chat;

import java.io.*;
import java.net.Socket;

public class Cliente implements Runnable{
    
    private final int puerto;
    private final String mensaje;
    
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
