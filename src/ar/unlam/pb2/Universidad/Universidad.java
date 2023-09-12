package ar.unlam.pb2.Universidad;

import java.util.ArrayList;
import java.util.HashSet;

public class Universidad {

	private String nombre;
	private HashSet<Aula> aulas;
	private HashSet<Materia> materias;
	private HashSet<Profesor> profesores;
	private HashSet<Alumno> alumnos;
	private HashSet<MateriaCorrelativa> materiasCorrelativas;
	private HashSet<Curso> cursos;
	private HashSet<CursoAlumno> cursosAlumnos;
	private HashSet<CursoProfe> cursosProfes;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.aulas = new HashSet<>();
		this.materias = new HashSet<>();
		this.profesores = new HashSet<>();
		this.alumnos = new HashSet<>();
		this.materiasCorrelativas = new HashSet<>();
		this.cursosAlumnos = new HashSet<>();
		this.cursosProfes = new HashSet<>();
		this.cursos = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}
	public HashSet<Aula> getAulas() {
		return aulas;
	}
	public HashSet<Materia> getMaterias() {
		return materias;
	}
	public HashSet<Profesor> getProfesores() {
		return profesores;
	}
	public HashSet<Alumno> getAlumnos() {
		return alumnos;
	}
	public HashSet<MateriaCorrelativa> getMateriasCorrelativas() {
		return materiasCorrelativas;
	}
	public HashSet<Curso> getCursos() {
		return cursos;
	}
	public HashSet<CursoAlumno> getCursosAlumnos() {
		return cursosAlumnos;
	}
	public HashSet<CursoProfe> getCursosProfes() {
		return cursosProfes;
	}




	public Boolean registrarUnProfeAUnCurso(Profesor profe, Curso curso) {
		Curso cursoBus = buscarCurso(curso);
		Profesor profeBus = buscarProfe(profe);
		if(cursoBus!=null && profeBus!=null) {
			CursoProfe cursoProfe = new CursoProfe(cursoBus, profeBus);
			return this.cursosProfes.add(cursoProfe);
		}
		return false;
	}
	

	private Curso buscarCurso(Curso curso) {
		for(Curso cur: this.cursos) {
			if(cur.equals(curso)) {
				return cur;
			}
		}
		return null;
	}

	private Profesor buscarProfe(Profesor profe) {
		for(Profesor pro: this.profesores) {
			if(pro.equals(profe)) {
				return pro;
			}
		}
		return null;
	}

	public Profesor buscarProfePorCurso(Curso curso) {
		for(CursoProfe curPro: this.cursosProfes) {
			if(curPro.getCurso().equals(curso)) {
				return curPro.getProfe();
			}
		}
		return null;
	}

	public Integer cantDeProfesDeUnCurso(Integer codigo) {
		Integer contador = 0;
		if(BuscarCurso(codigo)!=null) {
			for(CursoProfe curPro: this.cursosProfes) {
				if(curPro.getCurso().getCodigo().equals(codigo)) {
					contador++;
				}
			}
		}
		return  contador;
	}
	

	private Curso BuscarCurso(Integer codigo) {
		for(Curso cur: this.cursos) {
			if(cur.getCodigo().equals(codigo)) {
				return cur;
			}
		}
		return null;
	}

	public Boolean crearCurso(Curso curso) {
		return this.cursos.add(curso);
	}

	public Boolean ingresarProfesor(Profesor profe) {
		return this.profesores.add(profe);
	}
	public Boolean ingresarAlumno(Alumno alumno) {
		return this.alumnos.add(alumno);
	}

	public ArrayList<Profesor> obtenerProfesoresDeUnCurso(Integer codigo) {
		// TODO Auto-generated method stub
		ArrayList<Profesor> listaDeProfes = new ArrayList<>();
		for(CursoProfe curPro: this.cursosProfes) {
			if(curPro.getCurso().getCodigo().equals(codigo)) {
				listaDeProfes.add(curPro.getProfe());
			}
		}
		return listaDeProfes;
	}

	public Integer getCantidadDeIngresantes() {
		return this.alumnos.size();
	}

	public Integer cantidadDeCursos() {
		return this.cursos.size();
	}

	public Integer getCantidadDeProfesIngresados() {
		return this.profesores.size();
	}

	public Boolean crearUnCurso(Integer comision, Integer codMat, Horario horario,
							CicloLectivo cicloLectivo, Integer codAula) {
		Boolean resultado = false;
		Materia materiaBus = buscarMateriaPorCodigo(codMat);
		Aula aulaBus = buscarAulaPorCodigo(codAula);
		
		if(materiaBus==null || aulaBus==null) {
			return false;
		}
		
		if(this.cantidadDeCursos()==0) {
			Curso curso = new Curso(comision, materiaBus, horario, cicloLectivo, aulaBus);
			return this.cursos.add(curso);
		}
		
		for(Curso cur: this.cursos) {
			Boolean horariosIguales = cur.getHorario().equals(horario);
			Boolean ciclosLectivosIguales =cur.getCicloLectivo().equals(cicloLectivo);
			Boolean aulasIguales = cur.getAula().equals(aulaBus);
			Boolean materiasIguales = cur.getMateria().equals(materiaBus);
			
			if( (materiasIguales && horariosIguales && ciclosLectivosIguales && !aulasIguales)||
				(materiasIguales && horariosIguales && !ciclosLectivosIguales && aulasIguales)||
				(materiasIguales && !horariosIguales && ciclosLectivosIguales && aulasIguales)
					) {
				return this.cursos.add(new Curso(comision, materiaBus, horario, cicloLectivo, aulaBus));
			}
		}
		return resultado;
		
	}
	

	

	private Aula buscarAulaPorCodigo(Integer codAula) {
		for(Aula aula: this.aulas) {
			if(aula.getId().equals(codAula)) {
				return aula;
			}
		}
		return null;
	}

	private Materia buscarMateriaPorCodigo(Integer codMat) {
		for(Materia mat: this.materias) {
			if(mat.getCodigo().equals(codMat)) {
				return mat;
			}
		}
		return null;
	}

	public Boolean registrarMateria(Materia materia) {
		return this.materias.add(materia);
	}

	public Boolean registrarAula(Aula aula) {
		return this.aulas.add(aula);
	}

	public Materia obtenerMateriaPorCodigoDeCurso(Integer codCurso) {
		for(Curso curso: this.cursos) {
			if(curso.getCodigo().equals(codCurso)) {
				return curso.getMateria();
			}
		}
		return null;
	}

	public Boolean inscribirUnProfeAUnCurso(Integer dniPro, Integer codCurso) {
		Profesor profeBus = buscarProfePorDni(dniPro);
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		
		if(profeBus == null || cursoBus == null) {
			return false;
		}
		
		return this.registrarUnProfeAUnCurso(profeBus, cursoBus);
		
	}

	private Curso buscarCursoPorCodigo(Integer codCurso) {
		for(Curso cur: this.cursos) {
			if(cur.getCodigo().equals(codCurso)) {
				return cur;
			}
		}
		return null;
	}

	private Profesor buscarProfePorDni(Integer dniPro) {
		for(Profesor profe: this.profesores) {
			if(profe.getDni().equals(dniPro)) {
				return profe;
			}
		}
		return null;
	}

	//queNoSePuedaInscribirUnAlumnoDosVecesAUnMismoCurso
	public Boolean inscribirUnAlumnoAUnCurso(Integer dniAlu, Integer codCurso) {
		Alumno alumnoBus = buscarAlumnoPorDni(dniAlu);
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		
		if(alumnoBus==null || cursoBus ==null)
			return false;
		
		CursoAlumno cursoAlumno = new CursoAlumno(cursoBus, alumnoBus);
		
		return this.cursosAlumnos.add(cursoAlumno);
	}

	private Alumno buscarAlumnoPorDni(Integer dniAlu) {
		// TODO Auto-generated method stub
		for(Alumno alu:this.alumnos) {
			if(alu.getDni().equals(dniAlu))
				return alu;
		}
		return null;
	}

	public Integer cantDeAlumnosDeUnCurso(Integer codCurso) {
		// TODO Auto-generated method stub
		Integer contador = 0;
		for(CursoAlumno curAlu: this.cursosAlumnos) {
			if(curAlu.getCurso().getCodigo().equals(codCurso)) {
				contador++;
			}
		}
		return contador;
	}

	public ArrayList<Alumno> obtenerAlumnosDeUnCurso(Integer codCurso) {
		// TODO Auto-generated method stub
		ArrayList<Alumno> listaDeAlumnos = new ArrayList<>();
		for(CursoAlumno curAlu: this.cursosAlumnos) {
			if(curAlu.getCurso().getCodigo().equals(codCurso)) {
				listaDeAlumnos.add(curAlu.getAlumno());
			}
		}
		return listaDeAlumnos;
	}

	


	
	
	
	
}
