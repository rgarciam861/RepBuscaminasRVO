package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//github.com/vcanor01/RepBuscaminasRVO.git

import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import utiles.RespuestaColocacion;
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;

	private boolean jugar = true;

	public ParaUI() {
		super();
		controlador = new Controlador();
		this.jugar=true;

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
				asociarBotones();
			}
		});
		// leyes de demeter
		// para solucionar esto es crear metodos delegados
//		jPanelOpciones.btnIniciar.addActionListener(l);
	}
	private void asociarBotones() {
		for (int i = 0; i < this.botonera.getAlto(); i++) {
			for (int j = 0; j < this.botonera.getAncho(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				botonera.getButton(coordenada).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// lo primero es llamar a control para que cambie el estado del tablero

						super.mouseClicked(e);
						if (e.getButton() == 1) {
//                            System.out.println("boton izquierdo");
							if (jugar) {
								JButton boton = (JButton) e.getSource();
								Coordenada coordenada2 = botonera.getCoordenada(boton);
								realizarJugada(coordenada2);

								if (controlador.isMina(coordenada2).isRespuesta()) {
									boton.setText(controlador.isMina(coordenada2).getMensaje());
									jugar = false;
								}
							}
						}
						if (e.getButton() == 3) {
							JButton boton = (JButton) e.getSource();
							Coordenada coordenada2 = botonera.getCoordenada(boton);
							boton.setText(controlador.isMarcada(coordenada2).getMensaje());
						}
					}
				});
			}
		}
	}
	private void realizarJugada(Coordenada coordenada) {
		ArrayList<RespuestaColocacion> arrayRespuestasColocacion = controlador.realizarJugada(coordenada);
		for (RespuestaColocacion respuestaColocacion : arrayRespuestasColocacion) {
			botonera.getButton(respuestaColocacion.getCoordenada()).setText(respuestaColocacion.getMensaje());
		}
		;
	};

}
