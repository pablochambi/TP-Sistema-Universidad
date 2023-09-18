package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Profesor{

	private static int next_id_pro = 1;
	private Integer dni;
	private String nombre;
	private String apellido;
	private int id;

	public Profesor(Integer dni, String nombre, String apellido) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.id = next_id_pro;
		next_id_pro++;
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
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(id, other.id);
	}


	
	
}
