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
public class ArbolAVLTest {
    
    private ArbolAVL<Integer> arbol;

    @BeforeEach
    void setUp() {
        arbol = new ArbolAVL<>();
    }

    @Test
    void testInsertarBalanceLL() {
        // Caso LL: insertar en orden descendente
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(10);

        // El árbol debe balancearse con una rotación derecha
        String resultado = arbol.toString();
        assertTrue(resultado.contains("20")); // nueva raíz
        assertTrue(resultado.contains("10"));
        assertTrue(resultado.contains("30"));
    }

    @Test
    void testInsertarBalanceRR() {
        // Caso RR: insertar en orden ascendente
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);

        // El árbol debe balancearse con una rotación izquierda
        String resultado = arbol.toString();
        assertTrue(resultado.contains("20")); // nueva raíz
        assertTrue(resultado.contains("10"));
        assertTrue(resultado.contains("30"));
    }

    @Test
    void testInsertarBalanceLR() {
        // Caso LR: primero izquierda, luego derecha
        arbol.insertar(30);
        arbol.insertar(10);
        arbol.insertar(20);

        // El árbol debe balancearse con rotación izquierda-derecha
        String resultado = arbol.toString();
        assertTrue(resultado.contains("20")); // nueva raíz
        assertTrue(resultado.contains("10"));
        assertTrue(resultado.contains("30"));
    }

    @Test
    void testInsertarBalanceRL() {
        // Caso RL: primero derecha, luego izquierda
        arbol.insertar(10);
        arbol.insertar(30);
        arbol.insertar(20);

        // El árbol debe balancearse con rotación derecha-izquierda
        String resultado = arbol.toString();
        assertTrue(resultado.contains("20")); // nueva raíz
        assertTrue(resultado.contains("10"));
        assertTrue(resultado.contains("30"));
    }

    @Test
    void testAlturaYFactorBalance() {
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        // El árbol debe estar balanceado
        int alturaRaiz = arbol.altura(arbol.raiz);
        assertTrue(alturaRaiz <= 3); // altura balanceada para 7 nodos
    }  
}