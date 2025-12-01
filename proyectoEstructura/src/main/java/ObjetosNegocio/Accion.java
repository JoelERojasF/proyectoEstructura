/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Persistencia.RegistroEstudiantes;

/**
 *
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
                  Double calificacionAnterior, Double calificacionNueva) {
        this.tipo = tipo;
        this.estudiante = estudiante;
        this.curso = curso;
        this.calificacionAnterior = calificacionAnterior;
        this.calificacionNueva = calificacionNueva;
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
    public void revertir() {
        switch (tipo) {
            case REGISTRO:
                // Si la acción fue registrar un estudiante, al deshacer se elimina del BST
                if (estudiante != null) {
                RegistroEstudiantes registro = new RegistroEstudiantes();
                registro.eliminarEstudiante(estudiante.getMatricula());
            }
                break;
            case INSCRIPCION:
                // Si la acción fue inscribir, al deshacer se quita del curso
            if (curso != null && estudiante != null) {
                curso.removerInscrito(estudiante);
            }
                break;
            case BAJA:
                // Si la acción fue dar de baja, al deshacer se vuelve a inscribir
            if (curso != null && estudiante != null) {
                curso.inscribir(estudiante);
            }
                break;
            case CALIFICACION:
                if (calificacionAnterior != null) {
                    estudiante.reemplazarCalificacion(calificacionNueva, calificacionAnterior);
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

    @Override
    public String toString() {
        return "Accion{" +
                "tipo=" + tipo +
                ", estudiante=" + (estudiante != null ? estudiante.getMatricula() : "null") +
                ", curso=" + (curso != null ? curso.getClave() : "null") +
                '}';
    }
}