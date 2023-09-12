package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Materia {

	private Integer codigo;
	private String nombre;

	public Materia(Integer codigo, String nombre) {
		this.codigo=codigo;
		this.nombre=nombre;
	}

	public Materia() {
		this.codigo = 0;
		this.nombre = "\0";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		Materia other = (Materia) obj;
		return Objects.equals(codigo, other.codigo);
	}
	

	
	
}
