/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author cesar
 */
public class Servidor extends Observable implements Runnable{
    
    private final int puerto;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        ServerSocket servidor;
        Socket socket;
        DataInputStream entrada;

        try {
            //Creamos el servidor del socket
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            //Siempre se estara escuchando las peticiones
            while (true) {
                //Se espera a que el cliente se contecte
                socket = servidor.accept();
                System.out.println("Cliente conectado");
                entrada = new DataInputStream(socket.getInputStream());

                //Se lee el mensaje
                String mensaje = entrada.readUTF();
                System.out.println(mensaje);

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                socket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException error) {
            System.out.println(error);
        }
    }
}
