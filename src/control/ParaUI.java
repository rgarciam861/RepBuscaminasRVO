package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;

	public ParaUI() {
		super();
		controlador = new Controlador();

		// leyes de demeter
		// para solucionar esto es crear metodos delegados
//		jPanelOpciones.btnIniciar.addActionListener(l);
		getBtnIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();

				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();

				controlador.crearTablero(densidad, dificultad);
				addBotonera(dificultad.getLongitud());
				System.out.println();
//				
			}
		});
	}

	private void asociarBotones() {
		for (int i = 0; i < this.botonera.getAlto(); i++) {
			for (int j = 0; j < this.botonera.getAncho(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				botonera.getButton(coordenada).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// lo primero es llamar a control para que cambie el estado del tablero
						JButton boton = (JButton) e.getSource();
						Coordenada coordenada2 = botonera.getCoordenada(boton);
//						controlador.realizarJugada(coordenada2);
					}
				});
				;
			}
		}
	}

}
