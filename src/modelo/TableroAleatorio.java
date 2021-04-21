package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import utiles.Utiles;

public class TableroAleatorio extends Tablero {
	
	private int casillasAlrededor=8;
	//Constructor aleatorio
	public TableroAleatorio(int lado, int minas) {
		super(lado);
		ArrayList<Coordenada> posiciones = generaAleatorio(minas, lado);
		disponerTablero(posiciones);
	}
	
	//constructor no aleatorio
	public TableroAleatorio(int lado,ArrayList<Coordenada> posiciones) {
		super(lado);
		disponerTablero(posiciones);
	}
	private void disponerTablero(ArrayList<Coordenada> posiciones) {
		colocarMinas(posiciones);
		contarMinasAlrededor(posiciones);
	}


	public void contarMinasAlrededor(ArrayList<Coordenada> posiciones) {
		
		for (Coordenada coordenada : posiciones) {

			for (int i = 0; i < casillasAlrededor; i++) {
				int[] posicion = Utiles.damePosicionAlrededor(i);
				int xAuxiliar = coordenada.getPosX() + posicion[0];
				int yAuxiliar = coordenada.getPosY() + posicion[1];
				if (xAuxiliar >= 0 && yAuxiliar >= 0 && xAuxiliar <= getAlto() && yAuxiliar <= getAncho()) {
//					System.out.println("X " +xAuxiliar+ "Y " +yAuxiliar);
					Casilla casilla = getCasilla(new Coordenada(xAuxiliar, yAuxiliar));
					if (!casilla.isMina()) {
						
						casilla.setMinasAlrededor(casilla.getMinasAlrededor() + 1);
					}
				}

			}

		}
	}

	private void colocarMinas(ArrayList<Coordenada> posiciones) {
		for (Coordenada coordenada : posiciones) {
			ponerMina(coordenada);
		}
	}

	private void ponerMina(Coordenada coordenada) {
		getCasilla(coordenada).setMina(true);
	}

	public ArrayList<Coordenada> generaAleatorio(int minas, int longitud) {
		assert minas > 0 && longitud > 0;
		assert minas < longitud * longitud;
//		long inicio = System.currentTimeMillis();
		ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();
		for (int i = 0; i < minas; i++) {
			Coordenada coord;
			do {
				coord = dameCoordenada(longitud);
			} while (existeCoord(coord, coordenadas));
			coordenadas.add(coord);
		}
//		 long fin = System.currentTimeMillis();
//		 System.out.println("en milis "+(fin-inicio));
		return coordenadas;

	}

	private Coordenada dameCoordenada(int lado) {
		return new Coordenada(Utiles.dameNumero(lado), Utiles.dameNumero(lado));
	}

	private boolean existeCoord(Coordenada coord, ArrayList<Coordenada> coordenadas) {
		for (int i = 0; i < coordenadas.size(); i++) {
			if (coord.equals(coordenadas.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	private void desvelarCasilla (Coordenada coordenada) {
		
		if (getCasilla(coordenada).isVelada()) {
			getCasilla(coordenada).setVelada(false);
			
			if(!getCasilla(coordenada).isMina() || getCasilla(coordenada).getMinasAlrededor()>0) {
				for (int i = 0; i < casillasAlrededor; i++) {
					int posicionVector[]= Utiles.damePosicionAlrededor(i);
					Coordenada coordenadaV = new Coordenada(posicionVector);
					
					 desvelarCasilla(coordenadaV);
					
					}
				}
			}
			
		}
	
	

	
}
