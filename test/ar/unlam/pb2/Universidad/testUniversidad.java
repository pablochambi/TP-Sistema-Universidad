package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class testUniversidad {

	@Test
	public void queSePuedaCrearUnaUniversidadSinAlumnosIngresantes() {
		String nombre ="Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer cantEsperada = 0;
		assertEquals(nombre,unlam.getNombre());
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	@Test
	public void queSePuedaInscribirUnAlumnoAUnCursoEnLaUniversidad() {

		Universidad unlam = new Universidad("Unlam");
        
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		Integer cantidadEsperada = 1;
		Integer cantidadDeAlumnosObtenidos = unlam.obtenerCantidadDeAlumnosSegunCodigoDeCurso(codCurso);
		assertEquals(cantidadEsperada,cantidadDeAlumnosObtenidos);
		
	}
	
	@Test
	public void queSePuedaInscribir2AlumnosAUnCursoEnLaUniversidad() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323, dniAlumno2 = 2222;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		Alumno alumno2 = new Alumno(dniAlumno2, "Carlos", "Moreno", LocalDate.of(1998, 5, 5), LocalDate.of(2022, 3, 3));
		
		unlam.ingresarAlumno(alumno);
		unlam.ingresarAlumno(alumno2);
		

		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno2, codCurso,fechaInscripcion);
		
		Integer cantidadEsperada = 2;
		Integer cantidadDeAlumnosObtenidos = unlam.obtenerCantidadDeAlumnosSegunCodigoDeCurso(codCurso);
		assertEquals(cantidadEsperada,cantidadDeAlumnosObtenidos);
		
	}
	
	@Test
	public void queNoSePuedaInscribirUnAlumnoDosVecesAUnMismoCurso() {
		//Un alumno con su dni identificatorio no se puede volver a inscribir a un curso que ya esta inscripto
		Universidad unlam = new Universidad("Unlam");
        
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		//Verificacion
		assertFalse(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion));
		
		Integer cantidadEsperada = 1;
		assertEquals(cantidadEsperada,unlam.obtenerCantidadDeAlumnosSegunCodigoDeCurso(codCurso));
		
	}
	
	@Test
	public void queNoSePuedaInscribir2AlumnosAUnCursoSiTieneElMismoDNIEnLaUniversidad() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323, dniAlumno2 = 2222;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		Alumno alumno2 = new Alumno(dniAlumno, "Carlos", "Moreno", LocalDate.of(1998, 5, 5), LocalDate.of(2022, 3, 3));
		
		unlam.ingresarAlumno(alumno);
		unlam.ingresarAlumno(alumno2);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		Integer cantidadEsperada = 1;
		Integer cantidadDeAlumnosObtenidos = unlam.obtenerCantidadDeAlumnosSegunCodigoDeCurso(codCurso);
		assertEquals(cantidadEsperada,cantidadDeAlumnosObtenidos);
		
	}
	
	@Test
	public void queSePuedaRegistrarUnaNotaAUnAlumnoEnSuCurso() {

		Universidad unlam = new Universidad("Unlam");
        
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		Nota nota = new Nota(TipoParcial.PRIMER_PARCIAL, 6);
		unlam.registrarUnaNota(codCurso,dniAlumno,nota);
		
		Integer ve = 6;
		Integer vo = unlam.obtenerNotaPrimerParcialDeUnAlumnoEnUnCurso(dniAlumno, codCurso);
		
		assertEquals(ve,vo);
	}
	
	
	@Test
	public void queNoSePuedaRegistrar2NotasDelMismoTipoAUnAlumnoEnSuCurso() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		Nota nota = new Nota(TipoParcial.PRIMER_PARCIAL, 6);
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota));
		assertFalse(unlam.registrarUnaNota(codCurso,dniAlumno,nota));
		
		Integer ve = 1;
		Integer vo = unlam.obtenerCantidadDeNotasCargadasDeUnAlumnoEnUnCurso(dniAlumno, codCurso);
		
		assertEquals(ve,vo);
	}
	
	
	
	@Test
	public void queSePuedaRegistrarHasta3NotasDistintasAUnAlumnoEnSuCurso() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 8);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 6);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 8);
		Nota nota4 = new Nota(TipoParcial.RECU_1ER_PARCIAL, 9);
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota1));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota2));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota3));
		assertFalse(unlam.registrarUnaNota(codCurso,dniAlumno,nota4));
		
		Integer ve = 3;
		Integer vo = unlam.obtenerCantidadDeNotasCargadasDeUnAlumnoEnUnCurso(dniAlumno, codCurso);
		
		assertEquals(ve,vo);
	}
	
	//ObtenerPromedioDeUnAlumno  ó
	//queSePuedaSaberLaNotaFinalDeUnAlumnoDeUnaMateria
	@Test
	public void queSePuedaSaberLaNotaFinalDeUnAlumnoDeUnaMateria() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 7);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 4);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 8);
		
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota1));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota2));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota3));
		
		Integer ve = 8;
		Integer vo = unlam.obtenerNotaFinalDeUnAlumno(dniAlumno,codMateria);
		
		assertEquals(ve,vo);
	}
	
	/*No se puede inscribir Alumnos si este no tiene al menos cursada todas las
	   correlativas (Todas las correlativas Con nota >=4
	   
	   */
	
	@Test
	public void queSePuedaInscribirUnAlumnoAUnCursoSiTieneLasCorrelativasConNotaMayorOIgualA4() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000 , codMateriaCorrelativa = 1001;
		String nomMateria = "PB2", nomMateriaCorrelativa = "PB1";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		unlam.registrarMateria( new Materia(codMateriaCorrelativa, nomMateriaCorrelativa));
		
		Integer codCicloL = 11, codCicloL2 = 12;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 6, 6));
		CicloLectivo cicloL2 = new CicloLectivo(codCicloL2,  LocalDate.of(2023, 7, 15),LocalDate.of(2023,7,20),LocalDate.of(2023, 7, 22),LocalDate.of(2023, 11, 11));
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
		
		Integer numComision = 13, numComisionCorr = 14;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComisionCorr,codMateriaCorrelativa,codCicloL,turno,dias);
		unlam.registrarComision(numComision,codMateria,codCicloL2,turno,dias);
		
		Integer codCurso = 1, codCursoCorrelativo = 2;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		unlam.crearUnCurso(codCursoCorrelativo,numComisionCorr,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCursoCorrelativo,fechaInscripcion);
		
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 4);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 4);
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota1));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota2));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota3));
		
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 16);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion2));
	}
	
	
	@Test
	public void queNoSePuedaInscribirUnAlumnoAUnCursoSiNoTieneLasCorrelativasCursadasConNotaMayorOIgualA4() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000 , codMateriaCorrelativa = 1001;
		String nomMateria = "PB2", nomMateriaCorrelativa = "PB1";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		unlam.registrarMateria( new Materia(codMateriaCorrelativa, nomMateriaCorrelativa));
		unlam.asignarUnaMateriaCorrelativa(codMateria, codMateriaCorrelativa);
		
		Integer codCicloL = 11, codCicloL2 = 12;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 6, 6));
		CicloLectivo cicloL2 = new CicloLectivo(codCicloL2,  LocalDate.of(2023, 7, 15),LocalDate.of(2023,7,20),LocalDate.of(2023, 7, 22),LocalDate.of(2023, 11, 11));
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
		
		Integer numComisionCorr = 13, numComision = 14;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComisionCorr,codMateriaCorrelativa,codCicloL,turno,dias);
		unlam.registrarComision(numComision,codMateria,codCicloL2,turno,dias);
		
		Integer codCurso = 1, codCursoCorrelativo = 2;
		unlam.crearUnCurso(codCursoCorrelativo,numComisionCorr,numAula);
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCursoCorrelativo,fechaInscripcion));
		
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 4);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 2);
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota1));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota2));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota3));
		
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 16);
		assertFalse(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion2));
		
	}
	
	// No se puede asignar Una nota Mayor o igual a 7 si no están
	//todas las correlativas aprobadas (Mayor o igual a 7)
	
	@Test
	public void queNoSePuedaAsignarUnaNotaMayorOIgualA7SiNoEstanTodasLasCorrelativasAprobadas_MayorOIgualA7_() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000 , codMateriaCorrelativa = 1001;
		String nomMateria = "PB2", nomMateriaCorrelativa = "PB1";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		unlam.registrarMateria( new Materia(codMateriaCorrelativa, nomMateriaCorrelativa));
		unlam.asignarUnaMateriaCorrelativa(codMateria, codMateriaCorrelativa);
		
		Integer codCicloL = 11, codCicloL2 = 12;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 6, 6));
		CicloLectivo cicloL2 = new CicloLectivo(codCicloL2,  LocalDate.of(2023, 7, 15),LocalDate.of(2023,7,20),LocalDate.of(2023, 7, 22),LocalDate.of(2023, 11, 11));
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
		
		Integer numComisionCorr = 13, numComision = 14;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComisionCorr,codMateriaCorrelativa,codCicloL,turno,dias);
		unlam.registrarComision(numComision,codMateria,codCicloL2,turno,dias);
		
		Integer codCurso = 1, codCursoCorrelativo = 2;
		unlam.crearUnCurso(codCursoCorrelativo,numComisionCorr,numAula);
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCursoCorrelativo,fechaInscripcion));
		
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 4);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 4);
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota1));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota2));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota3));
		
		
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 16);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion2));
		
		//Verificacion
		Nota nota4 = new Nota(TipoParcial.PRIMER_PARCIAL, 7);
		assertFalse(unlam.registrarUnaNota(codCurso,dniAlumno,nota4));
	}
	
	@Test
	public void queSePuedaAsignarUnaNotaMayorOIgualA7SiEstanTodasLasCorrelativasAprobadas_MayorOIgualA7_() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000 , codMateriaCorrelativa = 1001;
		String nomMateria = "PB2", nomMateriaCorrelativa = "PB1";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		unlam.registrarMateria( new Materia(codMateriaCorrelativa, nomMateriaCorrelativa));
		unlam.asignarUnaMateriaCorrelativa(codMateria, codMateriaCorrelativa);
		
		Integer codCicloL = 11, codCicloL2 = 12;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 6, 6));
		CicloLectivo cicloL2 = new CicloLectivo(codCicloL2,  LocalDate.of(2023, 7, 15),LocalDate.of(2023,7,20),LocalDate.of(2023, 7, 22),LocalDate.of(2023, 11, 11));
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
		
		Integer numComisionCorr = 13, numComision = 14;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComisionCorr,codMateriaCorrelativa,codCicloL,turno,dias);
		unlam.registrarComision(numComision,codMateria,codCicloL2,turno,dias);
		
		Integer codCurso = 1, codCursoCorrelativo = 2;
		unlam.crearUnCurso(codCursoCorrelativo,numComisionCorr,numAula);
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCursoCorrelativo,fechaInscripcion));
		
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 8);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota1));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota2));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota3));
		
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 16);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion2));
		
		//Verificacion
		Nota nota4 = new Nota(TipoParcial.PRIMER_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota4));
		
	}
	
	
	//No se puede inscribir el alumno si excede la cantidad de alumnos permitidos en el aula
	@Test
	public void queNoSePuedaInscribirUnAlumnoAUnCursoSiExcedeLaCantidadDeAlumnosPermitidosEnElAula() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 23;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		Alumno alumno2 = new Alumno(2222, "Carlos", "Moreno", LocalDate.of(1998, 5, 5), LocalDate.of(2022, 3, 3));
		Alumno alumno3 = new Alumno(3333, "Carlos", "Moreno", LocalDate.of(1998, 5, 5), LocalDate.of(2022, 3, 3));
		Alumno alumno4 = new Alumno(4444, "Carlos", "Moreno", LocalDate.of(1998, 5, 5), LocalDate.of(2022, 3, 3));
		Alumno alumno5 = new Alumno(5555, "Carlos", "Moreno", LocalDate.of(1998, 5, 5), LocalDate.of(2022, 3, 3));
		Alumno alumno6 = new Alumno(6666, "Carlos", "Moreno", LocalDate.of(1998, 5, 5), LocalDate.of(2022, 3, 3));
		
		unlam.ingresarAlumno(alumno);
		unlam.ingresarAlumno(alumno2);
		unlam.ingresarAlumno(alumno3);
		unlam.ingresarAlumno(alumno4);
		assertTrue(unlam.ingresarAlumno(alumno5));
		assertTrue(unlam.ingresarAlumno(alumno6));
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		unlam.inscribirUnAlumnoAUnCurso(2222, codCurso,fechaInscripcion);
		unlam.inscribirUnAlumnoAUnCurso(3333, codCurso,fechaInscripcion);
		unlam.inscribirUnAlumnoAUnCurso(4444, codCurso,fechaInscripcion);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(5555, codCurso,fechaInscripcion));
		assertFalse(unlam.inscribirUnAlumnoAUnCurso(6666, codCurso,fechaInscripcion));
		
		Integer cantidadEsperada = 5;
		Integer cantidadDeAlumnosObtenidos = unlam.obtenerCantidadDeAlumnosSegunCodigoDeCurso(codCurso);
		assertEquals(cantidadEsperada,cantidadDeAlumnosObtenidos);
		
	}
	//No se puede inscribir el Alumno si ya está inscripto a otra comisión el mismo día y Turno y ciclo lectivo
	@Test
	public void queNoSePuedaInscribirUnAlumnoSiYaEstaInscriptoAOtroCursoConElMismoDiaTurnoYCicloLectivo() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000,otroCodMateria=1001;
		String nomMateria = "PB2", otroNomMateria="BD1";
		assertTrue(unlam.registrarMateria( new Materia(codMateria, nomMateria)));
		assertTrue(unlam.registrarMateria( new Materia(otroCodMateria, otroNomMateria)));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		assertTrue(unlam.crearCicloLectivo(cicloL));
		
		Integer numComision = 23,otroNumComision=24;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		assertTrue(unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias));
		assertTrue(unlam.registrarComision(otroNumComision,otroCodMateria,codCicloL,turno,dias));
		
		Integer codCurso = 1,otroCodCurso = 2;
		assertTrue(unlam.crearUnCurso(codCurso,numComision,numAula));
		assertTrue(unlam.crearUnCurso(otroCodCurso,otroNumComision,numAula));
		
		Integer dniAlumno = 2323, dniAlumno2 = 2222;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		assertFalse(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, otroCodCurso,fechaInscripcion));
		
		Integer cantidadEsperada = 1;
		Integer cantidadDeInscripcionesDeUnAlumno = unlam.obtenerCantidadDeInscripcionesDeUnAlumnoSegunDniAlumno(dniAlumno);
		assertEquals(cantidadEsperada,cantidadDeInscripcionesDeUnAlumno);
		
	}
	
	
	//No se puede inscribir a una materia que haya aprobado previamente
	@Test
	public void queUnAlumnoNoSePuedaInscribirAUnaMateriaQueHayaAprobadoPreviamente() {

		Universidad unlam = new Universidad("Unlam");
        
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11, codCicloL2 = 12;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 6, 6));
		CicloLectivo cicloL2 = new CicloLectivo(codCicloL2,  LocalDate.of(2023, 7, 15),LocalDate.of(2023,7,20),LocalDate.of(2023, 7, 22),LocalDate.of(2023, 11, 11));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 23, otroNumComision = 24;
		Turno turno = Turno.MANIANA, turnoTarde = Turno.TARDE;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		unlam.registrarComision(otroNumComision,codMateria,codCicloL,turnoTarde,dias);
		
		Integer codCurso = 1, otroCodCurso = 2;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		unlam.crearUnCurso(otroCodCurso,otroNumComision,numAula);
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion);
		
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 7);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 5);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		unlam.registrarUnaNota(codCurso,dniAlumno,nota1);
		unlam.registrarUnaNota(codCurso,dniAlumno,nota2);
		unlam.registrarUnaNota(codCurso,dniAlumno,nota3);
		
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 16);
		assertFalse(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, otroCodCurso,fechaInscripcion2));
		
	}
	
	
	@Test
	public void queSePuedaAsignarUnProfeAUnCurso() {
		
		Universidad unlam = new Universidad("Unlam");
        
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		String nomPro = "Juanma", apePro = "Rodriguez";
		Integer dniPro = 1221, dniPro2 = 44455;
		unlam.ingresarProfesor(new Profesor(dniPro, nomPro, apePro));
		unlam.ingresarProfesor(new Profesor(dniPro2, "Marcos", "Lopez"));
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		assertTrue(unlam.asignarProfesorAUnCurso(dniPro,codCurso));
		
		Integer cantidadEsperada = 1;
		assertEquals(cantidadEsperada,unlam.cantidadDeProfesEnUnCurso(codCurso));
	}
	
	//Cada 20 alumnos se debe agregar un docente ejemplo :
	//de 1 a 20 alumnos solo se puede asignar  un docente, de 21 a 40, 2 docentes
		
	@Test
	public void queNoSePuedaAsignarDosProfesAUnCursoQueTiene10Alumnos() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 50;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		String nomPro = "Juanma", apePro = "Rodriguez";
		Integer dniPro = 1221, dniPro2 = 44455;
		unlam.ingresarProfesor(new Profesor(dniPro, nomPro, apePro));
		unlam.ingresarProfesor(new Profesor(dniPro2, "Marcos", "Lopez"));
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		//Ingresamos 10 alumnos e inscribimos a un curso
		for(int i=0 ; i<10; i++) {
			Alumno alumno = new Alumno(i+100, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
			unlam.ingresarAlumno(alumno);
			unlam.inscribirUnAlumnoAUnCurso(i+100, codCurso,fechaInscripcion);
		}
		
		//Verificacion
		assertEquals(10,unlam.cantDeAlumnosDeUnCurso(codCurso),0.0);
		
		assertTrue(unlam.asignarProfesorAUnCurso(dniPro,codCurso));
		assertFalse(unlam.asignarProfesorAUnCurso(dniPro2,codCurso));
		
		Integer cantidadEsperada = 1;
		assertEquals(cantidadEsperada,unlam.cantidadDeProfesEnUnCurso(codCurso));
	}
	
	@Test
	public void queSePuedaAsignarDosProfesAUnCursoQueTiene22Alumnos() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 50;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		String nomPro = "Juanma", apePro = "Rodriguez";
		Integer dniPro = 1221, dniPro2 = 44455;
		unlam.ingresarProfesor(new Profesor(dniPro, nomPro, apePro));
		unlam.ingresarProfesor(new Profesor(dniPro2, "Marcos", "Lopez"));
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		//Ingresamos 22 alumnos e inscribimos a un curso
		for(int i=0 ; i<22; i++) {
			Alumno alumno = new Alumno(i+100, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
			unlam.ingresarAlumno(alumno);
			unlam.inscribirUnAlumnoAUnCurso(i+100, codCurso,fechaInscripcion);
		}
		
		//Verificacion
		assertEquals(22,unlam.cantDeAlumnosDeUnCurso(codCurso),0.0);
		
		assertTrue(unlam.asignarProfesorAUnCurso(dniPro,codCurso));
		assertTrue(unlam.asignarProfesorAUnCurso(dniPro2,codCurso));
		
		Integer cantidadEsperada = 2;
		Integer canttidadObtenida = unlam.cantidadDeProfesEnUnCurso(codCurso);
		assertEquals(cantidadEsperada,canttidadObtenida);
	}
	
	//El mismo docente no puede ser profesor de la misma curso 2 veces.
	
	@Test
	public void queNoSePuedaAsignarUnProfeAUnCursoSiYaFueAsignadoAnteriormente() {
		
		Universidad unlam = new Universidad("Unlam");
        
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria( new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		String nomPro = "Juanma", apePro = "Rodriguez";
		Integer dniPro = 1221, dniPro2 = 44455;
		unlam.ingresarProfesor(new Profesor(dniPro, nomPro, apePro));
		unlam.ingresarProfesor(new Profesor(dniPro2, "Marcos", "Lopez"));
		
		Integer numComision = 13;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		assertTrue(unlam.asignarProfesorAUnCurso(dniPro,codCurso));
		assertFalse(unlam.asignarProfesorAUnCurso(dniPro,codCurso));
		
		Integer cantidadEsperada = 1;
		assertEquals(cantidadEsperada,unlam.cantidadDeProfesEnUnCurso(codCurso));
	}
	
	
	//obtenerListadoMateriasAprobadasParaUnAlumno(idAlumno)
	//Dni nombre apellido nombreMateria Nota descripción cicloLectivo
	
	@Test
	public void queSePuedaObtenerUnListadoDe2MateriasAprobadasParaUnAlumno_igualOMAyorA7() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000 ,codMateria2 = 1002, codMateriaCorrelativa = 1001;
		String nomMateria = "Prog. Basica 2", nomMateriaCorrelativa = "Prog. Basica 1",
				nomMateria2 = "Ingles Tec. 1";
		
		Materia materiaCorr =  new Materia(codMateriaCorrelativa, nomMateriaCorrelativa);
		Materia materia2 = new Materia(codMateria2, nomMateria2);
		Materia materia =  new Materia(codMateria, nomMateria);
		
		unlam.registrarMateria(materiaCorr);//PB1
		unlam.registrarMateria(materia2 );//IT1
		unlam.registrarMateria(materia);//PB2
		unlam.asignarUnaMateriaCorrelativa(codMateria, codMateriaCorrelativa);
		
		Integer codCicloL = 11, codCicloL2 = 12;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 6, 6));
		CicloLectivo cicloL2 = new CicloLectivo(codCicloL2,  LocalDate.of(2023, 7, 15),LocalDate.of(2023,7,20),LocalDate.of(2023, 7, 22),LocalDate.of(2023, 11, 11));
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
		
		Integer numComisionCorr = 13, numComision2 = 14, numComision = 15 ;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		Dias dias2 = Dias.MIERCOLES;
		unlam.registrarComision(numComisionCorr,codMateriaCorrelativa,codCicloL,turno,dias);//PB1/1C
		unlam.registrarComision(numComision2,codMateria2,codCicloL,turno,dias2);//IngTec1/1C
		
		unlam.registrarComision(numComision,codMateria,codCicloL2,turno,dias);//PB2/2C
		
		
		
		Integer codCursoCorrelativo = 1,codCurso2 = 2, codCurso = 3 ;
		unlam.crearUnCurso(codCursoCorrelativo,numComisionCorr,numAula);//PB1
		unlam.crearUnCurso(codCurso2,numComision2,numAula);//IngTec1
		
		unlam.crearUnCurso(codCurso,numComision,numAula);//PB2
		

		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCursoCorrelativo,fechaInscripcion));//PB1
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso2,fechaInscripcion));//IngTec1
		
		
		//PB1 //APROBADA
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 8);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota1));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota2));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota3));
		
		//IT1 // DESAPROBADA
		Nota nota4 = new Nota(TipoParcial.PRIMER_PARCIAL, 7);
		Nota nota5 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota6 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 4);
		assertTrue(unlam.registrarUnaNota(codCurso2,dniAlumno,nota4));
		assertTrue(unlam.registrarUnaNota(codCurso2,dniAlumno,nota5));
		assertTrue(unlam.registrarUnaNota(codCurso2,dniAlumno,nota6));
		
		//Me anoto a PB2
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 16);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion2));
		//APROBADA
		Nota nota7 = new Nota(TipoParcial.PRIMER_PARCIAL, 9);
		Nota nota8 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota9 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota7));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota8));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota9));
		
		
		HashSet<Materia> materiasEsperadas = new HashSet<>();
		materiasEsperadas.add(new Materia(codMateriaCorrelativa, nomMateriaCorrelativa));//PB1
		materiasEsperadas.add(new Materia(codMateria, nomMateria));//PB2
				
		HashSet<Materia> materiasObtenidas = unlam.obtenerMateriasAprobadas(dniAlumno);
		
		for(Materia matObtenida : materiasObtenidas) {
			assertTrue(materiasEsperadas.contains(matObtenida));
		}
		
		
	}
	
	@Test
	public void queSePuedaObtenerUnListadoDe3MateriasAprobadasParaUnAlumno_igualOMAyorA7() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000 ,codMateria2 = 1002, codMateriaCorrelativa = 1001;
		String nomMateria = "Prog. Basica 2", nomMateriaCorrelativa = "Prog. Basica 1",
				nomMateria2 = "Ingles Tec. 1";
		
		Materia materiaCorr =  new Materia(codMateriaCorrelativa, nomMateriaCorrelativa);
		Materia materia2 = new Materia(codMateria2, nomMateria2);
		Materia materia =  new Materia(codMateria, nomMateria);
		
		unlam.registrarMateria(materiaCorr);//PB1
		unlam.registrarMateria(materia2 );//IT1
		unlam.registrarMateria(materia);//PB2
		unlam.asignarUnaMateriaCorrelativa(codMateria, codMateriaCorrelativa);
		
		Integer codCicloL = 11, codCicloL2 = 12;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 6, 6));
		CicloLectivo cicloL2 = new CicloLectivo(codCicloL2,  LocalDate.of(2023, 7, 15),LocalDate.of(2023,7,20),LocalDate.of(2023, 7, 22),LocalDate.of(2023, 11, 11));
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
		
		Integer numComisionCorr = 13, numComision2 = 14, numComision = 15 ;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		Dias dias2 = Dias.MIERCOLES;
		unlam.registrarComision(numComisionCorr,codMateriaCorrelativa,codCicloL,turno,dias);//PB1/1C
		unlam.registrarComision(numComision2,codMateria2,codCicloL,turno,dias2);//IngTec1/1C
		
		unlam.registrarComision(numComision,codMateria,codCicloL2,turno,dias);//PB2/2C
		
		
		
		Integer codCursoCorrelativo = 1,codCurso2 = 2, codCurso = 3 ;
		unlam.crearUnCurso(codCursoCorrelativo,numComisionCorr,numAula);//PB1
		unlam.crearUnCurso(codCurso2,numComision2,numAula);//IngTec1
		
		unlam.crearUnCurso(codCurso,numComision,numAula);//PB2
		
		
		
		Integer dniAlumno = 2323;
		Alumno alumno = new Alumno(dniAlumno, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 20);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCursoCorrelativo,fechaInscripcion));//PB1
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso2,fechaInscripcion));//IngTec1
		
		
		//PB1 //APROBADA
		Nota nota1 = new Nota(TipoParcial.PRIMER_PARCIAL, 8);
		Nota nota2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota1));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota2));
		assertTrue(unlam.registrarUnaNota(codCursoCorrelativo,dniAlumno,nota3));
		
		//IT1 //APROBADA
		Nota nota4 = new Nota(TipoParcial.PRIMER_PARCIAL, 7);
		Nota nota5 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota6 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCurso2,dniAlumno,nota4));
		assertTrue(unlam.registrarUnaNota(codCurso2,dniAlumno,nota5));
		assertTrue(unlam.registrarUnaNota(codCurso2,dniAlumno,nota6));
		
		//Me anoto a PB2
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 16);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno, codCurso,fechaInscripcion2));
		//APROBADA
		Nota nota7 = new Nota(TipoParcial.PRIMER_PARCIAL, 9);
		Nota nota8 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota nota9 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota7));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota8));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno,nota9));
		
		
		HashSet<Materia> materiasEsperadas = new HashSet<>();
		materiasEsperadas.add(new Materia(codMateriaCorrelativa, nomMateriaCorrelativa));//PB1
		materiasEsperadas.add(new Materia(codMateria, nomMateria));//PB2
		materiasEsperadas.add(new Materia(codMateria2, nomMateria2));//IT1
		
		
		HashSet<Materia> materiasObtenidas = unlam.obtenerMateriasAprobadas(dniAlumno);
		
		for(Materia matObtenida : materiasObtenidas) {
			assertTrue(materiasEsperadas.contains(matObtenida));
		}
		
	}
	
	@Test
	public void queSePuedaObtenerUnReporteDeNotasDeLosAlumnosDeUnCurso() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		unlam.registrarAula( new Aula(numAula, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "Prog. Basica 1";
		
		Materia materia =  new Materia(codMateria, nomMateria);
		
		unlam.registrarMateria(materia);//PB1
		
		Integer codCicloL = 11, codCicloL2 = 12;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 6, 6));
		CicloLectivo cicloL2 = new CicloLectivo(codCicloL2,  LocalDate.of(2023, 7, 15),LocalDate.of(2023,7,20),LocalDate.of(2023, 7, 22),LocalDate.of(2023, 11, 11));
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
		
		Integer numComisionCorr = 13, numComision2 = 14, numComision = 15 ;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL2,turno,dias);//PB1
		
		Integer codCurso = 3 ;
		unlam.crearUnCurso(codCurso,numComision,numAula);//PB1
		
		
		Integer dniAlumno1 = 2323, dniAlumno2 = 9191;
		String nomAlumno1 = "Lucas", apeAlumno1 ="Moreno";
		String nomAlumno2 = "Franco", apeAlumno2 ="Perez";
		Alumno alumno1 = new Alumno(dniAlumno1, nomAlumno1, apeAlumno1, LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		Alumno alumno2 = new Alumno(dniAlumno2, nomAlumno2, apeAlumno2, LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno1);
		unlam.ingresarAlumno(alumno2);
		
		
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 16);
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno1, codCurso,fechaInscripcion2));
		assertTrue(unlam.inscribirUnAlumnoAUnCurso(dniAlumno2, codCurso,fechaInscripcion2));
		
		//Notas de Lucas
		Nota n1 = new Nota(TipoParcial.PRIMER_PARCIAL, 9);
		Nota n2 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota n3 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno1,n1));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno1,n2));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno1,n3));
		Integer notaFinal1 = unlam.obtenerNotaFinalDeUnAlumno(dniAlumno1, codMateria);
		
		
		//Notas de Franco
		Nota n4 = new Nota(TipoParcial.PRIMER_PARCIAL, 9);
		Nota n5 = new Nota(TipoParcial.SEGUNDO_PARCIAL, 2);
		Nota n6 = new Nota(TipoParcial.RECU_2DO_PARCIAL, 7);
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno2,n4));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno2,n5));
		assertTrue(unlam.registrarUnaNota(codCurso,dniAlumno2,n6));
		Integer notaFinal2 = unlam.obtenerNotaFinalDeUnAlumno(dniAlumno2, codMateria);
		
