package ec.edu.puce.Formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.Clases.*;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AggCandidatos extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombresCandidatos;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtPartido;
	
	private Candidatos candidato;
	private List <Candidatos> candidatos;

	public AggCandidatos( List <Candidatos> candidatos) {
		getContentPane().setBackground(new Color(128, 0, 255));
		
		this.candidatos = candidatos;
		
		setTitle("AÑADE CANDIDATOS");
		setBounds(100, 100, 564, 392);
		getContentPane().setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNombres.setBounds(10, 11, 71, 16);
		getContentPane().add(lblNombres);
		
		txtNombresCandidatos = new JTextField();
		txtNombresCandidatos.setBounds(72, 11, 298, 20);
		getContentPane().add(txtNombresCandidatos);
		txtNombresCandidatos.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 402, 279);
		getContentPane().add(scrollPane);

		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Candidato", "Partido" }));
		scrollPane.setViewportView(table);
		
		JLabel lblPartido = new JLabel("Partido:");
		lblPartido.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblPartido.setBounds(20, 39, 71, 16);
		getContentPane().add(lblPartido);
		
		txtPartido = new JTextField();
		txtPartido.setColumns(10);
		txtPartido.setBounds(72, 39, 298, 20);
		getContentPane().add(txtPartido);
		
		JButton btnAnadirCandidato = new JButton("Añadir");
		btnAnadirCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCandidato();
			}
		});
		btnAnadirCandidato.setBounds(422, 10, 120, 23);
		getContentPane().add(btnAnadirCandidato);
		
		JButton btnLimpiarCandidato = new JButton("Limpiar");
		btnLimpiarCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiarCandidato.setBounds(422, 39, 120, 23);
		getContentPane().add(btnLimpiarCandidato);
		
		JButton btnSalirCandidato = new JButton("Salir");
		btnSalirCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		btnSalirCandidato.setBounds(422, 330, 120, 23);
		getContentPane().add(btnSalirCandidato);
		
		model = (DefaultTableModel) table.getModel();
		agregarFila();
	}
	
	
	
	private void agregarCandidato() {
		candidato = new Candidatos();
		candidato.setNombreCandidato(txtNombresCandidatos.getText());
		candidato.setLista(txtPartido.getText());

		
		candidatos.add(candidato);
		agregarFila();
		txtNombresCandidatos.setText("");
		txtPartido.setText("");
	}
	
	private void limpiarCampos() {
		txtNombresCandidatos.setText("");
		txtPartido.setText("");
	}

	
	private void agregarFila() {
		model.setRowCount(0);
		for (Candidatos candidato : candidatos) {
			Object[] fila = new Object[2];
			fila[0] = candidato.getNombreCandidato();
			fila[1] = candidato.getLista();
			model.addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
