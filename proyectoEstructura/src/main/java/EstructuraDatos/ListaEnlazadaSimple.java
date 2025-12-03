/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 * ListaEnlazadaSimple.java
 *
 * Implementa una lista dinámica sobre una lista enlazada simple.
 *
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 *
 * @param <T> Tipo del dato almacenado
 * en la lista enlazada simple
 */
public class ListaEnlazadaSimple<T> implements Iterable<T>, ILista<T> {
    protected NodoSimple<T> inicio;
    protected int nElementos;

    /**
     * Clase interna que representa un iterador para la lista
     */
    private class ListIterator implements java.util.Iterator<T> {
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
     * Inserta un elemento al inicio de la lista
     * 
     * @param dato 
     */
    public void agregarInicio(T dato) {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(dato);
        nodoNuevo.setSig(inicio); // el nuevo apunta al antiguo inicio
        inicio = nodoNuevo; // ahora el nuevo es el inicio
        nElementos++;
    }

    /**
     * Inserta un elemento al final de la lista como agregarFinal().
     * 
     * @param dato 
     */
    @Override
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
     * Inserta un elemento en la posición de la lista como agregarPos()
     * 
     * @param dato
     * @param posicion
     * @throws Exception 
     */
    @Override
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
     * Obtiene el elemento en la posición sin eliminarlo.
     * 
     * @param posicion
     * @return
     * @throws Exception 
     */
    @Override
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
     * Elimina el elemento en la posición y lo regresa.
     * 
     * @param posicion
     * @return
     * @throws Exception 
     */
    @Override
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
     * Determina si la lista está vacía,
     * 
     * @return true si inicio apunta a null,
     *         false si inicio apunta a otra cosa
     */
    @Override
    public boolean vacio() {
        return inicio == null;
    }
    
    /**
     * Regresa el número de elementos en la lista.
     * 
     * @return nElementos
     */
    @Override
    public int tamanio() {
        return nElementos;
    }

    /**
     * Regresa un iterador para recorrer la lista.
     * 
     * @return 
     */
    @Override
    public java.util.Iterator<T> iterator() {
        return new ListIterator(inicio);
    }

    /**
     * Genera una cadena con los valores de los elementos de la lista.
     * 
     * @return String formateado
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodoSimple<T> nodo = inicio;
        while (nodo != null) {
            sb.append(nodo.getDato());
            if (nodo.getSig() != null) {
                sb.append(", ");
            }
            nodo = nodo.getSig();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Devuelve el índice de un dato en la lista
     * @param dato Elemento a buscar
     * @return índice del elemento o -1 si no se encuentra
     */
    @Override
    public int indexOf(T dato) {
        NodoSimple<T> nodo = inicio;
        int i = 0;
        while (nodo != null) {
            if (nodo.getDato().equals(dato)) {
                return i;
            }
            nodo = nodo.getSig();
            i++;
        }
        return -1;
    }
}