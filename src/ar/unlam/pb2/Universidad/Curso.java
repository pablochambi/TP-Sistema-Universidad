package ar.unlam.pb2.Universidad;

import java.util.HashSet;
import java.util.Objects;

public class Curso {

	private static Integer NEXT_ID = 1;
	private Integer id;
	private Integer codigo;
	private Comision comision;
	private Aula aula;
	
	public Curso(Integer codigo, Comision comision, Aula aula) {
		this.codigo = codigo;
		this.aula = aula;
		this.comision = comision;
		this.id = NEXT_ID;
		NEXT_ID++;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Comision getComision() {
		return comision;
	}
	public void setComision(Comision comision) {
		this.comision = comision;
	}
	public Aula getAula() {
		return aula;
	}
	public void setAula(Aula aula) {
		this.aula = aula;
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
	
	
	public String getNomMateria() {
		return getComision().getMateria().getNombre();
	}


	
	
	
	
	
	
	
	
}
