package modelo;

public class GestionDatos {
	private TableroAleatorio tablero;

	public GestionDatos() {
		super();
		
		
	}
	
	public void crearTablero(int densidad, int dificultad) {
		int cantidadMinas=calcularPorcentaje(densidad, dificultad);
		
		
		tablero= new TableroAleatorio(dificultad, cantidadMinas);
	}
	
	public int calcularPorcentaje(int densidad, int dificultad) {
		int resultado= dificultad*dificultad/densidad;
		
		return resultado;
	
	}
	public Casilla getCasilla(Coordenada coord) {
		return this.tablero.getCasilla(coord);
	}
}
