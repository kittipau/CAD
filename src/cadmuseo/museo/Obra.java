/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadmuseo.museo;

import cadmuseo.museo.Artista;
import java.util.Scanner;

/**
 *
 * @author Paula Unibaso
 */
public class Obra {
    Integer obraId;
    String nombreObra;
    Artista artista;

    /**
     * getter
     * @return ObraId
     */
    public Integer getObraId() {
        return obraId;
    }

    /**
     * setter
     * @param ObraId 
     */
    public void setObraId(Integer ObraId) {
        this.obraId = ObraId;
    }

    /**
     * getter
     * @return nombreObra
     */
    public String getNombreObra() {
        return nombreObra;
    }

    /**
     * setter
     * @param nombreObra 
     */
    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    /**
     * getter
     * @return artista
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * setter
     * @param artista 
     */
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    /**
     * Constructor por defecto
     */
    
    public Obra() {
    }

    /**
     * Constructor con todos los atributos como parámetros
     * @param regionId
     * @param nombreObra
     * @param artista 
     */
    public Obra(Integer regionId, String nombreObra, Artista artista) {
        this.obraId = regionId;
        this.nombreObra = nombreObra;
        this.artista = artista;
    }

    /**
     * Método que devuelve un String con los datos de la obra
     * @return 
     */
    @Override
    public String toString() {
        return "IDENTIFICADOR: " + obraId + "  |  NOMBRE: " + nombreObra + "  |  ARTISTA: "+ artista.getAlias();
    }    

}
