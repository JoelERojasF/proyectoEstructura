/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/*
* Esta clase cumple con el requisito de reutilizacion y genericidad
*/
/**
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolBinarioBusqueda<T> {

    @Override
    public void insertar(T dato) {
        raiz = insertar(raiz, dato);
    }

    private NodoArbolBinario<T> insertar(NodoArbolBinario<T> nodo, T dato) {
        if (nodo == null) return new NodoArbolBinario<>(dato);

        if (dato.compareTo(nodo.dato) < 0) nodo.hijoIzq = insertar(nodo.hijoIzq, dato);
        else nodo.hijoDer = insertar(nodo.hijoDer, dato);

        return reBalancear(nodo);
    }

    private NodoArbolBinario<T> reBalancear(NodoArbolBinario<T> nodo) {
        int factorBalance = factorBalance(nodo);

        if (factorBalance < -1) {
            if (factorBalance(nodo.hijoIzq) < 0) nodo = rotacionDerecha(nodo); // LL
            else nodo = rotacionIzquierdaDerecha(nodo); // LR
        } else if (factorBalance > 1) {
            if (factorBalance(nodo.hijoDer) > 0) nodo = rotacionIzquierda(nodo); // RR
            else nodo = rotacionDerechaIzquierda(nodo); // RL
        }
        return nodo;
    }

    private int factorBalance(NodoArbolBinario<T> nodo) {
        if (nodo == null) return 0;
        return altura(nodo.hijoDer) - altura(nodo.hijoIzq);
    }

    private NodoArbolBinario<T> rotacionDerecha(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> nodoT = nodo.hijoIzq;
        nodo.hijoIzq = nodoT.hijoDer;
        nodoT.hijoDer = nodo;
        return nodoT;
    }

    private NodoArbolBinario<T> rotacionIzquierda(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> nodoT = nodo.hijoDer;
        nodo.hijoDer = nodoT.hijoIzq;
        nodoT.hijoIzq = nodo;
        return nodoT;
    }

    private NodoArbolBinario<T> rotacionIzquierdaDerecha(NodoArbolBinario<T> nodo) {
        nodo.hijoIzq = rotacionIzquierda(nodo.hijoIzq);
        return rotacionDerecha(nodo);
    }

    private NodoArbolBinario<T> rotacionDerechaIzquierda(NodoArbolBinario<T> nodo) {
        nodo.hijoDer = rotacionDerecha(nodo.hijoDer);
        return rotacionIzquierda(nodo);
    }

    @Override
    public String toString() {
        return "[" + toStringInOrden(raiz) + "]";
    }

    private String toStringInOrden(NodoArbolBinario<T> nodo) {
        if (nodo == null) return "";
        return toStringInOrden(nodo.hijoIzq)
             + "(" + nodo.dato + ", " + altura(nodo) + ", " + factorBalance(nodo) + "), "
             + toStringInOrden(nodo.hijoDer);
    }
}