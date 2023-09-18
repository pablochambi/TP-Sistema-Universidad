package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class testUniversidadCicloLectivo {
	
	//queNoSePuedaCrearDosCiclosLectivosQueSeSuperpongan	
	
	
	@Test
	public void queSePuedaCrear2CiclosLectivosEnUnaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		Integer codigoCl = 100;
		LocalDate fechaInscripcion = LocalDate.of(2023, 2, 15),
				fechaFinalizacionInscripcion = LocalDate.of(2023,3,1),
				fechaInicioCl = LocalDate.of(2023, 3, 7),
				fechaFinalizacionCl = LocalDate.of(2023, 7, 5);
		
		CicloLectivo cicloL = new CicloLectivo(codigoCl, fechaInscripcion, 
				fechaFinalizacionInscripcion,fechaInicioCl,fechaFinalizacionCl);
		CicloLectivo cicloL2 = new CicloLectivo(22,  LocalDate.of(2023, 2, 15), 
				LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		
		unlam.crearCicloLectivo(cicloL);
		unlam.crearCicloLectivo(cicloL2);
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
	
	
	

}
