/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ArbolBinarioBusqueda;
import EstructuraDatos.ListaEnlazadaSimple;
import ObjetosNegocio.Accion;
import ObjetosNegocio.Curso;
/**
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class RegistroCursos implements Comparable<Curso>{
    private static ArbolBinarioBusqueda<Curso> arbol;
    RegistroAcciones acciones = new RegistroAcciones();

    public RegistroCursos() {
        arbol = new ArbolBinarioBusqueda<>();
    }

    public void agregarCurso(Curso curso) {
        arbol.insertar(curso);
        Accion accion = new Accion(
                Accion.TipoAccion.REGISTRO,
                null,
                curso,
                -1.0,
                -1.0,
                true
            );
            acciones.registrarAccion(accion);
    }
    
    public void eliminarCurso(Curso curso){
        arbol.eliminar(curso);
        Accion accion = new Accion(
                Accion.TipoAccion.REGISTRO,
                null,
                curso,
                -1.0,
                -1.0,
                false
            );
            acciones.registrarAccion(accion);
    }

    public Curso buscarPorClave(String clave) {
        Curso claveCurso = new Curso(clave, "", 0);
        return arbol.buscar(claveCurso);
    }

    public ListaEnlazadaSimple<Curso> mostrarCursos() {
        return arbol.obtenerTodos();
    }
    
    public int tamanio(){
        return mostrarCursos().tamanio();
    }

    // Metodo implementado por Comparable<T>
    @Override
    public int compareTo(Curso o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}