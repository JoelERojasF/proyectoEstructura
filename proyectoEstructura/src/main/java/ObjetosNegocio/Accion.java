/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Persistencia.Fachada;
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

    private Fachada fachada;
    private TipoAccion tipo;
    private Estudiante estudiante;
    private Curso curso;
    private Calificacion calificacionAnterior;
    private Double calificacionNueva;
    private Boolean aniadido;
    private Inscripcion inscripcion;
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
    public Accion(TipoAccion tipo, Estudiante estudiante, Curso curso, Inscripcion inscripcion,
                  Calificacion calificacionAnterior, Double calificacionNueva, Boolean aniadido) {
        this.tipo = tipo;
        this.estudiante = estudiante;
        this.curso = curso;
        this.inscripcion = inscripcion;
        this.calificacionAnterior = calificacionAnterior;
        this.calificacionNueva = calificacionNueva;
        this.aniadido = aniadido;
        this.fachada = Fachada.getInstancia();
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
        System.out.println("se revertira la accion: " + toString());
        switch (tipo) {
            case REGISTRO:
                // Si la acción fue registrar un estudiante o un curso, al deshacer se elimina del BST
                if (estudiante != null) {
                    if(aniadido){
                        fachada.ReliminarEstudiante(estudiante.getMatricula());
                        System.out.println("se elimino el estudiante: " + estudiante.toString());
                    }else{
                        fachada.RagregarEstudiante(estudiante.getMatricula(),estudiante.getNombreCompleto(), estudiante.getContacto().getTelefono(), estudiante.getContacto().getEmail(), estudiante.getContacto().getDireccion().getCalle(), estudiante.getContacto().getDireccion().getNumero(), estudiante.getContacto().getDireccion().getColonia(), estudiante.getContacto().getDireccion().getCiudad());
                        System.out.println("se registro al estudiante: " + estudiante.toString());
                    }   
            }   else if(curso != null){
                    if(aniadido){
                        fachada.ReliminarCurso(curso.getClave());
                        System.out.println("se elimino el curso: " + curso.toString());
                    }else{
                        fachada.RagregarCurso(curso.getClave(), curso.getNombre(), curso.getCupoMaximo()+"");
                        System.out.println("se registro el curso: " + curso.toString());
                    }
            }
                break;
            case INSCRIPCION:
                // Si la acción fue inscribir, al deshacer se quita al estudiante del curso
            if (curso != null && estudiante != null && inscripcion != null) {
                if(aniadido){
                    fachada.ReliminarInscripcion(inscripcion.getId());
                    System.out.println("se elimino la inscripcion del estudiante: " + estudiante.toString() + " al curso: "+ curso.toString());
                }else{
                    fachada.RagregarInscripcion(curso.getClave(), estudiante.getMatricula());
                    System.out.println("se agrego la inscripcion del estudiante: " + estudiante.toString() + " al curso: " + curso.toString());

                }
            }
                break;
            case BAJA:
                // Si la acción fue dar de baja, al deshacer se vuelve a inscribir
            if (curso != null && estudiante != null) {
                if(aniadido){
                    fachada.RagregarInscripcion(curso.getClave(), estudiante.getMatricula());
                    System.out.println("se agrego la inscripcion del estudiante: " + estudiante.toString() + " al curso: " + curso.toString());
                }else{
                    fachada.ReliminarInscripcion(inscripcion.getId());
                    System.out.println("se elimino la inscripcion del estudiante: " + estudiante.toString() + " al curso: " + curso.toString());
                }
            }
                break;
            case CALIFICACION:
                if (calificacionAnterior != null) {
                    if(aniadido){
                        fachada.RregistrarSolicitudCalificacion(estudiante.getMatricula(), curso.getClave(), calificacionNueva+"");
                        System.out.println("se reemplazo la calificacion :"+ calificacionAnterior.toString() + " por: " + calificacionNueva);
                    }else{
                        Calificacion c = new Calificacion(calificacionAnterior.getCurso(), calificacionNueva);
                        estudiante.reemplazarCalificacion(calificacionAnterior.getCalificacion(), c);
                        System.out.println("se reemplazo la calificacion :" + c.toString() + " por: " + calificacionAnterior.getCalificacion());

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

    public Calificacion getCalificacionAnterior() {
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