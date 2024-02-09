package ec.edu.puce.Formularios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ec.edu.puce.Clases.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;

public class AgregarEstudiantes extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JComboBox<Curso> comboBox;
    private JLabel lblCedula;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnGuardar;
    private JButton btnNuevo;
    private JButton btnCancelar;
    private JButton btnEliminar;

    private List<Estudiantes> estudiantes;
    private List<Curso> cursos;

    public AgregarEstudiantes(List<Curso> cursos, List<Estudiantes> estudiantes) {
        getContentPane().setBackground(new Color(128, 0, 255));
        this.cursos = cursos;
        this.estudiantes = estudiantes;

        setTitle("ESTUDIANTES");
        setBounds(100, 100, 460, 454);
        getContentPane().setLayout(null);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(33, 43, 70, 15);
        getContentPane().add(lblNombres);

        txtNombre = new JTextField();
        txtNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        txtNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                agregarEstudiante();
            }
        });
        txtNombre.setBounds(100, 41, 231, 19);
        getContentPane().add(txtNombre);
        txtNombre.setColumns(10);

        btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(this);
        btnNuevo.setBounds(18, 127, 91, 25);
        getContentPane().add(btnNuevo);

        btnGuardar = new JButton("Agregar");
        btnGuardar.addActionListener(this);
        btnGuardar.setBounds(119, 127, 85, 25);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cerrar");
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(337, 127, 101, 25);
        getContentPane().add(btnCancelar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnEliminar.setBounds(218, 127, 101, 25);
        getContentPane().add(btnEliminar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(18, 162, 416, 224);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    String nombre = model.getValueAt(row, 0).toString();
                    String cedula = model.getValueAt(row, 1).toString();
                    String curso = model.getValueAt(row, 2).toString();
                    txtNombre.setText(nombre);
                    txtCedula.setText(cedula);
                    comboBox.setSelectedItem(findCurso(curso));
                }
            }
        });
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre Estudiante", "Cédula", "Curso" }));
        scrollPane.setViewportView(table);

        JLabel lblNombres_1 = new JLabel("Curso");
        lblNombres_1.setBounds(33, 14, 70, 15);
        getContentPane().add(lblNombres_1);

        comboBox = new JComboBox<>();
        DefaultComboBoxModel<Curso> comboBoxModel = new DefaultComboBoxModel<>(cursos.toArray(new Curso[0]));
        comboBox.setModel(comboBoxModel);
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                if (value instanceof Curso) {
                    Curso curso = (Curso) value;
                    value = curso.getNombreCurso();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        comboBox.setBounds(100, 5, 231, 24);
        getContentPane().add(comboBox);

        lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(33, 75, 70, 15);
        getContentPane().add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setColumns(10);
        txtCedula.setBounds(100, 73, 231, 19);
        getContentPane().add(txtCedula);

        model = (DefaultTableModel) table.getModel();
        agregarFila();
    }

    private void nuevo() {
        txtNombre.setText("");
        txtCedula.setText("");
        comboBox.setSelectedIndex(0);
    }

    private void agregarEstudiante() {
        Estudiantes estudiante = new Estudiantes();
        estudiante.setNombreEstudiante(txtNombre.getText());
        estudiante.setCedulaEstudiante(txtCedula.getText());
        estudiante.setCurso((Curso) comboBox.getSelectedItem());
        estudiantes.add(estudiante);
        agregarFila();
        nuevo();
    }

    private void eliminarEstudiante() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este estudiante?",
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                estudiantes.remove(selectedRow);
                agregarFila();
                nuevo();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un estudiante para eliminar.",
                    "Selección requerida", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void agregarFila() {
        model.setRowCount(0);
        for (Estudiantes estudiante : estudiantes) {
            Object[] fila = new Object[3];
            fila[0] = estudiante.getNombreEstudiante();
            fila[1] = estudiante.getCedulaEstudiante();
            fila[2] = estudiante.getCurso().getNombreCurso();
            model.addRow(fila);
        }
    }

    private Curso findCurso(String nombre) {
        for (Curso curso : cursos) {
            if (curso.getNombreCurso().equals(nombre)) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevo) {
            nuevo();
        } else if (e.getSource() == btnGuardar) {
            agregarEstudiante();
        } else if (e.getSource() == btnCancelar) {
            dispose();
        } else if (e.getSource() == btnEliminar) {
            eliminarEstudiante();
        }
    }

    public List<Estudiantes> getEstudiante() {
        return estudiantes;
    }
}
