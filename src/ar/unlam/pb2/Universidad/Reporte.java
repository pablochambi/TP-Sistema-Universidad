package ar.unlam.pb2.Universidad;

import java.util.Objects;

public class Reporte {

	private String reporte;

	public Reporte(String reporte) {
		this.reporte = reporte;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reporte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reporte other = (Reporte) obj;
		return Objects.equals(reporte, other.reporte);
	}
	
	
	
	
}
