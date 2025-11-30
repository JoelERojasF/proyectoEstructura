/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EstructuraDatos;

/**
 *
 * @author le0jx
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
