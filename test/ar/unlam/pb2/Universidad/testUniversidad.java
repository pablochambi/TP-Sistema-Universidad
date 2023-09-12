package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testUniversidad {

	@Test
	public void queSePuedaCrearUnaUniversidad() {
		String nombre ="Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer cantEsperada = 0;
		assertEquals(nombre,unlam.getNombre());
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	
	@Test
	public void queSePuedaCrearUnCurso() {

		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso = 1, codMat = 22, anio = 2024,
				codAula = 333, cantMax = 5, cantidadEsperada=1;
		String nomMat = "Programacion basica 2", fechaInicio = "02/03/2023";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		
		
		unlam.registrarMateria(materia);
		unlam.registrarAula(aula);
		unlam.crearUnCurso(codCurso,codMat,horario,cicloLectivo,codAula);
		
		Materia materiaEsperada = new Materia(codMat,nomMat);
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso)));
		assertEquals(cantidadEsperada,unlam.cantidadDeCursos());
	}
	
	
	@Test
	public void queSePuedaInscribirDosProfesDistintosAUnCursoCorrectamente() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso = 1, codMat = 22, anio = 2024,
				codAula = 333, cantMax = 5, dniPro = 4,dniPro2=5;
		String nomMat = "Programacion basica 2",nomPro="Juan", apePro = "Montan",
				nomPro2="Diego", apePro2 = "Maradona",fechaInicio = "02/03/2023";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		
		Profesor profe = new Profesor(dniPro, nomPro, apePro);
		Profesor profe2 = new Profesor(dniPro2, nomPro2, apePro2);
		
		assertTrue(unlam.registrarMateria(materia));
		assertTrue(unlam.registrarAula(aula));
		assertTrue(unlam.crearUnCurso(codCurso,codMat,horario,cicloLectivo,codAula));
		assertTrue(unlam.ingresarProfesor(profe));
		assertTrue(unlam.ingresarProfesor(profe2));
		assertTrue(unlam.inscribirUnProfeAUnCurso(dniPro, codCurso));
		assertTrue(unlam.inscribirUnProfeAUnCurso(dniPro2, codCurso));
		
		Integer cantDeProfesEnUnCursoEsperado = 2;
		Integer cantDeProfesEnUnCurso = unlam.cantDeProfesDeUnCurso(codCurso);
		assertEquals(cantDeProfesEnUnCursoEsperado, cantDeProfesEnUnCurso);
		
		Profesor profeEsperado1 = new Profesor(dniPro, nomPro, apePro);
		Profesor profeEsperado2 = new Profesor(dniPro2, nomPro2, apePro2);
		ArrayList<Profesor> profesObtenidos = unlam.obtenerProfesoresDeUnCurso(codCurso);
		assertEquals(profeEsperado1, profesObtenidos.get(0));
		assertEquals(profeEsperado2, profesObtenidos.get(1));
	}
	@Test
	public void queSePuedaInscribirDosAlumnosConDistintoDniAUnCursoConProfesCorrectamente() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso = 1, codMat = 22, anio = 2024,
				codAula = 333, cantMax = 5, dniPro = 4,dniPro2=5,
				dniAlu = 12	,dniAlu2=14;
		String nomMat = "Programacion basica 2",nomPro="Juan", apePro = "Montan",
				nomPro2="Diego", apePro2 = "Maradona",fechaInicio = "02/03/2023",
				nomAlu = "Carlos", apeAlu ="Rodriguez",
		        nomAlu2 = "Yanina", apeAlu2 ="Perez";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		
		Profesor profe = new Profesor(dniPro, nomPro, apePro);
		Profesor profe2 = new Profesor(dniPro2, nomPro2, apePro2);
		
		Alumno alumno1 = new Alumno(dniAlu, nomAlu, apeAlu);//12,Carlos
		Alumno alumno2 = new Alumno(dniAlu2, nomAlu2, apeAlu2);//14,Yanina
		
		assertTrue(unlam.registrarMateria(materia));
		assertTrue(unlam.registrarAula(aula));
		assertTrue(unlam.ingresarProfesor(profe));
		assertTrue(unlam.ingresarProfesor(profe2));
		assertTrue(unlam.ingresarAlumno(alumno1));
		assertTrue(unlam.ingresarAlumno(alumno2));
		
		assertTrue(unlam.crearUnCurso(codCurso,codMat,horario,cicloLectivo,codAula));
		assertTrue(unlam.inscribirUnProfeAUnCurso(dniPro, codCurso));
		assertTrue(unlam.inscribirUnProfeAUnCurso(dniPro2, codCurso));
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlu, codCurso));
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlu2, codCurso));
		
		Integer cantDeAlumnosEnUnCursoEsperado = 2;
		Integer cantDeAlumnosEnUnCurso = unlam.cantDeAlumnosDeUnCurso(codCurso);
		Alumno aluEsperado1 = new Alumno(dniAlu, nomAlu, apeAlu);
		Alumno aluEsperado2 = new Alumno(dniAlu2, nomAlu2, apeAlu2);
		ArrayList<Alumno> alumnosObtenidos = unlam.obtenerAlumnosDeUnCurso(codCurso);
		//Los ALumnos Estan Cargados a un Curso correctamente pero en distinto orden
		assertEquals(cantDeAlumnosEnUnCursoEsperado, cantDeAlumnosEnUnCurso);
		assertEquals(aluEsperado1,alumnosObtenidos.get(1));
		assertEquals(aluEsperado2,alumnosObtenidos.get(0));
	}
	
