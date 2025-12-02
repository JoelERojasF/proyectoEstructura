/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Persistencia;

import ObjetosNegocio.Estudiante;
import ObjetosNegocio.SolicitudCalificacion;
import ObjetosNegocio.Contacto;
import ObjetosNegocio.Direccion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroCalificacionesTest {
    
    private RegistroEstudiantes registroEstudiantes;
    private RegistroCalificaciones registroCalificaciones;

    @BeforeEach
    void setUp() {
        registroEstudiantes = new RegistroEstudiantes();
        registroCalificaciones = new RegistroCalificaciones(registroEstudiantes);

        // Crear direcciones y contactos
        Direccion dir1 = new Direccion("Calle A", "123", "Centro", "Ciudad Obregón");
        Direccion dir2 = new Direccion("Calle B", "456", "Norte", "Ciudad Obregón");

        Contacto contacto1 = new Contacto("6441234567", "ana@mail.com", dir1);
        Contacto contacto2 = new Contacto("6449876543", "luis@mail.com", dir2);

        // Crear estudiantes con matrícula, nombre y contacto
        Estudiante e1 = new Estudiante("001", "Ana López", contacto1);
        Estudiante e2 = new Estudiante("002", "Luis Pérez", contacto2);

        registroEstudiantes.agregarEstudiante(e1);
        registroEstudiantes.agregarEstudiante(e2);
    }

    @Test
    void testRegistrarYProcesarSolicitud() throws Exception {
        // Crear solicitud para Ana
        SolicitudCalificacion solicitud = new SolicitudCalificacion("001", 95.0);
        registroCalificaciones.registrarSolicitud(solicitud);

        // Procesar
        registroCalificaciones.procesarSiguiente();

        Estudiante e1 = registroEstudiantes.buscarPorMatricula("001");
        assertEquals(95.0, e1.getCalificaciones().obtener(0));
    }

    @Test
    void testAccionRegistradaEnPila() {
        SolicitudCalificacion solicitud = new SolicitudCalificacion("002", 80.0);
        registroCalificaciones.registrarSolicitud(solicitud);

        registroCalificaciones.procesarSiguiente();

        // Última acción debe ser sobre Luis
        Estudiante ultimo = registroCalificaciones.getEstudianteUltimaAccion();
        assertEquals("Luis Pérez", ultimo.getNombreCompleto());
    }

    @Test
    void testDeshacerUltimaAccion() throws Exception {
        SolicitudCalificacion solicitud = new SolicitudCalificacion("001", 70.0);
        registroCalificaciones.registrarSolicitud(solicitud);

        registroCalificaciones.procesarSiguiente();

        Estudiante e1 = registroEstudiantes.buscarPorMatricula("001");
        assertEquals(70.0, e1.getCalificaciones().obtener(0));

        // Deshacer
        registroCalificaciones.deshacer();

        // Lista de calificaciones debe estar vacía otra vez
        assertTrue(e1.getCalificaciones().vacio());
    }

    @Test
    void testMostrarListadoPromedios() throws Exception {
        // Agregar calificaciones
        registroCalificaciones.registrarSolicitud(new SolicitudCalificacion("001", 90.0));
        registroCalificaciones.registrarSolicitud(new SolicitudCalificacion("002", 80.0));

        registroCalificaciones.procesarSolicitudes();

        Estudiante e1 = registroEstudiantes.buscarPorMatricula("001");
        Estudiante e2 = registroEstudiantes.buscarPorMatricula("002");

        assertEquals(90.0, e1.calcularPromedio());
        assertEquals(80.0, e2.calcularPromedio());
    }
}