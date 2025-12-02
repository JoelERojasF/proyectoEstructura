/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Persistencia;

import ObjetosNegocio.Curso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroCursosTest {
    
    private RegistroCursos registro;

    @BeforeEach
    void setUp() {
        registro = new RegistroCursos();
    }

    @Test
    void testAgregarYBuscarCurso() {
        Curso c1 = new Curso("C001", "Matematicas");
        Curso c2 = new Curso("C002", "Programacion");

        registro.agregarCurso(c1);
        registro.agregarCurso(c2);

        Curso buscado1 = registro.buscarPorClave("C001");
        Curso buscado2 = registro.buscarPorClave("C002");

        assertNotNull(buscado1);
        assertEquals("Matematicas", buscado1.getNombre());

        assertNotNull(buscado2);
        assertEquals("Programacion", buscado2.getNombre());
    }

    @Test
    void testBuscarCursoNoExistente() {
        Curso c1 = new Curso("C001", "Matematicas");
        registro.agregarCurso(c1);

        Curso buscado = registro.buscarPorClave("C999");
        assertNull(buscado); // no deberia existir
    }

    @Test
    void testMostrarCursos() {
        Curso c1 = new Curso("C001", "Matematicas");
        Curso c2 = new Curso("C002", "Programacion");
        Curso c3 = new Curso("C003", "Historia");

        registro.agregarCurso(c1);
        registro.agregarCurso(c2);
        registro.agregarCurso(c3);

        // Este metodo imprime en consola, no devuelve nada
        registro.mostrarCursos();

        // Verificamos que los cursos estan en el arbol
        assertNotNull(registro.buscarPorClave("C001"));
        assertNotNull(registro.buscarPorClave("C002"));
        assertNotNull(registro.buscarPorClave("C003"));
    }
}