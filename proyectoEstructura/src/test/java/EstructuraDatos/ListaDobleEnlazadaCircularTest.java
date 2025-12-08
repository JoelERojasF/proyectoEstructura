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
public class ListaDobleEnlazadaCircularTest {
    
    private ListaDobleEnlazadaCircular<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaDobleEnlazadaCircular<>();
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
    void testInsertarInicio() throws Exception {
        lista.agregar(20);
        lista.insertar(10, 0); // insertar al inicio
        assertEquals("[10, 20]", lista.toString());
    }

    @Test
    void testInsertarMedio() throws Exception {
        lista.agregar(10);
        lista.agregar(30);
        lista.insertar(20, 1); // insertar en medio
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    void testInsertarFinal() throws Exception {
        lista.agregar(10);
        lista.agregar(20);
        lista.insertar(30, 2); // insertar al final
        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    void testObtener() throws Exception {
        lista.agregar(100);
        lista.agregar(200);
        lista.agregar(300);
        assertEquals(100, lista.obtener(0));
        assertEquals(200, lista.obtener(1));
        assertEquals(300, lista.obtener(2));
    }

    @Test
    void testEliminarInicio() throws Exception {
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        int eliminado = lista.eliminar(0);
        assertEquals(10, eliminado);
        assertEquals("[20, 30]", lista.toString());
    }

    @Test
    void testEliminarMedio() throws Exception {
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        int eliminado = lista.eliminar(1);
        assertEquals(20, eliminado);
        assertEquals("[10, 30]", lista.toString());
    }

    @Test
    void testEliminarFinal() throws Exception {
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        int eliminado = lista.eliminar(2);
        assertEquals(30, eliminado);
        assertEquals("[10, 20]", lista.toString());
    }

    @Test
    void testIndexOf() {
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        assertEquals(1, lista.indexOf(20));
        assertEquals(-1, lista.indexOf(40));
    }

    @Test
    void testCircularidad() throws Exception {
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);

        NodoDoble<Integer> ultimo = lista.inicio.getAnt();

        // Comprobar que inicio apunta al último con ant
        assertEquals(3, lista.inicio.getAnt().getDato());

        // Comprobar que el último apunta al inicio con sig
        assertEquals(1, ultimo.getSig().getDato());
    }
}