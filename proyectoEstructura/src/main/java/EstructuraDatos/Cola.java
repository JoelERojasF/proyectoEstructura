/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 * Esta clase implementa una Cola Generica
 * 
 * @author Joel Eduardo Rojas Fuentes
 * 
 * @param <T> Parametro de tipo para los objetos a almacenarse
 * en la Cola
 */
public class Cola<T> implements ILista<T>{
    protected NodoSimple<T> inicio;
    protected int nElementos;

    public Cola() {
        inicio = null;
        nElementos =0;
    }
    /**
     * Metodo que agrega un dato al final de la Cola,
     * es el equivalente a encolar()
     * 
     * @param dato 
     */
    @Override
    public void agregar(T dato) {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(dato);
        if (inicio == null) {
            inicio = nodoNuevo;
        } else {
            NodoSimple<T> actual = inicio;
            while (actual.getSig() != null) {
                actual = actual.getSig();
            }
            actual.setSig(nodoNuevo);
        }
        nElementos++;
    }

    /**
     *
     * @param posicion
     * @return
     * @throws Exception
     */
    @Override
    public T obtener(int posicion) throws Exception {
        if (vacio()) throw new Exception("Cola vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de límites");

        NodoSimple<T> nodo = inicio;
        for (int i = 0; i < posicion; i++) {
            nodo = nodo.getSig();
        }
        return nodo.getDato();
    }
    /**
     * Metodo que elimina el primer dato que haya en la Cola,
     * equivalente a desencolar()
     * 
     * @return
     * @throws Exception 
     */
    public T eliminar() throws Exception {
        if (vacio()) throw new Exception("Cola vacía");
        T dato = inicio.getDato();
        inicio = inicio.getSig();
        nElementos--;
        return dato;
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
     *
     * @return
     */
    @Override
    public String toString(){
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
        NodoSimple<T> nodo = inicio;
        int i = 0;
        while (nodo != null) {
            if (nodo.getDato().equals(dato)) {
                return i; 
            }
            nodo = nodo.getSig();
            i++;
        }
        return -1; // mejor que devolver 0 si no existe
    }

    
    // Metodos forzados por ILista
    @Override
    public void insertar(T dato, int posicion) throws Exception {
        //no se debe poder insertar en una posicion en una cola
        agregar(dato);
    }
    
    @Override
    public T eliminar(int posicion) throws Exception {
        //solo se puede eliminar el nodo inferior en una cola
        return eliminar();
    }
}