//	queNoSePuedaInscribirUnAlumnoDosVecesAUnMismoCurso
	@Test
	public void queNoSePuedaInscribirUnAlumnoDosVecesAUnMismoCurso() {
		//Un alumno con su dni identificatorio no se puede volver a inscribir a un curso que ya esta inscripto
		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso = 1, codMat = 22, anio = 2024,
				codAula = 333, cantMax = 5, dniPro = 4,dniPro2=5,
				dniAlu = 12	,dniAlu2=14;
		String nomMat = "Programacion basica 2",nomPro="Juan", apePro = "Montan",
				nomPro2="Diego", apePro2 = "Maradona",fechaInicio = "02/03/2023",
				nomAlu = "Carlos", apeAlu ="Rodriguez",
		        nomAlu2 = "Yanina", apeAlu2 ="Perez";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		
		Profesor profe = new Profesor(dniPro, nomPro, apePro);
		Profesor profe2 = new Profesor(dniPro2, nomPro2, apePro2);
		
		Alumno alumno1 = new Alumno(dniAlu, nomAlu, apeAlu);//12,Carlos
		Alumno alumno2 = new Alumno(dniAlu2, nomAlu2, apeAlu2);//14,Yanina
		
		assertTrue(unlam.registrarMateria(materia));
		assertTrue(unlam.registrarAula(aula));
		assertTrue(unlam.ingresarProfesor(profe));
		assertTrue(unlam.ingresarProfesor(profe2));
		assertTrue(unlam.ingresarAlumno(alumno1));
		assertTrue(unlam.ingresarAlumno(alumno2));
		
		assertTrue(unlam.crearUnCurso(codCurso,codMat,horario,cicloLectivo,codAula));
		
		assertTrue(unlam.inscribirUnProfeAUnCurso(dniPro, codCurso));
		assertTrue(unlam.inscribirUnProfeAUnCurso(dniPro2, codCurso));
		
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlu, codCurso));
		assertFalse(unlam.inscribirUnAlumnoAUnCurso(dniAlu, codCurso));//Falso porque es el mismo alumno
		
		Integer cantDeAlumnosEnUnCursoEsperado = 1;
		Integer cantDeAlumnosEnUnCurso = unlam.cantDeAlumnosDeUnCurso(codCurso);
		Alumno aluEsperado1 = new Alumno(dniAlu, nomAlu, apeAlu);
		Alumno aluEsperado2 = new Alumno(dniAlu2, nomAlu2, apeAlu2);
		ArrayList<Alumno> alumnosObtenidos = unlam.obtenerAlumnosDeUnCurso(codCurso);
		//Los ALumnos Estan Cargados a un Curso correctamente pero en distinto orden
		assertEquals(cantDeAlumnosEnUnCursoEsperado, cantDeAlumnosEnUnCurso);
		assertEquals(aluEsperado1,alumnosObtenidos.get(0));
	}
	
	//que un Alumno no se pueda inscribir dos veces a una misma materia en distintos cursos
	
	 
	
	
	
	

}
