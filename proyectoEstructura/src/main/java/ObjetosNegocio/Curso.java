/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import EstructuraDatos.ListaEnlazadaSimple;


/**
 *
 * @author Joel Eduardo Rojas Fuentes
 */
public class Curso implements Comparable<Curso>{
    private String clave;
    private String nombre;
    private ListaEnlazadaSimple<Estudiante> listaEstudiantes;
    private int cupoMaximo;

    public Curso() {
    }

    public Curso(String clave, String nombre, int cupoMaximo) {
        this.clave = clave;
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
    }
    
    /**
     * Inscribe a un estudiante en el curso si hay cupo disponible.
     * 
     * @param estudiante Estudiante a inscribir.
     * @return true si se inscribió, false si el curso está lleno.
     */
    public boolean inscribir(Estudiante estudiante) {
        if (listaEstudiantes.tamanio() < cupoMaximo) {
            listaEstudiantes.agregar(estudiante);
            return true;
        } else {
            System.out.println("Curso lleno, no se pudo inscribir: " + estudiante.getNombreCompleto());
            return false;
        }
    }

    /**
     * Remueve a un estudiante de la lista de inscritos.
     * 
     * @param estudiante Estudiante a remover.
     * @return true si se removió, false si no estaba inscrito.
     */
    public boolean removerInscrito(Estudiante estudiante) {
        int pos = listaEstudiantes.indexOf(estudiante);
        if (pos != -1) {
            try {
                listaEstudiantes.eliminar(pos);
                return true;
            } catch (Exception ex) {
                System.out.println("Error al remover estudiante: " + ex.getMessage());
            }
        }
        return false;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Curso otro) {
        return this.clave.compareTo(otro.clave);
    }
}