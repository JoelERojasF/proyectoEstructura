/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

import java.util.Iterator;

/**
 *
 * @author le0jx
 */
public class ListaDobleEnlazadaCircular<T> implements ILista<T> {
    protected NodoDoble<T> inicio;
    protected int nElementos;

    public ListaDobleEnlazadaCircular() {
        inicio = null;
        nElementos = 0;
    }
    
    public void agregar(T dato){
        NodoDoble<T> nodoNuevo = new NodoDoble<>(dato);
        if(inicio == null){
            inicio = nodoNuevo;
        }else{
            NodoDoble<T> nodo = inicio;
            insertar(dato, nElementos);
        }
    }
    
    public void insertar(T dato, int posicion){
    
    }
    
    public T obtener(int posicion){
    return null;
    }
    
    public T eliminar(int posicion){
        return null;
    }
    
    public boolean vacio(){
        return inicio == null;
    }
    
    public int tamanio(){
        return nElementos;
    }
    
    public String toString(){
        return null;
    }

    @Override
    public int indexOf(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
