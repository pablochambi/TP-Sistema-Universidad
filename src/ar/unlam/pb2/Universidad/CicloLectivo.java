package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class CicloLectivo {

	private Integer anio;
	private TipoCuatri cuatrimestre;
	private String fechaInicio;
	
	public CicloLectivo(Integer anio, TipoCuatri tipoCuatri, String fechaInicio) {
		this.anio = anio;
		this.cuatrimestre = tipoCuatri;
		this.fechaInicio=fechaInicio;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public TipoCuatri getCuatrimestre() {
		return cuatrimestre;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anio, cuatrimestre);
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
		return Objects.equals(anio, other.anio) && cuatrimestre == other.cuatrimestre;
	}
	
	

	
	
	
	
	
	
}
