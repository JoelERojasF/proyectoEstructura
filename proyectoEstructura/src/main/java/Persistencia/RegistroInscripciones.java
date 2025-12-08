/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ListaEnlazadaSimple;
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

    public RegistroInscripciones() {
        inscripciones = new ListaEnlazadaSimple<>();
    }

    public void inscribirEstudianteEnCurso(Inscripcion inscripcion) {
        inscripciones.agregar(inscripcion);

        // Actualizar el curso con el estudiante
        inscripcion.getCurso().inscribir(inscripcion.getEstudiante());
    }
    
    public void eliminarInscripcion(Inscripcion ins) throws Exception {
        // Eliminar de la lista global
        inscripciones.eliminar(inscripciones.indexOf(ins));

        // Tambien actualizar el curso
        ins.getCurso().removerInscrito(ins.getEstudiante());
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