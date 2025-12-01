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
public class ListaEnlazadaSimpleTest {
    
    private ListaEnlazadaSimple<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaEnlazadaSimple<>();
    }

    @Test
    void testAgregar() {
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        assertEquals(3, lista.tamanio());
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    void testAgregarInicio() {
        lista.agregar(10);
        lista.agregarInicio(5);
        assertEquals(2, lista.tamanio());
        assertEquals("[5, 10]", lista.toString());
    }

    @Test
    void testInsertar() throws Exception {
        lista.agregar(10);
        lista.agregar(30);
        lista.insertar(20, 1); // insertar en medio
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    void testObtener() throws Exception {
        lista.agregar(100);
        lista.agregar(200);
        lista.agregar(300);
        assertEquals(200, lista.obtener(1));
        assertEquals(300, lista.obtener(2));
    }

    @Test
    void testEliminar() throws Exception {
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        int eliminado = lista.eliminar(1); // elimina el "2"
        assertEquals(2, eliminado);
        assertEquals("[1, 3]", lista.toString());
    }

    @Test
    void testIndexOf() {
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        assertEquals(1, lista.indexOf(20)); // índice 0-based
        assertEquals(-1, lista.indexOf(40)); // no existe
    }

    @Test
    void testVacio() {
        assertTrue(lista.vacio());
        lista.agregar(99);
        assertFalse(lista.vacio());
    }
}