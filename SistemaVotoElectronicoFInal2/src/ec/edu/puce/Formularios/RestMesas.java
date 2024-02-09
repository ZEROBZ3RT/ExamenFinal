package ec.edu.puce.Formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.Clases.*;

import java.awt.*;
import java.util.List;

@SuppressWarnings("unused")
public class RestMesas extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public RestMesas(List<Candidatos> candidatos, List<Mesas> mesas) {
    	getContentPane().setBackground(new Color(128, 128, 128));
        setClosable(true);
        setTitle("RESULTADOS POR MESA");
        setBounds(100, 100, 800, 600);

        getContentPane().setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        model.addColumn("Candidato");

        for (Mesas mesa : mesas) {
            model.addColumn(mesa.getnombreMesa());
        }

        for (Candidatos candidato : candidatos) {
            Object[] row = new Object[mesas.size() + 1]; 
            row[0] = candidato.getNombreCandidato();

          
            for (int i = 0; i < mesas.size(); i++) {
                int votosEnMesa = obtenerVotosEnMesa(candidato, mesas.get(i));
                row[i + 1] = votosEnMesa; 
            }

            model.addRow(row);
        }
    }

    private int obtenerVotosEnMesa(Candidatos candidato, Mesas mesa) {
        int votosEnMesa = 0;
        for (Estudiantes estudiante : mesa.getEstudiantesDeMesa()) {
            if (estudiante.getCandidatoVotado() != null && estudiante.getCandidatoVotado().equals(candidato)) {
                votosEnMesa++;
            }
        }
        return votosEnMesa;
    }
}

