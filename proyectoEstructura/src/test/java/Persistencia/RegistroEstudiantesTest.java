/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Persistencia;

import ObjetosNegocio.Calificacion;
import ObjetosNegocio.Contacto;
import ObjetosNegocio.Curso;
import ObjetosNegocio.Direccion;
import ObjetosNegocio.Estudiante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroEstudiantesTest {
    
    private RegistroEstudiantes registro;

    @BeforeEach
    void setUp() {
        registro = new RegistroEstudiantes();
    }

    @Test
    void testAgregarYBuscarEstudiante() {
        Direccion d1 = new Direccion("Av. Universidad", "123", "Centro", "Ciudad Obregon");
        Contacto c1 = new Contacto("6621234567", "correo1@example.com", d1);

        Estudiante e1 = new Estudiante("EST0001", "Juan Perez", c1);
        registro.agregarEstudiante(e1);

        Estudiante buscado1 = registro.buscarPorMatricula("EST0001");

        assertNotNull(buscado1);
        assertEquals("Juan Perez", buscado1.getNombreCompleto());
        assertEquals("Ciudad Obregon", buscado1.getContacto().getDireccion().getCiudad());
    }

    @Test
    void testBuscarEstudianteNoExistente() {
        Direccion d = new Direccion("Calle Principal", "10", "Centro", "Navojoa");
        Contacto c = new Contacto("6449876543", "correo@example.com", d);
        Estudiante e1 = new Estudiante("EST0001", "Carlos Ruiz", c);

        registro.agregarEstudiante(e1);

        // Ahora esperamos una excepción en lugar de null
        assertThrows(java.util.NoSuchElementException.class, () -> {
            registro.buscarPorMatricula("EST9999");
        });
    }

    @Test
    void testCalificacionesYPromedio() throws Exception {
        Direccion d = new Direccion("Av. Reforma", "20", "Industrial", "Hermosillo");
        Contacto c = new Contacto("6625554321", "correo3@example.com", d);
        Estudiante e1 = new Estudiante("EST0003", "Luis Martinez", c);

        Curso c1 = new Curso("CUR0001", "Matemáticas", 30);
        Curso c2 = new Curso("CUR0002", "Historia", 30);
        Curso c3 = new Curso("CUR0003", "Programación", 30);
        
        Calificacion cal1 = new Calificacion(c1, 90.0);
        Calificacion cal2 = new Calificacion(c2, 80.0);
        Calificacion cal3 = new Calificacion(c3, 100.0);

        e1.agregarCalificacion(cal1);
        e1.agregarCalificacion(cal2);
        e1.agregarCalificacion(cal3);

        registro.agregarEstudiante(e1);

        Estudiante buscado = registro.buscarPorMatricula("EST0003");
        assertEquals(90.0, buscado.calcularPromedio(), 0.01); // (90+80+100)/3 = 90
    }

    @Test
    void testMostrarEstudiantes() {
        Direccion d1 = new Direccion("Av. Universidad", "123", "Centro", "Ciudad Obregon");
        Contacto c1 = new Contacto("6621234567", "correo1@example.com", d1);
        Estudiante e1 = new Estudiante("EST0001", "Juan Perez", c1);

        Direccion d2 = new Direccion("Av. Tecnologico", "456", "Industrial", "Hermosillo");
        Contacto c2 = new Contacto("6627654321", "correo2@example.com", d2);
        Estudiante e2 = new Estudiante("EST0002", "Maria Lopez", c2);

        registro.agregarEstudiante(e1);
        registro.agregarEstudiante(e2);

        registro.mostrarEstudiantes(); // imprime en consola

        assertNotNull(registro.buscarPorMatricula("EST0001"));
        assertNotNull(registro.buscarPorMatricula("EST0002"));
    }
}
