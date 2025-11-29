/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Carmen Andrea Lara Osuna
 */
public class Ventana_principal extends JFrame {

    private JPanel panelCentral;

    public Ventana_principal() {
        setTitle("Menú del Sistema Académico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();

        //  Menú Estudiantes 
        JMenu menuEstudiantes = new JMenu("Estudiantes");
        JMenuItem registrarEstudiante = new JMenuItem("Registrar estudiante");
        JMenuItem buscarEstudiante = new JMenuItem("Buscar estudiante por matrícula");
        menuEstudiantes.add(registrarEstudiante);
        menuEstudiantes.add(buscarEstudiante);

        //  Menú Cursos 
        JMenu menuCursos = new JMenu("Cursos");
        JMenuItem agregarCurso = new JMenuItem("Agregar curso");
        JMenuItem eliminarCurso = new JMenuItem("Eliminar curso");
        JMenuItem listarCursos = new JMenuItem("Listar cursos");
        menuCursos.add(agregarCurso);
        menuCursos.add(eliminarCurso);
        menuCursos.add(listarCursos);

        //  Menú Inscripciones 
        JMenu menuInscripciones = new JMenu("Inscripciones");
        JMenuItem inscribirEstudiante = new JMenuItem("Inscribir estudiante en curso");
        JMenuItem listaInscritos = new JMenuItem("Mostrar lista de inscritos");
        JMenuItem listaEspera = new JMenuItem("Mostrar lista de espera");
        menuInscripciones.add(inscribirEstudiante);
        menuInscripciones.add(listaInscritos);
        menuInscripciones.add(listaEspera);

        //  Menú Calificaciones 
        JMenu menuCalificaciones = new JMenu("Calificaciones");
        JMenuItem enviarSolicitud = new JMenuItem("Enviar solicitud de calificación");
        JMenuItem procesarSolicitud = new JMenuItem("Procesar siguiente solicitud");
        menuCalificaciones.add(enviarSolicitud);
        menuCalificaciones.add(procesarSolicitud);

        //  Menú Acciones 
        JMenu menuAcciones = new JMenu("Acciones");
        JMenuItem deshacerAccion = new JMenuItem("Deshacer última acción");
        menuAcciones.add(deshacerAccion);

        //  Menú Reportes 
        JMenu menuReportes = new JMenu("Reportes");
        JMenuItem listarPromedios = new JMenuItem("Listar estudiantes ordenados por promedio");
        JMenuItem rotarTutor = new JMenuItem("Rotar rol de tutor/líder de proyecto");
        menuReportes.add(listarPromedios);
        menuReportes.add(rotarTutor);

        //  Menú Salir 
        JMenu menuSalir = new JMenu("Salir");
        JMenuItem salirItem = new JMenuItem("Cerrar aplicación");
        menuSalir.add(salirItem);

        menuBar.add(menuEstudiantes);
        menuBar.add(menuCursos);
        menuBar.add(menuInscripciones);
        menuBar.add(menuCalificaciones);
        menuBar.add(menuAcciones);
        menuBar.add(menuReportes);
        menuBar.add(menuSalir);

        add(menuBar, BorderLayout.NORTH);

        panelCentral = new JPanel();
        panelCentral.add(new JLabel("Bienvenido al Sistema Académico"));
        add(panelCentral, BorderLayout.CENTER);

        //  Listeners para cambiar panel 
        // Estudiantes
        registrarEstudiante.addActionListener(e -> cambiarPanel(new PanelRegistrarEstudiante()));
        buscarEstudiante.addActionListener(e -> cambiarPanel(new PanelBuscarEstudiante()));

        // Cursos
        agregarCurso.addActionListener(e -> cambiarPanel(new PanelAgregarCurso()));
        eliminarCurso.addActionListener(e -> cambiarPanel(new PanelEliminarCurso()));
        listarCursos.addActionListener(e -> cambiarPanel(new PanelListarCursos()));

        // Inscripciones
        inscribirEstudiante.addActionListener(e -> cambiarPanel(new PanelInscribirEstudiante()));
        listaInscritos.addActionListener(e -> cambiarPanel(new PanelListaInscritos()));
        listaEspera.addActionListener(e -> cambiarPanel(new PanelListaEspera()));

        // Calificaciones
        enviarSolicitud.addActionListener(e -> cambiarPanel(new PanelEnviarSolicitud()));
        procesarSolicitud.addActionListener(e -> cambiarPanel(new PanelProcesarSolicitud()));

        // Acciones
        deshacerAccion.addActionListener(e -> cambiarPanel(new PanelDeshacerAccion()));

        // Reportes
        listarPromedios.addActionListener(e -> cambiarPanel(new PanelListarPorPromedio()));
        rotarTutor.addActionListener(e -> cambiarPanel(new PanelRotarRol()));

        // Salir
        salirItem.addActionListener(e -> System.exit(0));
    }

    // Método para cambiar el panel central
    private void cambiarPanel(JPanel nuevoPanel) {
        remove(panelCentral);
        panelCentral = nuevoPanel;
        add(panelCentral, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

//  Estudiantes 
    class PanelRegistrarEstudiante extends JPanel {

        public PanelRegistrarEstudiante() {
            setLayout(new GridLayout(0, 2, 8, 8));
            add(new JLabel("Matrícula:"));
            add(new JTextField());
            add(new JLabel("Nombre completo:"));
            add(new JTextField());
            add(new JLabel("Teléfono:"));
            add(new JTextField());
            add(new JLabel("Correo electrónico:"));
            add(new JTextField());
            add(new JLabel("Calle:"));
            add(new JTextField());
            add(new JLabel("Número:"));
            add(new JTextField());
            add(new JLabel("Colonia:"));
            add(new JTextField());
            add(new JLabel("Ciudad:"));
            add(new JTextField());
            add(new JLabel());
            add(new JButton("Registrar"));
        }
    }

    class PanelBuscarEstudiante extends JPanel {

        public PanelBuscarEstudiante() {
            setLayout(new BorderLayout(8, 8));
            JPanel top = new JPanel(new FlowLayout());
            top.add(new JLabel("Matrícula:"));
            top.add(new JTextField(12));
            top.add(new JButton("Buscar"));
            add(top, BorderLayout.NORTH);
            add(new JScrollPane(new JTextArea("Resultado...")), BorderLayout.CENTER);
        }
    }

//  Cursos 
    class PanelAgregarCurso extends JPanel {

        public PanelAgregarCurso() {
            setLayout(new GridLayout(0, 2, 8, 8));
            add(new JLabel("Clave curso:"));
            add(new JTextField());
            add(new JLabel("Nombre curso:"));
            add(new JTextField());
            add(new JLabel("Capacidad:"));
            add(new JSpinner(new SpinnerNumberModel(30, 1, 200, 1)));
            add(new JLabel());
            add(new JButton("Agregar"));
        }
    }

    class PanelEliminarCurso extends JPanel {

        public PanelEliminarCurso() {
            setLayout(new FlowLayout());
            add(new JLabel("Clave curso:"));
            add(new JTextField(12));
            add(new JButton("Eliminar"));
        }
    }

    class PanelListarCursos extends JPanel {

        public PanelListarCursos() {
            setLayout(new BorderLayout());
            String[] cols = {"Clave", "Nombre", "Capacidad"};
            JTable tabla = new JTable(new Object[][]{}, cols);
            add(new JScrollPane(tabla), BorderLayout.CENTER);
            add(new JButton("Listar"), BorderLayout.SOUTH);
        }
    }

//  Inscripciones 
    class PanelInscribirEstudiante extends JPanel {

        public PanelInscribirEstudiante() {
            setLayout(new GridLayout(0, 2, 8, 8));
            add(new JLabel("Clave curso:"));
            add(new JTextField());
            add(new JLabel("Matrícula estudiante:"));
            add(new JTextField());
            add(new JLabel());
            add(new JButton("Inscribir"));
        }
    }

    class PanelListaInscritos extends JPanel {

        public PanelListaInscritos() {
            setLayout(new BorderLayout());
            JPanel top = new JPanel(new FlowLayout());
            top.add(new JLabel("Clave curso:"));
            top.add(new JTextField(12));
            top.add(new JButton("Mostrar inscritos"));
            add(top, BorderLayout.NORTH);
            add(new JScrollPane(new JTextArea("Lista inscritos...")), BorderLayout.CENTER);
        }
    }

    class PanelListaEspera extends JPanel {

        public PanelListaEspera() {
            setLayout(new BorderLayout());
            JPanel top = new JPanel(new FlowLayout());
            top.add(new JLabel("Clave curso:"));
            top.add(new JTextField(12));
            top.add(new JLabel("N primeros:"));
            top.add(new JSpinner(new SpinnerNumberModel(5, 1, 100, 1)));
            top.add(new JButton("Mostrar espera"));
            add(top, BorderLayout.NORTH);
            add(new JScrollPane(new JTextArea("Lista espera...")), BorderLayout.CENTER);
        }
    }

    class PanelEnviarSolicitud extends JPanel {

        public PanelEnviarSolicitud() {
            setLayout(new GridLayout(0, 2, 8, 8));
            add(new JLabel("Matrícula:"));
            add(new JTextField());
            add(new JLabel("Calificación:"));
            add(new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1)));
            add(new JLabel());
            add(new JButton("Enviar solicitud"));
        }
    }

    class PanelProcesarSolicitud extends JPanel {

        public PanelProcesarSolicitud() {
            setLayout(new FlowLayout());
            add(new JButton("Procesar siguiente solicitud"));
        }
    }

//  Acciones 
    class PanelDeshacerAccion extends JPanel {

        public PanelDeshacerAccion() {
            setLayout(new FlowLayout());
            add(new JButton("Deshacer última acción"));
        }
    }

//  Reportes 
    class PanelListarPorPromedio extends JPanel {

        public PanelListarPorPromedio() {
            setLayout(new BorderLayout());
            add(new JButton("Listar estudiantes por promedio"), BorderLayout.NORTH);
            add(new JScrollPane(new JTextArea("Resultados...")), BorderLayout.CENTER);
        }
    }

    class PanelRotarRol extends JPanel {

        public PanelRotarRol() {
            setLayout(new FlowLayout());
            add(new JLabel("Clave curso:"));
            add(new JTextField(12));
            add(new JButton("Rotar rol tutor/líder"));
        }
    }
}
