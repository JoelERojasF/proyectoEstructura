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
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroInscripciones {

    private ListaEnlazadaSimple<Inscripcion> inscripciones;

    public RegistroInscripciones() {
        inscripciones = new ListaEnlazadaSimple<>();
    }

    public void inscribirEstudianteEnCurso(Estudiante e, Curso c) {
        Inscripcion inscripcion = new Inscripcion(e, c);
        inscripciones.agregar(inscripcion);
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
}