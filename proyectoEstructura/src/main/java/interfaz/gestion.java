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
        
        
        
        
        
        
        
        
        
        
        
        
        
//        
//        // Direcciones
//        Direccion dirFranco = new Direccion("Calle Reforma", "123", "Centro", "Ciudad Obregón");
//        Direccion dirJoel   = new Direccion("Av. Hidalgo", "456", "Norte", "Ciudad Obregón");
//        Direccion dirAndrea = new Direccion("Calle Morelos", "789", "Sur", "Ciudad Obregón");
//
//        // Contactos
//        Contacto contactoFranco = new Contacto("6621112233", "franco@mail.com", dirFranco);
//        Contacto contactoJoel   = new Contacto("6622223344", "joel@mail.com", dirJoel);
//        Contacto contactoAndrea = new Contacto("6623334455", "andrea@mail.com", dirAndrea);
//
//        // Estudiantes
//        Estudiante estFranco = new Estudiante("EST0001", "Franco Giovanny Gastelum Barcelo", contactoFranco);
//        Estudiante estJoel   = new Estudiante("EST0002", "Joel Eduardo Rojas Fuentes", contactoJoel);
//        Estudiante estAndrea = new Estudiante("EST0003", "Carmen Andrea Lara Osuna", contactoAndrea);
//
//        // Depuración en consola
//        System.out.println(">>> Estudiantes precargados:");
//        System.out.println(estFranco.getMatricula() + " | " + estFranco.getNombreCompleto() + " | " + estFranco.getContacto().getEmail());
//        System.out.println(estJoel.getMatricula()   + " | " + estJoel.getNombreCompleto()   + " | " + estJoel.getContacto().getEmail());
//        System.out.println(estAndrea.getMatricula() + " | " + estAndrea.getNombreCompleto() + " | " + estAndrea.getContacto().getEmail());
//
//        // Cursos
//        Curso cursoMatematicas = new Curso("CUR0001", "Matemáticas", 2);
//        Curso cursoProgramacion = new Curso("CUR0002", "Programación Orientada a Objetos", 3);
//
//        System.out.println("\n>>> Cursos precargados:");
//        System.out.println(cursoMatematicas.getClave() + " | " + cursoMatematicas.getNombre() + " | Cupo: " + cursoMatematicas.getCupoMaximo());
//        System.out.println(cursoProgramacion.getClave() + " | " + cursoProgramacion.getNombre() + " | Cupo: " + cursoProgramacion.getCupoMaximo());
//
//        // Inscripciones en curso Matemáticas
//        cursoMatematicas.inscribir(estFranco);
//        cursoMatematicas.inscribir(estJoel);
//        cursoMatematicas.inscribir(estAndrea); // este debería ir a lista de espera
//
//        System.out.println("\n>>> Inscritos en " + cursoMatematicas.getNombre() + ":");
//        for (int i = 0; i < cursoMatematicas.getListaEstudiantes().tamanio(); i++) {
//            Estudiante e = cursoMatematicas.getListaEstudiantes().obtener(i);
//            System.out.println("   - " + e.getMatricula() + " | " + e.getNombreCompleto());
//        }
//
//        System.out.println("\n>>> Lista de espera en " + cursoMatematicas.getNombre() + ":");
//        for (int i = 0; i < cursoMatematicas.getListaEspera().tamanio(); i++) {
//            Estudiante e = cursoMatematicas.getListaEspera().obtener(i);
//            System.out.println("   - " + e.getMatricula() + " | " + e.getNombreCompleto());
//        }

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
    //Pruebas para eliminar a un estudiante
            // 1. Crear fachada
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
//        System.out.println(">>> Inscritos ANTES de eliminar:");
//        for (int i = 0; i < c.getListaEstudiantes().tamanio(); i++) {
//            Estudiante inscrito = c.getListaEstudiantes().obtener(i);
//            System.out.println("   - " + inscrito.getMatricula() + " | " + inscrito.getNombreCompleto());
//        }
//
//        // 6. Mostrar lista de espera
//        System.out.println(">>> Lista de espera ANTES de eliminar:");
//        if (c.getListaEspera().tamanio() == 0) {
//            System.out.println("   (vacía)");
//        } else {
//            for (int i = 0; i < c.getListaEspera().tamanio(); i++) {
//                Estudiante enEspera = c.getListaEspera().obtener(i);
//                System.out.println("   - " + enEspera.getMatricula() + " | " + enEspera.getNombreCompleto());
//            }
//        }
//
//        // 7. Eliminar un inscrito (ejemplo: e1)
//        Estudiante eliminado = c.removerInscrito(e1);
//        System.out.println(">>> Se eliminó al estudiante: " + eliminado.getMatricula() + " | " + eliminado.getNombreCompleto());
//
//        // 8. Mostrar inscritos después de eliminar
//        System.out.println(">>> Inscritos DESPUÉS de eliminar:");
//        for (int i = 0; i < c.getListaEstudiantes().tamanio(); i++) {
//            Estudiante inscrito = c.getListaEstudiantes().obtener(i);
//            System.out.println("   - " + inscrito.getMatricula() + " | " + inscrito.getNombreCompleto());
//        }
//
//        // 9. Mostrar lista de espera después de eliminar
//        System.out.println(">>> Lista de espera DESPUÉS de eliminar:");
//        if (c.getListaEspera().tamanio() == 0) {
//            System.out.println("   (vacía)");
//        } else {
//            for (int i = 0; i < c.getListaEspera().tamanio(); i++) {
//                Estudiante enEspera = c.getListaEspera().obtener(i);
//                System.out.println("   - " + enEspera.getMatricula() + " | " + enEspera.getNombreCompleto());
//            }
//        }
        
        //Probando solicitud de calificacion
        // 1. Crear curso
