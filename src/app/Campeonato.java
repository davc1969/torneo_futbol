package app;

import modelos.Torneo;

public class Campeonato {

	public static void main(String[] args) {
		Torneo nuevoTorneo = new Torneo();
		nuevoTorneo.crearEquipos();
		nuevoTorneo.creaPartidos();
		nuevoTorneo.mostrarTabla();

	}

}
