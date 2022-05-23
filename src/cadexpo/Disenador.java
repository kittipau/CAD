/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadexpo;

/**
 *
 * @author pulpracticas.VSTI
 */
class Disenador {
    private Integer diseñadorID;
    private String alias;
    private String descripcion;  
    private Diseno diseno;

    public Disenador() {
    }

    public Disenador(Integer diseñadorID, String alias, String descripcion) {
        this.diseñadorID = diseñadorID;
        this.alias = alias;
        this.descripcion = descripcion;
    }

    public Integer getDiseñadorID() {
        return diseñadorID;
    }

    public void setDiseñadorID(Integer diseñadorID) {
        this.diseñadorID = diseñadorID;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Disenador{" + "diseñador=" + diseñadorID + ", alias=" + alias + ", descripcion=" + descripcion + '}';
    }
    
}
