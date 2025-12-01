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
public class PilaTest {
    
    private Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new Pila<>();
    }

    @Test
    void testPush() {
        pila.agregar(10); // push
        pila.agregar(20);
        assertEquals(2, pila.tamanio());
        assertFalse(pila.vacio());
    }

    @Test
    void testPop() throws Exception {
        pila.agregar(10);
        pila.agregar(20);
        int dato = pila.eliminar(); // pop
        assertEquals(20, dato); // ultimo insertado
        assertEquals(1, pila.tamanio());
    }

    @Test
    void testPeek() throws Exception {
        pila.agregar(10);
        pila.agregar(30);
        // peek: mirar el tope sin quitarlo
        int tope = pila.obtener(0); 
        assertEquals(30, tope);
        assertEquals(2, pila.tamanio()); // sigue con 2 elementos
    }

    @Test
    void testEliminarHastaVacio() throws Exception {
        pila.agregar(5);
        pila.agregar(15);
        pila.eliminar();
        pila.eliminar();
        assertTrue(pila.vacio());
    }

    @Test
    void testIndexOf() {
        pila.agregar(100);
        pila.agregar(200);
        pila.agregar(300);
        assertEquals(1, pila.indexOf(200)); // posicion del 200
        assertEquals(-1, pila.indexOf(400)); // no existe
    }
}