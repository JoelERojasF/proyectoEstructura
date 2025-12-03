/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

/**
 * Inscripcion.java
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Inscripcion {
    private Estudiante estudiante;
    private Curso curso;

    public Inscripcion(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Curso getCurso() { return curso; }

    @Override
    public String toString() {
        return estudiante.getMatricula() + " inscrito en " + curso.getClave();
    }
}