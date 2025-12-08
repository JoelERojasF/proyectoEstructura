/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validadores.java
 * 
 * Se encargan de cumplir con la logica y formato de los datos que se piden,
 * asegurandose de que no haya informacion en blanco o solo espacios
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
        if(nombre == null || nombre.trim().isEmpty()) return false;
        String patron = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(nombre);
        return matcher.matches();
    }

    public boolean validarTelefono(String telefono) {
        // Acepta exactamente 10 dígitos (ejemplo: 6621234567)
        if(telefono == null || telefono.trim().isEmpty()) return false;
        String patron = "^\\d{10}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(telefono.trim());
        return matcher.matches();
    }


    public boolean validarEmail(String Email){
        // Usuario: letras, números, punto, guion bajo (1-20)
        // Dominio: letras, números, punto, guion bajo (1-20)
        // Extensión: punto seguido de 1 o 3 letras
        if(Email == null || Email.trim().isEmpty()) return false;
        String patron = "^(?!.*\\.\\.)[A-Za-z0-9._]{1,20}@[A-Za-z0-9._]{1,20}\\.[A-Za-z]{1,3}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(Email.trim());
        return matcher.matches();
    }


    public boolean validarDireccionCalle(String calle){
        // Patrón: ^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$
        // Letras, números, espacios, punto y coma
        if(calle == null || calle.trim().isEmpty()) return false;
        String patron = "^[A-Za-z-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(calle);
        return matcher.matches();
    }

    public boolean validarDireccionNumero(String numero){
        // Patrón: ^[1-9]\d*$
        // Número entero positivo, no empieza en 0
        if(numero == null || numero.trim().isEmpty()) return false;
        String patron = "^[1-9]\\d*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(numero);
        return matcher.matches();
    }

    public boolean validarDireccionColonia(String colonia){
        // Patrón: ^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$
        // Letras, números, espacios, punto y coma
        if(colonia == null || colonia.trim().isEmpty()) return false;
        String patron = "^[A-Za-z-zÁÉÍÓÚáéíóúÑñ0-9 .,]*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(colonia);
        return matcher.matches();
    }

    public boolean validarDireccionCiudad(String ciudad) {
        // Debe contener al menos una letra (mayúscula/minúscula con acentos o ñ)
        // y solo puede incluir letras, números, espacios, punto y coma
        if(ciudad == null ||  ciudad.trim().isEmpty()) return false;
        String patron = "^(?=.*[A-Za-zÁÉÍÓÚáéíóúÑñ])[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 .,]+$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(ciudad.trim());
        return matcher.matches();
    }

    // curso

    public boolean validarNombreCurso(String nombreCurso){
        // Patrón: ^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$
        // Letras con acentos, ñ y espacios, entre 1 y 50 caracteres
        String patron = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{1,50}$";
        if(nombreCurso == null || nombreCurso.trim().isEmpty()) return false;
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(nombreCurso);
        return matcher.matches();
    }

    public boolean validarCupoCurso(String cupo){
        // Patrón: ^[1-9]\d*$
        // Número entero positivo, no empieza en 0
        if(cupo == null || cupo.trim().isEmpty()) return false;
        String patron = "^[1-9]\\d*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(cupo);
        return matcher.matches();
    }

    // calificación
    //No agregue validaciones porque viene de un spinner en la interfaz
    public boolean validarCalificacion(String calificacion){
        // Patrón: ^(?:0(?:\.\d+)?|[1-9]\d?(?:\.\d+)?|100(?:\.0+)?)$
        // Valores válidos: 0, 0.5, 10, 9.9, 10, 10.0
        String patron = "^(?:0(?:\\.\\d+)?|[1-9]\\d?(?:\\.\\d+)?|10(?:\\.0+)?)$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(calificacion);
        return matcher.matches();
    }

    // promedio
    public boolean validarPromedio(String promedio){
        // Patrón: ^(?:0(?:\.\d+)?|[1-9]\d?(?:\.\d+)?|10(?:\.0+)?)$
        // Igual que calificación: valores entre 0 y 10 con decimales opcionales
        String patron = "^(?:0(?:\\.\\d+)?|[1-9]\\d?(?:\\.\\d+)?|10(?:\\.0+)?)$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(promedio);
        return matcher.matches();
    }
}
