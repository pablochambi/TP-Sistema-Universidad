package ar.unlam.pb2.Universidad;

public class ReporteDeNotaDeAlumno {

	private Integer codCurso;
	private String nomMateria;
	private Integer dniAlumno;
	private String nombreAlumno;
	private String apellidoAlumno;
	private Integer nota;
	
	public ReporteDeNotaDeAlumno(Integer codCurso, String nomMateria, Integer dniAlumno, String nombreAlumno,
			String apellidoAlumno, Integer nota) {
		this.codCurso = codCurso;
		this.nomMateria = nomMateria;
		this.dniAlumno = dniAlumno;
		this.nombreAlumno = nombreAlumno;
		this.apellidoAlumno = apellidoAlumno;
		this.nota = nota;
	}

	public Integer getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(Integer codCurso) {
		this.codCurso = codCurso;
	}

	public String getNomMateria() {
		return nomMateria;
	}

	public void setNomMateria(String nomMateria) {
		this.nomMateria = nomMateria;
	}

	public Integer getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoAlumno() {
		return apellidoAlumno;
	}

	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	
	
	
	
	
	
	
	
	
}