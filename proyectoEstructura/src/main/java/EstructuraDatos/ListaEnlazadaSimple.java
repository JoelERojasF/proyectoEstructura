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
public class ListaEnlazadaSimple<T> implements Iterable<T>, ILista<T>{
    protected NodoSimple<T> inicio;
    protected int nElementos;


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
            T dato = nodoActual.getDato();
            nodoActual = nodoActual.getSig();
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
    public void agregar(T dato) {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(dato);
        if (inicio == null) {
            inicio = nodoNuevo;
        } else {
            NodoSimple<T> nodo = inicio;
            while (nodo.getSig() != null) {
                nodo = nodo.getSig();
            }
            nodo.setSig(nodoNuevo);
        }
        nElementos++;
    }

    /**
     * Inserta un elemento en la posición de la lista
     */
    public void insertar(T dato, int posicion) throws Exception {
        if (posicion < 0 || posicion > nElementos) {
            throw new Exception("Índice fuera de límites");
        }
        NodoSimple<T> nodoNuevo = new NodoSimple<>(dato);
        if (posicion == 0) {
            nodoNuevo.setSig(inicio);
            inicio = nodoNuevo;
        } else {
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < posicion - 1; j++) {
                nodo = nodo.getSig();
            }
            nodoNuevo.setSig(nodo.getSig());
            nodo.setSig(nodoNuevo);
        }
        nElementos++;
    }

    /**
     * Obtiene el elemento en la posición sin eliminarlo
     */
    public T obtener(int posicion) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de límites");

        NodoSimple<T> nodo = inicio;
        for (int j = 0; j < posicion; j++) {
            nodo = nodo.getSig();
        }
        return nodo.getDato();
    }

    /**
     * Elimina el elemento en la posición y lo regresa
     */
    public T eliminar(int posicion) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de límites");

        T dato;
        if (posicion == 0) {
            dato = inicio.getDato();
            inicio = inicio.getSig();
        } else {
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < posicion - 1; j++) {
                nodo = nodo.getSig();
            }
            dato = nodo.getSig().getDato();
            nodo.setSig(nodo.getSig().getSig());
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
            s += nodo.getDato();
            if (nodo.getSig() != null) {
                s += ", ";
            }
            nodo = nodo.getSig();
        }
        s += "]";
        return s;
    }
    
    
    @Override
    public int indexOf(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
