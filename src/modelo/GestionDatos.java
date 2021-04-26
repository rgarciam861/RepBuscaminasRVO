package modelo;

import java.util.ArrayList;

import utiles.RespuestaColocacion;
import utiles.Utiles;

public class GestionDatos {
	private TableroAleatorio tablero;

	public GestionDatos() {
		super();

	}

	public void crearTablero(int densidad, int dificultad) {
		int cantidadMinas = calcularPorcentaje(densidad, dificultad);

		tablero = new TableroAleatorio(dificultad, cantidadMinas);
		
		
	}

	public int calcularPorcentaje(int densidad, int dificultad) {
		int resultado = dificultad * dificultad / densidad;

		return resultado;

	}
	
	public RespuestaColocacion isMina(Coordenada coordenada) {
		RespuestaColocacion respuesta= new RespuestaColocacion();
		if (this.tablero.getCasilla(coordenada).isMina()) {
			 respuesta= new RespuestaColocacion(true, "M",coordenada);
		}
		return respuesta;
	}

	
	
	public ArrayList<RespuestaColocacion> realizarJugada(Coordenada coordenada) {
		ArrayList<RespuestaColocacion> arrayRespuestas= new ArrayList<>();
		
		int minasAlrededor = this.tablero.getCasilla(coordenada).getMinasAlrededor();
		
		if(this.tablero.getCasilla(coordenada).isMina()) {
			arrayRespuestas.add(new RespuestaColocacion(true,"M", coordenada));
		} else {
			ArrayList<RespuestaColocacion> arrayRespuestasDesveladas = this.tablero.desvelarCasillas(coordenada);
			for (RespuestaColocacion respuestaColocacion : arrayRespuestasDesveladas) {
				arrayRespuestas.add(respuestaColocacion);
			}
			arrayRespuestas.add(new RespuestaColocacion(true, String.valueOf(minasAlrededor), coordenada));
		}
		
		return arrayRespuestas;
	}

	public RespuestaColocacion isMina(Coordenada coordenada) {
		RespuestaColocacion respuesta= new RespuestaColocacion();
		if (this.tablero.getCasilla(coordenada).isMina()) {
			 respuesta= new RespuestaColocacion(true, "M");
		}
		return respuesta;
	}
}
