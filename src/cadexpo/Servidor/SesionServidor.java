/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadexpo.Servidor;

import cadexpo.CADexpo;
import cadexpo.ExcepcionExpo;
import cadexpo.Usuario;
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
public class SesionServidor extends Thread  {

    Socket clienteConectado;
   

    public SesionServidor(Socket clienteConectado) {
        this.clienteConectado = clienteConectado;
    }

    @Override
    public void run() {
        try {
             //El servidor recibe on objeto del clente
            System.out.println("abriendo sesión");
            InputStream is = clienteConectado.getInputStream();           
            ObjectInputStream ois = new ObjectInputStream(is);
            CADexpo cad = new CADexpo();
                        

            OutputStream os = clienteConectado.getOutputStream();
            //Se lee el objeto recibido 
            Usuario usuario = (Usuario) ois.readObject();
            System.out.println("Leyendo objeto: "+ usuario.toString());
            cad.insertarUsuario(usuario);           
            
            //el servidor devuelveo el objeto (aquí se puede modificar lo que quieras
            ObjectOutputStream oos = new ObjectOutputStream(clienteConectado.getOutputStream());
            oos.writeObject(usuario);
            //cierro
            is.close();
            ois.close();
            os.close();
            oos.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (ExcepcionExpo ex) {
            Logger.getLogger(SesionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
