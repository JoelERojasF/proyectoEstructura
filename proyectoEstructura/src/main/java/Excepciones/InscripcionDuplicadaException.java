/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * InscripcionDuplicadaException.java
 * 
 * Se lanza cuando un estudiante ya está inscrito en el curso.
 * 
 * @author Franco Giovanny Gastelum Barcelo
 */
public class InscripcionDuplicadaException extends Exception{
    public InscripcionDuplicadaException(String mensaje){
        super(mensaje);
    }
}
