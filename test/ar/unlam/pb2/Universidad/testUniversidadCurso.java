package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testUniversidadCurso {

	@Test
	public void queSePuedaCrearUnCurso() {

		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso = 1, codMat = 22, anio = 2024,
				codAula = 333, cantMax = 5;
		String nomMat = "Programacion basica 2", fechaInicio = "02/03/2023";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		
		
		unlam.registrarMateria(materia);
		unlam.registrarAula(aula);
		unlam.crearUnCurso(codCurso,codMat,horario,cicloLectivo,codAula);
		
		Integer cantidadEsperada = 1;
		Materia materiaEsperada = new Materia(codMat,nomMat);
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso)));
		assertEquals(cantidadEsperada,unlam.cantidadDeCursos());
	}
	

	@Test
	public void queSePuedaCrearDosCursosConLaMismaMateriaHorarioCicloLectivoPeroDistintaAula() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso = 1,codCurso2= 2, codMat = 22, anio = 2024,
				codAula = 333,codAula2= 444, cantMax = 5;
		String nomMat = "Programacion basica 2", fechaInicio = "02/03/2023";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		Aula aula2 = new Aula(codAula2, cantMax);
		
		unlam.registrarMateria(materia);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.crearUnCurso(codCurso,codMat,horario,cicloLectivo,codAula);
		unlam.crearUnCurso(codCurso2,codMat,horario,cicloLectivo,codAula2);
		
		Materia materiaEsperada = new Materia(codMat,nomMat);
		Integer ve = 2;
		Integer vo = unlam.cantidadDeCursos();
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso)));
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso2)));
		assertEquals(ve,vo);
	}
		
		
	@Test
	public void queNoSePuedaCrearDosCursosConElMismoCodigo() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso = 1,codCurso2= 1, codMat = 22, anio = 2024,
				codAula = 333,codAula2= 444, cantMax = 5;
		String nomMat = "Programacion basica 2", fechaInicio = "02/03/2023";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		Aula aula2 = new Aula(codAula2, cantMax);
		
		unlam.registrarMateria(materia);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.crearUnCurso(codCurso,codMat,horario,cicloLectivo,codAula);
		unlam.crearUnCurso(codCurso2,codMat,horario,cicloLectivo,codAula2);
		
		Integer cantidadEsperada = 1;
		Integer cantidadObtenida = unlam.cantidadDeCursos();
		assertEquals(cantidadEsperada, cantidadObtenida);
	}
	
	
	
	@Test
	public void queNoSePuedaCrearDosCursosConLaMismaMateriaHorarioCiclosLectivoYAula() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso1 = 1,codCurso2= 2, codMat = 22, anio = 2024,
				codAula = 333,codAula2= 444, cantMax = 5;
		String nomMat = "Programacion basica 2", fechaInicio = "02/03/2023";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		Aula aula2 = new Aula(codAula2, cantMax);
		
		unlam.registrarMateria(materia);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.crearUnCurso(codCurso1,codMat,horario,cicloLectivo,codAula);
		unlam.crearUnCurso(codCurso2,codMat,horario,cicloLectivo,codAula);
		
		Materia materiaEsperada = new Materia(codMat,nomMat);
		Integer ve = 1;
		Integer vo = unlam.cantidadDeCursos();
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso1)));
		assertEquals(ve,vo);
	}
	@Test
	public void queSePuedaCrearDosCursosConIgualesMateriasHorariosYaulasPeroDistintoCicloLectivo() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso1 = 1,codCurso2= 2, codMat = 22, anio = 2024,
				codAula = 333,codAula2= 444, cantMax = 5;
		String nomMat = "Programacion basica 2", fechaInicio = "02/03/2023",
				fechaInicio2 = "01/06/2023";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		TipoCuatri tipoCuatri2 = TipoCuatri._2DO_C;
		Dias dias = Dias.LUNES;
		Hora hora = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		CicloLectivo otroCicloLectivo = new CicloLectivo(anio, tipoCuatri2,fechaInicio2);
		Aula aula = new Aula(codAula, cantMax);
		Aula aula2 = new Aula(codAula2, cantMax);
		
		unlam.registrarMateria(materia);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.crearUnCurso(codCurso1,codMat,horario,cicloLectivo,codAula);
		unlam.crearUnCurso(codCurso2,codMat,horario,otroCicloLectivo,codAula);
		
		Materia materiaEsperada = new Materia(codMat,nomMat);
		Integer ve = 2;
		Integer vo = unlam.cantidadDeCursos();
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso1)));
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso2)));
		assertEquals(ve,vo);
	}
	
	@Test
	public void queSePuedaCrearDosCursosConIgualesMateriasAulasYCiclosLectivosPeroDistintosHorarios() {
		
		Universidad unlam = new Universidad("Unlam");
		
		Integer codCurso1 = 1,codCurso2= 2, codMat = 22, anio = 2024,
				codAula = 333,codAula2= 444, cantMax = 5;
		String nomMat = "Programacion basica 2", fechaInicio = "02/03/2023",
				fechaInicio2 = "01/06/2023";
		TipoCuatri tipoCuatri = TipoCuatri._1ER_C;
		TipoCuatri tipoCuatri2 = TipoCuatri._2DO_C;
		Dias dias = Dias.LUNES, dias2 = Dias.MARTES;
		Hora hora = Hora._08a12, hora2 = Hora._08a12;
		
		Materia materia = new Materia(codMat, nomMat);
		Horario horario = new Horario(hora, dias);
		Horario otroHorario = new Horario(hora2, dias2);
		CicloLectivo cicloLectivo = new CicloLectivo(anio, tipoCuatri,fechaInicio);
		Aula aula = new Aula(codAula, cantMax);
		Aula aula2 = new Aula(codAula2, cantMax);
		
		unlam.registrarMateria(materia);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.crearUnCurso(codCurso1,codMat,horario,cicloLectivo,codAula);
		unlam.crearUnCurso(codCurso2,codMat,otroHorario,cicloLectivo,codAula);
		
		Materia materiaEsperada = new Materia(codMat,nomMat);
		Integer ve = 2;
		Integer vo = unlam.cantidadDeCursos();
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso1)));
		assertTrue(materiaEsperada.equals(unlam.obtenerMateriaPorCodigoDeCurso(codCurso2)));
		assertEquals(ve,vo);
	}
	
	
	
}
