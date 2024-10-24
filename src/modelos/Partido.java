package modelos;

import java.util.Random;

public class Partido {
	
	Equipo equipoA, equipoB;
	int golesA, golesB;
	final int MAX_GOLES = 6;
	private Random random = new Random();
	
	public Partido() {
		
	}
	
	public Partido(Equipo equipoA, Equipo equipoB) {
		this.equipoA = equipoA;
		this.equipoB = equipoB;
	}
	
	private int simularGoles(int maxGol) {
		return random.nextInt(maxGol);
	}
	
	public void jugar(float[] probabilidadA) {
		float p1 = random.nextFloat();
		if (p1 > probabilidadA[1]) {  //empatan ambos equipos
			golesA = simularGoles(MAX_GOLES);
			golesB = golesA;
			System.out.println("Los equipos " + this.equipoA.nombre + " y " 
					+ this.equipoB.nombre + " empataron con " + golesA + " goles");
			this.equipoA.addEmpate();
			this.equipoB.addEmpate();

			
		} else if (p1 > probabilidadA[0]) {  //gana equipo B
			golesB = simularGoles(MAX_GOLES - 1) + 1; 
			golesA = simularGoles(golesB);
			System.out.println(this.equipoB.nombre + "(" + golesB + ") le ganó a " + this.equipoA.nombre + "(" + golesA + ")");
			this.equipoA.addDerrota();
			this.equipoB.addVictoria();
			
		} else {  // gana eqiopo A
			golesA = simularGoles(MAX_GOLES - 1) + 1;
			golesB = simularGoles(golesA);
			System.out.println(this.equipoA.nombre + "(" + golesA + ") le ganó a " + this.equipoB.nombre + "(" + golesB + ")");
			this.equipoA.addVictoria();
			this.equipoB.addDerrota();
		}
		
		this.equipoA.addGoles(golesA, golesB);
		this.equipoB.addGoles(golesB, golesA);
		
		System.out.println("eq: " + this.equipoA.nombre + " " + this.equipoA.derrotas);
	}
}
