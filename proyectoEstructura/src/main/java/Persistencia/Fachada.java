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
import Validadores.Validadores;

/**
 *esta clase sera la que se conecte la interfaz con el resto de registros
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Fachada {
    RegistroEstudiantes estudiantes = new RegistroEstudiantes();
//    RegistroCalificaciones calificaciones = new RegistroCalificaciones();
    RegistroCursos cursos = new RegistroCursos();
    RegistroInscripciones inscripciones = new RegistroInscripciones();
    Validadores val = new Validadores();
    
    //estudiantes
    public void agregarEstudiante(String matricula, String nombre, String telefono, String email, String calle, String numero, String colonia, String ciudad){
        
        if(!val.validarNombreEstudiante(nombre)){
            throw new IllegalArgumentException("nombre de estudiante invalido");
        }
        if(!val.validarTelefono(telefono)){
            throw new IllegalArgumentException("telefono invalido");
        }
        if(!val.validarEmail(email)){
            throw new IllegalArgumentException("e-mail invalido");
        }
        if(!val.validarDireccionCalle(calle)){
            throw new IllegalArgumentException("calle invalida");
        }
        if(!val.validarDireccionNumero(numero)){
            throw new IllegalArgumentException("numero de calle invalido");
        }
        if(!val.validarDireccionColonia(colonia)){
            throw new IllegalArgumentException("colonia invalida");
        }
        if(val.validarDireccionCiudad(ciudad)){
            throw new IllegalArgumentException("ciudad invalida");
        }
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
    public void agregarCurso(String clave, String nombre, String capacidad){
            if(!val.validarNombreCurso(nombre)){
            throw new IllegalArgumentException("nombre de curso invalido");
        }
        if(!val.validarCupoCurso(capacidad)){
            throw new IllegalArgumentException("cupo invalido");
        }
        int cupo= Integer.parseInt(capacidad);
        
        Curso c  = new Curso(clave, nombre, cupo);
        cursos.agregarCurso(c);
    }
    
    public Curso buscarCurso(String clave){
        return cursos.buscarPorClave(clave);
    }
    
    public void eliminarCurso(String clave){
        cursos.eliminarCurso(cursos.buscarPorClave(clave));
    }
    
    public ListaEnlazadaSimple<Curso> listarCursos(){
        return cursos.mostrarCursos();
    }
    
    //inscripciones
    public void agregarInscripcion(String claveCurso, String matriculaEstudiante){
        Curso c = cursos.buscarPorClave(claveCurso);
        Estudiante e = estudiantes.buscarPorMatricula(matriculaEstudiante);
        
        inscripciones.inscribirEstudianteEnCurso(e, c);
    }
    
    //pendiente
    public Inscripcion buscarInscripcion(){
        return null;
    }
    
    //pendiente
    public void eliminarInscripcion(){}
    
    public ListaEnlazadaSimple<Curso> listarInscripcionesDeEstudiante(String matriculaEstudiante){
        return inscripciones.obtenerCursosPorEstudiante(matriculaEstudiante);
    }
    
    public ListaEnlazadaSimple<Estudiante> listarInscripcionesDeCurso(String claveCurso){
        return inscripciones.obtenerEstudiantesPorCurso(claveCurso);
    }
    
    public ListaEnlazadaSimple<Inscripcion> listarInscripciones(){
        return inscripciones.obtenerInscripciones();
    }
    
    //calificaciones
    //aun no estoy seguro de como implementarlos aqui
    
}
