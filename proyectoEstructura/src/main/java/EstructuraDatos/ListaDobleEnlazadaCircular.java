/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 * ListaDobleEnlazadaCircular.java
 * 
 * Implementacion generica de una lista doblemente enlazada circular.
 * El ultimo nodo apunta al primero y el primero al ultimo.
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 * 
 * @param <T> Parametro de tipo para los objetos a almacenarse
 * en la lista doblemente enlazada circular
 */
public class ListaDobleEnlazadaCircular<T> implements ILista<T> {
    protected NodoDoble<T> inicio;
    protected int nElementos;

    public ListaDobleEnlazadaCircular() {
        inicio = null;
        nElementos = 0;
    }

    @Override
    public void agregar(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (inicio == null) {
            inicio = nuevo;
            inicio.setSig(inicio);
            inicio.setAnt(inicio);
        } else {
            NodoDoble<T> ultimo = inicio.getAnt();
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            nuevo.setSig(inicio);
            inicio.setAnt(nuevo);
        }
        nElementos++;
    }

    @Override
    public void insertar(T dato, int posicion) throws Exception {
        if (posicion < 0 || posicion > nElementos) {
            throw new Exception("Índice fuera de rango");
        }
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (inicio == null) {
            inicio = nuevo;
            inicio.setSig(inicio);
            inicio.setAnt(inicio);
        } else if (posicion == 0) {
            NodoDoble<T> ultimo = inicio.getAnt();
            nuevo.setSig(inicio);
            nuevo.setAnt(ultimo);
            ultimo.setSig(nuevo);
            inicio.setAnt(nuevo);
            inicio = nuevo;
        } else if (posicion == nElementos) {
            NodoDoble<T> ultimo = inicio.getAnt();
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            nuevo.setSig(inicio);
            inicio.setAnt(nuevo);
        } else {
            NodoDoble<T> actual = inicio;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSig();
            }
            NodoDoble<T> anterior = actual.getAnt();
            anterior.setSig(nuevo);
            nuevo.setAnt(anterior);
            nuevo.setSig(actual);
            actual.setAnt(nuevo);
        }
        nElementos++;
    }

    @Override
    public T obtener(int posicion) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de rango");

        NodoDoble<T> actual = inicio;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSig();
        }
        return actual.getDato();
    }

    @Override
    public T eliminar(int posicion) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de rango");

        NodoDoble<T> eliminado;
        if (nElementos == 1) {
            eliminado = inicio;
            inicio = null;
        } else if (posicion == 0) {
            eliminado = inicio;
            NodoDoble<T> ultimo = inicio.getAnt();
            inicio = inicio.getSig();
            inicio.setAnt(ultimo);
            ultimo.setSig(inicio);
        } else {
            NodoDoble<T> actual = inicio;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSig();
            }
            eliminado = actual;
            NodoDoble<T> anterior = actual.getAnt();
            NodoDoble<T> siguiente = actual.getSig();
            anterior.setSig(siguiente);
            siguiente.setAnt(anterior);
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

    @Override
    public String toString() {
        if (vacio()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        NodoDoble<T> actual = inicio;
        for (int i = 0; i < nElementos; i++) {
            sb.append(actual.getDato());
            if (i < nElementos - 1) sb.append(", ");
            actual = actual.getSig();
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int indexOf(T dato) {
        if (vacio()) return -1;
        NodoDoble<T> actual = inicio;
        for (int i = 0; i < nElementos; i++) {
            if (actual.getDato().equals(dato)) return i;
            actual = actual.getSig();
        }
        return -1;
    }
}