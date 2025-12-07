/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * EstudianteNoEncontradoException.java
 *
 * Se lanza cuando no se encuentra un estudiante con la matrícula especificada.
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class EstudianteNoEncontradoException extends Exception{
    public EstudianteNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
