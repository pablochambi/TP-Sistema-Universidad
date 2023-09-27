package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class testUniversidadAlumno {

	@Test
	public void queSePuedaCrearUnaUniversidadQueNoTengaAlumnos() {
		String nombre ="Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer cantEsperada = 0;
		assertEquals(nombre,unlam.getNombre());
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	@Test
	public void queSePuedaIngresarAUnAlumno() {
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno = new Alumno(22, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		Integer cantEsperada = 1;
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	@Test
	public void queSePuedaIngresarA2Alumnos() {
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno = new Alumno(292, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		Alumno otroAlumno = new Alumno(252, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		unlam.ingresarAlumno(otroAlumno);
		Integer cantEsperada = 2;
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	@Test
	public void queNoSePuedaIngresarADosAlumnosConElMismoDni() {
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno = new Alumno(22, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		Alumno otroAlumno = new Alumno(22, "Lucas", "Moreno", LocalDate.of(1998, 3, 3), LocalDate.of(2022, 3, 3));
		unlam.ingresarAlumno(alumno);
		unlam.ingresarAlumno(otroAlumno);
		Integer cantEsperada = 1;
		assertEquals(cantEsperada,unlam.getCantidadDeIngresantes());
	}
	
	
	
	
	

}
