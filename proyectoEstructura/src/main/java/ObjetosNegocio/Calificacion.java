/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

/**
 *
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Calificacion {

    private String matricula;
    private Double nuevaCalificacion;

    public Calificacion(String matricula, Double nuevaCalificacion) {
        this.matricula = matricula;
        this.nuevaCalificacion = nuevaCalificacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getNuevaCalificacion() {
        return nuevaCalificacion;
    }

    public void setNuevaCalificacion(Double nuevaCalificacion) {
        this.nuevaCalificacion = nuevaCalificacion;
    }
}