package ec.edu.puce.Formularios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import ec.edu.puce.Clases.*;

import java.awt.Color;

@SuppressWarnings("unused")
public class Estadisticas extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public Estadisticas(List <Candidatos> candidatos) {
    	setBackground(new Color(192, 192, 192));
    	getContentPane().setBackground(new Color(192, 192, 192));
    	setClosable(true);
        setTitle("RESULTADOS EN BARRAS");
        setBounds(100, 100, 450, 300);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Candidatos candidato : candidatos) {
            dataset.addValue(candidato.getVotos(), "Votos", candidato.getNombreCandidato());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Resultados de Votaciones", 
                "Candidatos", 
                "Votos",
                dataset 
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(128, 0, 255));
        getContentPane().add(chartPanel);
    }
}
