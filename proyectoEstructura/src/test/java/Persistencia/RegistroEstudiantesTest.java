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

        Direccion d2 = new Direccion("Av. Tecnologico", "456", "Industrial", "Hermosillo");
        Contacto c2 = new Contacto("6627654321", "correo2@example.com", d2);

        Estudiante e1 = new Estudiante("A001", "Juan Perez", c1);
        Estudiante e2 = new Estudiante("A002", "Maria Lopez", c2);

        registro.agregarEstudiante(e1);
        registro.agregarEstudiante(e2);
        
        System.out.println("tamaño: " + registro.tamanio());

        Estudiante buscado1 = registro.buscarPorMatricula("A001");
        Estudiante buscado2 = registro.buscarPorMatricula("A002");

        assertNotNull(buscado1);
        assertEquals("Juan Perez", buscado1.getNombreCompleto());
        assertEquals("Ciudad Obregon", buscado1.getContacto().getDireccion().getCiudad());

        assertNotNull(buscado2);
        assertEquals("Maria Lopez", buscado2.getNombreCompleto());
        assertEquals("Hermosillo", buscado2.getContacto().getDireccion().getCiudad());
    }

    @Test
    void testBuscarEstudianteNoExistente() {
        Direccion d = new Direccion("Calle Principal", "10", "Centro", "Navojoa");
        Contacto c = new Contacto("6449876543", "correo@example.com", d);
        Estudiante e1 = new Estudiante("A001", "Carlos Ruiz", c);

        registro.agregarEstudiante(e1);

        Estudiante buscado = registro.buscarPorMatricula("A999");
        assertNull(buscado); // no deberia existir
    }

    @Test
    void testCalificacionesYPromedio() throws Exception {
        Direccion d = new Direccion("Av. Reforma", "20", "Industrial", "Hermosillo");
        Contacto c = new Contacto("6625554321", "correo3@example.com", d);
        Estudiante e1 = new Estudiante("A003", "Luis Martinez", c);
        Curso c1 = new Curso();
        Curso c2 = new Curso();
        Curso c3 = new Curso();
        
        Calificacion cal1 = new Calificacion(c1, 90.0);
        Calificacion cal2 = new Calificacion(c2, 80.0);
        Calificacion cal3 = new Calificacion(c3, 100.0);

        e1.agregarCalificacion(cal1);
        e1.agregarCalificacion(cal2);
        e1.agregarCalificacion(cal3);

        registro.agregarEstudiante(e1);

        Estudiante buscado = registro.buscarPorMatricula("A003");
        assertEquals(90.0, buscado.calcularPromedio()); // (90+80+100)/3 = 90
    }

    @Test
    void testMostrarEstudiantes() {
        Direccion d1 = new Direccion("Av. Universidad", "123", "Centro", "Ciudad Obregon");
        Contacto c1 = new Contacto("6621234567", "correo1@example.com", d1);
        Estudiante e1 = new Estudiante("A001", "Juan Perez", c1);

        Direccion d2 = new Direccion("Av. Tecnologico", "456", "Industrial", "Hermosillo");
        Contacto c2 = new Contacto("6627654321", "correo2@example.com", d2);
        Estudiante e2 = new Estudiante("A002", "Maria Lopez", c2);

        registro.agregarEstudiante(e1);
        registro.agregarEstudiante(e2);

        // Este metodo imprime en consola, no devuelve nada
        registro.mostrarEstudiantes();

        // Verificamos que los estudiantes estan en el arbol BST
        assertNotNull(registro.buscarPorMatricula("A001"));
        assertNotNull(registro.buscarPorMatricula("A002"));
    }
}