package ar.unlam.pb2.Universidad;
import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

public class testUniversidadComision {

	//queNoSePuedaSuperponerDosRangosDeFechaEntreCiclosLectivos
	
	@Test
	public void queSePuedaCrear1ComisionEnUnaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		
		Integer numComision = 1, codMateria =1001, codCicloL = 11;
		
		Materia materia = new Materia(codMateria, "pb2");
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		Turno turno = Turno.MANIANA;
		Dias dias = Dias.MARTES_Y_JUEVES;
		
		unlam.registrarMateria(materia);
		unlam.crearCicloLectivo(cicloL);
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		
		Integer ve = 1;
		Integer vo = unlam.obtenerCantidadDeComisiones();
		assertEquals(ve,vo);
	}
	
	@Test
	public void queSePuedaCrear2ComisionesEnUnaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		
		Integer numComision = 1, otroNumCom=2, codMateria =1001, codCicloL = 11;
		
		Materia materia = new Materia(codMateria, "pb2");
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		Dias dias = Dias.MARTES_Y_JUEVES, dias2 = Dias.LUNES_Y_MIERCOLES;
		Turno turno = Turno.MANIANA,turno2 = Turno.TARDE;
		
		
		unlam.registrarMateria(materia);
		unlam.crearCicloLectivo(cicloL);
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		unlam.registrarComision(otroNumCom,codMateria,codCicloL,turno2,dias2);
		
		Integer ve = 2;
		Integer vo = unlam.obtenerCantidadDeComisiones();
		assertEquals(ve,vo);
	}
	@Test
	public void queNoSePuedaCrear2ComisionesConElMismoNumeroEnUnaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		
		Integer numComision = 1, codMateria =1001, codCicloL = 11;
		
		Materia materia = new Materia(codMateria, "pb2");
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		Dias dias = Dias.MARTES_Y_JUEVES, dias2 = Dias.LUNES_Y_MIERCOLES;
		Turno turno = Turno.MANIANA,turno2 = Turno.TARDE;
		
		unlam.registrarMateria(materia);
		unlam.crearCicloLectivo(cicloL);
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		unlam.registrarComision(numComision,codMateria,codCicloL,turno2,dias2);
		
		Integer ve = 1;
		Integer vo = unlam.obtenerCantidadDeComisiones();
		assertEquals(ve,vo);
	}
	
	/*
	 * No se Pueden generar 2 Comisiones para la misma materia,
	 * el mismo cicloLectivo y el mismo turno
	 * 
	 * */
	
	@Test
	public void queNoSePuedaCrear2ComisionesParaLaMismaMateriaCicloLectivoTurnoYHorario() {
		Universidad unlam = new Universidad("Unlam");
		
		Integer numComision = 1, codMateria =1001, codCicloL = 11;
		
		Materia materia = new Materia(codMateria, "pb2");
		CicloLectivo cicloL = new CicloLectivo(codCicloL,  LocalDate.of(2023, 2, 15),LocalDate.of(2023,3,1),LocalDate.of(2023, 3, 7),LocalDate.of(2023, 7, 5));
		Dias dias = Dias.MARTES_Y_JUEVES, dias2 = Dias.LUNES_Y_MIERCOLES;
		Turno turno = Turno.MANIANA,turno2 = Turno.TARDE;
		
		unlam.registrarMateria(materia);
		unlam.crearCicloLectivo(cicloL);
		unlam.registrarComision(numComision,codMateria,codCicloL,turno,dias);
		unlam.registrarComision(2,codMateria,codCicloL,turno2,dias2);
		
		Integer ve = 2;
		Integer vo = unlam.obtenerCantidadDeComisiones();
		assertEquals(ve,vo);
	}
	
	
	
	
	

}
