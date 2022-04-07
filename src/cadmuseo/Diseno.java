/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadmuseo;

/**
 *
 * @author pulpracticas.VSTI
 */
class Diseno {
    private Integer diseñoID;
    private String nombre;
    private String descripcion;  
    private Disenador diseñador;

    public Diseno() {
    }

    public Diseno(Integer diseñoID, String nombre, String descripcion, Disenador diseñador) {
        this.diseñoID = diseñoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.diseñador = diseñador;
    }

    public Integer getDiseñoID() {
        return diseñoID;
    }

    public void setDiseñoID(Integer diseñoID) {
        this.diseñoID = diseñoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Disenador getDiseñador() {
        return diseñador;
    }

    public void setDiseñador(Disenador diseñador) {
        this.diseñador = diseñador;
    }

    @Override
    public String toString() {
        return "Diseno{" + "disenoID=" + diseñoID + ", nombre=" + nombre + ", descripcion=" + descripcion + ", disenador=" + diseñador + '}';
    }
    
    
}
