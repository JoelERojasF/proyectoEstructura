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
    // estudiante

    public boolean validarNombreEstudiante(String nombre){
        // Patrón: ^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$
        // ^ inicio
        // [A-Za-zÁÉÍÓÚáéíóúÑñ ] letras mayúsculas/minúsculas, acentos, ñ, espacios
        // {1,50} entre 1 y 50 caracteres
        // $ fin
        String patron = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(nombre);
        return matcher.matches();
    }

    public boolean validarTelefono(String telefono){
        // Patrón: ^\((?:55|33|81)\)[\s-]?\d{4}[\s-]?\d{4}$ | ^\(\d{3}\)[\s-]?\d{3}[\s-]?\d{4}$
        // Formatos válidos:
        // (55)1234-5678 , (33)12345678 , (81)1234 5678
        // (644)123-4567 , (662)1234567
        String patron = "^\\((?:55|33|81)\\)[\\s-]?\\d{4}[\\s-]?\\d{4}$|^\\(\\d{3}\\)[\\s-]?\\d{3}[\\s-]?\\d{4}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(telefono);
        return matcher.matches();    
    }

    public boolean validarEmail(String Email){
        // Patrón: ^(?!.*\.\.)[A-Za-z0-9._]{1,20}@[A-Za-z0-9._]{1,20}$
        // No permite ".."
        // Usuario: letras, números, punto, guion bajo (1-20)
        // @ obligatorio
        // Dominio: letras, números, punto, guion bajo (1-20)
        String patron = "^(?!.*\\.\\.)[A-Za-z0-9._]{1,20}@[A-Za-z0-9._]{1,20}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(Email);
        return matcher.matches();
    }

    public boolean validarDireccionCalle(String calle){
        // Patrón: ^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$
        // Letras, números, espacios, punto y coma
        String patron = "^[A-Za-z-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(calle);
        return matcher.matches();
    }

    public boolean validarDireccionNumero(String numero){
        // Patrón: ^[1-9]\d*$
        // Número entero positivo, no empieza en 0
        String patron = "^[1-9]\\d*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(numero);
        return matcher.matches();
    }

    public boolean validarDireccionColonia(String colonia){
        // Patrón: ^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$
        // Letras, números, espacios, punto y coma
        String patron = "^[A-Za-z-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(colonia);
        return matcher.matches();
    }

    public boolean validarDireccionCiudad(String ciudad){
        // Patrón: ^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$
        // Letras, números, espacios, punto y coma
        String patron = "^[A-Za-z-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(ciudad);
        return matcher.matches();
    }

    // curso

    public boolean validarNombreCurso(String nombre){
        // Patrón: ^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$
        // Letras con acentos, ñ y espacios, entre 1 y 50 caracteres
        String patron = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(nombre);
        return matcher.matches();
    }

    public boolean validarCupoCurso(String cupo){
        // Patrón: ^[1-9]\d*$
        // Número entero positivo, no empieza en 0
        String patron = "^[1-9]\\d*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(cupo);
        return matcher.matches();
    }

    // calificación
    public boolean validarCalificacion(String calificacion){
        // Patrón: ^(?:0(?:\.\d+)?|[1-9]\d?(?:\.\d+)?|100(?:\.0+)?)$
        // Valores válidos: 0, 0.5, 10, 99.9, 100, 100.0
        String patron = "^(?:0(?:\\.\\d+)?|[1-9]\\d?(?:\\.\\d+)?|100(?:\\.0+)?)$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(calificacion);
        return matcher.matches();
    }

    // promedio
    public boolean validarPromedio(String promedio){
        // Patrón: ^(?:0(?:\.\d+)?|[1-9]\d?(?:\.\d+)?|100(?:\.0+)?)$
        // Igual que calificación: valores entre 0 y 100 con decimales opcionales
        String patron = "^(?:0(?:\\.\\d+)?|[1-9]\\d?(?:\\.\\d+)?|100(?:\\.0+)?)$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(promedio);
        return matcher.matches();
    }
}
