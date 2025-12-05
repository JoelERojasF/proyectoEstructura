/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ArbolBinarioBusqueda;
import EstructuraDatos.ListaEnlazadaSimple;
import EstructuraDatos.NodoSimple;
import ObjetosNegocio.Accion;
import ObjetosNegocio.Estudiante;


/**
 * Esta clase es para almacenar y gestionar los registros de cada estudiante
 * mediante un BST (BinarySearchTree)
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroEstudiantes {
    private static ArbolBinarioBusqueda<Estudiante> arbol;
    RegistroAcciones acciones = new RegistroAcciones();

    public RegistroEstudiantes() {
        arbol = new ArbolBinarioBusqueda<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        arbol.insertar(estudiante);
        Accion accion = new Accion(
                Accion.TipoAccion.REGISTRO,
                estudiante,
                null,
                null,
                -1.0,
                true
            );
            acciones.registrarAccion(accion);
    }
    
    public void eliminarEstudiante(Estudiante estudiante) {
//        Estudiante estudiante = new Estudiante(matricula, "", null);
        arbol.eliminar(estudiante);
        Accion accion = new Accion(
                Accion.TipoAccion.REGISTRO,
                estudiante,
                null,
                null,
                -1.0,
                false
            );
            acciones.registrarAccion(accion);
    }
    
    public Estudiante buscarPorMatricula(String matricula) {
        Estudiante matriculaEstudiante = new Estudiante(matricula, "", null);
        return arbol.buscar(matriculaEstudiante);
    }
    
    /**
     * Solo en consola
     */
    public void mostrarEstudiantes() {
        arbol.recorridoInOrden();
    }
    
    public ListaEnlazadaSimple<Estudiante> obtenerTodos() {
        return arbol.obtenerTodos(); // delega al árbol
    }  
    
    public int tamanio(){
        return obtenerTodos().tamanio();
    }
}