//    Curso curso = new Curso("CUR0001", "Matemáticas", 2);
//    System.out.println(">>> Curso creado: " + curso.getClave() + " - " + curso.getNombre());
//
//    // 2. Crear estudiante
//    Direccion direccion = new Direccion("Calle Reforma", "123", "Centro", "Ciudad Obregón");
//    Contacto contacto = new Contacto(
//        "6621234567", "juan@mail.com",
//        direccion
//    );
//
//    Estudiante estudiante = new Estudiante("EST0001", "Juan Pérez",contacto);
//    System.out.println(">>> Estudiante creado: " + estudiante.getMatricula() + " | " + estudiante.getNombreCompleto());
//
//    // 3. Crear calificación
//    Calificacion calificacion = new Calificacion(curso, 95.0);
//    System.out.println(">>> Calificación creada para curso " + calificacion.getCurso().getNombre() +
//                       ": " + calificacion.getCalificacion());
//
//    // 4. Crear solicitud de calificación
//    SolicitudCalificacion solicitud = new SolicitudCalificacion(estudiante, calificacion);
//    System.out.println(">>> Solicitud de calificación creada:");
//    System.out.println("   Estudiante: " + solicitud.getEstudiante().getNombreCompleto());
//    System.out.println("   Curso: " + solicitud.getCalificacion().getCurso().getNombre());
//    System.out.println("   Calificación: " + solicitud.getCalificacion().getCalificacion());
//        // 1. Crear fachada
//        Fachada fachada = Fachada.getInstancia();
//
//        // 2. Crear estudiantes
//        Estudiante e1 = fachada.agregarEstudiante("Juan Pérez", "6621234567", "juan@mail.com",
//                "Calle Reforma", "123", "Centro", "Ciudad Obregón");
//        Estudiante e2 = fachada.agregarEstudiante("María López", "6627654321", "maria@mail.com",
//                "Av. Hidalgo", "456", "Norte", "Ciudad Obregón");
//        Estudiante e3 = fachada.agregarEstudiante("Pedro García", "6621112233", "pedro@mail.com",
//                "Calle Morelos", "789", "Sur", "Ciudad Obregón");
//
//        System.out.println(">>> Estudiantes creados:");
//        System.out.println("   - " + e1.getNombreCompleto());
//        System.out.println("   - " + e2.getNombreCompleto());
//        System.out.println("   - " + e3.getNombreCompleto());
//
//        // 3. Crear curso
//        Curso c = fachada.agregarCurso("Matemáticas", "3");
//        System.out.println(">>> Curso creado: " + c.getClave() + " - " + c.getNombre());
//
//        // 4. Inscribir estudiantes
//        fachada.agregarInscripcion(c.getClave(), e1.getMatricula());
//        fachada.agregarInscripcion(c.getClave(), e2.getMatricula());
//        fachada.agregarInscripcion(c.getClave(), e3.getMatricula());
//
//        // 5. Mostrar líderes antes de rotar
//        System.out.println(">>> Líderes ANTES de rotar:");
//        System.out.println("   Líder anterior: " + c.getLiderAnterior().getNombreCompleto());
//        System.out.println("   Líder actual: " + c.getLiderActual().getNombreCompleto());
//        System.out.println("   Siguiente líder: " + c.getSiguienteLider().getNombreCompleto());
//
//        // 6. Rotar rol
//        Estudiante nuevoLider = c.rotarRol();
//        System.out.println(">>> Se rotó el rol. Nuevo líder actual: " + nuevoLider.getNombreCompleto());
//
//        // 7. Mostrar líderes después de rotar
//        System.out.println(">>> Líderes DESPUÉS de rotar:");
//        System.out.println("   Líder anterior: " + c.getLiderAnterior().getNombreCompleto());
//        System.out.println("   Líder actual: " + c.getLiderActual().getNombreCompleto());
//        System.out.println("   Siguiente líder: " + c.getSiguienteLider().getNombreCompleto());

    }
}
