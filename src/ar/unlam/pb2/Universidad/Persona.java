package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Persona {

	private Integer dni;
	private String nombre;
	private String apellido;

	public Persona(Integer dni, String nombre, String apellido) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	
	
	

}
