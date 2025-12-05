/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Persistencia;

import EstructuraDatos.Cola;
import ObjetosNegocio.Estudiante;
import ObjetosNegocio.Calificacion;
import ObjetosNegocio.Promedio;
import EstructuraDatos.ArbolAVL;
import EstructuraDatos.ListaEnlazadaSimple;
import EstructuraDatos.Pila;
import ObjetosNegocio.Accion;
import ObjetosNegocio.SolicitudCalificacion;
import java.util.NoSuchElementException;
/**
 * RegistroCalificaciones.java
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroCalificaciones {
    RegistroAcciones acciones = new RegistroAcciones();
    private Cola<SolicitudCalificacion> solicitudes;
    private RegistroEstudiantes registroEstudiantes;

    public RegistroCalificaciones(RegistroEstudiantes registroEstudiantes) {
        this.registroEstudiantes = registroEstudiantes;
        this.solicitudes = new Cola<>();
    }

    // Registrar una nueva solicitud en la cola
    public void registrarSolicitud(SolicitudCalificacion solicitud) {
        solicitudes.agregar(solicitud); // FIFO
    }

    // Procesar solicitudes en orden FIFO
    public void procesarTodasSolicitudes() throws Exception {
        if (solicitudes.vacio()) {
            throw new NoSuchElementException("No hay solicitudes pendientes");
        }
        while (!solicitudes.vacio()) {
            SolicitudCalificacion solicitud = solicitudes.eliminar(); // atiende la más antigua
            Estudiante estudiante = registroEstudiantes.buscarPorMatricula(solicitud.getEstudiante().getMatricula());
            if (estudiante != null) {
                
                Double calificacionNueva = solicitud.getCalificacion().getCalificacion();
                Calificacion calificacionAnterior = new Calificacion(solicitud.getCalificacion().getCurso(), 0.0);
                
                if (!estudiante.getCalificaciones().vacio()) {
                    ListaEnlazadaSimple<Calificacion> lista = estudiante.getCalificaciones();
                    for(Calificacion i : lista){
                        if(i.getCurso().equals(solicitud.getCalificacion().getCurso())){
                            calificacionAnterior = i;
                        }
                    }
                }
                
                estudiante.agregarCalificacion(solicitud.getCalificacion());
                
                Accion accion = new Accion(
                Accion.TipoAccion.CALIFICACION,
                estudiante,
                null,
                calificacionAnterior,
                calificacionNueva,
                true
            );
            acciones.registrarAccion(accion);
            }
        }
    }
    
    /**
     * Procesa la siguiente solicitud de calificacion en la cola.
     * Extrae la solicitud
     * Actualiza la calificación del estudiante
     * Registra la acción en la pila para poder deshacer
     */
    public void procesarSiguienteSolicitud() throws Exception {
        if (solicitudes.vacio()) {
            throw new NoSuchElementException("No hay solicitudes pendientes");
        }

//        try {
            // 1. Tomar la siguiente solicitud
            SolicitudCalificacion solicitud = solicitudes.eliminar();

            // 2. Buscar estudiante en el registro usando la matrícula
            Estudiante estudiante = registroEstudiantes.buscarPorMatricula(solicitud.getEstudiante().getMatricula());
            if (estudiante == null) {
                throw new NoSuchElementException("Estudiante de la solicitud no encontrado");
            }

            Double calificacionNueva = solicitud.getCalificacion().getCalificacion();
                Calificacion calificacionAnterior = new Calificacion(solicitud.getCalificacion().getCurso(), 0.0);

            // 3. Guardar calificación anterior (si existe)
            if (!estudiante.getCalificaciones().vacio()) {
                    ListaEnlazadaSimple<Calificacion> lista = estudiante.getCalificaciones();
                    for(Calificacion i : lista){
                        if(i.getCurso().equals(solicitud.getCalificacion().getCurso())){
                            calificacionAnterior = i;
                        }
                    }
                }

            // 4. Agregar la nueva calificación
            estudiante.agregarCalificacion(solicitud.getCalificacion());

            // 5. Registrar acción en la pila
            Accion accion = new Accion(
                Accion.TipoAccion.CALIFICACION,
                estudiante,
                null,
                calificacionAnterior,
                calificacionNueva,
                true
            );
            acciones.registrarAccion(accion);

            System.out.println("Procesada solicitud: " + estudiante.getNombreCompleto() +
                               " nueva calificación = " + calificacionNueva);
//        } catch (Exception e) {
//            System.out.println("Error al procesar solicitud: " + e.getMessage());
//        }

    }
    
    public ListaEnlazadaSimple<Promedio> obtenerListadoPromedios() throws Exception {
        ArbolAVL<Promedio> arbolConPromedios = new ArbolAVL<>();

        for (Estudiante e : registroEstudiantes.obtenerTodos()) {
            arbolConPromedios.insertar(new Promedio(e.calcularPromedio(), e));
        }

        return arbolConPromedios.obtenerTodos();
    }
    
    public Cola<SolicitudCalificacion> obtenerListaSolicitudes(){
        return solicitudes;
    }
    
        
    public Estudiante getEstudianteSiguienteSolicitud() {
        if (solicitudes.vacio()) return null;
        try {
            SolicitudCalificacion solicitud = solicitudes.obtener(0);
            return registroEstudiantes.buscarPorMatricula(solicitud.getEstudiante().getMatricula());
        } catch (Exception e) {
            return null;
        }
    }

    public Estudiante getEstudianteUltimaAccion() {
        if (acciones.vacio()) return null;
        try {
            return acciones.ultimaAccion().getEstudiante();
        } catch (Exception e) {
            return null;
        }
    }
}