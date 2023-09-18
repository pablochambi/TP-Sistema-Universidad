package ar.unlam.pb2.Universidad;

import java.util.ArrayList;
import java.util.HashSet;

public class Universidad {

	private String nombre;
	private HashSet<Aula> aulas;
	private HashSet<Materia> materias;
	private HashSet<Profesor> profesores;
	private HashSet<Alumno> alumnos;
	private HashSet<Curso> cursos;
	private HashSet<CursoAlumno> cursosAlumnos;
	private HashSet<CursoProfe> cursosProfes;
	private HashSet<CicloLectivo> ciclosLectivos;
	private HashSet<Comision> comisiones;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.aulas = new HashSet<>();
		this.materias = new HashSet<>();
		this.profesores = new HashSet<>();
		this.alumnos = new HashSet<>();
		this.cursosAlumnos = new HashSet<>();
		this.cursosProfes = new HashSet<>();
		this.cursos = new HashSet<>();
		this.ciclosLectivos = new HashSet<>();
		this.comisiones = new HashSet<>();
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
	public HashSet<Curso> getCursos() {
		return cursos;
	}
	public HashSet<CursoAlumno> getCursosAlumnos() {
		return cursosAlumnos;
	}
	public HashSet<CursoProfe> getCursosProfes() {
		return cursosProfes;
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

//	public Boolean crearUnCurso(Integer comision, Integer codMat, Horario horario,
//							CicloLectivo cicloLectivo, Integer codAula) {
//		Materia materiaBus = buscarMateriaPorCodigo(codMat);
//		Aula aulaBus = buscarAulaPorCodigo(codAula);
//		
//		if(materiaBus==null || aulaBus==null) {
//			return false;
//		}
//		
//		if(this.cantidadDeCursos()==0) {
//			Curso curso = new Curso(comision, materiaBus, horario, cicloLectivo, aulaBus);
//			return this.cursos.add(curso);
//		}
//		
//		for(Curso cur: this.cursos) {
//			Boolean horariosIguales = cur.getHorario().equals(horario);
//			Boolean ciclosLectivosIguales =cur.getCicloLectivo().equals(cicloLectivo);
//			Boolean aulasIguales = cur.getAula().equals(aulaBus);
//			Boolean materiasIguales = cur.getMateria().equals(materiaBus);
//			
//			//Me aseguro que por lo menos no sea igual un campo
//			if(materiasIguales &&  horariosIguales && ciclosLectivosIguales && aulasIguales) {
//				return false;
//			}
//		}
//		return this.cursos.add(new Curso(comision, materiaBus, horario, cicloLectivo, aulaBus));
//	}
	
	
	//QueNoSePuedaAsignarMasDeUnaMateriaAUnCurso
	//QueNoSepuedaAsignarMasDeUnAulaAUnCurso
	//QueNoSePuedaAsignarUnaMateriaAUnAulaOcupada

	

	private Aula buscarAulaPorCodigo(Integer codAula) {
		for(Aula aula: this.aulas) {
			if(aula.getNumero().equals(codAula)) {
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
				return curso.getComision().getMateria();
			}
		}
		return null;
	}

	public Boolean inscribirUnProfeAUnCurso(Integer dniPro, Integer codCurso) {
		Profesor profeBus = buscarProfePorDni(dniPro);
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		
		if(profeBus == null || cursoBus == null)
			return false;
		
		
		//Si no esta cargado ninguna asignacion CursoProfe se ejecuta primero este codigo
		if(this.cursosProfes.size()==0) {
			CursoProfe cursoProfe = new CursoProfe(cursoBus, profeBus);
			return this.cursosProfes.add(cursoProfe);
		}
		
		for(CursoProfe curPro: this.cursosProfes) {
			
			Boolean cursosConIgualHorario = curPro.getCurso().getHorario().equals(cursoBus.getHorario());
			Boolean cursosConIgualCicloectivo = curPro.getCurso().getCicloLectivo().equals(cursoBus.getCicloLectivo());
			Boolean cursosConElMismoProfe = curPro.getProfe().equals(profeBus);
			
			if(cursosConIgualHorario && cursosConIgualCicloectivo && cursosConElMismoProfe) {
				return false;
			}
		}
		
		return this.cursosProfes.add(new CursoProfe(cursoBus, profeBus));
		
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
		
		cursoBus.getAula().getCantMax();
		
		if(cantDeAlumnosDeUnCurso(codCurso) >= cursoBus.getAula().getCantMax()) {
			return false;
		}
		
		
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

	public Integer obtenerCantidadDeMaterias() {
		return this.materias.size();
	}

	public Boolean crearCicloLectivo(CicloLectivo cicloL) {
		return this.ciclosLectivos.add(cicloL);
	}

	public Integer obtenerCantidadDeCiclosLectivosIngresados() {
		return this.ciclosLectivos.size();
	}

	public Boolean registrarComision(Comision nueva) {
		return this.comisiones.add(nueva);
	}

	public Integer obtenerCantidadDeComisiones() {
		return this.comisiones.size();
	}

	public Boolean registrarComision(Integer numComision, Integer codMateria, 
			Integer codCicloL, Turno turno,Dias dias) {
		// TODO Auto-generated method stub
		Materia materiaBus = buscarMateriaPorCodigo(codMateria);
		CicloLectivo cicloLBus = buscarCicloLectivoPorCodigo(codCicloL);
		
		if(materiaBus==null ||cicloLBus==null) {
			return false;
		}
		
		Comision comision = new Comision(numComision, materiaBus, cicloLBus, turno, dias);
		return this.comisiones.add(comision);
		
	}

	private CicloLectivo buscarCicloLectivoPorCodigo(Integer codCicloL) {
		for(CicloLectivo cl: this.ciclosLectivos) {
			if(cl.getCodigo().equals(codCicloL)) {
				return cl;
			}
		}
		return null;
	}

	public Boolean crearUnCurso(Integer codCurso, Integer numComision, Integer numAula) {
		Comision comisionBus = buscarComisionPorCodigo(numComision);
		Aula aulaBus = buscarAulaPorCodigo(numAula);
		if(comisionBus==null ||aulaBus==null) {
			return false;
		}
		Curso curso = new Curso(codCurso, comisionBus, aulaBus);
		return this.cursos.add(curso);
		
	}

	private Comision buscarComisionPorCodigo(Integer numComision) {
		for(Comision comision:this.comisiones) {
			if(comision.getNumeroCom().equals(numComision)) {
				return comision;
			}
		}
		return null;
	}

	public Integer obtenerCantidadDeCursos() {
		return this.cursos.size();
	}

	public Boolean asignarUnaMateriaCorrelativa(Integer codMateria, Integer codMateriaCorrelativa) {
		Materia materiaBus = buscarMateriaPorCodigo(codMateria);
		Materia materiaCorrelativaBus = buscarMateriaPorCodigo(codMateriaCorrelativa);
		
		if(materiaBus==null || materiaCorrelativaBus==null)
			return false;
		
		
		return materiaBus.getMateriasCorrelativas().add(materiaCorrelativaBus);
		
	}

	public Boolean eliminarUnaMateriaCorrelativa(Integer codMateria, Integer codMateriaCorrelativa) {
		Materia materiaBus = buscarMateriaPorCodigo(codMateria);
		Materia materiaCorrelativaBus = buscarMateriaPorCodigo(codMateriaCorrelativa);
		
		if(materiaBus==null || materiaCorrelativaBus==null)
			return false;
		
		return materiaBus.eliminarCorrelativa(materiaCorrelativaBus);
		
	}


	


	
	
	
	
}
