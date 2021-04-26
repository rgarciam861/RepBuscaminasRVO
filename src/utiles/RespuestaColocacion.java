package utiles;

import modelo.Coordenada;

public class RespuestaColocacion {
	private boolean respuesta;
	private String mensaje;
	private Coordenada coordenada;

	public RespuestaColocacion() {
		super();
	}

	public RespuestaColocacion(boolean respuesta, String mensaje, Coordenada coordenada) {
		super();
		this.respuesta = respuesta;
		this.mensaje = mensaje;
		this.coordenada = coordenada;
	}
	
	public RespuestaColocacion(boolean respuesta, String mensaje) {
		super();
		this.respuesta = respuesta;
		this.mensaje = mensaje;
	}


	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public boolean isRespuesta() {
		return respuesta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
