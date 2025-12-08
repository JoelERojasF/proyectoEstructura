/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package interfaz;
//imports para pruebas
import ObjetosNegocio.Calificacion;
import ObjetosNegocio.Contacto;
import ObjetosNegocio.Curso;
import ObjetosNegocio.Direccion;
import ObjetosNegocio.Estudiante;
import ObjetosNegocio.SolicitudCalificacion;
import Persistencia.Fachada;

/**
 * gestion.java
 * 
 * Clase main que llama a la ventana principal
 * 
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class gestion {

    public static void main(String[] args) throws Exception {
        Ventana_principal v  = new Ventana_principal();
        v.setVisible(true);     
        Fachada fachada = Fachada.getInstancia();
        
        //pruebas rapidas

        // Crear estudiantes precargados con agregarEstudiante
        Estudiante estFranco = fachada.agregarEstudiante(
            "Franco Giovanny Gastelum Barcelo",
            "6621112233",
            "franco@mail.com",
            "Calle Reforma", "123", "Centro", "Ciudad Obregón"
        );

        Estudiante estJoel = fachada.agregarEstudiante(
            "Joel Eduardo Rojas Fuentes",
            "6622223344",
            "joel@mail.com",
            "Av. Hidalgo", "456", "Norte", "Ciudad Obregón"
        );

        Estudiante estAndrea = fachada.agregarEstudiante(
            "Carmen Andrea Lara Osuna",
            "6623334455",
            "andrea@mail.com",
            "Calle Morelos", "789", "Sur", "Ciudad Obregón"
        );

        System.out.println(">>> Estudiantes precargados:");
        System.out.println(estFranco.getMatricula() + " | " + estFranco.getNombreCompleto());
        System.out.println(estJoel.getMatricula()   + " | " + estJoel.getNombreCompleto());
        System.out.println(estAndrea.getMatricula() + " | " + estAndrea.getNombreCompleto());

        // Crear cursos precargados
        Curso cursoMatematicas = fachada.agregarCurso("Matemáticas", "2");
        Curso cursoProgramacion = fachada.agregarCurso("Programación Orientada a Objetos", "3");

        System.out.println("\n>>> Cursos precargados:");
        System.out.println(cursoMatematicas.getClave() + " | " + cursoMatematicas.getNombre() + " | Cupo: " + cursoMatematicas.getCupoMaximo());
        System.out.println(cursoProgramacion.getClave() + " | " + cursoProgramacion.getNombre() + " | Cupo: " + cursoProgramacion.getCupoMaximo());

        // Inscripciones de prueba en curso Matemáticas
        fachada.agregarInscripcion(cursoMatematicas.getClave(), estFranco.getMatricula());
        fachada.agregarInscripcion(cursoMatematicas.getClave(), estJoel.getMatricula());
        fachada.agregarInscripcion(cursoMatematicas.getClave(), estAndrea.getMatricula()); // debería ir a lista de espera

        System.out.println("\n>>> Inscritos en " + cursoMatematicas.getNombre() + ":");
        for (int i = 0; i < cursoMatematicas.getListaEstudiantes().tamanio(); i++) {
            Estudiante e = cursoMatematicas.getListaEstudiantes().obtener(i);
            System.out.println("   - " + e.getMatricula() + " | " + e.getNombreCompleto());
        }

        System.out.println("\n>>> Lista de espera en " + cursoMatematicas.getNombre() + ":");
        for (int i = 0; i < cursoMatematicas.getListaEspera().tamanio(); i++) {
            Estudiante e = cursoMatematicas.getListaEspera().obtener(i);
            System.out.println("   - " + e.getMatricula() + " | " + e.getNombreCompleto());
        }
    }
}
