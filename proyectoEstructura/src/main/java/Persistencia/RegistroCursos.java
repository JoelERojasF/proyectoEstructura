/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ArbolBinarioBusqueda;
import ObjetosNegocio.Curso;

public class RegistroCursos implements Comparable<Curso>{
    private static ArbolBinarioBusqueda<Curso> arbol;

    public RegistroCursos() {
        arbol = new ArbolBinarioBusqueda<>();
    }

    public void agregarCurso(Curso curso) {
        arbol.insertar(curso);
    }

    public Curso buscarPorClave(String clave) {
        Curso claveCurso = new Curso(clave, "");
        return arbol.buscar(claveCurso);
    }

    public void mostrarCursos() {
        arbol.recorridoInOrden();
    }

    // Metodo implementado por Comparable<T>
    @Override
    public int compareTo(Curso o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}