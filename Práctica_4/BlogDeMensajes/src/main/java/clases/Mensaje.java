package clases;

public class Mensaje {
	private String contenido;
	private int idpersona;
	
	public Mensaje(String c, int idp) {
		this.setContenido(c);
		this.setIdpersona(idp);
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
}
