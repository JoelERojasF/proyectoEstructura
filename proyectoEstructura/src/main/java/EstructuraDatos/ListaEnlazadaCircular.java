/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 * ListaEnlazadaCircular.java
 * 
 * Esta clase implementa una Lista Enlazada Circular generica.
 * El ultimo nodo apunta siempre al primero, formando un ciclo.
 * 
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 * 
 * @param <T> Parametro de tipo para los objetos a almacenarse
 * en la lista enlazada simple
 */
public class ListaEnlazadaCircular<T> implements ILista<T>{
    protected NodoSimple<T> inicio;
    protected int nElementos;

    public ListaEnlazadaCircular() {
        inicio = null;
        nElementos = 0;
    }

    /**
     * Agrega un elemento al final de la lista.
     * @param dato Elemento a insertar.
     */
    @Override
    public void agregar(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato);
        if (inicio == null) {
            inicio = nuevo;
            inicio.setSig(inicio); // apunta a sí mismo
        } else {
            NodoSimple<T> actual = inicio;
            while (actual.getSig() != inicio) {
                actual = actual.getSig();
            }
            actual.setSig(nuevo);
            nuevo.setSig(inicio);
        }
        nElementos++;
    }

    /**
     * Inserta un elemento en una posición específica.
     * @param dato Elemento a insertar.
     * @param posicion Índice donde insertar (0 = inicio).
     * @throws Exception Si la posición es inválida.
     */
    @Override
    public void insertar(T dato, int posicion) throws Exception {
        if (posicion < 0 || posicion > nElementos) {
            throw new Exception("Índice fuera de rango");
        }
        NodoSimple<T> nuevo = new NodoSimple<>(dato);
        if (posicion == 0) {
            if (inicio == null) {
                inicio = nuevo;
                inicio.setSig(inicio);
            } else {
                NodoSimple<T> ultimo = inicio;
                while (ultimo.getSig() != inicio) {
                    ultimo = ultimo.getSig();
                }
                nuevo.setSig(inicio);
                inicio = nuevo;
                ultimo.setSig(inicio);
            }
        } else {
            NodoSimple<T> actual = inicio;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSig();
            }
            nuevo.setSig(actual.getSig());
            actual.setSig(nuevo);
        }
        nElementos++;
    }

    /**
     * Obtiene el elemento en una posición específica.
     * @param posicion Índice del elemento.
     * @return El dato en esa posición.
     * @throws Exception Si la posición es inválida.
     */
    @Override
    public T obtener(int posicion) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de rango");

        NodoSimple<T> actual = inicio;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSig();
        }
        return actual.getDato();
    }

    /**
     * Elimina el elemento en una posición específica.
     * @param posicion Índice del elemento a eliminar.
     * @return El dato eliminado.
     * @throws Exception Si la posición es inválida.
     */
    @Override
    public T eliminar(int posicion) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de rango");

        NodoSimple<T> eliminado;
        if (posicion == 0) {
            eliminado = inicio;
            if (nElementos == 1) {
                inicio = null;
            } else {
                NodoSimple<T> ultimo = inicio;
                while (ultimo.getSig() != inicio) {
                    ultimo = ultimo.getSig();
                }
                inicio = inicio.getSig();
                ultimo.setSig(inicio);
            }
        } else {
            NodoSimple<T> actual = inicio;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSig();
            }
            eliminado = actual.getSig();
            actual.setSig(eliminado.getSig());
        }
        nElementos--;
        return eliminado.getDato();
    }

    @Override
    public boolean vacio() {
        return inicio == null;
    }

    @Override
    public int tamanio() {
        return nElementos;
    }

    /**
     * Devuelve una representación textual de la lista circular.
     * @return Cadena con los elementos en orden.
     */
    @Override
    public String toString() {
        if (vacio()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        NodoSimple<T> actual = inicio;
        for (int i = 0; i < nElementos; i++) {
            sb.append(actual.getDato());
            if (i < nElementos - 1) sb.append(", ");
            actual = actual.getSig();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Devuelve el indice de un dato en la lista.
     * @param dato Elemento a buscar.
     * @return Índice del elemento, o -1 si no se encuentra.
     */
    @Override
    public int indexOf(T dato) {
        if (vacio()) return -1;
        NodoSimple<T> actual = inicio;
        for (int i = 0; i < nElementos; i++) {
            if (actual.getDato().equals(dato)) return i;
            actual = actual.getSig();
        }
        return -1;
    }
}