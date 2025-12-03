/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EstructuraDatos;

/**
 * Esta clase ayuda a indicar a las clases de subtipo Lista
 * que metodos mayormente deben tener.
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 * 
 * @param <T>
 */
public interface ILista<T> {
    public void agregar(T dato);
    public void insertar(T dato, int posicion)  throws Exception;
    public T obtener(int posicion)  throws Exception;
    public T eliminar(int posicion)  throws Exception;
    public boolean vacio();
    public int tamanio();
    public String toString();
    public int indexOf(T dato);
}