package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import modelo.Coordenada;
import modelo.Densidad;
import modelo.Dificultad;
import modelo.TableroAleatorio;
import vista.UI;

public class ParaUI extends UI {

	private Controlador controlador;
	boolean jugar;

	public ParaUI() {
		super();
		controlador = new Controlador();
		this.jugar=true;

		// leyes de demeter
		// para solucionar esto es crear metodos delegados
//		jPanelOpciones.btnIniciar.addActionListener(l);
		getBtnIniciar().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Densidad densidad = (Densidad) getCmbDensidad().getSelectedItem();
				
				Dificultad dificultad = (Dificultad) getCmbDificultad().getSelectedItem();
				
				controlador.crearTablero(densidad, dificultad);
				addBotonera(dificultad.getLongitud());
				asociarBotones();
				
				
				
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
						if (jugar) {
							
							JButton boton = (JButton) e.getSource();
							Coordenada coordenada2 = botonera.getCoordenada(boton);
							boton.setText(controlador.realizarJugada(coordenada2).getMensaje());
							if (controlador.isMina(coordenada2).isRespuesta()) {
								boton.setText(controlador.isMina(coordenada2).getMensaje());
								jugar=false;
							}
						}
						
						
						
					}
				});
				;
			}
		}
	}

}
