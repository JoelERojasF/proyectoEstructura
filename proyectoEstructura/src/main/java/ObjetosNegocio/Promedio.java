/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import EstructuraDatos.ArbolAVL;
import EstructuraDatos.ListaEnlazadaSimple;

/**
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Promedio implements Comparable<Promedio> {
    private double promedio;
    private Estudiante estudiante;

    public Promedio(double promedio, Estudiante estudiante) {
        this.promedio = promedio;
        this.estudiante = estudiante;
    }

    public double getPromedio() { 
        return promedio;
    }
    public Estudiante getEstudiante() { 
        return estudiante;
    }
    
    @Override
    public int compareTo(Promedio otro) {
        return Double.compare(this.promedio, otro.promedio);
    }

    @Override
    public String toString() {
        return estudiante.getNombreCompleto() + " -> " + promedio;
    }
}