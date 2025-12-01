/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EstructuraDatos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class ColaTest {
    
    private Cola<Integer> cola;

    @BeforeEach
    void setUp() {
        cola = new Cola<>();
    }

    @Test
    void testEnqueue() {
        cola.agregar(10); // enqueue
        cola.agregar(20);
        cola.agregar(30);
        assertEquals(3, cola.tamanio());
        assertFalse(cola.vacio());
    }

    @Test
    void testDequeue() throws Exception {
        cola.agregar(10);
        cola.agregar(20);
        cola.agregar(30);

        int primero = cola.eliminar(); // dequeue
        assertEquals(10, primero); // debe sacar el primero en entrar
        assertEquals(2, cola.tamanio());
    }

    @Test
    void testObtenerPorIndice() throws Exception {
        cola.agregar(5);
        cola.agregar(15);
        cola.agregar(25);

        assertEquals(15, cola.obtener(1)); // segundo elemento
        assertEquals(25, cola.obtener(2)); // tercero
    }

    @Test
    void testEliminarHastaVacio() throws Exception {
        cola.agregar(1);
        cola.agregar(2);
        cola.eliminar();
        cola.eliminar();
        assertTrue(cola.vacio());
    }

    @Test
    void testIndexOf() {
        cola.agregar(100);
        cola.agregar(200);
        cola.agregar(300);

        assertEquals(1, cola.indexOf(200)); // posición del 200
        assertEquals(-1, cola.indexOf(400)); // no existe
    }
}