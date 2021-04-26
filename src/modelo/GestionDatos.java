package modelo;

import utiles.RespuestaColocacion;

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

	
	
	public RespuestaColocacion realizarJugada(Coordenada coordenada) {
		RespuestaColocacion respuesta= new RespuestaColocacion();
		
		
		int minasAlrededor = this.tablero.getCasilla(coordenada).getMinasAlrededor();
		return respuesta = new RespuestaColocacion(true, String.valueOf(minasAlrededor));
	}

	public RespuestaColocacion isMina(Coordenada coordenada) {
		RespuestaColocacion respuesta= new RespuestaColocacion();
		if (this.tablero.getCasilla(coordenada).isMina()) {
			 respuesta= new RespuestaColocacion(true, "M");
		}
		return respuesta;
	}
}
