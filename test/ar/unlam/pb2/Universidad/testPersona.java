package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class testPersona {

	@Test
	public void queSePuedaCrearProfesConIdIncremental() {
		
		String nombre = "Juan";
		String apellido = "Perez";
		Integer dni = 234352;
		Profesor profesor ,otroProfesor,otro2Profesor;
		
		profesor = otroProfesor = otro2Profesor = new Profesor();
		
		profesor = new Profesor(dni,nombre,apellido);
		otroProfesor = new Profesor(534535,"Carlos","Perrone");
		otro2Profesor = new Profesor(999765,"Marcos","gdf");
		
		assertEquals(nombre,profesor.getNombre());
		assertEquals((Integer)1,profesor.getId());
		assertEquals((Integer)2,otroProfesor.getId());
		assertEquals((Integer)3,otro2Profesor.getId());
		
	}
	
	@Test
	public void queSePuedaCrearAlumnosConIdIncremental() {
		
		Integer dni = 22443;
		String nombre = "Marcelo";
		String apellido = "Perez";
		LocalDate fechaNac = LocalDate.of(1998, 10, 4),
				fechaIngreso = LocalDate.of(2022, 4, 4);
		
		Alumno alumno,otroAlumno,otroAlumno2;
		alumno = otroAlumno = otroAlumno2 = new Alumno();
		
		 alumno = new Alumno(dni,nombre,apellido,fechaNac,fechaIngreso);
		 otroAlumno = new Alumno(767,nombre,apellido,fechaNac,fechaIngreso);
		 otroAlumno2 = new Alumno(876,nombre,apellido,fechaNac,fechaIngreso);
		
		assertEquals(nombre,alumno.getNombre());
		assertEquals((Integer)1, alumno.getId());
		assertEquals((Integer)2, otroAlumno.getId());
		assertEquals((Integer)3, otroAlumno2.getId());
	}


	
}
