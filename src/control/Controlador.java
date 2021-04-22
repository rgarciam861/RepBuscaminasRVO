package control;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.GestionDatos;
import modelo.TableroAleatorio;
import utiles.RespuestaColocacion;

public class Controlador {
	private GestionDatos gestion;

	public Controlador() {
		super();
		this.gestion= new GestionDatos();
		
	}
	public void crearTablero(Densidad densidad, Dificultad dificultad){
		 this.gestion.crearTablero(densidad.getPorcentaje(), dificultad.getLongitud());
	}
	
	
}
