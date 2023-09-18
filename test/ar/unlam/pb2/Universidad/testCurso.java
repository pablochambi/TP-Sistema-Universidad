package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class testCurso {

	
	@Test
	public void queSePuedaCrearUnCursoEnLaUniversidad() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22, cantMax = 5;
		Aula aula = new Aula(numAula, cantMax);
		unlam.registrarAula(aula);
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		Materia materia = new Materia(codMateria, nomMateria);
		unlam.registrarMateria(materia);
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 1;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		
		Integer ve = 1;
		Integer vo = unlam.obtenerCantidadDeCursos();
		assertEquals(ve,vo);
	}
	
	@Test
	public void queSePuedaCrear2Cursos() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22,numAula2=25, cantMax = 5;
		unlam.registrarAula(new Aula(numAula, cantMax));
		unlam.registrarAula(new Aula(numAula2, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria(new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 1;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1, codCurso2 = 2;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		unlam.crearUnCurso(codCurso2,numComision,numAula2);
		
		Integer ve = 2;
		Integer vo = unlam.obtenerCantidadDeCursos();
		assertEquals(ve,vo);
	}
	
	@Test
	public void queNoSePuedaCrear2CursosConIgualCodigo() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer numAula=22,numAula2=25, cantMax = 5;
		unlam.registrarAula(new Aula(numAula, cantMax));
		unlam.registrarAula(new Aula(numAula2, cantMax));
		
		Integer codMateria = 1000;
		String nomMateria = "PB2";
		unlam.registrarMateria(new Materia(codMateria, nomMateria));
		
		Integer codCicloL = 11;
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		unlam.crearCicloLectivo(cicloL);
		
		Integer numComision = 1;
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer codCurso = 1;
		unlam.crearUnCurso(codCurso,numComision,numAula);
		unlam.crearUnCurso(codCurso,numComision,numAula2);
		
		Integer ve = 1;
		Integer vo = unlam.obtenerCantidadDeCursos();
		assertEquals(ve,vo);
	}

	
	
}
