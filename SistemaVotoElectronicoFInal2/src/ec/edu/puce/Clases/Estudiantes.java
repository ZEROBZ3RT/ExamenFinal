package ec.edu.puce.Clases;

import ec.edu.puce.Clases.Candidatos;
import ec.edu.puce.Clases.Curso;
import ec.edu.puce.Clases.Mesas;

public class Estudiantes {
    
    private String nombreEstudiante;
    private String cedulaEstudiante;
    private Curso curso;
    private Mesas mesaDelEstudiante;
    private Candidatos candidatoVotado;
    private boolean voto;

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Mesas getMesaDelEstudiante() {
        return mesaDelEstudiante;
    }

    public void setMesaDelEstudiante(Mesas mesaDelEstudiante) {
        this.mesaDelEstudiante = mesaDelEstudiante;
    }

    public Candidatos getCandidatoVotado() {
        return candidatoVotado;
    }

    public void setCandidatoVotado(Candidatos candidatoVotado) {
        this.candidatoVotado = candidatoVotado;
    }

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }
}
