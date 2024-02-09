package ec.edu.puce.Formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import ec.edu.puce.Clases.*;

import javax.swing.JLabel;
import java.awt.Color;

public class AsignarMesas extends JInternalFrame implements ActionListener {
	private List<Mesas> mesas;
	private CrearMesas CrearMesas; 
	private List<Estudiantes> estudiantes;
	private List <Estudiantes> estudiantesDeMesa;

	private static final long serialVersionUID = 1L;

	public AsignarMesas( final List<Mesas> mesas, final List<Estudiantes> estudiantes) {
		getContentPane().setBackground(new Color(64, 0, 128));
		setTitle("MESAS -ESCOGE UNA OPCIÓN-");
		this.mesas = mesas;
		this.estudiantes = estudiantes;
		
		setBounds(100, 100, 712, 491);
		getContentPane().setLayout(null);
		
		final JPanel panelChiquito = new JPanel();
		panelChiquito.setBackground(new Color(128, 0, 255));
		panelChiquito.setBounds(10, 11, 676, 439);
		getContentPane().add(panelChiquito);
		panelChiquito.setLayout(null);
		
		JButton btnCrearMesas = new JButton("Crear Mesas");
		btnCrearMesas.setBackground(new Color(255, 255, 255));
		btnCrearMesas.setBounds(10, 11, 190, 29);
		panelChiquito.add(btnCrearMesas);
		btnCrearMesas.setFont(new Font("Tahoma", Font.ITALIC, 17));
		
		JButton btnNewButton_1 = new JButton("Añadir Estudiantes a Mesas");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AggMesa panelAñadirEstMesa = new AggMesa(mesas, estudiantes, estudiantesDeMesa );
		        panelChiquito.add(panelAñadirEstMesa);
		        panelAñadirEstMesa.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(205, 11, 265, 29);
		panelChiquito.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.ITALIC, 17));
		btnSalir.setBounds(476, 11, 190, 29);
		panelChiquito.add(btnSalir);
		btnCrearMesas.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

				 CrearMesas panelCrearMesas = new CrearMesas(mesas);
			        panelChiquito.add(panelCrearMesas);
			        panelCrearMesas.setVisible(true);
				 
				 
	            }
	        });
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
