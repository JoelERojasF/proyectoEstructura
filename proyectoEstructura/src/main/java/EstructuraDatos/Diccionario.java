/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDatos;

import ObjetosNegocio.Curso;
import java.util.Iterator;
/**
 * Clase Diccionario genérico implementado con tabla hash y manejo de colisiones
 * mediante listas enlazadas simples (separate chaining).
 * 
 * @param <K> Tipo de la clave (debe implementar hashCode y equals correctamente).
 * @param <V> Tipo del valor asociado a la clave.
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Diccionario<K, V> {
    private ListaEnlazadaSimple<Entrada<K,V>>[] tabla;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public Diccionario(int capacidad) {
        this.capacidad = capacidad;
        tabla = new ListaEnlazadaSimple[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new ListaEnlazadaSimple<>();
        }
    }

    private int hash(K clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void put(K clave, V valor) {
        if(tamanio() == capacidad){
            redimensionar();
        }
        
        int indice = hash(clave);
        for (Entrada<K,V> e : tabla[indice]) { 
            if (e.getClave().equals(clave)) {
                e.setValor(valor);
                return;
            }
        }
        tabla[indice].agregar(new Entrada<>(clave, valor));
    }

    public V get(K clave) {
        int indice = hash(clave);
        for (Entrada<K,V> e : tabla[indice]) {
            if (e.getClave().equals(clave)) {
                return e.getValor();
            }
        }
        return null;
    }

    public void remove(K clave) throws Exception {
        int indice = hash(clave);
        int pos = 0;
        for (Entrada<K,V> e : tabla[indice]) {
            if (e.getClave().equals(clave)) {
                tabla[indice].eliminar(pos);
                return;
            }
            pos++;
        }
    }

    public ListaEnlazadaSimple<V> obtenerTodos() {
        ListaEnlazadaSimple<V> lista = new ListaEnlazadaSimple<V>();
        for (int i = 0; i < capacidad; i++) {
            for (Entrada<K,V> e : tabla[i]) {
               lista.agregar(e.valor);
            }
        }
        return lista;
    }
    
    public int tamanio() {
        int total = 0;
        for (int i = 0; i < capacidad; i++) {
            for (Entrada<K,V> e : tabla[i]) {
                total++;
            }
        }

        return total;
    }
    
    private void redimensionar() {
        int nuevaCapacidad = capacidad +1;

        ListaEnlazadaSimple<Entrada<K, V>>[] nuevaTabla = new ListaEnlazadaSimple[nuevaCapacidad];

        for (int i = 0; i < nuevaCapacidad; i++) {
            nuevaTabla[i] = new ListaEnlazadaSimple<>();
        }

        for (int i = 0; i < capacidad; i++) {
            for (Entrada<K, V> entrada : tabla[i]) {
                int nuevoIndice = Math.abs(entrada.getClave().hashCode()) % nuevaCapacidad;
                nuevaTabla[nuevoIndice].agregar(entrada);
            }
        }

        tabla = nuevaTabla;
        capacidad = nuevaCapacidad;
    }

    // Clase interna Entrada
    private static class Entrada<K,V> {
        private K clave;
        private V valor;

        public Entrada(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        public K getClave() { return clave; }
        public V getValor() { return valor; }
        public void setValor(V valor) { this.valor = valor; }

        @Override
        public String toString() {
            return clave + " -> " + valor;
        }
    }
}
