package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Torneo {
	public static final int NUM_EQUIPOS = 6;
	public static final int NUM_RONDAS = 2;
	public static final int NUM_JORNADAS = (NUM_EQUIPOS - 1) * (NUM_RONDAS + 1);
	public ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
	public ArrayList<ArrayList<Float>> probabilidadesEquipo = new  ArrayList<ArrayList<Float>>();
	public ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
	
	
	Random random = new Random();
	
	public void crearEquipos() {
		listaEquipos.add(new Equipo("Serena"));
		listaEquipos.add(new Equipo("Talca"));
		listaEquipos.add(new Equipo("Iquique"));
		listaEquipos.add(new Equipo("Antofagasta"));
		listaEquipos.add(new Equipo("Rancagua"));
		listaEquipos.add(new Equipo("Barnechea"));
	}
	
	public float[] ProbabilidadesEquipoA() {
		float probA, probB, probEmpate;
		//Probabilidad que el equipo A le gane un partido al equipo B
		//debe ser un número menor a 0.7, para dejar probabilidad de que empate o pierada
		probA = random.nextFloat((float) 0.7);
		probB = random.nextFloat((float) 1 - probA);
		probEmpate = 1 - probA - probB;
		return new float[] {(float) probA, (float) probB, (float) probEmpate};
	}
	
	public void creaPartidos() {
		Partido partido = new Partido();
		//Jornada 1
		
		//partido 1
		System.out.println("Jornada 1 - Partido 1:");
		partido.equipoA = listaEquipos.get(0);
		partido.equipoB = listaEquipos.get(1);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 2
		System.out.println("Jornada 1 - Partido 2:");
		partido.equipoA = listaEquipos.get(2);
		partido.equipoB = listaEquipos.get(3);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 3
		System.out.println("Jornada 1 - Partido 3:");
		partido.equipoA = listaEquipos.get(4);
		partido.equipoB = listaEquipos.get(5);
		partido.jugar(ProbabilidadesEquipoA());
		
		//Jornada 2
		
		//partido 4
		System.out.println("Jornada 2 - Partido 4:");
		partido.equipoA = listaEquipos.get(0);
		partido.equipoB = listaEquipos.get(5);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 5
		System.out.println("Jornada 2 - Partido 5:");
		partido.equipoA = listaEquipos.get(1);
		partido.equipoB = listaEquipos.get(2);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 6
		System.out.println("Jornada 2 - Partido 6:");
		partido.equipoA = listaEquipos.get(3);
		partido.equipoB = listaEquipos.get(4);
		partido.jugar(ProbabilidadesEquipoA());
		
		//Jornada 3
		
		//partido 7
		System.out.println("Jornada 3 - Partido 7:");
		partido.equipoA = listaEquipos.get(0);
		partido.equipoB = listaEquipos.get(2);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 8
		System.out.println("Jornada 3 - Partido 8:");
		partido.equipoA = listaEquipos.get(1);
		partido.equipoB = listaEquipos.get(4);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 9
		System.out.println("Jornada 3 - Partido 9:");
		partido.equipoA = listaEquipos.get(3);
		partido.equipoB = listaEquipos.get(5);
		partido.jugar(ProbabilidadesEquipoA());
		
		//Jornada 4
		
		//partido 10
		System.out.println("Jornada 4 - Partido 10:");
		partido.equipoA = listaEquipos.get(0);
		partido.equipoB = listaEquipos.get(4);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 11
		System.out.println("Jornada 4 - Partido 11:");
		partido.equipoA = listaEquipos.get(1);
		partido.equipoB = listaEquipos.get(3);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 12
		System.out.println("Jornada 4 - Partido 12:");
		partido.equipoA = listaEquipos.get(2);
		partido.equipoB = listaEquipos.get(5);
		partido.jugar(ProbabilidadesEquipoA());
		
		//Jornada 5
		
		//partido 13
		System.out.println("Jornada 5 - Partido 13:");
		partido.equipoA = listaEquipos.get(0);
		partido.equipoB = listaEquipos.get(3);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 14
		System.out.println("Jornada 5 - Partido 14:");
		partido.equipoA = listaEquipos.get(1);
		partido.equipoB = listaEquipos.get(5);
		partido.jugar(ProbabilidadesEquipoA());
		//partido 15
		System.out.println("Jornada 5 - Partido 15:");
		partido.equipoA = listaEquipos.get(2);
		partido.equipoB = listaEquipos.get(4);
		partido.jugar(ProbabilidadesEquipoA());
	}
	

	public void ordenarTabla() {
		Collections.sort(listaEquipos, new Comparator<Equipo>() {

			@Override
			public int compare(Equipo e1, Equipo e2) {
				System.out.println("-- " + e2.getPuntos() + " -- " + e1.getPuntos());
				if(e2.getPuntos() != e1.getPuntos()) {
					return e2.getPuntos() - e1.getPuntos();
				} else if (e2.getDiferenciaGoles() != e1.getDiferenciaGoles()) {
					return e2.getDiferenciaGoles() - e1.getDiferenciaGoles();
				} else {
					return e2.getGolesFavor() - e1.getGolesFavor();
				}
			}
			
		});
	};
	
	public void mostrarTabla() {
		
		ordenarTabla();
		System.out.println("\n\n\n");
		System.out.println("Tabla de Posiciones");
		System.out.println("Equipo      \t\tG\tP\tE\tPtos\tGF\tGC\tDG");
		for(Equipo eq : listaEquipos) {
			System.out.println(eq);
		}
	}
}
