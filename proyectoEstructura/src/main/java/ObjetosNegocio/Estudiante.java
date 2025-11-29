/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import EstructuraDatos.ListaEnlazadaSimple;
import java.util.ArrayList;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {
    private String matricula;
    private String nombreCompleto;
    private Contacto contacto;
    private ListaEnlazadaSimple<Double> calificaciones; 

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

    public void agregarCalificacion(Double c) {
        calificaciones.agregar(c);
    }

    public double calcularPromedio() throws Exception {
        if (calificaciones.tamanio() == 0) return 0.0;
        double suma = 0;
        for (Double c : calificaciones) {
            suma += c;
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

