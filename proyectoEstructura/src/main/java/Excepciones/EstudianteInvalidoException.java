/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * EstudianteInvalidoException.java
 *
 * Se lanza cuando los datos de un estudiante no cumplen con las validaciones requeridas.
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class EstudianteInvalidoException extends Exception{
    public EstudianteInvalidoException(String mensaje){
        super(mensaje);
    }
}
