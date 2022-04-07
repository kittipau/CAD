/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadmuseo.museo;

import java.util.Scanner;

/**
 *
 * @author Paula Unibaso
 */
public class Artista {
    private Integer artistaId;
    private String alias;
    private String nombre;
    private String apellido;
    private String DNI;
    private String tlfn;
    private String email;    

    /**
     * Constructor con el id como único parámetro
     * @param artistaId 
     */
    public Artista(Integer artistaId) {
        this.artistaId = artistaId;
    }
    
    /**
     * Getter
     * @return artistaId
     */
    public Integer getArtistaId() {
        return artistaId;
    }
    
    /**
     * Setter
     * @param artistaId 
     */
    public void setArtistaId(Integer artistaId) {
        this.artistaId = artistaId;
    }
    
    /**
     * Getter
     * @return alias
     */
    public String getAlias() {
        return alias;
    }
    
    /**
     * Setter
     * @param alias 
     */

    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Getter
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Getter
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Setter 
     * @return DNI 
     */
    
    public String getDNI() {
        return DNI;
    }
    
    /**
     * Getter
     * @param DNI 
     */

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Setter
     * @return tlfn
     */
    public String getTlfn() {
        return tlfn;
    }

    /**
     * Getter
     * @param tlfn 
     */
    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    /**
     * Setter
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Contructor por defecto
     */
    public Artista() {
    }

    /**
     * Constructor con todos los atributos como parámetros
     * @param artistaId
     * @param alias
     * @param nombre
     * @param apellido
     * @param DNI
     * @param tlfn
     * @param email 
     */
    public Artista(Integer artistaId, String alias, String nombre, String apellido, String DNI, String tlfn, String email) {
        this.artistaId = artistaId;
        this.alias = alias;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.tlfn = tlfn;
        this.email = email;
    }

    /**
     * Método que devuelve un String con los datos del artista
     * @return 
     */
    @Override
    public String toString() {
        return "ID ARTISTA= " + artistaId + "  |  ALIAS= " + alias + "  |  NOMBRE= " + nombre +" "+ apellido + "  |  DNI= " + DNI + "  |  TELÉFONO= " + tlfn + "  |  E-MAIL= " + email + '.';
    }     
           
        
}
