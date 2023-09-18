package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class testCicloLectivo {

	@Test
	public void queSePuedaCrearCiclosLectivosConIdIncremental() {
		
		Integer numero = 100;
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 15),
				fechaFinalizacionInscripcion = LocalDate.of(2023,3,1),
				fechaInicioCl = LocalDate.of(2023, 3, 7),
				fechaFinalizacionCl = LocalDate.of(2023, 7, 5);
		
		CicloLectivo cicloL = new CicloLectivo(numero, fechaInscripcion, 
				fechaFinalizacionInscripcion,fechaInicioCl,fechaFinalizacionCl);
		CicloLectivo otroCicloL = new CicloLectivo(numero, fechaInscripcion, 
				fechaFinalizacionInscripcion,fechaInicioCl,fechaFinalizacionCl);
		CicloLectivo otroCicloL2 = new CicloLectivo(numero, fechaInscripcion, 
				fechaFinalizacionInscripcion,fechaInicioCl,fechaFinalizacionCl);
		
		assertEquals(fechaInscripcion, cicloL.getFechaInscripcion());
		
		assertEquals(1,cicloL.getId(),0.0);
		assertEquals(2,otroCicloL.getId(),0.0);
		assertEquals(3,otroCicloL2.getId(),0.0);
		
		
	}

	
	
	
	
	
	
	
	
	
	
}
