package ec.edu.puce.Formularios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import ec.edu.puce.Sistema.SistemaDeVotacion;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class FinalVotacion extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistemaDeVotacion;
    private JTextField txtSufragar;


	public FinalVotacion() {
		getContentPane().setBackground(new Color(128, 0, 255));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		
		JButton btnSALIR = new JButton("SALIR");
		btnSALIR.setBackground(new Color(255, 255, 255));
		btnSALIR.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnSALIR.setBounds(0, 241, 434, 29);
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnSALIR);
		
		JLabel lblGracias = new JLabel("¡Gracias por votar!");
		lblGracias.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblGracias.setBounds(131, 76, 249, 70);
		getContentPane().add(lblGracias);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
