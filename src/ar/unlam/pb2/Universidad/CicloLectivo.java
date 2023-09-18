package ar.unlam.pb2.Universidad;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {

	private static Integer NEXT_ID = 1;
	private Integer id;
	private Integer codigo;
	private LocalDate fechaInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	private LocalDate fechaInicioCl;
	private LocalDate fechaFinalizacionCl;
	
	public CicloLectivo(Integer codigo, LocalDate fechaInscripcion,
							LocalDate fechaFinalizacionInscripcion,
							LocalDate fechaInicioCl, LocalDate fechaFinalizacionCl) {
		// TODO Auto-generated constructor stub
		this.codigo= codigo;
		this.fechaInscripcion=fechaInscripcion;
		this.fechaFinalizacionInscripcion=fechaFinalizacionInscripcion;
		this.fechaInicioCl=fechaInicioCl;
		this.fechaFinalizacionCl=fechaFinalizacionCl;
		this.id = NEXT_ID;
		NEXT_ID++;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer numeroIns) {
		this.codigo = numeroIns;
	}

	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public void setFechaFinalizacionInscripcion(LocalDate fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	public LocalDate getFechaInicioCl() {
		return fechaInicioCl;
	}

	public void setFechaInicioCl(LocalDate fechaInicioCl) {
		this.fechaInicioCl = fechaInicioCl;
	}

	public LocalDate getFechaFinalizacionCl() {
		return fechaFinalizacionCl;
	}

	public void setFechaFinalizacionCl(LocalDate fechaFinalizacionCl) {
		this.fechaFinalizacionCl = fechaFinalizacionCl;
	}

	public Integer getId() {
		return id;
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
		CicloLectivo other = (CicloLectivo) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
	
	

	
	
	
	
	
	
}
