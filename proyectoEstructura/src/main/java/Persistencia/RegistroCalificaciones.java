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
import EstructuraDatos.Pila;
import ObjetosNegocio.Accion;
/**
 * RegistroCalificaciones.java
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroCalificaciones {
    private Pila<Accion> acciones = new Pila<>(); // Requerida en el documento
    private Cola<Calificacion> solicitudes;
    private RegistroEstudiantes registroEstudiantes;

    public RegistroCalificaciones(RegistroEstudiantes registroEstudiantes) {
        this.registroEstudiantes = registroEstudiantes;
        this.solicitudes = new Cola<>();
    }

    // Registrar una nueva solicitud en la cola
    public void registrarSolicitud(Calificacion solicitud) {
        solicitudes.agregar(solicitud); // FIFO
    }

    // Procesar solicitudes en orden FIFO
    public void procesarSolicitudes() throws Exception {
        while (!solicitudes.vacio()) {
            Calificacion solicitud = solicitudes.eliminar(); // atiende la más antigua
            Estudiante estudiante = registroEstudiantes.buscarPorMatricula(solicitud.getMatricula());
            if (estudiante != null) {
                estudiante.agregarCalificacion(solicitud.getNuevaCalificacion());
            }
        }
    }
    
    public void deshacer() {
        if (acciones.vacio()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }

        try {
            Accion ultima = acciones.eliminar();
            ultima.revertir();
            System.out.println("Se deshizo la accion: " + ultima);
        } catch (Exception e) {
            System.out.println("Error al deshacer accion: " + e.getMessage());
        }
    }

    public void mostrarListadoPromedios() throws Exception {
        ArbolAVL<Promedio> arbolConPromedios = new ArbolAVL<>();

        for (Estudiante e : registroEstudiantes.obtenerTodos()) {
            arbolConPromedios.insertar(new Promedio(e.calcularPromedio(), e));
        }

        System.out.println(arbolConPromedios.toString()); // recorrido in-orden del AVL
    }
    
    /**
     * Procesa la siguiente solicitud de calificacion en la cola.
     * Extrae la solicitud
     * Actualiza la calificación del estudiante
     * Registra la acción en la pila para poder deshacer
     */
    public void procesarSiguiente() {
        if (solicitudes.vacio()) {
            System.out.println("No hay solicitudes pendientes.");
            return;
        }

        try {
            // 1. Tomar la siguiente solicitud
            Calificacion solicitud = solicitudes.eliminar();

            // 2. Buscar estudiante en el registro usando la matrícula
            Estudiante estudiante = registroEstudiantes.buscarPorMatricula(solicitud.getMatricula());
            if (estudiante == null) {
                System.out.println("No se encontró estudiante con matrícula: " + solicitud.getMatricula());
                return;
            }

            Double calificacionNueva = solicitud.getNuevaCalificacion();
            Double calificacionAnterior = null;

            // 3. Guardar calificación anterior (si existe)
            if (!estudiante.getCalificaciones().vacio()) {
                int ultimaPos = estudiante.getCalificaciones().tamanio() - 1;
                calificacionAnterior = estudiante.getCalificaciones().obtener(ultimaPos);
            }

            // 4. Agregar la nueva calificación
            estudiante.getCalificaciones().agregar(calificacionNueva);

            // 5. Registrar acción en la pila
            Accion accion = new Accion(
                Accion.TipoAccion.CALIFICACION,
                estudiante,
                null,
                calificacionAnterior,
                calificacionNueva
            );
            acciones.agregar(accion);

            System.out.println("Procesada solicitud: " + estudiante.getNombreCompleto() +
                               " nueva calificación = " + calificacionNueva);
        } catch (Exception e) {
            System.out.println("Error al procesar solicitud: " + e.getMessage());
        }

        }
        
    public Estudiante getEstudianteSiguienteSolicitud() {
        if (solicitudes.vacio()) return null;
        try {
            Calificacion solicitud = solicitudes.obtener(0);
            return registroEstudiantes.buscarPorMatricula(solicitud.getMatricula());
        } catch (Exception e) {
            return null;
        }
    }

    public Estudiante getEstudianteUltimaAccion() {
        if (acciones.vacio()) return null;
        try {
            return acciones.obtener(0).getEstudiante();
        } catch (Exception e) {
            return null;
        }
    }
}