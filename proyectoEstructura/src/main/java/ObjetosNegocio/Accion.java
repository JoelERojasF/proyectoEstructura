/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Persistencia.RegistroCursos;
import Persistencia.RegistroEstudiantes;

/**
 *
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Accion {
    /**
     * Tipos de acción que se pueden registrar en el sistema.
     */
    public enum TipoAccion {
        REGISTRO, INSCRIPCION, BAJA, CALIFICACION
    }

    private TipoAccion tipo;
    private Estudiante estudiante;
    private Curso curso;
    private Double calificacionAnterior;
    private Double calificacionNueva;
    private Boolean aniadido;
    RegistroEstudiantes registroEstudiante = new RegistroEstudiantes();
    RegistroCursos registroCurso = new RegistroCursos();

    /**
     * Constructor de la clase Accion.
     * 
     * @param tipo Tipo de acción realizada.
     * @param estudiante Estudiante involucrado en la acción.
     * @param curso Curso involucrado (si aplica).
     * @param calificacionAnterior Calificación previa (si aplica).
     * @param calificacionNueva Calificación nueva (si aplica).
     */
    public Accion(TipoAccion tipo, Estudiante estudiante, Curso curso,
                  Double calificacionAnterior, Double calificacionNueva, Boolean aniadido) {
        this.tipo = tipo;
        this.estudiante = estudiante;
        this.curso = curso;
        this.calificacionAnterior = calificacionAnterior;
        this.calificacionNueva = calificacionNueva;
        this.aniadido = aniadido;
    }

    /**
     * Método para revertir la acción registrada.
     * 
     * Dependiendo del tipo de acción, se ejecuta la operación inversa:
     * - REGISTRO: eliminar estudiante del BST.
     * - INSCRIPCION: quitar estudiante del curso.
     * - BAJA: volver a inscribir estudiante.
     * - CALIFICACION: restaurar calificación anterior.
     */
    public void revertir() throws Exception {
        switch (tipo) {
            case REGISTRO:
                // Si la acción fue registrar un estudiante o un curso, al deshacer se elimina del BST
                if (estudiante != null) {
                    if(aniadido){
                        registroEstudiante.eliminarEstudiante(estudiante);
                    }else{
                        registroEstudiante.agregarEstudiante(estudiante);
                    }   
            }   else if(curso != null){
                    if(aniadido){
                        registroCurso.eliminarCurso(curso);
                    }else{
                        registroCurso.agregarCurso(curso);
                    }
            }
                break;
            case INSCRIPCION:
                // Si la acción fue inscribir, al deshacer se quita al estudiante del curso
            if (curso != null && estudiante != null) {
                if(aniadido){
                    curso.removerInscrito(estudiante);
                }else{
                    curso.inscribir(estudiante);
                }
            }
                break;
            case BAJA:
                // Si la acción fue dar de baja, al deshacer se vuelve a inscribir
            if (curso != null && estudiante != null) {
                if(aniadido){
                    curso.inscribir(estudiante);
                }else{
                    curso.removerInscrito(estudiante);
                }
            }
                break;
            case CALIFICACION:
                if (calificacionAnterior != null) {
                    if(aniadido){
                        estudiante.reemplazarCalificacion(calificacionNueva, calificacionAnterior);
                    }else{
                        estudiante.reemplazarCalificacion(calificacionAnterior, calificacionNueva);
                    }
                }
                break;
        }
    }

    public TipoAccion getTipo() {
        return tipo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public Double getCalificacionAnterior() {
        return calificacionAnterior;
    }

    public Double getCalificacionNueva() {
        return calificacionNueva;
    }

    public Boolean getAniadido() {
        return aniadido;
    }

    @Override
    public String toString() {
        return "Accion{" +
                "tipo=" + tipo +
                ", estudiante=" + (estudiante != null ? estudiante.getMatricula() : "null") +
                ", curso=" + (curso != null ? curso.getClave() : "null") +
                '}';
    }
}