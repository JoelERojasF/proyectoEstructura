/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ListaEnlazadaSimple;
import ObjetosNegocio.Contacto;
import ObjetosNegocio.Curso;
import ObjetosNegocio.Direccion;
import ObjetosNegocio.Estudiante;
import ObjetosNegocio.Inscripcion;

/**
 *esta clase sera la que se conecte la interfaz con el resto de registros
 * 
 * @author le0jx
 */
public class Fachada {
    RegistroEstudiantes estudiantes = new RegistroEstudiantes();
//    RegistroCalificaciones calificaciones = new RegistroCalificaciones();
    RegistroCursos cursos = new RegistroCursos();
    RegistroInscripciones inscripciones = new RegistroInscripciones();
    
    //estudiantes
    public void agregarEstudiante(String matricula, String nombre, String telefono, String email, String calle, String numero, String colonia, String ciudad){
        Direccion d = new Direccion(calle, numero, colonia, ciudad);
        Contacto c= new Contacto(telefono, email, d);
        Estudiante e = new Estudiante(matricula, nombre, c);
        
        estudiantes.agregarEstudiante(e);
    }
    
    public void eliminarEstudiante(String id){
        estudiantes.eliminarEstudiante(id);
    }
    
    public Estudiante buscarEstudiante(String id){
        return estudiantes.buscarPorMatricula(id);
    }
    
    public ListaEnlazadaSimple listarEstudiantes(){
        return estudiantes.obtenerTodos();
    }
    
    //cursos
    public void agregarCurso(){}
    
    public void buscarCurso(){}
    
    public void eliminarCurso(){}
    
    public void listarCursos(){}
    
    //inscripciones
    public void agregarInscripcion(){}
    
    
    public void eliminarInscripcion(){}
    
    public ListaEnlazadaSimple<Curso> listarInscripcionesDeEstudiante(){
        return null;
    }
    
    public ListaEnlazadaSimple<Estudiante> listarInscripcionesDeCurso(){
        return null;
    }
    
    public ListaEnlazadaSimple<Inscripcion> listarInscripciones(){
        return null;
    }
    
    //calificaciones
    //aun no estoy seguro de como implementarlos aqui
    
}
