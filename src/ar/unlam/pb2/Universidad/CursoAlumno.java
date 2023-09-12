package ar.unlam.pb2.Universidad;

import java.util.ArrayList;
import java.util.Objects;

public class CursoAlumno {
	
	private Curso curso;
	private Alumno alumno;
	private ArrayList<Nota> notas;
	public CursoAlumno(Curso curso, Alumno alumno) {
		this.curso = curso;
		this.alumno = alumno;
		this.notas = new ArrayList<>();
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(alumno, curso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoAlumno other = (CursoAlumno) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(curso, other.curso);
	}
	
	
	
	
	
	
	
}
