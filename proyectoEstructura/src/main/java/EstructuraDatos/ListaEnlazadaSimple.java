/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 *
 * @author Franco Giovanny Gastelum Barcelo
 */

/**
 * ListaEnlazadaSimple.java
 *
 * Implementa una lista dinámica sobre una lista enlazada simple.
 *
 * @param <T> Tipo del dato almacenado
 */
public class ListaEnlazadaSimple<T> implements Iterable<T> {
    protected NodoSimple<T> inicio;
    protected int nElementos;

    /**
     * Clase interna que representa un nodo de la lista enlazada
     */
    private class NodoSimple<T> {
        private T dato;
        private NodoSimple<T> sig;

        public NodoSimple(T dato) {
            this.dato = dato;
        }
    }

    /**
     * Clase interna que representa un iterador para la lista
     */
    private class ListIterator<T> implements java.util.Iterator<T> {
        private NodoSimple<T> nodoActual;

        public ListIterator(NodoSimple<T> inicio) {
            nodoActual = inicio;
        }

        @Override
        public boolean hasNext() {
            return nodoActual != null;
        }

        @Override
        public T next() {
            T dato = nodoActual.dato;
            nodoActual = nodoActual.sig;
            return dato;
        }
    }

    /**
     * Constructor: inicializa la lista vacía
     */
    public ListaEnlazadaSimple() {
        inicio = null;
        nElementos = 0;
    }

    /**
     * Inserta un elemento al final de la lista
     */
    public void agregar(T o) {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        if (inicio == null) {
            inicio = nodoNuevo;
        } else {
            NodoSimple<T> nodo = inicio;
            while (nodo.sig != null) {
                nodo = nodo.sig;
            }
            nodo.sig = nodoNuevo;
        }
        nElementos++;
    }

    /**
     * Inserta un elemento en la posición i de la lista
     */
    public void insertar(T o, int i) throws Exception {
        if (i < 0 || i > nElementos) {
            throw new Exception("Índice fuera de límites");
        }
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        if (i == 0) {
            nodoNuevo.sig = inicio;
            inicio = nodoNuevo;
        } else {
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.sig;
            }
            nodoNuevo.sig = nodo.sig;
            nodo.sig = nodoNuevo;
        }
        nElementos++;
    }

    /**
     * Obtiene el elemento en la posición i sin eliminarlo
     */
    public T obtener(int i) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (i < 0 || i >= nElementos) throw new Exception("Índice fuera de límites");

        NodoSimple<T> nodo = inicio;
        for (int j = 0; j < i; j++) {
            nodo = nodo.sig;
        }
        return nodo.dato;
    }

    /**
     * Elimina el elemento en la posición i y lo regresa
     */
    public T eliminar(int i) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (i < 0 || i >= nElementos) throw new Exception("Índice fuera de límites");

        T dato;
        if (i == 0) {
            dato = inicio.dato;
            inicio = inicio.sig;
        } else {
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.sig;
            }
            dato = nodo.sig.dato;
            nodo.sig = nodo.sig.sig;
        }
        nElementos--;
        return dato;
    }

    /**
     * Determina si la lista está vacía
     */
    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Regresa el número de elementos en la lista
     */
    public int tamanio() {
        return nElementos;
    }

    /**
     * Regresa un iterador para recorrer la lista
     */
    @Override
    public java.util.Iterator<T> iterator() {
        return new ListIterator<>(inicio);
    }

    /**
     * Genera una cadena con los valores de los elementos de la lista
     */
    @Override
    public String toString() {
        String s = "[";
        NodoSimple<T> nodo = inicio;
        while (nodo != null) {
            s += nodo.dato;
            if (nodo.sig != null) {
                s += ", ";
            }
            nodo = nodo.sig;
        }
        s += "]";
        return s;
    }
}
