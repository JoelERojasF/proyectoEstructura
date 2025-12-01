/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 * Pila.java
 * 
 * Esta clase implementa una Pila
 * 
 * @author Joel Eduardo Rojas Fuentes
 * 
 * @param <T> Parametro de tipo para los objetos a almacenarse
 * en la Pila
 */
public class Pila<T> implements ILista<T>{
    protected NodoSimple<T> inicio;
    protected int nElementos;

    public Pila() {
        inicio = null;
        nElementos =0;
    }
    /**
     * Metodo equivalente a push() en una pila,
     * Inserta un nuevo nodo en el tope de la pila
     * @param dato 
     */
    @Override
    public void agregar(T dato) {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(dato);
        if(inicio == null) inicio = nodoNuevo;
        else{
            nodoNuevo.setSig(inicio);
            inicio = nodoNuevo;
        }
        nElementos++;
    }

    @Override
    public T obtener(int posicion) throws Exception {
        if (vacio()) throw new Exception("Pila vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de límites");

        NodoSimple<T> nodo = inicio;
        for (int i = 0; i < posicion; i++) {
            nodo = nodo.getSig();
        }
        return nodo.getDato();
    }

    /**
     * Metodo equivalente a pop() en una pila,
     * Quita y devuelve el nodo en el tope de la pila
     * 
     * @return null si la lista esta vacia,
     *         dato si
     * @throws Exception 
     */
    public T eliminar() throws Exception{
        if (vacio()) throw new Exception("Pila vacía");
        T dato = null;
        dato = inicio.getDato();
        inicio = inicio.getSig();
        
        nElementos--;
        return dato;
    }
    
    public T peek() throws Exception {
        if (vacio()) throw new Exception("Pila vacía");
        return inicio.getDato();
    }

    @Override
    public boolean vacio() {
        return inicio == null;
    }

    @Override
    public int tamanio() {
        return nElementos;
    }
    
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
    
    // Metodos forzados por ILista
    @Override
    public void insertar(T dato, int posicion) throws Exception {
        //no se debe poder insertar en una posicion en una pila
        agregar(dato);
    }
    
    @Override
    public T eliminar(int posicion) throws Exception {
        //solo se puede eliminar el nodo superior en una pila
        return eliminar();
    }
}
