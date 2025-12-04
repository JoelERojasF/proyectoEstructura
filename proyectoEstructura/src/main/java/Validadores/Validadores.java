/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Validadores {
    //estudiante

    public boolean validarNombreEstudiante(String nombre){
        String patron = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(nombre);
        
        return matcher.matches();
    }
    
    public boolean validarTelefono(String telefono){
       String patron = "^\\((?:55|33|81)\\)[\\s-]?\\d{4}[\\s-]?\\d{4}$|^\\(\\d{3}\\)[\\s-]?\\d{3}[\\s-]?\\d{4}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(telefono);
        
        return matcher.matches();    
    }
    
    public boolean validarEmail(String Email){
        String patron = "^(?!.*\\.\\.)[A-Za-z0-9._]{1,20}@[A-Za-z0-9._]{1,20}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(Email);

        return matcher.matches();
    }
    
    public boolean validarDireccionCalle(String calle){
        String patron = "^[A-Za-z-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(calle);
        
        return matcher.matches();
    }
    
    public boolean validarDireccionNumero(String numero){
        String patron = "^[1-9]\\d*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(numero);
        
        return matcher.matches();
    }
    
    public boolean validarDireccionColonia(String colonia){
       String patron = "^[A-Za-z-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(colonia);
        
        return matcher.matches();
    }
    
    public boolean validarDireccionCiudad(String ciudad){
        String patron = "^[A-Za-z-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(ciudad);
        
        return matcher.matches();
    }
    
    //curso

    public boolean validarNombreCurso(String nombre){
        String patron = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(nombre);
        
        return matcher.matches();
    }
    
    public boolean validarCupoCurso(String cupo){
        String patron = "^[1-9]\\d*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(cupo);
        
        return matcher.matches();
    }
    
    //calificacion
    public boolean validarCalificacion(String calificacion){
        String patron = "^(?:0(?:\\.\\d+)?|[1-9]\\d?(?:\\.\\d+)?|100(?:\\.0+)?)$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(calificacion);
        
        return matcher.matches();
    }
    
    //promedio
    public boolean validarPromedio(String promedio){
        String patron = "^(?:0(?:\\.\\d+)?|[1-9]\\d?(?:\\.\\d+)?|100(?:\\.0+)?)$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(promedio);
        
        return matcher.matches();
    }
    
}
