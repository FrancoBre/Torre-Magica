package juego;

import entorno.Entorno;

public class Plataforma {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	Entorno entorno;
	

	Plataforma(double x, double y, double ancho, double alto, Entorno entorno){
		setX(x);
		setY(y);
		setAncho(ancho);
		setAlto(alto);
		setEntorno(entorno);
		
	}

//	public void dibujarPlataforma(){
//		entorno.dibujarRectangulo(x, y, ancho, alto, 0, java.awt. Color.BLUE);
//	}
	
	public double getSuperficie(){
		return this.y-(this.alto/2);
	}
	
	public double getLadoIzq() {
		return this.x-(this.ancho/2);
	}
	
	public double getLadoDer() {
		return this.x+(this.ancho/2);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}
	
	
}
