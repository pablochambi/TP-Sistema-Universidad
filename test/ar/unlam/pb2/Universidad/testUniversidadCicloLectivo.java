package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class testUniversidadCicloLectivo {
	
	@Test
	public void queSePuedaCrear2CiclosLectivosQueNoSeSuperponganEnUnaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		Integer codigoCl = 100;
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 15),
				fechaFinalInscripcion = LocalDate.of(2023,3,1),
				fechaInicioCl = LocalDate.of(2023, 3, 7),
				fechaFinalizacionCl = LocalDate.of(2023, 7, 5);
		CicloLectivo cicloL = new CicloLectivo(codigoCl, fechaInscripcion, 
				fechaFinalInscripcion,fechaInicioCl,fechaFinalizacionCl);
		unlam.crearCicloLectivo(cicloL);

		
		Integer codigoCl2 = 101;
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 7, 10),
				fechaFinalInscripcion2 = LocalDate.of(2023,7,29),
				fechaInicioCl2 = LocalDate.of(2023, 8, 7),
				fechaFinalizacionCl2 = LocalDate.of(2023, 12, 5);
		CicloLectivo cicloL2 = new CicloLectivo(codigoCl2, fechaInscripcion2, 
				fechaFinalInscripcion2,fechaInicioCl2,fechaFinalizacionCl2);
		
		//Verificacion
		assertTrue(unlam.crearCicloLectivo(cicloL2));
		
		assertEquals((Integer)2, unlam.obtenerCantidadDeCiclosLectivosIngresados());
	}
	
	@Test
	public void queNoSePuedaCrear2CiclosLectivosConElMismoCodigoEnUnaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		
		CicloLectivo cicloL = new CicloLectivo(22,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		CicloLectivo cicloL2 = new CicloLectivo(22,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
		assertEquals((Integer)1, unlam.obtenerCantidadDeCiclosLectivosIngresados());
	}

	
	//queNoSePuedaCrearDosCiclosLectivosQueSeSuperpongan	
	@Test
	public void queNoSePuedaCrearDosCiclosLectivosQueSeSuperpongan() {
		Universidad unlam = new Universidad("Unlam");
		
		Integer codigoCl = 100;
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 15),
				fechaFinalInscripcion = LocalDate.of(2023,3,1),
				fechaInicioCl = LocalDate.of(2023, 3, 7),
				fechaFinalizacionCl = LocalDate.of(2023, 7, 5);
		CicloLectivo cicloL = new CicloLectivo(codigoCl, fechaInscripcion, 
				fechaFinalInscripcion,fechaInicioCl,fechaFinalizacionCl);
		unlam.crearCicloLectivo(cicloL);

		
		Integer codigoCl2 = 101;
		LocalDate fechaInscripcion2 = LocalDate.of(2023, 5, 15),
				fechaFinalInscripcion2 = LocalDate.of(2023,5,29),
				fechaInicioCl2 = LocalDate.of(2023, 6, 7),
				fechaFinalizacionCl2 = LocalDate.of(2023, 10, 5);
		CicloLectivo cicloL2 = new CicloLectivo(codigoCl2, fechaInscripcion2, 
				fechaFinalInscripcion2,fechaInicioCl2,fechaFinalizacionCl2);
		
		//Verificacion
		assertFalse(unlam.crearCicloLectivo(cicloL2));
		
		assertEquals((Integer)1, unlam.obtenerCantidadDeCiclosLectivosIngresados());
		
		
	}
	
	
	
	
	

}
