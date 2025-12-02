/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ArbolBinarioBusqueda;
import EstructuraDatos.ListaEnlazadaSimple;
import EstructuraDatos.NodoSimple;
import ObjetosNegocio.Estudiante;


/**
 * Esta clase es para almacenar y gestionar los registros de cada estudiante
 * mediante un BST (BinarySearchTree)
 * 
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroEstudiantes {
    private static ArbolBinarioBusqueda<Estudiante> arbol;

    public RegistroEstudiantes() {
        arbol = new ArbolBinarioBusqueda<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        arbol.insertar(estudiante);
    }
    
    public void eliminarEstudiante(String matricula) {
        Estudiante estudiante = new Estudiante(matricula, "", null);
        arbol.eliminar(estudiante);
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
}