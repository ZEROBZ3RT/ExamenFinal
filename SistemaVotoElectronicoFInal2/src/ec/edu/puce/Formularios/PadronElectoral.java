package ec.edu.puce.Formularios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.Clases.Estudiantes;
import ec.edu.puce.Clases.Mesas;

public class PadronElectoral extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;
    private List<Mesas> mesas;
    private List<Estudiantes> estudiantes;
    private List<Estudiantes> estudiantesDeMesa;

    public PadronElectoral(List<Mesas> mesas, List<Estudiantes> estudiantes, List<Estudiantes> estudiantesDeMesa) {
        getContentPane().setBackground(new Color(128, 0, 255));
        this.mesas = mesas;
        this.estudiantes = estudiantes;
        this.estudiantesDeMesa = estudiantesDeMesa;

        setTitle("PADRÓN ELECTORAL");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 560, 300);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Estudiante", "Mesa", "Cédula", "Curso", "Votó" }));
        scrollPane.setViewportView(table);

        JLabel lblPadronGeneral = new JLabel("PADRÓN ELECTORAL");
        lblPadronGeneral.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblPadronGeneral.setBounds(10, 11, 176, 22);
        getContentPane().add(lblPadronGeneral);

        JButton btnNewButton = new JButton("Salir");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton.setBounds(481, 11, 89, 23);
        getContentPane().add(btnNewButton);
        model = (DefaultTableModel) table.getModel();

        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                System.out.println("PanelPadronElectoral cerrado");
            }
        });

        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        model.setRowCount(0);

        for (Mesas mesa : mesas) {
            for (Estudiantes estudiante : mesa.getEstudiantesDeMesa()) {
                agregarFila(estudiante.getNombreEstudiante(),
                        mesa.getnombreMesa(),
                        estudiante.getCedulaEstudiante(),
                        estudiante.getCurso().getNombreCurso(),
                        estudiante.isVoto()); 
            }
        }
    }

    private void agregarFila(String nombreEstudiante, String nombreMesa, String cedulaEstudiante, String curso, boolean voto) {
        model.addRow(new Object[]{nombreEstudiante, nombreMesa, cedulaEstudiante, curso, voto ? "Sí" : "No"});
    }

    public void setVotoEstudiante(String cedulaEstudiante, boolean votoRealizado) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 2).equals(cedulaEstudiante)) {
                model.setValueAt(votoRealizado ? "Votó" : "No Votó", i, 4);
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String cedulaEstudiante = "cedulaEstudiante"; 
        boolean votoRealizado = true; 
        
        setVotoEstudiante(cedulaEstudiante, votoRealizado);
    }
}
