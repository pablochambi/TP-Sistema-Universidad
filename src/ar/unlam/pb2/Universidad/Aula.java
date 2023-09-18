package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Aula {

	private static Integer NEXT_ID = 1;
	private Integer id;
	private Integer numAula;
	private Integer cantMax;

	public Aula(Integer numAula, Integer cantMax) {
		this.numAula=numAula;
		this.cantMax=cantMax;
		this.id = NEXT_ID;
		NEXT_ID++;
	}
	
	

	public Integer getCantMax() {
		return cantMax;
	}

	public void setCantMax(Integer cantMax) {
		this.cantMax = cantMax;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numAula;
	}

	public void setNumero(Integer numero) {
		this.numAula = numero;
	}



	@Override
	public int hashCode() {
		return Objects.hash(numAula);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(numAula, other.numAula);
	}
	
	

}
