package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class testComision {

	@Test
	public void queSePuedaCrearComisionesConIdIncremental() {
		
		Integer numeroCom = 100;
		Integer numeroCl = 200;
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 15),
				fechaFinalizacionInscripcion = LocalDate.of(2023,3,1),
				fechaInicioCl = LocalDate.of(2023, 3, 7),
				fechaFinalizacionCl = LocalDate.of(2023, 7, 5);
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		CicloLectivo cicloL = new CicloLectivo(numeroCl, fechaInscripcion, 
				fechaFinalizacionInscripcion,fechaInicioCl,fechaFinalizacionCl);
		Materia materia = new Materia(1002, "Base de datos 1");
		
		Comision comision = new Comision(numeroCom,materia,cicloL,turno,dias);
		Comision otraComision = new Comision(numeroCom,materia,cicloL,turno,dias);
		Comision otraComision2 = new Comision(numeroCom,materia,cicloL,turno,dias);
		
		Materia materiaEsperada = new Materia(1002, "Base de datos 1");
		assertEquals(materiaEsperada,comision.getMateria());
		assertEquals(1,comision.getId(),0.0);
		assertEquals(2,otraComision.getId(),0.0);
		assertEquals(3,otraComision2.getId(),0.0);
		
	}

}