//		Curso  nombreMateria Dni nombre apellido Nota
		
		ArrayList<ReporteDeNotaDeAlumno> reporteEsperado = new ArrayList<>();
		reporteEsperado.add(new ReporteDeNotaDeAlumno(codCurso, nomMateria, dniAlumno1, nomAlumno1, apeAlumno1, notaFinal1));
		reporteEsperado.add(new ReporteDeNotaDeAlumno(codCurso, nomMateria, dniAlumno2, nomAlumno2, apeAlumno2, notaFinal2));
		
		
		ArrayList<ReporteDeNotaDeAlumno> reportesObtenidos = unlam.obtenerReporteDeNotasDeAlumnos(codCurso);
		
		assertTrue(reporteEsperado.size()!=0);
		assertTrue(reporteEsperado.size()==2);
		
		for(int i = 0 ; i < reportesObtenidos.size(); i++ ) {
			assertEquals(reporteEsperado.get(i).getCodCurso(),reportesObtenidos.get(i).getCodCurso());
			assertEquals(reporteEsperado.get(i).getNomMateria(),reportesObtenidos.get(i).getNomMateria());
			assertEquals(reporteEsperado.get(i).getDniAlumno(),reportesObtenidos.get(i).getDniAlumno());
			assertEquals(reporteEsperado.get(i).getNombreAlumno(),reportesObtenidos.get(i).getNombreAlumno());
			assertEquals(reporteEsperado.get(i).getApellidoAlumno(),reportesObtenidos.get(i).getApellidoAlumno());
			assertEquals(reporteEsperado.get(i).getNota(),reportesObtenidos.get(i).getNota());
		}
		
	}
	

}
