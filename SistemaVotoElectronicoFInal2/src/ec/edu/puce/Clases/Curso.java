package ec.edu.puce.Clases;

import java.util.List;

public class Curso {
	
	private String nombreCurso;
	private List <Estudiantes> estudiantesCurso;
	
	

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public List <Estudiantes> getEstudiantesCurso() {
		return estudiantesCurso;
	}

	public void setEstudiantesCurso(List <Estudiantes> estudiantesCurso) {
		this.estudiantesCurso = estudiantesCurso;
	}

}