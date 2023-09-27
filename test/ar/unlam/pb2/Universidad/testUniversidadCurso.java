package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class testUniversidadCurso {

	@Test
	public void queSePuedaCrearUnCursoEnLaUniversidad() {

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
		
		Integer cantidadEsperada = 1;
		Materia materiaEsperada = new Materia(codMateria,nomMateria);
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso)));
		assertEquals(cantidadEsperada,unlam.cantidadDeCursos());
	}
	
	
	
}
