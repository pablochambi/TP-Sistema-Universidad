package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Horario {
	
	private Hora hora;
	private Dias dias;
	
	public Horario(Hora hora, Dias dias) {
		this.hora = hora;
		this.dias = dias;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(dias, hora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		return dias == other.dias && hora == other.hora;
	}


	
	
	
	

}
