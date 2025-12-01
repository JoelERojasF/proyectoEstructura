/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 * ArbolBinarioBusqueda.java
 * 
 * Esta clase implementa un arbol BST generico
 * 
 * @param <T> Parametro de tipo para almacenarse en el arbol
 * 
 * @author Franco Giovanny Gastelum Barcelo
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> {
    protected NodoArbolBinario<T> raiz;

    protected static class NodoArbolBinario<T> {
        T dato;
        NodoArbolBinario<T> hijoIzq, hijoDer;

        NodoArbolBinario(T dato) { 
            this.dato = dato;
        }
    }
    /**
    * Driver para el metodo recursivo para agregar un nodo al arbol
    * @param dato Dato del nodo a agregar al arbol
    */
    public void insertar(T dato) { 
        raiz = insertarRec(raiz, dato);
    }
    /**
    * Metodo recursivo para agregar un nodo al arbol
    * @param nodo Subarbol al que se le agrega recursivamente el
    * nodo
    * @param dato Dato del nodo a agregar al subarbol
    * @return Subarbol al que se le agrego recursivamente el nodo
    */
    private NodoArbolBinario<T> insertarRec(NodoArbolBinario<T> nodo, T dato) {
        if (nodo == null) return new NodoArbolBinario<>(dato);
        if (dato.compareTo(nodo.dato) < 0) nodo.hijoIzq = insertarRec(nodo.hijoIzq, dato);
        else nodo.hijoDer = insertarRec(nodo.hijoDer, dato);
        return nodo;
    }
    /**
    * Driver para el metodo recursivo para eliminar un nodo
    * del arbol
    * @param dato Dato a eliminar del arbol
    */
    public void eliminar(T dato) {
    raiz = eliminar(raiz, dato);
    }
    /**
    * Metodo recursivo para eliminar un nodo del arbol
    * @param nodo Subarbol del que se elimina recursivamente el
    * nodo
    * @return Subarbol del que se elimino recursivamente el nodo
    */
    private NodoArbolBinario<T> eliminar(NodoArbolBinario<T> nodo,
    T dato) {
        // Caso base
        // Si el nodo a borrar no esta en el subarbol
        if(nodo == null) {
            return null;
        }
        // Si es el nodo a borrar
        if(dato.compareTo(nodo.dato) == 0) {
        // Si el nodo a borrar es una hoja. Solo elimina el nodo
        if(nodo.hijoIzq == null && nodo.hijoDer== null) {
            return null;
        }
        // Si el nodo a borrar solo tiene el hijo derecho
        // sustituye el nodo a borrar por el subarbol derecho
        if(nodo.hijoIzq == null) {
            return nodo.hijoDer;
        }
        // Si el nodo a borrar solo tiene el hijo izquierdo
        // sustituye el nodo a borrar por el subarbol izquierdo
        if(nodo.hijoDer == null) {
            return nodo.hijoIzq;
        }
        // Si el nodo a borrar tiene ambos hijos
        // Encuentra el nodo con el dato mas pequeño que sea
        // mayor al dato del nodo a borrar. Es el nodo mas
        // a la izquierda del subarbol derecho
        NodoArbolBinario<T> nodoMenor = encontrarNodoMasPequeno(nodo.hijoDer);
        // Reemplaza el contenido del nodo a borrar por el
        // contenido del nodo mas pequeño que sea mayor al
        // nodo a borrar.
        nodo.dato = nodoMenor.dato;
        // Elimina recursivamente el nodo con el dato mas
        // pequeño que sea mayor al dato del nodo a borrar.
        nodo.hijoDer = eliminar(nodo.hijoDer, nodoMenor.dato);
        }
        // Casos recursivos
        // Se determina de que subarbol se eliminara el nodo
        if(dato.compareTo(nodo.dato) < 0) {
            nodo.hijoIzq = eliminar(nodo.hijoIzq, dato);
        }
        else {
            nodo.hijoDer = eliminar(nodo.hijoDer, dato);
        }
        return nodo;
    }
    /**
     * Metodo recursivo que regresa el nodo mas pequeno de un arbol, si el nodo
     * actual tiene un nodo hijoIzquierdo, no es el mas pequeno por lo que se 
     * llama recursivamente hasta que este no tenga hijoIzquierdo
     * @param nodo
     * @return nodo
     */
    protected NodoArbolBinario<T>
        encontrarNodoMasPequeno(NodoArbolBinario<T> nodo) {
        return nodo.hijoIzq == null? nodo: 
        encontrarNodoMasPequeno(nodo.hijoIzq);
    }
    /**
     * Driver para el metodo recursivo para buscar un dato de un nodo
     * @param dato
     * @return dato
     */
    public T buscar(T dato) {
        NodoArbolBinario<T> nodo = buscarRec(raiz, dato);
        return (nodo != null) ? nodo.dato : null;
    }
    /**
     * Metodo recursivo para buscar un dato de un nodo, si el dato es nulo 
     * regresa nulo,sino va comparando el dato del nodo actual con el dato
     * recibido, si es menor, busca en los hijos izquierdos,
     * si es mayor, busca en los hijos derechos
     * hasta que sean exactamente iguales
     * @param nodo
     * @param dato
     * @return null si el nodo esta vacio, nodo si encuentra al nodo con el dato
     * exacto
     */
    private NodoArbolBinario<T> buscarRec(NodoArbolBinario<T> nodo, T dato) {
        if (nodo == null) return null;
        int comparar = dato.compareTo(nodo.dato);
        if (comparar == 0) return nodo;
        else if (comparar < 0) return buscarRec(nodo.hijoIzq, dato);
        else return buscarRec(nodo.hijoDer, dato);
    }
    /**
     * Driver para el metodo recursivo que imprime los datos de los nodos de un
     * arbol en orden InOrder
     */
    public void recorridoInOrden() { 
        recorridoInOrdenRec(raiz);
    }
    /**
     * Imprime los datos de los nodos de un arbol BST en orden InOrden,
     * primero llega hasta el nodo mas a la izquierda del arbol e imprime,
     * despues imprime su nodo padre y despues imprime el hijo derecho,
     * SOLO IMPRIME EN CONSOLA.
     * 
     * @param nodo 
     */
    private void recorridoInOrdenRec(NodoArbolBinario<T> nodo) {
        if (nodo != null) {
            recorridoInOrdenRec(nodo.hijoIzq);
            System.out.println(nodo.dato);
            recorridoInOrdenRec(nodo.hijoDer);
        }
    }
    /**
     * Calcula la altura de un nodo dentro del arbol binario de búsqueda.
     * La altura se define como el numero maximo de niveles desde el nodo
     * dado hasta una hoja
     *
     * @param nodo El nodo del cual se desea calcular la altura
     *             Si es null, se considera que la altura es 0
     * @return Un numero entero que representa la altura del nodo:
     *         - 0 si el nodo es null.
     *         - 1 si el nodo es una hoja (sin hijos)
     *         - Un valor mayor si el nodo tiene descendientes
     */
    public int altura(NodoArbolBinario<T> nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.hijoIzq), altura(nodo.hijoDer));
    }
    public ListaEnlazadaSimple<T> obtenerTodos() {
        ListaEnlazadaSimple<T> lista = new ListaEnlazadaSimple<>();
        llenarListaInOrden(raiz, lista);
        return lista;
    }

    private void llenarListaInOrden(NodoArbolBinario<T> nodo, ListaEnlazadaSimple<T> lista) {
        if (nodo != null) {
            llenarListaInOrden(nodo.hijoIzq, lista);
            lista.agregar(nodo.dato); // en vez de imprimir, lo guardamos
            llenarListaInOrden(nodo.hijoDer, lista);
        }
    }

    @Override
    public String toString() {
        return "[" + toStringInOrden(raiz).trim() + "]";
    }

    private String toStringInOrden(NodoArbolBinario<T> nodo) {
        if (nodo == null) return "";
        return toStringInOrden(nodo.hijoIzq)
             + nodo.dato + " "
             + toStringInOrden(nodo.hijoDer);
    }
}