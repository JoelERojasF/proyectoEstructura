/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

/**
 *
 * @author Joel Eduardo Rojas Fuentes
 * 
 * @param <T> Parametro de tipo para los objetos a almacenarse
 * en el Nodo Simple
 */
public class NodoSimple<T> {
        private T dato;
        private NodoSimple<T> sig;

        public NodoSimple(T dato) {
            this.dato = dato;
        }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoSimple<T> getSig() {
        return sig;
    }

    public void setSig(NodoSimple<T> sig) {
        this.sig = sig;
    }
        
        
}
