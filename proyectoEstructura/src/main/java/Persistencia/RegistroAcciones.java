/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.Pila;
import ObjetosNegocio.Accion;
import ObjetosNegocio.Estudiante;
import java.util.NoSuchElementException;

/**
 *
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroAcciones {
    private Pila<Accion> acciones = new Pila<>();
    
    public void registrarAccion(Accion accion){
        acciones.agregar(accion);
    }
    
    public Accion deshacerUltimaAccion() throws Exception{
    if (acciones.vacio()) {
            throw new NoSuchElementException("No hay solicitudes pendientes");
        }

            Accion ultima = acciones.eliminar();
            ultima.revertir();
//            System.out.println("Se deshizo la accion: " + ultima);
            return ultima;
    }
    
    public Estudiante getEstudianteUltimaAccion() {
        if (acciones.vacio()) return null;
        try {
            return ultimaAccion().getEstudiante();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Accion ultimaAccion() throws Exception{
        return acciones.obtener(0);
    }
    
    public boolean vacio(){
        return acciones.vacio();
    }
    
    public int tamanio(){
        return acciones.tamanio();
    }
    
    
}
