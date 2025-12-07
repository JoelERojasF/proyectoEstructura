/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;


import EstructuraDatos.ListaDobleEnlazadaCircular;
import java.awt.*;
import javax.swing.*;
import Persistencia.Fachada;
import EstructuraDatos.ListaEnlazadaSimple;
import ObjetosNegocio.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Carmen Andrea Lara Osuna
 * @author Joel Eduardo Rojas Fuentes
 * @author Franco Giovanny Gastelum Barcelo
 */
public class Ventana_principal extends JFrame {
    private JPanel panelCentral;
    private final Fachada fachada;

    public Ventana_principal() {
        fachada = Fachada.getInstancia();
        
        setTitle("Menú del Sistema Académico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Estudiantes
        JMenu menuEstudiantes = new JMenu("Estudiantes");
        JMenuItem registrarEstudiante = new JMenuItem("Registrar estudiante");
        JMenuItem buscarEstudiante = new JMenuItem("Buscar estudiante por matrícula");
        menuEstudiantes.add(registrarEstudiante);
        menuEstudiantes.add(buscarEstudiante);

        // Menú Cursos
        JMenu menuCursos = new JMenu("Cursos");
        JMenuItem agregarCurso = new JMenuItem("Agregar curso");
        JMenuItem eliminarCurso = new JMenuItem("Eliminar curso");
        JMenuItem listarCursos = new JMenuItem("Listar cursos");
        menuCursos.add(agregarCurso);
        menuCursos.add(eliminarCurso);
        menuCursos.add(listarCursos);

        // Menú Inscripciones
        JMenu menuInscripciones = new JMenu("Inscripciones");
        JMenuItem inscribirEstudiante = new JMenuItem("Inscribir estudiante en curso");
        JMenuItem listaInscritos = new JMenuItem("Mostrar lista de inscritos");
        JMenuItem listaEspera = new JMenuItem("Mostrar lista de espera");
        menuInscripciones.add(inscribirEstudiante);
        menuInscripciones.add(listaInscritos);
        menuInscripciones.add(listaEspera);

        // Menú Calificaciones
        JMenu menuCalificaciones = new JMenu("Calificaciones");
        JMenuItem enviarSolicitud = new JMenuItem("Enviar solicitud de calificación");
        JMenuItem procesarSolicitud = new JMenuItem("Procesar siguiente solicitud");
        menuCalificaciones.add(enviarSolicitud);
        menuCalificaciones.add(procesarSolicitud);

        // Menú Acciones
        JMenu menuAcciones = new JMenu("Acciones");
        JMenuItem deshacerAccion = new JMenuItem("Deshacer última acción");
        menuAcciones.add(deshacerAccion);

        // Menú Reportes
        JMenu menuReportes = new JMenu("Reportes");
        JMenuItem listarPromedios = new JMenuItem("Listar estudiantes ordenados por promedio");
        JMenuItem rotarTutor = new JMenuItem("Rotar rol de tutor/líder de proyecto");
        menuReportes.add(listarPromedios);
        menuReportes.add(rotarTutor);

        // Menú Acerca de
        JMenu menuAcercade = new JMenu("Acerca de");
        JMenuItem acercadeItem = new JMenuItem("Información sobre los integrantes");
        menuAcercade.add(acercadeItem);

        // Menú Salir
        JMenu menuSalir = new JMenu("Salir");
        JMenuItem salirItem = new JMenuItem("Cerrar aplicación");
        menuSalir.add(salirItem);

        // Agregar menús a la barra
        menuBar.add(menuEstudiantes);
        menuBar.add(menuCursos);
        menuBar.add(menuInscripciones);
        menuBar.add(menuCalificaciones);
        menuBar.add(menuAcciones);
        menuBar.add(menuReportes);
        menuBar.add(menuAcercade);
        menuBar.add(menuSalir);

        add(menuBar, BorderLayout.NORTH);

        // Panel central con fondo
        panelCentral = new PanelConFondo("imagenes/fondoPrincipal.png");
        panelCentral.setLayout(new FlowLayout());
        panelCentral.add(new JLabel("Bienvenido al Sistema Académico"));
        add(panelCentral, BorderLayout.CENTER);

        // Listeners para cambiar panel
        registrarEstudiante.addActionListener(e -> cambiarPanel(new PanelRegistrarEstudiante()));
        buscarEstudiante.addActionListener(e -> cambiarPanel(new PanelBuscarEstudiante()));

        agregarCurso.addActionListener(e -> cambiarPanel(new PanelAgregarCurso()));
        eliminarCurso.addActionListener(e -> cambiarPanel(new PanelEliminarCurso()));
        listarCursos.addActionListener(e -> cambiarPanel(new PanelListarCursos()));

        inscribirEstudiante.addActionListener(e -> cambiarPanel(new PanelInscribirEstudiante()));
        listaInscritos.addActionListener(e -> cambiarPanel(new PanelListaInscritos()));
        listaEspera.addActionListener(e -> cambiarPanel(new PanelListaEspera()));

        enviarSolicitud.addActionListener(e -> cambiarPanel(new PanelEnviarSolicitud()));
        procesarSolicitud.addActionListener(e -> cambiarPanel(new PanelProcesarSolicitud()));

        deshacerAccion.addActionListener(e -> cambiarPanel(new PanelDeshacerAccion()));

        listarPromedios.addActionListener(e -> cambiarPanel(new PanelListarPorPromedio()));
        rotarTutor.addActionListener(e -> cambiarPanel(new PanelRotarRol()));
        
        acercadeItem.addActionListener(e -> cambiarPanel(new PanelMostrarIntegrantes()));

        salirItem.addActionListener(e -> System.exit(0));
    }

    // Método para cambiar el panel central
    private void cambiarPanel(JPanel nuevoPanel) {
        remove(panelCentral);
        nuevoPanel.setOpaque(false); // transparente para que se vea el fondo
        panelCentral = nuevoPanel;
        add(panelCentral, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    //Clase interna para dibujar el fondo
    class PanelConFondo extends JPanel {
        private Image backgroundImage;

        public PanelConFondo(String rutaImagen) {
            try {
                backgroundImage = ImageIO.read(new File(rutaImagen));
            } catch (Exception e) {
                System.out.println("No se pudo cargar la imagen: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }



//  Estudiantes 
    class PanelRegistrarEstudiante extends JPanel {
        private JTextField txtNombre;
        private JTextField txtTelefono;
        private JTextField txtEmail;
        private JTextField txtCalle;
        private JTextField txtNumero;
        private JTextField txtColonia;
        private JTextField txtCiudad;
        private JButton btnRegistrar;
        private final Fachada fachada;
        private Image backgroundImage;

        public PanelRegistrarEstudiante() {
            fachada = Fachada.getInstancia();
            setLayout(new BorderLayout(10, 10));

            // Panel de imagen a la izquierda
            JPanel panelImagen = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (backgroundImage != null) {
                        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    }
                }
            };
            try {
                backgroundImage = ImageIO.read(new File("imagenes/fondoRegistrarEstudiante.png"));
            } catch (Exception e) {
                System.out.println("No se pudo cargar la imagen: " + e.getMessage());
            }
            panelImagen.setPreferredSize(new Dimension(350, 0)); // ancho fijo para la imagen
            add(panelImagen, BorderLayout.WEST);

            // Panel del formulario a la derecha
            JPanel panelForm = new JPanel();
            panelForm.setLayout(new GridBagLayout());
            panelForm.setOpaque(false);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5); // espacio pequeño entre componentes
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;

            // Campos
            panelForm.add(new JLabel("Nombre:"), gbc);
            gbc.gridx = 1;
            txtNombre = new JTextField(15);
            panelForm.add(txtNombre, gbc);

            gbc.gridx = 0; gbc.gridy++;
            panelForm.add(new JLabel("Teléfono:"), gbc);
            gbc.gridx = 1;
            txtTelefono = new JTextField(15);
            panelForm.add(txtTelefono, gbc);

            gbc.gridx = 0; gbc.gridy++;
            panelForm.add(new JLabel("Email:"), gbc);
            gbc.gridx = 1;
            txtEmail = new JTextField(15);
            panelForm.add(txtEmail, gbc);

            gbc.gridx = 0; gbc.gridy++;
            panelForm.add(new JLabel("Calle:"), gbc);
            gbc.gridx = 1;
            txtCalle = new JTextField(15);
            panelForm.add(txtCalle, gbc);

            gbc.gridx = 0; gbc.gridy++;
            panelForm.add(new JLabel("Número:"), gbc);
            gbc.gridx = 1;
            txtNumero = new JTextField(15);
            panelForm.add(txtNumero, gbc);

            gbc.gridx = 0; gbc.gridy++;
            panelForm.add(new JLabel("Colonia:"), gbc);
            gbc.gridx = 1;
            txtColonia = new JTextField(15);
            panelForm.add(txtColonia, gbc);

            gbc.gridx = 0; gbc.gridy++;
            panelForm.add(new JLabel("Ciudad:"), gbc);
            gbc.gridx = 1;
            txtCiudad = new JTextField(15);
            panelForm.add(txtCiudad, gbc);

            // Botón
            gbc.gridx = 0; gbc.gridy++;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            btnRegistrar = new JButton("Registrar");
            panelForm.add(btnRegistrar, gbc);

            add(panelForm, BorderLayout.CENTER);

            // Acción del botón
            btnRegistrar.addActionListener(e -> {
                try {
                        Estudiante es = fachada.agregarEstudiante(
                        txtNombre.getText(),
                        txtTelefono.getText(),
                        txtEmail.getText(),
                        txtCalle.getText(),
                        txtNumero.getText(),
                        txtColonia.getText(),
                        txtCiudad.getText()
                    );
                    JOptionPane.showMessageDialog(this, "Estudiante registrado correctamente con la matricula: " + es.getMatricula());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }


    class PanelBuscarEstudiante extends JPanel {
        private JTextField txtMatricula;
        private JButton btnBuscar;
        private JTextArea areaResultado;
        private final Fachada fachada;
        
        public PanelBuscarEstudiante() {
            fachada = Fachada.getInstancia();

            setLayout(new BorderLayout(8, 8));

            JPanel top = new JPanel(new GridLayout(1, 3, 8, 8));
            top.add(new JLabel("Matrícula:"));
            txtMatricula = new JTextField();
            top.add(txtMatricula);
            btnBuscar = new JButton("Buscar");
            top.add(btnBuscar);
            add(top, BorderLayout.NORTH);

            areaResultado = new JTextArea();
            areaResultado.setEditable(false);
            add(new JScrollPane(areaResultado), BorderLayout.CENTER);

            btnBuscar.addActionListener(e -> {
                try {
                    String matricula = txtMatricula.getText().trim();
                    Estudiante est = fachada.buscarEstudiante(matricula);

                    Contacto contacto = est.getContacto(); 
                    String telefono = contacto.getTelefono();
                    String email    = contacto.getEmail();

                    Direccion direccion = contacto.getDireccion();
                    String direccionStr = direccion.toString();

                    String resultado =
                            "Nombre: " + est.getNombreCompleto() + "\n" +
                            "Matrícula: " + est.getMatricula() + "\n" +
                            "Teléfono: " + telefono + "\n" +
                            "Email: " + email + "\n" +
                            "Dirección: " + direccionStr;

                    areaResultado.setText(resultado);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    areaResultado.setText("");
                }
            });
        }
    }

//  Cursos 
    class PanelAgregarCurso extends JPanel {
    private JTextField txtNombreCurso;
    private JTextField txtCapacidad;   // campo para capacidad
    private JButton btnAgregar;
    private final Fachada fachada;
    private Image fondoAgregarCurso;

    public PanelAgregarCurso() {
        fachada = Fachada.getInstancia();

        try {
            fondoAgregarCurso = ImageIO.read(new File("imagenes/fondoAgregarCurso.png"));
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen de fondo: " + e.getMessage());
        }

        setLayout(new BorderLayout());

        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setOpaque(false);

        // Fila nombre
        JPanel filaNombre = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        filaNombre.setOpaque(false);
        filaNombre.add(new JLabel("Nombre curso:"));
        txtNombreCurso = new JTextField(15);
        filaNombre.add(txtNombreCurso);
        centro.add(filaNombre);

        // Fila capacidad
        JPanel filaCapacidad = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        filaCapacidad.setOpaque(false);
        filaCapacidad.add(new JLabel("Capacidad:"));
        txtCapacidad = new JTextField(5);
        filaCapacidad.add(txtCapacidad);
        centro.add(filaCapacidad);

        // Fila botón
        JPanel filaBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        filaBoton.setOpaque(false);
        btnAgregar = new JButton("Agregar");
        btnAgregar.setPreferredSize(new Dimension(120, 30));
        filaBoton.add(btnAgregar);
        centro.add(filaBoton);

        add(centro, BorderLayout.CENTER);

        // Acción del botón
        btnAgregar.addActionListener(e -> {
            try {
                String nombre = txtNombreCurso.getText().trim();
                String capacidadStr = txtCapacidad.getText().trim();

                if (nombre.isBlank() || capacidadStr.isBlank()) {
                    throw new IllegalArgumentException("Debe ingresar nombre y capacidad");
                }

                int capacidad = Integer.parseInt(capacidadStr);
                if (capacidad <= 0) {
                    throw new IllegalArgumentException("La capacidad debe ser mayor que cero");
                }

                Curso c = fachada.agregarCurso(nombre, String.valueOf(capacidad));
                JOptionPane.showMessageDialog(this, "Curso agregado correctamente con la clave: " + c.getClave());

                // limpiar campos
                txtNombreCurso.setText("");
                txtCapacidad.setText("");
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "La capacidad debe ser un número entero",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondoAgregarCurso != null) {
            g.drawImage(fondoAgregarCurso, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


    class PanelEliminarCurso extends JPanel {
    private JTextField txtClave;
    private JButton btnEliminar;
    private final Fachada fachada;
    private Image fondoEliminarCurso;

    public PanelEliminarCurso() {
        fachada = Fachada.getInstancia();
        setLayout(new BorderLayout(10, 10));

        // Panel de imagen a la izquierda
        JPanel panelImagen = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (fondoEliminarCurso != null) {
                    g.drawImage(fondoEliminarCurso, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        try {
            fondoEliminarCurso = ImageIO.read(new File("imagenes/fondoEliminarCurso.png"));
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen de fondo: " + e.getMessage());
        }
        panelImagen.setPreferredSize(new Dimension(250, 0)); // ancho fijo para la imagen
        add(panelImagen, BorderLayout.WEST);

        // Panel del formulario a la derecha
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
        panelForm.setOpaque(false);

        JLabel lblClave = new JLabel("Clave curso:");
        lblClave.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(lblClave);

        txtClave = new JTextField(12);
        txtClave.setMaximumSize(new Dimension(200, 25));
        txtClave.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(txtClave);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setPreferredSize(new Dimension(120, 30));
        btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(Box.createRigidArea(new Dimension(0, 10))); // espacio
        panelForm.add(btnEliminar);

        add(panelForm, BorderLayout.CENTER);

        // Acción del botón
        btnEliminar.addActionListener(e -> {
            try {
                String clave = txtClave.getText().trim();
                fachada.eliminarCurso(clave);

                JOptionPane.showMessageDialog(this,
                        "Curso eliminado correctamente",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);

                txtClave.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            });
        }
    }



    class PanelListarCursos extends JPanel {
    private JTable tabla;
    private JButton btnListar;
    private final Fachada fachada;

    public PanelListarCursos() {
        fachada = Fachada.getInstancia();
        setLayout(new BorderLayout());

        String[] cols = {"Clave", "Nombre", "Capacidad"};
        DefaultTableModel modelo = new DefaultTableModel(cols, 0);
        tabla = new JTable(modelo);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnListar = new JButton("Listar");
        add(btnListar, BorderLayout.SOUTH);

        // Acción del botón
        btnListar.addActionListener(e -> {
            try {
                // Limpiar la tabla antes de llenarla
                modelo.setRowCount(0);

                ListaEnlazadaSimple<Curso> cursos = fachada.listarCursos();
                for (Curso c : cursos) {
                    Object[] fila = {c.getClave(), c.getNombre(), c.getCupoMaximo()};
                    modelo.addRow(fila);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error al listar cursos: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}


    //  Inscripciones 
    class PanelInscribirEstudiante extends JPanel {
    private JTextField txtClaveCurso;
    private JTextField txtMatriculaEstudiante;
    private JButton btnInscribir;
    private final Fachada fachada;
    private Image fondo;

    public PanelInscribirEstudiante() {
        fachada = Fachada.getInstancia();
        setLayout(new BorderLayout(10, 10));

        // Panel de imagen a la izquierda
        JPanel panelImagen = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (fondo != null) {
                    g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        try {
            fondo = ImageIO.read(new File("imagenes/fondoInscribirEstudianteCurso.png"));
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen de fondo: " + e.getMessage());
        }
        panelImagen.setPreferredSize(new Dimension(350, 0)); // ancho fijo para la imagen
        add(panelImagen, BorderLayout.WEST);

        // Panel del formulario a la derecha
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
        panelForm.setOpaque(false);

        JLabel lblClave = new JLabel("Clave del curso:");
        lblClave.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(lblClave);

        txtClaveCurso = new JTextField();
        txtClaveCurso.setMaximumSize(new Dimension(180, 25)); // campo más pequeño
        txtClaveCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(txtClaveCurso);

        panelForm.add(Box.createRigidArea(new Dimension(0, 10))); // espacio

        JLabel lblMatricula = new JLabel("Matrícula del estudiante:");
        lblMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(lblMatricula);

        txtMatriculaEstudiante = new JTextField();
        txtMatriculaEstudiante.setMaximumSize(new Dimension(180, 25)); // campo más pequeño
        txtMatriculaEstudiante.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(txtMatriculaEstudiante);

        panelForm.add(Box.createRigidArea(new Dimension(0, 15))); // espacio

        btnInscribir = new JButton("Inscribir");
        btnInscribir.setPreferredSize(new Dimension(120, 30));
        btnInscribir.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(btnInscribir);

        add(panelForm, BorderLayout.CENTER);

        // Acción del botón
        btnInscribir.addActionListener(e -> {
            try {
                if (txtClaveCurso.getText().isBlank() || txtMatriculaEstudiante.getText().isBlank()) {
                    throw new IllegalArgumentException("Debe matricula del curso y del estudiante");
                }
                
                Estudiante es = fachada.buscarEstudiante(txtMatriculaEstudiante.getText());
                Curso c = fachada.buscarCurso(txtClaveCurso.getText());
                
                int opcion = JOptionPane.showConfirmDialog(null, "¿Inscribir al estudiante " +es.getMatricula() +": " + es.getNombreCompleto() + " en el curso " + c.getClave() +": " + c.getNombre(), "Confirmar inscripcion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (opcion == JOptionPane.YES_OPTION) {
                    Inscripcion i = fachada.agregarInscripcion(
                            txtClaveCurso.getText(),
                            txtMatriculaEstudiante.getText()
                    );
                    JOptionPane.showMessageDialog(this, "Inscripción realizada correctamente con la clave: " + i.getId());
                }
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}


    class PanelListaInscritos extends JPanel {
        private final Fachada fachada;
        private JTextField txtClaveCurso;
        private JButton btnMostrar;
        private JTextArea areaResultados;

        public PanelListaInscritos() {
            fachada = Fachada.getInstancia();
            setLayout(new BorderLayout());

            // Panel superior con campo y botón
            JPanel top = new JPanel(new FlowLayout());
            top.add(new JLabel("Clave curso:"));
            txtClaveCurso = new JTextField(12);
            top.add(txtClaveCurso);
            btnMostrar = new JButton("Mostrar inscritos");
            top.add(btnMostrar);
            add(top, BorderLayout.NORTH);

            // Área de resultados
            areaResultados = new JTextArea("Lista inscritos...");
            areaResultados.setEditable(false);
            add(new JScrollPane(areaResultados), BorderLayout.CENTER);

            // Acción del botón
            btnMostrar.addActionListener(e -> {
                try {
                    String clave = txtClaveCurso.getText().trim();
                    Curso curso = fachada.buscarCurso(clave); // buscar curso por clave

                    if (curso == null) {
                        areaResultados.setText("No se encontró el curso con clave: " + clave);
                        return;
                    }

                    ListaEnlazadaSimple<Estudiante> inscritos = curso.getListaEstudiantes();
                    if (inscritos.vacio()) {
                        areaResultados.setText("El curso " + curso.getNombre() + " no tiene estudiantes inscritos.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Estudiantes inscritos en ").append(curso.getNombre()).append(":\n\n");
                        for (Estudiante eInscrito : inscritos) {
                            sb.append(eInscrito.getMatricula())
                              .append(" - ")
                              .append(eInscrito.getNombreCompleto())
                              .append("\n");
                        }
                        areaResultados.setText(sb.toString());
                    }
                } catch (Exception ex) {
                    areaResultados.setText("Error al mostrar inscritos: " + ex.getMessage());
                }
            });
        }
    }


    class PanelListaEspera extends JPanel {
    private final Fachada fachada;
    private JTextField txtClaveCurso;
    private JSpinner spinnerCantidad;
    private JButton btnMostrar;
    private JTextArea areaResultados;

    public PanelListaEspera() {
            fachada = Fachada.getInstancia();
            setLayout(new BorderLayout());

            // Panel superior con campo y botón
            JPanel top = new JPanel(new FlowLayout());
            top.add(new JLabel("Clave curso:"));
            txtClaveCurso = new JTextField(12);
            top.add(txtClaveCurso);

            top.add(new JLabel("N primeros:"));
            spinnerCantidad = new JSpinner(new SpinnerNumberModel(5, 1, 100, 1));
            top.add(spinnerCantidad);

            btnMostrar = new JButton("Mostrar espera");
            top.add(btnMostrar);
            add(top, BorderLayout.NORTH);

            // Área de resultados
            areaResultados = new JTextArea("Lista espera...");
            areaResultados.setEditable(false);
            add(new JScrollPane(areaResultados), BorderLayout.CENTER);

            // Acción del botón
            btnMostrar.addActionListener(e -> {
                try {
                    String clave = txtClaveCurso.getText().trim();
                    int cantidad = (int) spinnerCantidad.getValue();

                    Curso curso = fachada.buscarCurso(clave); // buscar curso por clave
                    if (curso == null) {
                        areaResultados.setText("No se encontró el curso con clave: " + clave);
                        return;
                    }

                    ListaDobleEnlazadaCircular<Estudiante> listaEspera = curso.getListaEspera();
                    if (listaEspera.vacio()) {
                        areaResultados.setText("El curso " + curso.getNombre() + " no tiene estudiantes en lista de espera.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Primeros ").append(cantidad)
                          .append(" estudiantes en lista de espera del curso ")
                          .append(curso.getNombre()).append(":\n\n");

                        for (int i = 0; i < cantidad && i < listaEspera.tamanio(); i++) {
                            Estudiante eEspera = listaEspera.obtener(i);
                            sb.append(eEspera.getMatricula())
                              .append(" - ")
                              .append(eEspera.getNombreCompleto())
                              .append("\n");
                        }
                        areaResultados.setText(sb.toString());
                    }
                } catch (Exception ex) {
                    areaResultados.setText("Error al mostrar lista de espera: " + ex.getMessage());
                }
            });
        }
    }


    class PanelEnviarSolicitud extends JPanel {
    private JTextField txtMatricula, txtClaveCurso;
    private JSpinner spCalificacion;
    private JButton btnEnviar;
    private final Fachada fachada;
    private Image fondo;

    public PanelEnviarSolicitud() {
        fachada = Fachada.getInstancia();
        setLayout(new BorderLayout(10, 10));

        // Panel de imagen a la izquierda
        JPanel panelImagen = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (fondo != null) {
                    g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        try {
            fondo = ImageIO.read(new File("imagenes/fondoSolicitudCalificacion.png"));
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen de fondo: " + e.getMessage());
        }
        panelImagen.setPreferredSize(new Dimension(350, 0)); // ancho más grande para la imagen
        add(panelImagen, BorderLayout.WEST);

        // Panel del formulario a la derecha
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
        panelForm.setOpaque(false);

        JLabel lblMatriculaEstudiante = new JLabel("Matrícula del estudiante:");
        lblMatriculaEstudiante.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(lblMatriculaEstudiante);

        txtMatricula = new JTextField();
        txtMatricula.setMaximumSize(new Dimension(180, 25)); // campo más pequeño
        txtMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(txtMatricula);
        
        
        JLabel lblMatriculaCurso = new JLabel("Clave del curso:");
        lblMatriculaCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(lblMatriculaCurso);

        txtClaveCurso = new JTextField();
        txtClaveCurso.setMaximumSize(new Dimension(180, 25)); // campo más pequeño
        txtClaveCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(txtClaveCurso);
        
        

        panelForm.add(Box.createRigidArea(new Dimension(0, 10))); // espacio

        JLabel lblCalificacion = new JLabel("Calificación:");
        lblCalificacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(lblCalificacion);

        spCalificacion = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1));
        spCalificacion.setMaximumSize(new Dimension(100, 25)); // spinner más pequeño
        spCalificacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(spCalificacion);

        panelForm.add(Box.createRigidArea(new Dimension(0, 15))); // espacio

        btnEnviar = new JButton("Enviar solicitud");
        btnEnviar.setPreferredSize(new Dimension(150, 30));
        btnEnviar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelForm.add(btnEnviar);

        add(panelForm, BorderLayout.CENTER);

        // Acción del botón
        btnEnviar.addActionListener(e -> {
            try {
                
                if (txtClaveCurso.getText().isBlank() || txtClaveCurso.getText().isBlank()) {
                    throw new IllegalArgumentException("Debe matricula del curso y del estudiante");
                }
                
                String matriculaEstudiante = txtMatricula.getText();
                String calveCurso = txtClaveCurso.getText();
                String calificacion = spCalificacion.getValue()+"";
                
                Estudiante es = fachada.buscarEstudiante(matriculaEstudiante);
                Curso c = fachada.buscarCurso(calveCurso);
                
                int opcion = JOptionPane.showConfirmDialog(null, "¿Subir calificacion "+calificacion + " para el estudiante " +es.getMatricula() +": " + es.getNombreCompleto() + " en el curso " + c.getClave() +": " + c.getNombre(), "Confirmar envio de calificacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (opcion == JOptionPane.YES_OPTION) {
                fachada.registrarSolicitudCalificacion(matriculaEstudiante, calveCurso, calificacion);
                JOptionPane.showMessageDialog(this, "Solicitud enviada correctamente");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}


    class PanelProcesarSolicitud extends JPanel {
        private JButton btnProcesar;
        private final Fachada fachada;

        public PanelProcesarSolicitud() {
            fachada = Fachada.getInstancia();
            setLayout(new FlowLayout());

            btnProcesar = new JButton("Procesar siguiente solicitud");
            add(btnProcesar);

            btnProcesar.addActionListener(e -> {
                try {
                    fachada.procesarSiguienteSolicitud();
                    JOptionPane.showMessageDialog(this,
                            "Solicitud procesada correctamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            "Error al procesar la solicitud: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }


//  Acciones 
    class PanelDeshacerAccion extends JPanel {
        private JButton btnDeshacer;
        private final Fachada fachada;

        public PanelDeshacerAccion() {
            fachada = Fachada.getInstancia();
            setLayout(new FlowLayout());

            btnDeshacer = new JButton("Deshacer última acción");
            add(btnDeshacer);

            // Acción del botón
            btnDeshacer.addActionListener(e -> {
                try {
                    fachada.deshacerUltimaAccion();
                    JOptionPane.showMessageDialog(this,
                            "Se deshizo la última acción correctamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            "No se pudo deshacer la acción: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }


//  Reportes 
    class PanelListarPorPromedio extends JPanel {
        private JButton btnListar;
        private JTextArea txtResultados;
        private final Fachada fachada;

        public PanelListarPorPromedio() {
            fachada = Fachada.getInstancia();
            setLayout(new BorderLayout());

            btnListar = new JButton("Listar estudiantes por promedio");
            add(btnListar, BorderLayout.NORTH);

            txtResultados = new JTextArea("Resultados...");
            txtResultados.setEditable(false);
            add(new JScrollPane(txtResultados), BorderLayout.CENTER);

            // Acción del botón
            btnListar.addActionListener(e -> {
                try {
                    ListaEnlazadaSimple<Promedio> promedios = fachada.listarPromedios();

                    StringBuilder sb = new StringBuilder();
                    sb.append("Listado de estudiantes por promedio:\n\n");
                    for (Promedio p : promedios) {
                        sb.append("Estudiante: ").append(p.getEstudiante().getNombreCompleto())
                          .append(" | Promedio: ").append(p.getPromedio())
                          .append("\n");
                    }

                    txtResultados.setText(sb.toString());
                } catch (Exception ex) {
                    txtResultados.setText("Error al listar promedios: " + ex.getMessage());
                }
            });
        }
    }


    class PanelRotarRol extends JPanel {
    private Image backgroundImage;
    private JTextField txtClave;
    private JButton btnRotar;
    private final Fachada fachada;

    // Etiquetas para mostrar líderes
    private JLabel lblAnterior;
    private JLabel lblActual;
    private JLabel lblSiguiente;

    public PanelRotarRol() {
        fachada = Fachada.getInstancia();
        try {
            // Carga la imagen desde carpeta relativa "imagenes"
            backgroundImage = ImageIO.read(new File("imagenes/fondoRotarRol.png"));
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: " + e.getMessage());
        }

        setLayout(new BorderLayout(10, 10));

        // Panel central con clave y botón
        JPanel panelForm = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelForm.setOpaque(false);

        JLabel lblClave = new JLabel("Clave curso:");
        lblClave.setOpaque(false);
        panelForm.add(lblClave);

        txtClave = new JTextField(12);
        txtClave.setOpaque(false); // transparente para ver el fondo
        panelForm.add(txtClave);

        btnRotar = new JButton("Rotar rol tutor/líder");
        btnRotar.setPreferredSize(new Dimension(180, 30)); // tamaño compacto
        panelForm.add(btnRotar);

        add(panelForm, BorderLayout.CENTER);

        // Panel inferior con etiquetas en la misma línea
        JPanel panelLideres = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelLideres.setOpaque(false); // transparente para ver el fondo

        lblAnterior  = new JLabel("Líder anterior: ");
        lblActual    = new JLabel("Líder actual: ");
        lblSiguiente = new JLabel("Siguiente líder: ");

        panelLideres.add(lblAnterior);
        panelLideres.add(lblActual);
        panelLideres.add(lblSiguiente);

        add(panelLideres, BorderLayout.SOUTH);

        // Acción del botón Rotar
        btnRotar.addActionListener(e -> {
            try {
                // Rota el rol en el curso
                fachada.buscarCurso(txtClave.getText()).rotarRol();

                // Obtén los líderes actualizados desde Fachada
                String[] lideres = fachada.obtenerLideres(txtClave.getText());

                // Actualiza las etiquetas
                lblAnterior.setText("Líder anterior: " + lideres[0]);
                lblActual.setText("Líder actual: " + lideres[1]);
                lblSiguiente.setText("Siguiente líder: " + lideres[2]);

                JOptionPane.showMessageDialog(this, "Rol rotado correctamente");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Dibuja la imagen escalada al tamaño del panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}




    
    class PanelMostrarIntegrantes extends JPanel {
        private Image backgroundImage;

        public PanelMostrarIntegrantes() {
            try {
            // Carga la imagen desde carpeta relativa "imagenes"
            backgroundImage = ImageIO.read(new File("imagenes/fondoIntegrantes.png"));
            } catch (Exception e) {
                System.out.println("No se pudo cargar la imagen: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Dibuja la imagen escalada al tamaño del panel
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
    
   

