/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ListaEnlazadaSimple;
import ObjetosNegocio.Accion;
import ObjetosNegocio.Calificacion;
import ObjetosNegocio.Contacto;
import ObjetosNegocio.Curso;
import ObjetosNegocio.Direccion;
import ObjetosNegocio.Estudiante;
import ObjetosNegocio.Inscripcion;
import ObjetosNegocio.Promedio;
import ObjetosNegocio.SolicitudCalificacion;
import Validadores.Validadores;
import java.util.NoSuchElementException;

/**
 * Esta clase sera la que conecte o haga de puente con la interfaz con el resto de registros
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Fachada {
    RegistroEstudiantes estudiantes;
    RegistroCalificaciones calificaciones;
    RegistroCursos cursos;
    RegistroInscripciones inscripciones;
    RegistroAcciones acciones;
    Validadores val = new Validadores();
    
    private static Fachada instancia;

    private Fachada(){
        estudiantes = new RegistroEstudiantes();
        calificaciones = new RegistroCalificaciones(estudiantes);
        cursos = new RegistroCursos();
        inscripciones = new RegistroInscripciones();
        acciones = new RegistroAcciones();
    }

    public static Fachada getInstancia() {
        if(instancia == null)
            instancia = new Fachada();
        return instancia;
    }
    
    //estudiantes
    public Estudiante agregarEstudiante(String nombre, String telefono, String email, String calle, String numero, String colonia, String ciudad){
        
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
        if(!val.validarDireccionCiudad(ciudad)){
            throw new IllegalArgumentException("ciudad invalida");
        }
        Direccion d = new Direccion(calle, numero, colonia, ciudad);
        Contacto c= new Contacto(telefono, email, d);
        
        Estudiante e = new Estudiante(crearIdEstudiante(), nombre, c);
        
        estudiantes.agregarEstudiante(e);
        return e;
    }
    
    public void eliminarEstudiante(String id){
        Estudiante e = estudiantes.buscarPorMatricula(id);
        if(e == null) throw new NoSuchElementException("Estudiante no encontrado");
        estudiantes.eliminarEstudiante(e);
    }
    
    public Estudiante buscarEstudiante(String id){
        Estudiante e = estudiantes.buscarPorMatricula(id);
        if(e == null) throw new NoSuchElementException("Estudiante no encontrado");
        return e;
    }
    
    public ListaEnlazadaSimple listarEstudiantes(){
        return estudiantes.obtenerTodos();
    }
    
    //cursos
    public Curso agregarCurso(String nombre, String capacidad){
            if(!val.validarNombreCurso(nombre)){
            throw new IllegalArgumentException("nombre de curso invalido");
        }
        if(!val.validarCupoCurso(capacidad)){
            throw new IllegalArgumentException("cupo invalido");
        }
        int cupo= Integer.parseInt(capacidad);
        
        Curso c  = new Curso(crearIdCurso(), nombre, cupo);
        cursos.agregarCurso(c);
        return c;
    }
    
    public Curso buscarCurso(String clave){
        Curso c = cursos.buscarPorClave(clave);
        if(c == null) throw new NoSuchElementException("Curso no encontrado");
        return cursos.buscarPorClave(clave);
    }
    
    public void eliminarCurso(String clave) throws Exception{
        Curso c = cursos.buscarPorClave(clave);
        if(c == null) throw new NoSuchElementException("Curso no encontrado");
        cursos.eliminarCurso(c);
    }
    
    public ListaEnlazadaSimple<Curso> listarCursos(){
        return cursos.mostrarCursos();
    }
    
    //inscripciones
    public Inscripcion agregarInscripcion(String claveCurso, String matriculaEstudiante){
        Curso c = cursos.buscarPorClave(claveCurso);
        Estudiante e = estudiantes.buscarPorMatricula(matriculaEstudiante);
        
        Inscripcion i = new Inscripcion(crearIdInscripcion(), e, c);
        inscripciones.inscribirEstudianteEnCurso(i);
        return i;
    }
    
    public Inscripcion buscarInscripcion(String id){
        Inscripcion i = inscripciones.buscarInscripcion(id);
        if(i == null) throw new NoSuchElementException("Inscripcion no encontrada");
        return i;
    }
    
    public void eliminarInscripcion(String id) throws Exception{
        Inscripcion i = inscripciones.buscarInscripcion(id);
        if(i == null) throw new NoSuchElementException("Inscripcion no encontrada");
        inscripciones.eliminarInscripcion(i);
    }
    
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
    public SolicitudCalificacion registrarSolicitudCalificacion(String matriculaEstudiante, String matriculaCurso, String calificacion){
        if(!val.validarCalificacion(calificacion)){
            throw new IllegalArgumentException("calificacion invalida");
        }
        
        Estudiante e = estudiantes.buscarPorMatricula(matriculaEstudiante);
        if(e == null) throw new NoSuchElementException("Estudiante no encontrado");
        Curso c = cursos.buscarPorClave(matriculaCurso);
        if(c == null) throw new NoSuchElementException("Curso no encontrado");
        
        Calificacion cal = new Calificacion(c, Double.parseDouble(calificacion));
        SolicitudCalificacion s = new SolicitudCalificacion(e, cal);
        
        calificaciones.registrarSolicitud(s);
        return s;
    }
    
    
    public ListaEnlazadaSimple<Promedio> listarPromedios() throws Exception{
        return calificaciones.obtenerListadoPromedios();
    } 
        
    //acciones
    public Accion deshacerUltimaAccion() throws Exception{
        return acciones.deshacerUltimaAccion();
    }
    
    private String crearIdEstudiante(){
        int numero =estudiantes.tamanio()+1;
        String matricula = String.format("EST%04d", numero);
        while(estudiantes.buscarPorMatricula(matricula) != null){
            numero++;
            matricula = String.format("EST%04d", numero);
        }
        return matricula;
    }
    
    private String crearIdCurso(){
        int numero =cursos.tamanio()+1;
        String matricula = String.format("CUR%04d", numero);
        while(cursos.buscarPorClave(matricula) != null){
            numero++;
            matricula = String.format("CUR%04d", numero);
        }
        return matricula;
    }
    
    private String crearIdInscripcion(){
        int numero =inscripciones.tamanio()+1;
        String matricula = String.format("INS%04d", numero);
        while(inscripciones.buscarInscripcion(matricula) != null){
            numero++;
            matricula = String.format("INS%04d", numero);
        }
        return matricula;
    }
    
    public void procesarSiguienteSolicitud() throws Exception {
        calificaciones.procesarSiguienteSolicitud();
    }

    public void procesarTodasSolicitudes() throws Exception {
        calificaciones.procesarTodasSolicitudes();
    }
    
    public String[] obtenerLideres(String claveCurso) throws Exception {
        Curso curso = cursos.buscarPorClave(claveCurso);
        String anterior  = curso.getLiderAnterior()  != null ? curso.getLiderAnterior().getNombreCompleto() : "N/A";
        String actual    = curso.getLiderActual()    != null ? curso.getLiderActual().getNombreCompleto()   : "N/A";
        String siguiente = curso.getSiguienteLider() != null ? curso.getSiguienteLider().getNombreCompleto(): "N/A";
        return new String[]{anterior, actual, siguiente};
    }


}
