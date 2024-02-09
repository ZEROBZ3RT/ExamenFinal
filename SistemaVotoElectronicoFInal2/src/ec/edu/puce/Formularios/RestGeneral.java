package ec.edu.puce.Formularios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.Clases.*;

import java.awt.*;
import java.util.List;

@SuppressWarnings("unused")
public class RestGeneral extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;

    public RestGeneral(List<Candidatos> candidatos) {
    	getContentPane().setBackground(new Color(128, 0, 255));
    	setClosable(true);
        setTitle("RESULTADOS GENERALES");
        setBounds(100, 100, 547, 465);
        getContentPane().setLayout(null);

        JTable table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"CANDIDATO", "VOTOS TOTALES"});
        table.setModel(model);

        for (Candidatos candidato : candidatos) {
            model.addRow(new Object[]{candidato.getNombreCandidato(), candidato.getVotos()});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 511, 405);
        getContentPane().add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}



