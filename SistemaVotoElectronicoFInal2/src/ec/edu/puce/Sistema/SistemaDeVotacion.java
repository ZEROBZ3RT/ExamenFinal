package ec.edu.puce.Sistema;

import java.awt.EventQueue;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import ec.edu.puce.Clases.*;
import ec.edu.puce.Formularios.AggCandidatos;
import ec.edu.puce.Formularios.AgregarEstudiantes;
import ec.edu.puce.Formularios.AsignarMesas;
import ec.edu.puce.Formularios.Estadisticas;
import ec.edu.puce.Formularios.FinalVotacion;
import ec.edu.puce.Formularios.IngresoVotante;
import ec.edu.puce.Formularios.PadronElectoral;
import ec.edu.puce.Formularios.RestGeneral;
import ec.edu.puce.Formularios.RestMesas;
import ec.edu.puce.Formularios.ScreenCurso;
import ec.edu.puce.Formularios.Votacion;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SistemaDeVotacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List <Candidatos> candidatos;
	private List <Curso> cursos;
	private List <Estudiantes> estudiantes;
	private List<Estudiantes> estudiantesMesa;
	private List <Mesas> mesas;
	
    private Map<Estudiantes, Mesas> asignacionesDeMesa;
    private Estudiantes estudiante;
    
    private Map<String, Candidatos> votosPorEstudiante;
	private PadronElectoral padronElectoral;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaDeVotacion frame = new SistemaDeVotacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SistemaDeVotacion() {
		setTitle("Sistema De Voto Electronico 2.0.0");
		setBackground(new Color(148, 191, 235));
		
		candidatos = new ArrayList<>(); 
		cursos = new ArrayList<>(); 
		estudiantes = new ArrayList<>();
		mesas = new ArrayList<>(); 
		estudiantesMesa = new ArrayList<>();
        asignacionesDeMesa = new HashMap<>();

        this.votosPorEstudiante = new HashMap<>();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 697);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 128, 255));
		menuBar.setForeground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("ARCHIVO");
		mnArchivo.setBackground(new Color(128, 128, 255));
		mnArchivo.setForeground(new Color(0, 0, 0));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setBackground(new Color(128, 128, 255));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAdministracion = new JMenu("ADMINISTRACIÓN");
		mnAdministracion.setBackground(new Color(128, 128, 255));
		mnAdministracion.setForeground(new Color(0, 0, 0));
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmMesas = new JMenuItem("Mesas");
		mntmMesas.setBackground(new Color(128, 128, 255));
		mntmMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AsignarMesas panelEleccionMesas = new AsignarMesas(mesas, estudiantes);
		        contentPane.add(panelEleccionMesas);
		        panelEleccionMesas.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmMesas);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mntmCursos.setBackground(new Color(128, 128, 255));
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ScreenCurso panelCurso = new ScreenCurso(cursos);
			        contentPane.add(panelCurso);
			        panelCurso.setVisible(true);
			}
		});
		mnAdministracion.add(mntmCursos);
		
		JMenuItem mntmEstudiantes = new JMenuItem("Estudiantes");
		mntmEstudiantes.setBackground(new Color(128, 128, 255));
		mntmEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarEstudiantes panelEstudiantes = new AgregarEstudiantes(cursos , estudiantes);
			        contentPane.add(panelEstudiantes);
			        panelEstudiantes.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmEstudiantes);
		
		JMenuItem mntmCandidatos = new JMenuItem("Candidatos");
		mntmCandidatos.setBackground(new Color(128, 128, 255));
		mntmCandidatos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	AggCandidatos panelCandidatos = new AggCandidatos(candidatos);
		        contentPane.add(panelCandidatos);
		        panelCandidatos.setVisible(true);
		    }
		});
		

		mnAdministracion.add(mntmCandidatos);
		
		
		mnAdministracion.add(mntmCandidatos);
		
		JMenu mnProceso = new JMenu("PROCESO");
		mnProceso.setBackground(new Color(128, 128, 255));
		mnProceso.setForeground(new Color(0, 0, 0));
		menuBar.add(mnProceso);
		
		JMenuItem mntmSufragar = new JMenuItem("Sufragar");
		mntmSufragar.setBackground(new Color(128, 128, 255));
		mntmSufragar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				IngresoVotante sufragar = new IngresoVotante(SistemaDeVotacion.this);
		        contentPane.add(sufragar);
		        sufragar.setVisible(true);
				
			}
		});
		mnProceso.add(mntmSufragar);
		
				
		JMenu mnReportes = new JMenu("REPORTES");
		mnReportes.setBackground(new Color(128, 128, 255));
		mnReportes.setForeground(new Color(0, 0, 0));
		menuBar.add(mnReportes);
		
		JMenuItem mntmPadron = new JMenuItem("Padrón Electoral");
		mntmPadron.setBackground(new Color(128, 128, 255));
		mntmPadron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PadronElectoral panelPadronElectoral = new PadronElectoral(
						mesas,
						estudiantes,
						estudiantesMesa);
				contentPane.add(panelPadronElectoral);
				panelPadronElectoral.setVisible(true);
			}
		});
		mnReportes.add(mntmPadron);
		
		JMenuItem mntmResultadosGenerales = new JMenuItem("Resultados Generales");
		mntmResultadosGenerales.setBackground(new Color(128, 128, 255));
		mntmResultadosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestGeneral resultadosGenerales = new RestGeneral(candidatos);
		        contentPane.add(resultadosGenerales);
		        resultadosGenerales.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosGenerales);
		
		JMenuItem mntmResultadosPorMesas = new JMenuItem("Resultados por Mesas");
		mntmResultadosPorMesas.setBackground(new Color(128, 128, 255));
		mntmResultadosPorMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestMesas resultadosMesas = new RestMesas(candidatos, mesas);
		        contentPane.add(resultadosMesas);
		        resultadosMesas.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosPorMesas);
		
		JMenuItem mntmResultadosEnGrfico = new JMenuItem("Resultados en Gráfico");
		mntmResultadosEnGrfico.setBackground(new Color(128, 128, 255));
		mntmResultadosEnGrfico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estadisticas panelGraficos = new Estadisticas(candidatos);
		        contentPane.add(panelGraficos);
		        panelGraficos.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosEnGrfico);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(148, 191, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}

	
	public void abrirSufragar2(String cedulaEstudiante) {
		Votacion sufragarP2 = new Votacion(this, cedulaEstudiante);
	    sufragarP2.setLocation(100, 100);
	    contentPane.add(sufragarP2);
	    sufragarP2.setVisible(true);
	}


	public void abrirSufragar3() {
    
	FinalVotacion sufragarP3 = new FinalVotacion();

    sufragarP3.setLocation(100, 100);

    contentPane.add(sufragarP3);
    sufragarP3.setVisible(true);
}
	public void setPadronElectoral(PadronElectoral padronElectoral) {
        this.padronElectoral = padronElectoral;
    }

    // Método para registrar un voto
    public void registrarVoto1(String cedulaEstudiante, Candidatos candidato) {
        votosPorEstudiante.put(cedulaEstudiante, candidato);

        // Actualizar el estado de votación en el PadronElectoral
        if (padronElectoral != null) {
            padronElectoral.setVotoEstudiante(cedulaEstudiante, true);
        } else {
            System.out.println("El PadronElectoral no está configurado en el SistemaDeVotacion.");
        }
    }

public List<Estudiantes> getEstudiantes() {
    return estudiantes;
}

public Mesas getMesaDeEstudiante(Estudiantes estudiante) {
    return asignacionesDeMesa.get(estudiante);
}

public Mesas getMesaPorNombre(String nombreMesa) {
    for (Mesas mesa : mesas) {
        if (mesa.getnombreMesa().equals(nombreMesa)) {
            return mesa;
        }
    }
    return null; 
}

public void asignarMesaAEstudiante(Estudiantes estudiante, Mesas mesa) {
    asignacionesDeMesa.put(estudiante, mesa);
}


public List<Candidatos> getCandidatos() {
    return candidatos;
}

public void registrarVoto(String cedulaEstudiante, Candidatos candidato) {
    votosPorEstudiante.put(cedulaEstudiante, candidato);
}

public boolean estudianteYaVoto(String cedulaEstudiante) {
    return votosPorEstudiante.containsKey(cedulaEstudiante);
}

public Candidatos getCandidatoVotadoPorEstudiante(String cedulaEstudiante) {
    return votosPorEstudiante.get(cedulaEstudiante);
}

}

