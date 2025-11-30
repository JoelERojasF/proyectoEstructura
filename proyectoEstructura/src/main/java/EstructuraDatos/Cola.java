/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 *
 * @author le0jx
 */
public class Cola<T> implements ILista<T>{
    protected NodoSimple<T> inicio;
    protected int nElementos;

    public Cola() {
        inicio = null;
        nElementos =0;
    }
    
    @Override
    public void agregar(T dato) {
       NodoSimple<T> nodoNuevo = new NodoSimple<>(dato);
       if(inicio == null) inicio= nodoNuevo;
    }

    @Override
    public void insertar(T dato, int posicion) throws Exception {
        //no se debe poder insertar en una posicion en una cola
        agregar(dato);
    }

    @Override
    public T obtener(int posicion) throws Exception {
        if (vacio()) throw new Exception("Lista vacía");
        if (posicion < 0 || posicion >= nElementos) throw new Exception("Índice fuera de límites");
        
        NodoSimple<T> nodo = inicio;
        for(int i=1; i < posicion; i++){
            nodo = nodo.getSig();
        }
        return nodo.getDato();
    }

    @Override
    public T eliminar(int posicion) throws Exception {
        //solo se puede eliminar el nodo inferior en una cola
        return eliminar();
    }
    
    public T eliminar() throws Exception {
        NodoSimple<T> nodo = inicio;
        T dato = null;
        while(nodo.getSig().getSig() != null){
            nodo = nodo.getSig();
        }
        dato = nodo.getSig().getDato();
        nodo.setSig(null);
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
        int i=0;
            while (nodo != null) {
               i++;
               if(nodo.getDato().equals(dato)){
                   return i;
               }
               nodo = nodo.getSig();
        }    
        return 0;
    }
}
