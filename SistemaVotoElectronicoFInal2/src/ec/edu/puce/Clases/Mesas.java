package ec.edu.puce.Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mesas {
	
	private String nombreMesa;
	private List <Estudiantes> estudiantesDeMesa;
	

	
	 public Mesas() {
	        this.estudiantesDeMesa = new ArrayList<>();

	    }
	
	public String getnombreMesa() {
		return nombreMesa;
	}
	public void setnombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}
	public List <Estudiantes> getEstudiantesDeMesa() {
		return estudiantesDeMesa;
	}
	public void setEstudiantesDeMesa(List <Estudiantes> estudiantesDeMesa) {
		this.estudiantesDeMesa = estudiantesDeMesa;
	}
	
	
	

}

