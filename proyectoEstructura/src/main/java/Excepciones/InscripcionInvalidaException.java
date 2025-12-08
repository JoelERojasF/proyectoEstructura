/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * InscripcionInvalidaException.java
 * 
 * Se lanza cuando los datos de inscripción no son correctos.
 * 
 * @author Franco Giovanny Gastelum Barcelo
 */
public class InscripcionInvalidaException extends Exception{
    public InscripcionInvalidaException(String mensaje){
        super(mensaje);
    }
}
