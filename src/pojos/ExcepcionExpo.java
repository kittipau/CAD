/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Paula Unibaso 
 */
public class ExcepcionExpo extends Exception {
    private Integer codigoError;
    private String mensajeErrorBD;
    private String mensajeErrorUsuario;
    private String sentenciaSQL;

    /**
     * Constructor por defecto
     */
    public ExcepcionExpo() {
    }
    
    /**
     * Constructor con todos los atriburos como parámetros
     * @param codigoError
     * @param mensajeErrorBD
     * @param mensajeErrorUsuario
     * @param setenciaSQL 
     */
    public ExcepcionExpo(Integer codigoError, String mensajeErrorBD, String mensajeErrorUsuario, String setenciaSQL) {
        this.codigoError = codigoError;
        this.mensajeErrorBD = mensajeErrorBD;
        this.mensajeErrorUsuario = mensajeErrorUsuario;
        this.sentenciaSQL = setenciaSQL;
    }
    
    /**
     * getter
     * @return codigoError
     */
    public Integer getCodigoError() {
        return codigoError;
    }

    /**
     * setter
     * @param codigoError 
     */
    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    /**
     * getter
     * @return mensajeErrorBD
     */
    public String getMensajeErrorBD() {
        return mensajeErrorBD;
    }

    /**
     * setter
     * @param mensajeErrorBD 
     */
    public void setMensajeErrorBD(String mensajeErrorBD) {
        this.mensajeErrorBD = mensajeErrorBD;
    }

    /**
     * getter
     * @return mensajeErrorUsuario
     */
    public String getMensajeErrorUsuario() {
        return mensajeErrorUsuario;
    }

    /**
     * setter
     * @param mensajeErrorUsuario 
     */
    public void setMensajeErrorUsuario(String mensajeErrorUsuario) {
        this.mensajeErrorUsuario = mensajeErrorUsuario;
    }

    /**
     * getter
     * @return sentenciaSQL
     */
    public String getSentenciaSQL() {
        return sentenciaSQL;
    }

    /**
     * setter
     * @param sentenciaSQL 
     */
    public void setSentenciaSQL(String sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    /**
     * Método que devuelve un String con todos los datos de la Excepción
     * @return 
     */
    @Override
    public String toString() {
        return "ExcepcionMUSEO{" + "CODIGO ERROR= " + codigoError + ". MENSAJE ERROR BD= " + mensajeErrorBD + ". MENSAJE ERROR USUARIO= " + mensajeErrorUsuario + ", SENTENCIA SQL= " + sentenciaSQL + '}';
    }
    
}
