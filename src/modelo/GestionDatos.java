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
		float resultado = (dificultad * dificultad)*(densidad/ 100f);
		
		return (int) resultado;

	}
	
	public RespuestaColocacion isMina(Coordenada coordenada) {
        RespuestaColocacion respuesta= new RespuestaColocacion();
        if (this.tablero.getCasilla(coordenada).isMina()) {
             respuesta= new RespuestaColocacion(true, "X");
        }
        return respuesta;
    }
	
	public RespuestaColocacion isMarcada(Coordenada coordenada) {
		RespuestaColocacion respuesta = new RespuestaColocacion();
		
	if(this.tablero.getCasilla(coordenada).isVelada()){
		
		if(this.tablero.getCasilla(coordenada).isMarcada()){
			this.tablero.getCasilla(coordenada).setMarcada(false);
			respuesta = new RespuestaColocacion(true, "", coordenada);
			this.tablero.contarMarcadasAlrededor(coordenada, -1);
			
		}else {
			this.tablero.getCasilla(coordenada).setMarcada(true);
			respuesta = new RespuestaColocacion(true, "M", coordenada);
			this.tablero.contarMarcadasAlrededor(coordenada, 1);
		}
		
	}else {
		respuesta = new RespuestaColocacion(true, String.valueOf(this.tablero.getCasilla(coordenada).getMinasAlrededor()), coordenada);
	}
	
		return respuesta;
	}
	
	
	
	public ArrayList<RespuestaColocacion> realizarJugada(Coordenada coordenada) {
		ArrayList<RespuestaColocacion> arrayRespuestas= new ArrayList<>();
		
		if(this.tablero.getCasilla(coordenada).isMina()) {
			arrayRespuestas.add(new RespuestaColocacion(true,"X", coordenada));
		} else {
			this.tablero.desvelarCasillas(coordenada);
			for (int i = 0; i < this.tablero.getAlto(); i++) {
				for (int j = 0; j < this.tablero.getAncho(); j++) {
					Coordenada auxiliar = new Coordenada(i, j);
					Casilla casilla = this.tablero.getCasilla(auxiliar);
					if(!casilla.isMina() && !casilla.isVelada()) {
						arrayRespuestas.add(new RespuestaColocacion(true, String.valueOf(casilla.getMinasAlrededor()) , auxiliar));
					}
				}
			}
		}
		
		return arrayRespuestas;
	}

	
}
