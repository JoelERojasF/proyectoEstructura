/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ArbolBinarioBusqueda;
import ObjetosNegocio.Estudiante;

/*
* Esta clase es para almacenar y gestionar los registros de cada estudiante
* mediante un BST (BinarySearchTree)
*/
/**
 *
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroEstudiantes {
    private static ArbolBinarioBusqueda<Estudiante> arbol;

    public RegistroEstudiantes() {
        arbol = new ArbolBinarioBusqueda<>();
    }

    public void agregarEstudiante(Estudiante e) {
        arbol.insertar(e);
    }

    public Estudiante buscarPorMatricula(String matricula) {
        Estudiante dummy = new Estudiante(matricula, "", null);
        return arbol.buscar(dummy);
    }

    public void mostrarEstudiantes() {
        arbol.recorridoInOrden();
    }
}