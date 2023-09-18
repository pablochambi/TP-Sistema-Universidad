package ar.unlam.pb2.Universidad;

import java.util.HashSet;
import java.util.Objects;

public class Materia {

	private static Integer NEXT_ID = 1;
	private Integer id;
	private Integer codigo;
	private String nombre;
	private HashSet <Materia> materiasCorrelativas;

	public Materia(Integer codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.materiasCorrelativas = new HashSet<>();
		this.id = NEXT_ID;
		NEXT_ID++;
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

	public Integer getId() {
		return id;
	}
	
	public HashSet <Materia> getMateriasCorrelativas() {
		return materiasCorrelativas;
	}

	public Integer cantidadDeMateriasCorrelativas() {
		return this.materiasCorrelativas.size();
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

	public Boolean eliminarCorrelativa(Materia materiaCorrelativaBus) {
		return this.materiasCorrelativas.remove(materiaCorrelativaBus);
	}

	

}
