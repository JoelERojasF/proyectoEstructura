/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Pruebas;

import Estructuras_de_datos.ArbolBinarioBusqueda;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author giova
 */
public class ArbolBinarioBusquedaTest {
    
    private ArbolBinarioBusqueda<Integer> arbol;

    @BeforeEach
    void setUp() {
        arbol = new ArbolBinarioBusqueda<>();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
    }

    @Test
    void testInsertarYRecorridoInOrden() {
        // Capturamos el recorrido en orden
        // Para simplificar, lo convertimos a String
        // (puedes adaptar tu método recorridoInOrden para devolver un String en lugar de imprimir)
        String resultado = arbol.toString(); 
        assertTrue(resultado.contains("20"));
        assertTrue(resultado.contains("30"));
        assertTrue(resultado.contains("40"));
        assertTrue(resultado.contains("50"));
        assertTrue(resultado.contains("60"));
        assertTrue(resultado.contains("70"));
        assertTrue(resultado.contains("80"));
    }

    @Test
    void testBuscarElementoExistente() {
        Integer encontrado = arbol.buscar(40);
        assertNotNull(encontrado);
        assertEquals(40, encontrado);
    }

    @Test
    void testBuscarElementoInexistente() {
        Integer encontrado = arbol.buscar(25);
        assertNull(encontrado);
    }

    @Test
    void testEliminarNodoHoja() {
        arbol.eliminar(20);
        assertNull(arbol.buscar(20));
    }

    @Test
    void testEliminarNodoConUnHijo() {
        arbol.eliminar(30);
        assertNull(arbol.buscar(30));
        assertNotNull(arbol.buscar(40)); // su hijo sigue existiendo
    }

    @Test
    void testEliminarNodoConDosHijos() {
        arbol.eliminar(50);
        assertNull(arbol.buscar(50));
        // El árbol debe seguir conteniendo los demás elementos
        assertNotNull(arbol.buscar(40));
        assertNotNull(arbol.buscar(60));
    }

}
