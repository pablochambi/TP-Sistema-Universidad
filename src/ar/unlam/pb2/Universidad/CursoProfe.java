package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class CursoProfe {

	private static Integer NEXT_ID = 1;
	private Integer id;
	private Curso curso;
	private Profesor profe;
	
	public CursoProfe(Curso curso, Profesor profe) {
		this.curso = curso;
		this.profe = profe;
		this.id = NEXT_ID;
		NEXT_ID++;
	}
	

	public Curso getCurso() {
		return curso;
	}

	public Profesor getProfe() {
		return profe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, profe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoProfe other = (CursoProfe) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(profe, other.profe);
	}
	
	
	
	
	
}
