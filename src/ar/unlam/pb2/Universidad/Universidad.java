package ar.unlam.pb2.Universidad;

import java.time.LocalDate;
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
	public Integer cantidadDeCursos() {
		return this.cursos.size();
	}
	public Integer obtenerCantidadDeCursos() {
		return this.cursos.size();
	}
	
	public Boolean ingresarProfesor(Profesor profe) {
		return this.profesores.add(profe);
	}
	public Integer getCantidadDeProfesIngresados() {
		return this.profesores.size();
	}
	
	public Boolean ingresarAlumno(Alumno alumno) {
		return this.alumnos.add(alumno);
	}
	public Integer getCantidadDeIngresantes() {
		return this.alumnos.size();
	}

	public Boolean registrarMateria(Materia materia) {
		return this.materias.add(materia);
	}
	public Integer obtenerCantidadDeMaterias() {
		return this.materias.size();
	}

	public Boolean registrarAula(Aula aula) {
		return this.aulas.add(aula);
	}

	public Boolean crearCicloLectivo(CicloLectivo cicloL) {
		
		if(this.ciclosLectivos.size()==0) {
			return this.ciclosLectivos.add(cicloL);
		}
		
		for(CicloLectivo cl : this.ciclosLectivos) {
			Boolean laFechaFinalEsAnterior = cl.getFechaFinalizacionCl().isBefore(cicloL.getFechaInscripcion());
			Boolean laFechaInicialEsPosterior = cl.getFechaInscripcion().isAfter(cicloL.getFechaFinalizacionCl());
			
			if(laFechaFinalEsAnterior || laFechaInicialEsPosterior)
				return this.ciclosLectivos.add(cicloL);
			
		}
		
		return false;
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

	

	public Materia obtenerMateriaPorCodigoDeCurso(Integer codCurso) {
		for(Curso curso: this.cursos) {
			if(curso.getCodigo().equals(codCurso)) {
				return curso.getComision().getMateria();
			}
		}
		return null;
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
	
	public Boolean inscribirUnAlumnoAUnCurso(Integer dniAlu, Integer codCurso, LocalDate fechaInscripcion) {
		Alumno alumnoBus = buscarAlumnoPorDni(dniAlu);
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		Boolean seLLenoElAula = cantDeAlumnosDeUnCurso(codCurso) >= cursoBus.getAula().getCantMax();
		
		if(alumnoBus==null || cursoBus ==null || seLLenoElAula||
			!esteAlumnoAproboLasCorrelativasDeLaMateriaDeEsteCurso(cursoBus) ||
			seEncontroOtroCursoConIgualDiaTurnoYCicloLectivoAlCualEstaInscriptoElAlumno(alumnoBus,cursoBus)||
			aproboEsteAlumnoEstaMateriaDeEsteCurso(alumnoBus, cursoBus)) {
			return false;
		}
		LocalDate fechaInicioInscripcion = cursoBus.getComision().getCicloLectivo().getFechaInscripcion();
		LocalDate fechaFinInscripcion = cursoBus.getComision().getCicloLectivo().getFechaFinalizacionInscripcion();
		
		//Before = anterior, after = posterior
		if(fechaInscripcion.isAfter(fechaInicioInscripcion) && fechaInscripcion.isBefore(fechaFinInscripcion))
			return this.cursosAlumnos.add(new CursoAlumno(cursoBus, alumnoBus));
		
		return false;
		
	}
	
	
	
	
	private Boolean esteAlumnoAproboLasCorrelativasDeLaMateriaDeEsteCurso(Curso cursoBus) {
		HashSet<Materia> materiasCorrelativas = cursoBus.getComision().getMateria().getMateriasCorrelativas();
		if(materiasCorrelativas.size()==0) {
			return true;
		}
		
		for(CursoAlumno curAlu : this.cursosAlumnos) {
			for(Materia materiaCorr : materiasCorrelativas) {
				if(curAlu.getCurso().getComision().getMateria().equals(materiaCorr)) {
					if(curAlu.getAprobo()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private Boolean seEncontroOtroCursoConIgualDiaTurnoYCicloLectivoAlCualEstaInscriptoElAlumno(Alumno alumnoBus, Curso cursoBus) {
		
		if(this.cursosAlumnos.size()==0)
			return false;
		
		for(CursoAlumno curAlu : this.cursosAlumnos) {
			Boolean losDiasSonIguales = curAlu.getCurso().getComision().getDias().equals(cursoBus.getComision().getDias());
			Boolean elTurnoEsIgual = curAlu.getCurso().getComision().getTurno().equals(cursoBus.getComision().getTurno());
			Boolean elCicloLectivoEsIgual = curAlu.getCurso().getComision().getCicloLectivo().equals(cursoBus.getComision().getCicloLectivo());
			Boolean elAlumnoEsIgual = curAlu.getAlumno().equals(alumnoBus);
			
			if(losDiasSonIguales  && elTurnoEsIgual && elCicloLectivoEsIgual && elAlumnoEsIgual) 
				return true;
			
		}
		
		return false;
	}

	private Boolean aproboEsteAlumnoEstaMateriaDeEsteCurso(Alumno alumnoBus, Curso cursoBus) {
		
		if(this.cursosAlumnos.size()==0)
			return false;
		
		for(CursoAlumno curAlu : this.cursosAlumnos) {
			Boolean lasMateriasSonIguales = curAlu.getCurso().getComision().getMateria().equals(cursoBus.getComision().getMateria());
			Boolean losAlumnosSonIguales = curAlu.getAlumno().equals(alumnoBus);
			Boolean aprobo = curAlu.getNotaFinal()>=4;
			if(lasMateriasSonIguales && losAlumnosSonIguales && aprobo)
				return true;
		}
		return false;
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

	

	public Boolean registrarComision(Integer numComision, Integer codMateria, 
			Integer codCicloL, Turno turno,Dias dias) {
		// TODO Auto-generated method stub
		Materia materiaBus = buscarMateriaPorCodigo(codMateria);
		CicloLectivo cicloLBus = buscarCicloLectivoPorCodigo(codCicloL);
		
		if(materiaBus==null ||cicloLBus==null) {
			return false;
		}
		
		for(Comision comision: this.comisiones) {
			Boolean losDiasSonIguales = comision.getDias().equals(dias);
			Boolean elTurnoEsIgual = comision.getTurno().equals(turno) ;
			Boolean elCicloLectivoEsIgual = comision.getCicloLectivo().equals(cicloLBus);
			Boolean laMateriaEsIgual = comision.getMateria().equals(materiaBus);
			
			if(losDiasSonIguales && elTurnoEsIgual && elCicloLectivoEsIgual && laMateriaEsIgual)
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

	public Integer obtenerCantidadDeAlumnosSegunCodigoDeCurso(Integer codCurso) {
		
		Integer contador=0;
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		
		for(CursoAlumno curAlu: this.cursosAlumnos) {
			if(curAlu.getCurso().equals(cursoBus)) {
				contador++;
			}
		}
		
		return contador;
	}
	
	
/////////////
	public Boolean registrarUnaNota(Integer codCurso, Integer dniAlumno, Nota nota) {
		// TODO Auto-generated method stub
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		Alumno alumnoBus = buscarAlumnoPorDni(dniAlumno);
		
		if(cursoBus==null || alumnoBus==null)
			return false;
		
		for(CursoAlumno curAlu:this.cursosAlumnos) {
			
			Boolean seEncontroCursoAlumno = curAlu.getAlumno().equals(alumnoBus) && curAlu.getCurso().equals(cursoBus);
			Boolean hayMenosDe4Notas = curAlu.getNotas().size()<3;//Solo admite 3 notas
			Boolean hayUnaNotaCargada = curAlu.getNotas().size()!=0;
			
			HashSet<Materia> materiasCorrelativas = cursoBus.getComision().getMateria().getMateriasCorrelativas();
			
			if(seEncontroCursoAlumno) {
				
				for(CursoAlumno cuAl : this.cursosAlumnos) {
					for(Materia mat: materiasCorrelativas) {
						if(cuAl.getAlumno().equals(alumnoBus) &&
								cuAl.getCurso().getComision().getMateria().equals(mat)) {
							if(!cuAl.getPromociono() && nota.getValor()>=7) {
								return false;
							}
						}
						
					}
				}
				
				if(!hayUnaNotaCargada) {
					
					return curAlu.getNotas().add(nota);
				}
				
				if(hayMenosDe4Notas){
					for(Nota notaa: curAlu.getNotas()) {
						if(!notaa.getTipoParcial().equals(nota.getTipoParcial())) {
							return curAlu.getNotas().add(nota);
						}
					}
				}
				
			}
		}
		
		return false;
	}
	

	public Integer obtenerNotaPrimerParcialDeUnAlumnoEnUnCurso(Integer dniAlumno, Integer codCurso) {
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		Alumno alumnoBus = buscarAlumnoPorDni(dniAlumno);
		
		if(cursoBus==null || alumnoBus==null)
			return null;
		
		for(CursoAlumno curAlu:this.cursosAlumnos) {
			if(curAlu.getAlumno().equals(alumnoBus) && curAlu.getCurso().equals(cursoBus)) {
				return curAlu.obtenerNotaDelPrimerParcial();
			}
		}
		
		return null;
	}

	public Integer obtenerCantidadDeNotasCargadasDeUnAlumnoEnUnCurso(Integer dniAlumno, Integer codCurso) {
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		Alumno alumnoBus = buscarAlumnoPorDni(dniAlumno);
		
		if(cursoBus==null || alumnoBus==null)
			return null;
		
		for(CursoAlumno curAlu:this.cursosAlumnos) {
			if(curAlu.getAlumno().equals(alumnoBus) && curAlu.getCurso().equals(cursoBus)) {
				return curAlu.getNotas().size();
			}
		}
		
		return null;
	}

	public Integer obtenerCantidadDeInscripcionesDeUnAlumnoSegunDniAlumno(Integer dniAlumno) {
		Integer contar = 0;
		Alumno alumnoBus = buscarAlumnoPorDni(dniAlumno);
		
		for(CursoAlumno curAlu: this.cursosAlumnos) {
			if(curAlu.getAlumno().equals(alumnoBus)) {
				contar++;
			}
		}
		return contar;
	}

	public Boolean asignarProfesorAUnCurso(Integer dniPro, Integer codCurso) {
		Profesor profeBus = buscarProfePorDni(dniPro);
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		
		if(profeBus == null || cursoBus == null)
			return false;
		
		if(this.cursosProfes.size()==0) {
			CursoProfe cursoProfe = new CursoProfe(cursoBus, profeBus);
			return this.cursosProfes.add(cursoProfe);
		}
		
		if(this.cursosProfes.contains(new CursoProfe(cursoBus, profeBus)))
			return false;
		
		Integer cantAlumnos = obtenerCantidadDeAlumnosSegunCodigoDeCurso(codCurso);
		int cantidadDeProfesAAsignar = 0;
		
		if(cantAlumnos%20 == 0) {
			 cantidadDeProfesAAsignar = cantAlumnos/20;
		}
		if(cantAlumnos!=0) {
			cantidadDeProfesAAsignar = cantAlumnos/20 + 1;
		}
			
		if(cantidadDeProfesEnUnCurso(codCurso)>=cantidadDeProfesAAsignar)
			return false;
		
		for(CursoProfe curPro: this.cursosProfes) {
			
			Boolean cursosConIgualDia = curPro.getCurso().getComision().getDias().equals(cursoBus.getComision().getDias());
			Boolean cursosConIgualCicloectivo = curPro.getCurso().getComision().getCicloLectivo().equals(cursoBus.getComision().getCicloLectivo());
			Boolean cursosConIgualTurno = curPro.getCurso().getComision().getTurno().equals(cursoBus.getComision().getTurno());
			Boolean cursosConElMismoProfe = curPro.getProfe().equals(profeBus);
			
			if(cursosConIgualDia && cursosConIgualCicloectivo && cursosConElMismoProfe && cursosConIgualTurno) 
				return false;
			
		}
		
		Integer contarAsignacion = 0;
		
		Boolean resultado = this.cursosProfes.add(new CursoProfe(cursoBus, profeBus));
		if(resultado)
			contarAsignacion++;
		
		return resultado;
	}

	public Integer cantidadDeProfesEnUnCurso(Integer codCurso) {
		// TODO Auto-generated method stub
		Integer contador=0;
		Curso cursoBus = buscarCursoPorCodigo(codCurso);
		
		for(CursoProfe curPro: this.cursosProfes) {
			if(curPro.getCurso().equals(cursoBus))
				contador++;
		}
		
		return contador;
	}

	public Integer obtenerNotaFinalDeUnAlumno(Integer dniAlumno, Integer codMateria) {
		// TODO Auto-generated method stub
		Alumno alumnoBus = buscarAlumnoPorDni(dniAlumno);
		Materia materiaBus = buscarMateriaPorCodigo(codMateria);
		
		if(alumnoBus == null || materiaBus == null)
			return null;
		
		for(CursoAlumno curAlu : this.cursosAlumnos) {
			if(curAlu.getAlumno().equals(alumnoBus) && 
				curAlu.getCurso().getComision().getMateria().equals(materiaBus)) {
				
				return curAlu.getNotaFinal();
			}
		}
		
		
		return null;
	}

	public HashSet<Materia> obtenerMateriasAprobadas(Integer dniAlumno) {
		
		HashSet<Materia> materiasAprobadas = new HashSet<>();
		Alumno alumnoBus = buscarAlumnoPorDni(dniAlumno);
		
		if(this.cursosAlumnos.size()==0)
			return null;
		
		for(CursoAlumno curAlu: this.cursosAlumnos) {
			if(curAlu.getAlumno().equals(alumnoBus) && curAlu.getPromociono()) 
				materiasAprobadas.add(curAlu.getMateria());
		}
		return materiasAprobadas;
	}

	public HashSet<Materia> obtenerMateriasQueFaltanCursar(Integer dniAlumno) {

		HashSet<Materia> copiaMat = new HashSet<>(this.materias);
		
		HashSet<Materia> materiasAprobadas = obtenerMateriasAprobadas(dniAlumno);
		
		copiaMat.removeAll(materiasAprobadas);
		
		return copiaMat;
		
	}
	
	
	
	//Reporte de notas de alumnos(idCurso)
//	Curso  nombreMateria Dni nombre apellido Nota
	//12	Pb1			2342	Pablo Chambi   7
	//12   Pb1		    3453    Natalia Chambi 5
	
	public ArrayList<ReporteDeNotaDeAlumno> obtenerReporteDeNotasDeAlumnos(Integer codCursoBus) {
		
		Curso cursoBus = buscarCursoPorCodigo(codCursoBus);
		ArrayList<ReporteDeNotaDeAlumno> reporteDeNotasDeAlumnos = new ArrayList<>();
		
		if(cursoBus==null)
			return null;
		
		if(this.cursosAlumnos.size()==0)
			return null;
		
		for(CursoAlumno curAlu: this.cursosAlumnos) {
			if(curAlu.getCurso().equals(cursoBus)) {
				Integer codCurso =cursoBus.getCodigo();
				String nomMateria = cursoBus.getNomMateria();
				Integer dniAlumno = curAlu.getAlumno().getDni();
				String nomAlumno = curAlu.getAlumno().getNombre();
				String apeAlumno = curAlu.getAlumno().getApellido();
				Integer nota = curAlu.getNotaFinal();
				
				ReporteDeNotaDeAlumno reporte = new ReporteDeNotaDeAlumno(codCurso, nomMateria, dniAlumno, nomAlumno, apeAlumno, nota);
				reporteDeNotasDeAlumnos.add(reporte);
			}
				
		}
		
		return reporteDeNotasDeAlumnos;
		
	}

	

	


	
	
	
	
}
