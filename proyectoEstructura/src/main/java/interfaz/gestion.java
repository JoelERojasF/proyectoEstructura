/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package interfaz;
//imports para pruebas
import ObjetosNegocio.Curso;
import ObjetosNegocio.Estudiante;
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
        //Pruebas para mostrar estudiantes inscritos en un curso
////         1. Crear fachada
//        Fachada fachada = Fachada.getInstancia();
//
//        // 2. Crear un estudiante
//        Estudiante e = fachada.agregarEstudiante(
//                "Juan Pérez",          // nombre
//                "6621234567",          // teléfono
//                "juan@mail.com",       // email
//                "Calle Reforma",       // calle
//                "123",                 // número
//                "Centro",              // colonia
//                "Ciudad Obregón"       // ciudad
//        );
//        System.out.println(">>> Estudiante creado: " + e.getNombreCompleto());
//
//        // 3. Crear un curso
//        Curso c = fachada.agregarCurso("Matemáticas", "2");
//        System.out.println(">>> Curso creado: " + c.getClave() + " - " + c.getNombre());
//
//        // 4. Inscribir al estudiante en el curso
//        fachada.agregarInscripcion(c.getClave(), e.getMatricula());
//        System.out.println(">>> Estudiante inscrito en curso: " + c.getNombre());
//
//        // 5. Mostrar estudiantes inscritos en ese curso
//        System.out.println(">>> Lista de estudiantes inscritos en curso " + c.getClave() + ":");
//        for (int i = 0; i < c.getListaEstudiantes().tamanio(); i++) {
//            Estudiante inscrito = c.getListaEstudiantes().obtener(i);
//            System.out.println("   - " + inscrito.getNombreCompleto());
//        }
          //Pruebas para lista de espera
//        // 1. Crear fachada
//        Fachada fachada = Fachada.getInstancia();
//
//        // 2. Crear estudiantes
//        Estudiante e1 = fachada.agregarEstudiante(
//                "Juan Pérez", "6621234567", "juan@mail.com",
//                "Calle Reforma", "123", "Centro", "Ciudad Obregón"
//        );
//        System.out.println(">>> Estudiante creado: " + e1.getMatricula() + " | " + e1.getNombreCompleto());
//
//        Estudiante e2 = fachada.agregarEstudiante(
//                "María López", "6627654321", "maria@mail.com",
//                "Av. Hidalgo", "456", "Norte", "Ciudad Obregón"
//        );
//        System.out.println(">>> Estudiante creado: " + e2.getMatricula() + " | " + e2.getNombreCompleto());
//
//        Estudiante e3 = fachada.agregarEstudiante(
//                "Pedro García", "6621112233", "pedro@mail.com",
//                "Calle Morelos", "789", "Sur", "Ciudad Obregón"
//        );
//        System.out.println(">>> Estudiante creado: " + e3.getMatricula() + " | " + e3.getNombreCompleto());
//
//        // 3. Crear curso con cupo reducido (ejemplo: 2)
//        Curso c = fachada.agregarCurso("Matemáticas", "2");
//        System.out.println(">>> Curso creado: " + c.getClave() + " - " + c.getNombre() + " | Cupo: " + c.getCupoMaximo());
//
//        // 4. Inscribir estudiantes
//        fachada.agregarInscripcion(c.getClave(), e1.getMatricula());
//        fachada.agregarInscripcion(c.getClave(), e2.getMatricula());
//        fachada.agregarInscripcion(c.getClave(), e3.getMatricula()); // este debería ir a lista de espera
//
//        // 5. Mostrar inscritos
//        System.out.println(">>> Lista de estudiantes inscritos en curso " + c.getClave() + ":");
//        if (c.getListaEstudiantes().tamanio() == 0) {
//            System.out.println("   (ninguno inscrito)");
//        } else {
//            for (int i = 0; i < c.getListaEstudiantes().tamanio(); i++) {
//                Estudiante inscrito = c.getListaEstudiantes().obtener(i);
//                System.out.println("   - " + inscrito.getMatricula() + " | " + inscrito.getNombreCompleto());
//            }
//        }
//
//        // 6. Mostrar lista de espera
//        System.out.println(">>> Lista de espera del curso " + c.getClave() + ":");
//        if (c.getListaEspera().tamanio() == 0) {
//            System.out.println("   (vacía)");
//        } else {
//            for (int i = 0; i < c.getListaEspera().tamanio(); i++) {
//                Estudiante enEspera = c.getListaEspera().obtener(i);
//                System.out.println("   - " + enEspera.getMatricula() + " | " + enEspera.getNombreCompleto());
//            }
//        }
    }
}
