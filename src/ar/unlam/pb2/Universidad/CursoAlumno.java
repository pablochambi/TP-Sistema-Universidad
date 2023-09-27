package ar.unlam.pb2.Universidad;

import java.util.ArrayList;
import java.util.Objects;

public class CursoAlumno {
	private static Integer NEXT_ID = 1;
	private Integer id;
	private Curso curso;
	private Alumno alumno;
	private ArrayList<Nota> notas;
	
	
	public CursoAlumno(Curso curso, Alumno alumno) {
		this.curso = curso;
		this.alumno = alumno;
		this.id = NEXT_ID;
		NEXT_ID++;
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
	
	public Integer obtenerNotaDelPrimerParcial() {
		for(Nota nota: this.notas) {
			if(nota.getTipoParcial().equals(TipoParcial.PRIMER_PARCIAL)) {
				return nota.getValor();
			}
		}
		
		return null;
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
	public Integer getId() {
		return id;
	}
	
	public boolean getAprobo() {
		if(getNotaFinal()>=4) {
			return true;
		}
		return false;
	}
	
	public Integer getNotaFinal() {
		Integer suma = 0;
		Double prom = 0.0;
		Integer notaPrimerParcial = 0,notaSegundoParcial = 0;
		
		for(Nota nota : this.notas) {
			if(nota.getTipoParcial().equals(TipoParcial.PRIMER_PARCIAL)) {
				 notaPrimerParcial = nota.getValor(); 
			}
			if(nota.getTipoParcial().equals(TipoParcial.SEGUNDO_PARCIAL)) {
				 notaSegundoParcial = nota.getValor(); 
			}
			if(nota.getTipoParcial().equals(TipoParcial.RECU_1ER_PARCIAL)) {
				 notaPrimerParcial = nota.getValor();  
			}
			if(nota.getTipoParcial().equals(TipoParcial.RECU_2DO_PARCIAL)) {
				 notaSegundoParcial = nota.getValor();
			}
			
		}
		
		suma = notaPrimerParcial + notaSegundoParcial;
		
		prom = (double) suma/2;
		
		return (int) Math.round(prom);
		
	}
	public Boolean getPromociono() {
		if(getNotaFinal()>=7){
			return true;
		}
		return false;
	}
	public Materia getMateria() {
		return this.getCurso().getComision().getMateria();
	}
	
	
	
	
	
	
	
	
}
