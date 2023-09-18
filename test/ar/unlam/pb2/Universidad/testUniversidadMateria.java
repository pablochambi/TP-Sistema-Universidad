package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testUniversidadMateria {
	
	@Test
	public void queSePuedaAgregarMateriasAUnaUniversidadCorrectamente() {
		
		Universidad unlam = new Universidad("Unlam");
		
		unlam.registrarMateria(new Materia(1002, "Pb2"));
		unlam.registrarMateria(new Materia(1003, "Bd1"));
		unlam.registrarMateria(new Materia(1004, "PW1"));
		
		Integer  ve = 3;
		Integer vo = unlam.obtenerCantidadDeMaterias();
		
		assertEquals(ve,vo);
		
	}
	
	
	@Test
	public void queNoSePuedaAgregar2MateriasAUnaUniversidadConElMismoCodigoDeMateria() {
		
		Universidad unlam = new Universidad("Unlam");
		
		unlam.registrarMateria(new Materia(1002, "Pb2"));
		unlam.registrarMateria(new Materia(1002, "Pb2"));
		
		Integer  ve = 1;
		Integer vo = unlam.obtenerCantidadDeMaterias();
		
		assertEquals(ve,vo);
		
	}
	
	@Test
	public void queSePuedaAsignarDosMateriasCorrelativasAUnaMateria() {
		
		Universidad unlam = new Universidad("Unlam");
		Integer codMateria = 1001;
		Integer codMateriaCorrelativa = 1002;
		Integer codMateriaCorrelativa2 = 1003;
		Materia materia = new Materia(codMateriaCorrelativa, "Programacion basica 1");
		Materia materia2 = new Materia(codMateriaCorrelativa2, "Ingenieria Informatica");
		Materia materia3 = new Materia(codMateria, "Programacion web 1");
		unlam.registrarMateria(materia);
		unlam.registrarMateria(materia2);
		unlam.registrarMateria(materia3);
		
		unlam.asignarUnaMateriaCorrelativa(codMateria,codMateriaCorrelativa);
		unlam.asignarUnaMateriaCorrelativa(codMateria,codMateriaCorrelativa2);
		Integer  ve = 2;
		Integer vo = materia3.cantidadDeMateriasCorrelativas();
		
		assertEquals(ve,vo);
		
	}
	
	@Test
	public void queNoSePuedaAsignarDosMateriasCorrelativasConElMismoCodigoAUnaMateria() {
		
		Universidad unlam = new Universidad("Unlam");
		Integer codMateria = 1001;
		Integer codMateriaCorrelativa = 1002;
		Materia materia = new Materia(codMateriaCorrelativa, "Pb1");
		Materia materia2 = new Materia(codMateria, "Pb2");
		unlam.registrarMateria(materia);
		unlam.registrarMateria(materia2);
		
		unlam.asignarUnaMateriaCorrelativa(codMateria,codMateriaCorrelativa);
		unlam.asignarUnaMateriaCorrelativa(codMateria,codMateriaCorrelativa);
		Integer  ve = 1;
		Integer vo = materia2.cantidadDeMateriasCorrelativas();
		
		assertEquals(ve,vo);
		
	}
	
	@Test
	public void queSePuedaEliminarUnaMateriaCorrelativaAUnaMateria() {
		
		Universidad unlam = new Universidad("Unlam");
		Integer codMateria = 1001;
		Integer codMateriaCorrelativa = 1002;
		Integer codMateriaCorrelativa2 = 1003;
		Materia materia = new Materia(codMateriaCorrelativa, "Programacion basica 1");
		Materia materia2 = new Materia(codMateriaCorrelativa2, "Ingenieria Informatica");
		Materia materia3 = new Materia(codMateria, "Programacion web 1");
		unlam.registrarMateria(materia);
		unlam.registrarMateria(materia2);
		unlam.registrarMateria(materia3);
		
		unlam.asignarUnaMateriaCorrelativa(codMateria,codMateriaCorrelativa);
		unlam.asignarUnaMateriaCorrelativa(codMateria,codMateriaCorrelativa2);
		
		Integer codMateriaCorrelativaAEliminar = 1002;
		unlam.eliminarUnaMateriaCorrelativa(codMateria,codMateriaCorrelativaAEliminar);
		
		Integer  ve = 1;
		Integer vo = materia3.cantidadDeMateriasCorrelativas();
		
		assertEquals(ve,vo);
		
	}
	
	
//	AsiganarMateriaCorrelativa (código Materia,  código DeMateria Correlativa)
//	//Se debe validar que ambos códigos existan en una materia
	
//	 EliminarCorrelativa(codigoMateria, CodigoCorrelativaAELiminar)
//	//Se debe validar que ambos códigos existan en una materia

	
	

}
