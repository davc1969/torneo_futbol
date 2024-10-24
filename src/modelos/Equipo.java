package modelos;

public class Equipo {
	
	public String nombre;
	public int victorias = 0, derrotas = 0, empates = 0;
	public int golesFavor = 0, golesContra = 0, diferenciaGoles = 0;
	public int puntos = 0;


	public Equipo(String nombre) {
		this.nombre = nombre;	
	}
	
	
	
	public void addVictoria() {
		this.victorias++;
		this.puntos += 3;
	}
	
	public void addDerrota() {
		this.derrotas++;
	}
	
	public void addEmpate() {
		this.empates++;
		this.puntos += 1;
	}
	
	public void addGoles(int golFavor, int golContra) {
		this.golesFavor += golFavor;
		this.golesContra += golContra;
		this.diferenciaGoles += golFavor - golContra;
	}
	

	
	

	@Override
	public String toString() {
		return String.format("%-12s\t\t%d\t%d\t%d\t%d\t%d\t%d\t%d", nombre, this.victorias, this.derrotas, 
							this.empates, this.puntos, this.golesFavor, this.golesContra, this.diferenciaGoles);
		//return "%12s" + nombre + "\t" + this.victorias + "\t" + this.derrotas + "\t" + this.empates + "\t" + this.showPuntos();
	}
	




	public int getGolesFavor() {
		return this.golesFavor;
	}

	public int getDiferenciaGoles() {
		return this.diferenciaGoles;
	}

	public int getPuntos() {
		return this.puntos;
	}

}
