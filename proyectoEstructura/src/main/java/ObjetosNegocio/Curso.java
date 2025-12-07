/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import EstructuraDatos.ListaDobleEnlazadaCircular;
import EstructuraDatos.ListaEnlazadaCircular;
import EstructuraDatos.ListaEnlazadaSimple;


/**
 * Curso.java
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Curso implements Comparable<Curso>{
    private String clave;
    private String nombre;
    private ListaEnlazadaSimple<Estudiante> listaEstudiantes;
    private ListaDobleEnlazadaCircular<Estudiante> listaEspera;
    private ListaEnlazadaCircular<Estudiante> roles;
//    private final int CUPO_MAXIMO = 15;
    private int cupoMaximo;

    public Curso() {
//        this.cupoMaximo = CUPO_MAXIMO;
        this.listaEstudiantes = new ListaEnlazadaSimple<>();
        this.listaEspera = new ListaDobleEnlazadaCircular<>();
        this.roles = new ListaEnlazadaCircular<>();
    }

    public Curso(String clave, String nombre, int cupoMaximo) {
        this.clave = clave;
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
        this.listaEstudiantes = new ListaEnlazadaSimple<>();
        this.listaEspera = new ListaDobleEnlazadaCircular<>();
        this.roles = new ListaEnlazadaCircular<>();
    }
    
    /**
     * Inscribe a un estudiante en el curso si hay cupo disponible.
     * Si no hay cupo, lo manda a la lista de espera.
     * 
     * @param estudiante Estudiante a inscribir.
     * @return true si se inscribió, false si fue enviado a lista de espera.
     */
    public boolean inscribir(Estudiante estudiante) {
        if (listaEstudiantes.tamanio() < cupoMaximo) {
            listaEstudiantes.agregar(estudiante);
            roles.agregar(estudiante);
            System.out.println("Estudiante inscrito: " + estudiante.getNombreCompleto());
            return true;
        } else {
            System.out.println("Curso lleno, se envía a lista de espera: " + estudiante.getNombreCompleto());
            agregarAListaEspera(estudiante);  
            return false;
        }
    }

    /**
     * Remueve a un estudiante de la lista de inscritos.
     * 
     * @param estudiante Estudiante a remover.
     * @return true si se removio, false si no estaba inscrito.
     */
    public Estudiante removerInscrito(Estudiante estudiante) throws Exception {
        int pos = listaEstudiantes.indexOf(estudiante);
        if (pos != -1) {
                Estudiante e =listaEstudiantes.eliminar(pos);
                int posR = roles.indexOf(estudiante);
                roles.eliminar(posR);
                inscribirTodosEstudiantesEspera();
                return e;
        }else{
            int posE = listaEspera.indexOf(estudiante);
            if(posE != -1){
                Estudiante e =listaEspera.eliminar(posE);
                return e;
            }
        }
        return null;
    }
    
    public void agregarAListaEspera(Estudiante estudiante) {
        listaEspera.agregar(estudiante);
    }
    
    public void mostrarListaEspera(int n) throws Exception {
        if (listaEspera.vacio()) {
            System.out.println("No hay estudiantes en lista de espera.");
            return;
        }
        for (int i = 0; i < n && i < listaEspera.tamanio(); i++) {
            System.out.println(listaEspera.obtener(i));
        }
    }
    
    public Estudiante rotarRol() throws Exception {
        if (roles.vacio()) return null;
        // El tutor/lider actual es el inicio
        Estudiante actual = roles.obtener(0);
        // Lo mandamos al final y eliminamos del inicio
        roles.insertar(actual, roles.tamanio());
        roles.eliminar(0);
        // Nuevo tutor/lider
        return roles.obtener(0);
    }
    
    public void inscribirSiguienteEstudianteEspera() throws Exception{
        if (listaEstudiantes.tamanio() < cupoMaximo && listaEspera.tamanio() > 0) {
            Estudiante e =listaEspera.eliminar(0);
            listaEstudiantes.agregar(e);
            roles.agregar(e);
        }
    }
    
    public void inscribirTodosEstudiantesEspera() throws Exception{
        while(listaEstudiantes.tamanio() < cupoMaximo && listaEspera.tamanio() > 0){
            inscribirSiguienteEstudianteEspera();
        }
    }
    
    public Estudiante getLiderActual() throws Exception {
        if (roles.vacio()) return null;
        return roles.obtener(0);
    }

    public Estudiante getLiderAnterior() throws Exception {
        if (roles.vacio()) return null;
        // El anterior sería el último en la lista circular
        return roles.obtener(roles.tamanio() - 1);
    }

    public Estudiante getSiguienteLider() throws Exception {
        if (roles.vacio()) return null;
        if (roles.tamanio() > 1) {
            return roles.obtener(1);
        }
        return null; // si solo hay un estudiante inscrito
    }

    
    public ListaEnlazadaSimple<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public ListaDobleEnlazadaCircular<Estudiante> getListaEspera() {
        return listaEspera;
    }

    public ListaEnlazadaCircular<Estudiante> getRoles() {
        return roles;
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
    
    public String toString(){
        return clave + ", " + nombre + ", capacidad: " + cupoMaximo;
    }
}