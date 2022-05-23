/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadexpo;

/**
 *
 * @author pulpracticas.VSTI
 */
class Diseno {

    private Integer disenoID;
    private String nombre;
    private String descripcion;
    private Disenador disenador;

    public Diseno() {
    }

    public Diseno(Integer disenoID, String nombre, String descripcion, Disenador diseñador) {
        this.disenoID = disenoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.disenador = diseñador;
    }

    public Integer getDiseñoID() {
        return disenoID;
    }

    public void setDiseñoID(Integer diseñoID) {
        this.disenoID = diseñoID;
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
        return disenador;
    }

    public void setDiseñador(Disenador diseñador) {
        this.disenador = diseñador;
    }

    @Override
    public String toString() {
        return "Diseno{" + "disenoID=" + disenoID + ", nombre=" + nombre + ", descripcion=" + descripcion + ", disenador=" + disenador + '}';
    }

}
