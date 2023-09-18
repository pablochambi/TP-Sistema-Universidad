package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Curso {

	private Integer codigo;
	private Comision comision;
	private Aula aula;
	
	public Curso(Integer codigo, Comision comision, Aula aula) {
		this.codigo = codigo;
		this.aula = aula;
		this.comision = comision;
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


	
	
	
	
	
	
	
	
}
