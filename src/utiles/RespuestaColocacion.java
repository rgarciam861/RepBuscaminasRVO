package utiles;


public class RespuestaColocacion {
	private boolean respuesta;
	private String mensaje;
	
	
	public RespuestaColocacion() {
		super();
	}

	
	public RespuestaColocacion(boolean respuesta, String mensaje) {
		super();
		this.respuesta = respuesta;
		this.mensaje = mensaje;
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
