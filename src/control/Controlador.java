package control;

import java.util.ArrayList;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;
import utiles.RespuestaColocacion;

public class Controlador {
	private GestionDatos gestion;

	public Controlador() {
		super();
		this.gestion = new GestionDatos();

	}

	public void crearTablero(Densidad densidad, Dificultad dificultad) {
		this.gestion.crearTablero(densidad.getPorcentaje(), dificultad.getLongitud());
	}

	public ArrayList<RespuestaColocacion> realizarJugada(Coordenada coordenada) {
		return this.gestion.realizarJugada(coordenada);
	}
	
	public RespuestaColocacion isMina(Coordenada coordenada) {
		return this.gestion.isMina(coordenada);
	}
	
	public RespuestaColocacion isMarcada(Coordenada coordenada) {
		return this.gestion.isMarcada(coordenada);
	}
}
