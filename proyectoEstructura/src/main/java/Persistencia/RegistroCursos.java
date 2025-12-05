/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraDatos.ArbolBinarioBusqueda;
import EstructuraDatos.Diccionario;
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
    private static Diccionario<String ,Curso> arbol;
    RegistroAcciones acciones = new RegistroAcciones();

    public RegistroCursos() {
        arbol = new Diccionario<>();
    }

    public void agregarCurso(Curso curso) {
        arbol.put(curso.getClave(),curso);
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
    
    public void eliminarCurso(Curso curso) throws Exception{
        arbol.remove(curso.getClave());
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
        return arbol.get(clave);
    }

    public ListaEnlazadaSimple<Curso> mostrarCursos() {
        return arbol.obtenerTodos();
    }
    
    public int tamanio(){
        return arbol.tamanio();
    }

    // Metodo implementado por Comparable<T>
    @Override
    public int compareTo(Curso o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}