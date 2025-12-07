/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * CursoNoEncontradoException.java
 *
 * Se lanza cuando no se encuentra un curso con la clave especificada.
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class CursoNoEncontradoException extends Exception{
    public CursoNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
