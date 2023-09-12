package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Curso {

	private Integer codigo;
	private Materia materia;
	private Horario horario;
	private CicloLectivo cicloLectivo;
	private Aula aula;
	
	public Curso(Integer codigo, Materia materia, Horario horario, 
			CicloLectivo cicloLectivo, Aula aula) {
		this.codigo = codigo;
		this.materia = materia;
		this.horario = horario;
		this.cicloLectivo = cicloLectivo;
		this.aula = aula;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Integer getCodigo() {
		return codigo;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(codigo, other.codigo);
	}


	
	
	
	
	
	
	
	
}
