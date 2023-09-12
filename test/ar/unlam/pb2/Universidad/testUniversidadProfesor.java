package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testUniversidadProfesor {

	@Test
	public void queSePuedaCrearUnaUniversidad() {
		String nombre ="Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer cantEsperada = 0;
		assertEquals(nombre,unlam.getNombre());
		assertEquals(cantEsperada,unlam.getCantidadDeProfesIngresados());
	}
	
	
	@Test
	public void queSePuedaIngresarAUnProfe() {
		Universidad unlam = new Universidad("Unlam");
		Profesor profe = new Profesor(22, "Micaela", "Sofia");
		unlam.ingresarProfesor(profe);
		Integer cantEsperada = 1;
		assertEquals(cantEsperada,unlam.getCantidadDeProfesIngresados());
	}
	
	@Test
	public void queSePuedaIngresarADosProfes() {
		Universidad unlam = new Universidad("Unlam");
		Profesor profe1 = new Profesor(22, "Micaela", "Sofia");
		Profesor profe2 = new Profesor(33, "Franco", "Pisso");
		unlam.ingresarProfesor(profe1);
		unlam.ingresarProfesor(profe2);
		Integer cantEsperada = 2;
		assertEquals(cantEsperada,unlam.getCantidadDeProfesIngresados());
	}
	
	@Test
	public void queNoSePuedaIngresarADosProfesConElMismoDni() {
		Universidad unlam = new Universidad("Unlam");
		Profesor profe1 = new Profesor(22, "Micaela", "Sofia");
		Profesor profe2 = new Profesor(22, "Micaela", "Pisso");
		unlam.ingresarProfesor(profe1);
		unlam.ingresarProfesor(profe2);
		Integer cantEsperada = 1;
		assertEquals(cantEsperada,unlam.getCantidadDeProfesIngresados());
	}
	
	
	
	

}
