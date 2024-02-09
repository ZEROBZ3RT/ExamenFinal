package ec.edu.puce.Formularios;

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


import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;

public class CrearMesas extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombreMesa;
    private JTable table;
    private DefaultTableModel model;
    private List<Mesas> mesas;

    public CrearMesas(List<Mesas> mesas) {
    	getContentPane().setBackground(new Color(128, 0, 255));
    	setClosable(true);
        this.mesas = mesas;
        initComponents();
    }

    private void initComponents() {
        setTitle("CREAR MESAS");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JLabel lblNombreMesa = new JLabel("Nombre de la Mesa:");
        lblNombreMesa.setBounds(29, 36, 150, 20);
        getContentPane().add(lblNombreMesa);

        txtNombreMesa = new JTextField();
        txtNombreMesa.setBounds(147, 36, 150, 20);
        getContentPane().add(txtNombreMesa);
        txtNombreMesa.setColumns(10);

        JButton btnAgregarMesa = new JButton("Agregar Mesa");
        btnAgregarMesa.setBounds(307, 35, 150, 23);
        btnAgregarMesa.addActionListener(this);
        getContentPane().add(btnAgregarMesa);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 83, 500, 267);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Mesa"});
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("Limpiar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				limpiarCampos();

        	}
        });
        btnNewButton.setBounds(474, 35, 89, 23);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("CREAR MESAS");
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblNewLabel.setBounds(239, 11, 97, 14);
        getContentPane().add(lblNewLabel);

        mostrarMesas();
    }

    private void mostrarMesas() {
        for (Mesas mesa : mesas) {
            Object[] row = {mesa.getnombreMesa()};
            model.addRow(row);
        }
    }

    private void limpiarCampos() {
		txtNombreMesa.setText("");
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar Mesa")) {
            String nombreMesa = txtNombreMesa.getText();
            Mesas nuevaMesa = new Mesas();
            nuevaMesa.setnombreMesa(nombreMesa);
            mesas.add(nuevaMesa);
            Object[] row = {nombreMesa};
            model.addRow(row);
            txtNombreMesa.setText("");
        }
    }
}


