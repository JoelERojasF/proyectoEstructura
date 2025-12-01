/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Persistencia;

import EstructuraDatos.Cola;
import ObjetosNegocio.Estudiante;
import ObjetosNegocio.SolicitudCalificacion;
import ObjetosNegocio.EstudiantePromedio;
import EstructuraDatos.ArbolAVL;
/**
 * 
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroCalificaciones {

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
    public void procesarSolicitudes() throws Exception {
        while (!solicitudes.vacio()) {
            SolicitudCalificacion solicitud = solicitudes.eliminar(); // atiende la más antigua
            Estudiante estudiante = registroEstudiantes.buscarPorMatricula(solicitud.getMatricula());
            if (estudiante != null) {
                estudiante.agregarCalificacion(solicitud.getNuevaCalificacion());
            }
        }
    }

    public void mostrarListadoPromedios() throws Exception {
        ArbolAVL<EstudiantePromedio> arbolConPromedios = new ArbolAVL<>();

        for (Estudiante e : registroEstudiantes.obtenerTodos()) {
            arbolConPromedios.insertar(new EstudiantePromedio(e.calcularPromedio(), e));
        }

        System.out.println(arbolConPromedios.toString()); // recorrido in-orden del AVL
    }
}