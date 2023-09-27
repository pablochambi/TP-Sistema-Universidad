package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Comision {

	private static Integer NEXT_ID = 1;
	private Integer id;
	private Integer numeroCom;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Turno turno;
	private Dias dias;

	public Comision(Integer numeroCom, Materia materia, 
			CicloLectivo cicloLectivo, Turno turno, Dias dias) {
		this.numeroCom=numeroCom; 
		this.materia=materia; 
		this.cicloLectivo=cicloLectivo; 
		this.turno=turno; 
		this.dias=dias;
		this.id = NEXT_ID;
		NEXT_ID++;
	}
	

	public Integer getNumeroCom() {
		return numeroCom;
	}

	public void setNumeroCom(Integer numeroCom) {
		this.numeroCom = numeroCom;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public Dias getDias() {
		return dias;
	}

	public void setDias(Dias dias) {
		this.dias = dias;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(numeroCom, other.numeroCom);
	}
	
	

}
