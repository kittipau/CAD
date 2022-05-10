/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadexpo.Servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pulpracticas.VSTI
 */
public class SesionServidor extends Thread {

    Socket clienteConectado;

    public SesionServidor(Socket clienteConectado) {
        this.clienteConectado = clienteConectado;
    }

    @Override
    public void run() {
        try {
             //El servidor recibe on objeto del clente
            InputStream is = clienteConectado.getInputStream();           
            ObjectInputStream ois = new ObjectInputStream(is);

            OutputStream os = clienteConectado.getOutputStream();
            //Se lee el objeto recibido 
            Object objeto = (Object) ois.readObject();
            //el servidor devuelveo el objeto (aquí se puede modificar lo que quieras
            ObjectOutputStream oos = new ObjectOutputStream(clienteConectado.getOutputStream());
            oos.writeObject(objeto);
            //cierro
            is.close();
            ois.close();
            os.close();
            oos.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
