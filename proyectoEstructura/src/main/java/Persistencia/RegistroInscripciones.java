/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ListaEnlazadaSimple;
import ObjetosNegocio.Accion;
import ObjetosNegocio.Estudiante;
import ObjetosNegocio.Curso;
import ObjetosNegocio.Inscripcion;

/**
 * RegistroInsripciones.java
 * 
 * Gestiona las inscripciones de estudiantes en cursos usando ListaEnlazadaSimple.
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroInscripciones {
    private ListaEnlazadaSimple<Inscripcion> inscripciones;
    RegistroAcciones acciones = new RegistroAcciones();

    public RegistroInscripciones() {
        inscripciones = new ListaEnlazadaSimple<>();
    }

    public void inscribirEstudianteEnCurso(Inscripcion inscripcion) {
        inscripciones.agregar(inscripcion);

        // Actualizar el curso con el estudiante
        inscripcion.getCurso().inscribir(inscripcion.getEstudiante());

        Accion accion = new Accion(
            Accion.TipoAccion.INSCRIPCION,
            inscripcion.getEstudiante(),
            inscripcion.getCurso(),
            null,
            -1.0,
            true
        );
        acciones.registrarAccion(accion);
    }
    
    public void eliminarInscripcion(Inscripcion ins) throws Exception{
        inscripciones.eliminar(inscripciones.indexOf(ins));
        Accion accion = new Accion(
                Accion.TipoAccion.BAJA,
                ins.getEstudiante(),
                ins.getCurso(),
                null,
                -1.0,
                true
            );
            acciones.registrarAccion(accion);
    }
    
    public Inscripcion buscarInscripcion(String id){
        for(Inscripcion i : inscripciones){
        if(i.getId() == id) return i;
        }
        return null;
    }

    public ListaEnlazadaSimple<Inscripcion> obtenerInscripciones() {
        return inscripciones;
    }

    public ListaEnlazadaSimple<Curso> obtenerCursosPorEstudiante(String matricula) {
        ListaEnlazadaSimple<Curso> cursos = new ListaEnlazadaSimple<>();
        for (Inscripcion i : inscripciones) {
            if (i.getEstudiante().getMatricula().equals(matricula)) {
                cursos.agregar(i.getCurso());
            }
        }
        return cursos;
    }

    public ListaEnlazadaSimple<Estudiante> obtenerEstudiantesPorCurso(String claveCurso) {
        ListaEnlazadaSimple<Estudiante> estudiantes = new ListaEnlazadaSimple<>();
        for (Inscripcion i : inscripciones) {
            if (i.getCurso().getClave().equals(claveCurso)) {
                estudiantes.agregar(i.getEstudiante());
            }
        }
        return estudiantes;
    }

    public void mostrarInscripciones() {
        for (Inscripcion i : inscripciones) {
            System.out.println(i);
        }
    }
    
    public int tamanio(){
    return inscripciones.tamanio();
    }
}