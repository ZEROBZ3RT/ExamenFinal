package ec.edu.puce.Formularios;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import ec.edu.puce.Clases.*;
import ec.edu.puce.Sistema.SistemaDeVotacion;

import java.awt.Color;


public class Votacion extends JInternalFrame {
    
    private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistemaDeVotacion;
    private Estudiantes estudiante;
    
    public Votacion(final SistemaDeVotacion sistemaDeVotacion, final String cedulaEstudiante) {
    	getContentPane().setBackground(new Color(164, 213, 244));
    	setClosable(true);
        this.sistemaDeVotacion = sistemaDeVotacion;
        this.estudiante = buscarEstudiantePorCedula(cedulaEstudiante);
        
        setTitle("BIENVENIDO");
        setBounds(100, 100, 626, 389);
        getContentPane().setLayout(null);
        
        JLabel lblHolaEstudiante = new JLabel("Hola "+estudiante.getNombreEstudiante());
        lblHolaEstudiante.setBackground(new Color(255, 255, 255));
        lblHolaEstudiante.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblHolaEstudiante.setBounds(25, 11, 219, 30);
        getContentPane().add(lblHolaEstudiante);
        
        JLabel lblMesa = new JLabel("Tu mesa es "+estudiante.getMesaDelEstudiante().getnombreMesa());
        lblMesa.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblMesa.setBounds(381, 11, 219, 30);
        getContentPane().add(lblMesa);
        
        JLabel lblEscoga = new JLabel("Escoge tu candidato.");
        lblEscoga.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblEscoga.setBounds(25, 39, 219, 30);
        getContentPane().add(lblEscoga);
        
        int y = 80;
        for (final Candidatos candidato : sistemaDeVotacion.getCandidatos()) {
            if (!sistemaDeVotacion.estudianteYaVoto(cedulaEstudiante)) { 
                JButton btnCandidato = new JButton(candidato.getNombreCandidato());
                btnCandidato.setBounds(25, y, 200, 30);
                getContentPane().add(btnCandidato);
                y += 40;
                
                btnCandidato.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sistemaDeVotacion.registrarVoto(cedulaEstudiante, candidato);
                       
                        estudiante.setCandidatoVotado(candidato);

                        candidato.aumentarVotos();

                        JOptionPane.showMessageDialog(null, "¡Voto registrado para " + candidato.getNombreCandidato() + "!");
                        dispose();
                        sistemaDeVotacion.abrirSufragar3();
                    }
                });
                
               

            } else {
                JLabel lblYaVoto = new JLabel("Usted ya ha votado");
                lblYaVoto.setBounds(25, y, 200, 30);
                getContentPane().add(lblYaVoto);
            }
        }
    }
    
    private Estudiantes buscarEstudiantePorCedula(String cedulaEstudiante) {
        for (Estudiantes estudiante : sistemaDeVotacion.getEstudiantes()) {
            if (estudiante.getCedulaEstudiante().equals(cedulaEstudiante)) {
                return estudiante;
            }
        }
        return null; 
    }
}




