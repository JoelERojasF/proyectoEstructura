/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import EstructuraDatos.ListaEnlazadaSimple;

/**
 * Estudiante.java
 * 
 * @author Carmen Andrea Lara Osuna@author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {
    private String matricula;
    private String nombreCompleto;
    private Contacto contacto;
    private ListaEnlazadaSimple<Calificacion> calificaciones; 

    public Estudiante(String matricula, String nombreCompleto, Contacto contacto) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.contacto = contacto;
        this.calificaciones = new ListaEnlazadaSimple<>();
    }

    public String getMatricula() { 
        return matricula;
    }
    
    public String getNombreCompleto() { 
        return nombreCompleto;
    }
    
    public Contacto getContacto() { 
        return contacto;
    }

    public void setNombreCompleto(String nombreCompleto) { 
        this.nombreCompleto = nombreCompleto;
    }
    public void setContacto(Contacto contacto) { 
        this.contacto = contacto;
    }
    
    public ListaEnlazadaSimple<Calificacion> getCalificaciones() {
        return calificaciones;
    }
    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.agregar(calificacion);
    }
    
    public void reemplazarCalificacion(Double valorViejo, Calificacion nueva) throws Exception {
        if (calificaciones == null || calificaciones.vacio()) return;

        // Buscar la posición de la calificación con el valor viejo
        for (int i = 0; i < calificaciones.tamanio(); i++) {
            Calificacion c = calificaciones.obtener(i);
            if (c.getCalificacion().equals(valorViejo)) {
                // Reemplazar por el nuevo objeto
                calificaciones.eliminar(i);
                calificaciones.insertar(nueva, i);
                return;
            }
        }
    }


    public double calcularPromedio() throws Exception {
        if (calificaciones.tamanio() == 0) return 0.0;
        double suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.getCalificacion();
        }
        return suma / calificaciones.tamanio();
    }

    @Override
    public int compareTo(Estudiante otro) {
        return this.matricula.compareTo(otro.matricula);
    }

    @Override
    public String toString() {
        try {
            return matricula + " - " + nombreCompleto + " Promedio: " + calcularPromedio();
        } catch (Exception e) {
            return matricula + " - " + nombreCompleto + " Promedio: N/A";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante e = (Estudiante) o;
        return Objects.equals(matricula, e.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}