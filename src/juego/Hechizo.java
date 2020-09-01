package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Hechizo {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Entorno entorno;
	private Personaje personaje; 
	private char lado; 
	private boolean activado;
	private Image hechizoDer, hechizoIzq;
	
	Hechizo (int ancho, int alto,Entorno entorno,int x, int y,Personaje personaje){
		setX(x);
		setY(y);
		setAncho(ancho);
		setAlto(alto);
		setEntorno(entorno);
		setPersonaje(personaje);
		hechizoDer= Herramientas.cargarImagen("./juego/hechizo-der.png");
		hechizoIzq= Herramientas.cargarImagen("./juego/hechizo-izq.png");
	}
	
	public void setActivado(boolean activado) {
		if (this.lado=='D' || this.lado=='I') {
			this.activado=activado;
		}
		
	}
	
	public boolean getActivado() {
		return activado;
	}
	
	public void setLado(char lado) {
		this.lado=lado;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int getLado() {
		return lado;
	}
	
	public int getSupercifie(){
		return this.y-(this.alto/2);
	}
	
	public int getBase(){
		return this.y+(this.alto/2);
	}
	
	public int getLadoIzq() {
		return this.x-(this.ancho/2);
	}
	
	public int getLadoDer() {
		return this.x+(this.ancho/2);
	}
	
	public void setPersonaje(Personaje personaje) {
		this.personaje=personaje;
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public Entorno getEntorno() {
		return entorno;
	}
	
	private void setEntorno(Entorno entorno) {
		this.entorno=entorno;	
	}

	public void setAlto(int alto) {
		this.alto=alto;		
	}

	public void setAncho(int ancho) {
		this.ancho=ancho;
	}

	public void setY(int y) {
		this.y=y;
	}
	
	public void setX(int x) {
		this.x = x;	
	}
	
	public void dibujarHechizo(){
		if(this.lado=='D') {
			entorno.dibujarImagen(hechizoDer, this.x, this.y, 0, 0.5);
			movimientoHechizo();
		}
		if(this.lado=='I') {
			entorno.dibujarImagen(hechizoIzq, this.x, this.y, 0, 0.5);
			movimientoHechizo();
		}
	}
	
	public void movimientoHechizo() {
		if (this.lado=='D') {
			this.x+=4;
		}
		else if (this.lado=='I') {
			this.x-=4;
		}
	}

}
