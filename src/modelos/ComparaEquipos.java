package modelos;
import java.util.Comparator;

public class ComparaEquipos implements Comparator<Equipo> {
	@Override
	public int compare(Equipo eq1, Equipo eq2) {
		if(eq1.getPuntos() != eq2.getPuntos()) {
			return Integer.compare(eq1.getPuntos(), eq2.getPuntos());
		} else {
			return Integer.compare(eq1.getGolesFavor(), eq2.getGolesFavor());
		}
	}
};




