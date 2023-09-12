package ar.unlam.pb2.Universidad;

public class MateriaCorrelativa {

	private Materia materia;
	private Materia correlativa;
	
	public MateriaCorrelativa(Materia materia, Materia correlativa) {
		this.materia = materia;
		this.correlativa = correlativa;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Materia getCorrelativa() {
		return correlativa;
	}

	public void setCorrelativa(Materia correlativa) {
		this.correlativa = correlativa;
	}
	
	
	
}
