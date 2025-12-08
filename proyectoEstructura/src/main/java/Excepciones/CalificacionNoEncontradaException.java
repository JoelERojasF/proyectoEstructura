/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * CalificacionNoEncontradaException.java
 * 
 * Se lanza cuando se intenta revertir una calificación inexistente.
 * 
 * @author Franco Giovanny Gastelum Barcelo
 */
public class CalificacionNoEncontradaException extends Exception{
    public CalificacionNoEncontradaException(String mensaje){
        super(mensaje);
    }
}
