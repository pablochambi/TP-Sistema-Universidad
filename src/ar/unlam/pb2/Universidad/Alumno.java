package ar.unlam.pb2.Universidad;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno{

	private static int next_id_alu;
	private int id;
	private Integer dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private LocalDate fechaIngreso;

	
	public Alumno() {
		this.dni=0;
		this.nombre="\0";
		this.apellido="\0";
		this.id =next_id_alu= 1;
	}
	public Alumno(Integer dni, String nombre, String apellido,
			LocalDate fechaNac, LocalDate fechaIngreso) {
		
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.setFechaNac(fechaNac);
		this.setFechaIngreso(fechaIngreso);
		this.id = next_id_alu;
		next_id_alu++;
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
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}




	
	
	
	
}
