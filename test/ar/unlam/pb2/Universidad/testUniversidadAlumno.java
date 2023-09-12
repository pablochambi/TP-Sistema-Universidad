package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testUniversidadAlumno {

	@Test
	public void queSePuedaCrearUnaUniversidad() {
		String nombre ="Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer cantEsperada = 0;
		assertEquals(nombre,unlam.getNombre());
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	@Test
	public void queSePuedaIngresarAUnAlumno() {
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno = new Alumno(22, "Micaela", "Sofia");
		unlam.ingresarAlumno(alumno);
		Integer cantEsperada = 1;
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	@Test
	public void queSePuedaIngresarADosAlumnos() {
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno = new Alumno(22, "Micaela", "Sofia");
		Alumno alumno2 = new Alumno(33, "Franco", "Pisso");
		unlam.ingresarAlumno(alumno);
		unlam.ingresarAlumno(alumno2);
		Integer cantEsperada = 2;
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	@Test
	public void queNoSePuedaIngresarADosAlumnosConElMismoDni() {
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno = new Alumno(22, "Micaela", "Sofia");
		Alumno alumno2 = new Alumno(22, "Micaela", "Pisso");
		unlam.ingresarAlumno(alumno);
		unlam.ingresarAlumno(alumno2);
		Integer cantEsperada = 1;
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	
	

}
