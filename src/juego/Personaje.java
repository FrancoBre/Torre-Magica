package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Personaje {
	private int alto;
	private int ancho;
	private int x;
	private int y;
	private int angulo;
	private int timer;
	private int lado;
	private boolean muerto;
	private boolean cayo;
	private boolean disparo;
	private char direccion;
	private char direccionCaida;
	private Entorno entorno;
	private Color color;
	private Hechizo hechizo;
	private Plataforma[] plataformas;
	private int contDer;
	private int contIzq;
	private int contDerMonstruo;
	private int contIzqMonstruo;
	private Image magoParado, magoCayendo, magoMuerte, magoGano, magoRunDer1, magoRunDer2, magoRunDer3, magoRunDer4, magoRunDer5, magoRunDer6, magoRunDer7, magoRunDer8, magoRunIzq1, magoRunIzq2, magoRunIzq3, magoRunIzq4, magoRunIzq5, magoRunIzq6, magoRunIzq7, magoRunIzq8, monstruo1Der, monstruo2Der, monstruo3Der, monstruo4Der, monstruo1Izq, monstruo2Izq, monstruo3Izq, monstruo4Izq, monstruoCongeladoDer, monstruoCongeladoIzq, magoHechizoDer, magoHechizoIzq, fantasmita; 

	
	Personaje(int alto,int ancho, int x, int y,Entorno entorno,Color color, Hechizo hechizo, Plataforma[] plataformas){
		setAlto(alto); 
		setAncho(ancho); 
		setX(x);
		setY(y);
		setEntorno(entorno);
		setLado();
		setColor(color);
		setAngulo();
		setHechizo(hechizo);
		setPlataformas(plataformas);
		magoParado= Herramientas.cargarImagen("./juego/mago-parado.png");
		magoCayendo= Herramientas.cargarImagen("./juego/mago-cayendo.png");
		magoMuerte= Herramientas.cargarImagen("./juego/mago-muerte.png");
		magoGano= Herramientas.cargarImagen("./juego/mago-gano.png");
		magoRunDer1= Herramientas.cargarImagen("./juego/mago-run-1-der.png");
		magoRunDer2= Herramientas.cargarImagen("./juego/mago-run-2-der.png");
		magoRunDer3= Herramientas.cargarImagen("./juego/mago-run-3-der.png");
		magoRunDer4= Herramientas.cargarImagen("./juego/mago-run-4-der.png");
		magoRunDer5= Herramientas.cargarImagen("./juego/mago-run-5-der.png");
		magoRunDer6= Herramientas.cargarImagen("./juego/mago-run-6-der.png");
		magoRunDer7= Herramientas.cargarImagen("./juego/mago-run-7-der.png");
		magoRunDer8= Herramientas.cargarImagen("./juego/mago-run-8-der.png");
		magoRunIzq1= Herramientas.cargarImagen("./juego/mago-run-1-izq.png");
		magoRunIzq2= Herramientas.cargarImagen("./juego/mago-run-2-der - copia.png");
		magoRunIzq3= Herramientas.cargarImagen("./juego/mago-run-3-izq.png");
		magoRunIzq4= Herramientas.cargarImagen("./juego/mago-run-4-izq.png");
		magoRunIzq5= Herramientas.cargarImagen("./juego/mago-run-5-izq.png");
		magoRunIzq6= Herramientas.cargarImagen("./juego/mago-run-6-izq.png");
		magoRunIzq7= Herramientas.cargarImagen("./juego/mago-run-7-izquierda.png");
		magoRunIzq8= Herramientas.cargarImagen("./juego/mago-run-8-izq.png");
		monstruo1Der= Herramientas.cargarImagen("./juego/monstruo-1-der.png");
		monstruo2Der= Herramientas.cargarImagen("./juego/monstruo-2-der.png");
		monstruo3Der= Herramientas.cargarImagen("./juego/monstruo-3-der.png");
		monstruo4Der= Herramientas.cargarImagen("./juego/monstruo-4-der.png");
		monstruo1Izq= Herramientas.cargarImagen("./juego/monstruo-1-izq.png");
		monstruo2Izq= Herramientas.cargarImagen("./juego/monstruo-2-izq.png");
		monstruo3Izq= Herramientas.cargarImagen("./juego/monstruo-3-izq.png");
		monstruo4Izq= Herramientas.cargarImagen("./juego/monstruo-4-izq.png");
		monstruoCongeladoDer= Herramientas.cargarImagen("./juego/monstruo-congelado-der.png");
		monstruoCongeladoIzq= Herramientas.cargarImagen("./juego/monstruo-congelado-izq.png");
		magoHechizoDer= Herramientas.cargarImagen("./juego/mago-hechizo-der.png");
		magoHechizoIzq= Herramientas.cargarImagen("./juego/mago-hechizo-izq.png");
		fantasmita= Herramientas.cargarImagen("./juego/fantasmita.png");
	}
	
	public void setHechizo(Hechizo hechizo) {
		this.hechizo=hechizo;
	}
	
	public void setPlataformas(Plataforma[] plataformas) {
		this.plataformas=plataformas;
	}
	
	public Hechizo getHechizo() {
		return this.hechizo;
	}
	
	public void setTimer(int timer) {
		this.timer=timer;
	}
	
	public int getTimer() {
		return timer;
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
	
	public int getAlto() {
		return alto;
	}
	
	public Entorno getEntorno() {
		return entorno;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getX() {	
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLado(){
		return lado; 
	}
	
	public void setEntorno(Entorno entorno) {
		this.entorno=entorno;
	}
	
	public void setAlto(int alto) {
		if (alto<0){
			throw new RuntimeException("alto invalido");
		}
		else{
			this.alto = alto;
		}
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public void setAncho(int ancho) {
		if (ancho<0){
			throw new RuntimeException("ancho invalido");
		}
		else{
			this.ancho = ancho;
		}
	}
	
	public void setX(int x) {
		if(x>700 || x<0){
			throw new RuntimeException("El personaje se sale de pantalla");
		}
		else{
			this.x = x;
		}
	}
	
	public void setY(int y) {
		if(y>900 || y<0){
			throw new RuntimeException("El personaje se sale de pantalla");
		}
		else{
			this.y = y;
		}
	}
	
	public void setLado() {
		if(!this.muerto) {
			this.lado= (int)  Math.floor(Math.random()* 2+1);	
		}
	}
		
	public void setLadoManual(int valor) {
		this.lado=valor;
	}
	
	public void setAngulo(){
		this.setDireccion();
		if (this.direccion=='D'){
			this.angulo=5;
		}
		else if(this.direccion=='I') {
			this.angulo=-5;
		}
		else {
			this.angulo=0;
		}
	}
	
	public void decrementarTimer() {
		if (this.timer>0) {
			this.timer--;
		}
	}
	
	public void tocaBordes(){
		if(this.x>=675){
			this.x=675;
		}
		if (this.x<=25){
			this.x=25;
		}
	}
	
	
	public void TP(){
		if(this.y>=898) {
			if (!this.muerto) {
				this.y=0;
			}
			else {
				this.lado=0;
				this.x=-50;
			}
		}
	}
	
	public void setDireccion() {
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)&&(entorno.estaPresionada(entorno.TECLA_DERECHA))) {
			this.direccion='C';
		}
		else if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			this.direccion='I';
		}
		else if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			this.direccion='D';
		}
		else {
			this.direccion='C';
		}
	}
	
	public void setDireccionCaida() {
		if (this.cayo && Colisiones.ColisionPersonajePlataforma(this, plataformas)) {
			this.direccionCaida=this.direccion;
		}
	}
	
	public char getDireccionCaida() {
		return this.direccionCaida;
	}

	public void setDisparo(boolean disparo) {
		this.setDireccionCaida();
		this.setCayo();
		if (!disparo) {
			this.disparo=false;
		}
		if (this.cayo && Colisiones.ColisionPersonajePlataforma(this, this.plataformas)&&disparo) {
			this.cayo=false;
			this.disparo=true;
			hechizo.setLado(this.direccionCaida);
			hechizo.setActivado(true);
			if(this.direccion=='D')	{
				entorno.dibujarImagen(magoHechizoDer, x, y, 0, 1.3);
			}
			if(this.direccion=='I') {
				entorno.dibujarImagen(magoHechizoIzq, x, y, 0, 1.3);
			}
		}
	}
	
	public boolean getDisparo() {
		return this.disparo;
	}
	
	public void movEnemigo(){	
		if (lado==1){
			this.x++;
			if (this.x>=688){
				lado=2; 
			}
			contDerMonstruo++;
			if(congelado()) {
				entorno.dibujarImagen(fantasmita, x, y, 0, 1.8);
			}
		}
		else {
			if (lado==2){
				this.x--;
				if (this.x<=20){
					lado=1; 
				}
			contIzqMonstruo++;
				if(congelado()) {
					entorno.dibujarImagen(fantasmita, x, y, 0, 1.8);
				}
			}
		}
	}
	
	public void muertePersonaje(Personaje enemigo) {
	if (Colisiones.ColisionPersonajePersonaje(this, enemigo) && (!enemigo.congelado()||!enemigo.muerto)) {
			this.color=Color.red;
		}
	}
	
	public void setMuerto() {
		this.timer=200000;
		this.muerto=true;
		this.color=Color.ORANGE;
	}
	
	public boolean getMuerto() {
		return this.muerto;
	}
	
	public boolean congelado() {
		if (this.timer>0) {
			entorno.dibujarImagen(monstruoCongeladoDer, x, y, 0, 1.3);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void dibujarPersonaje(){
			if(this.lado==1 && !congelado()) {
			if(contDerMonstruo==1 || contDerMonstruo==2 || contDerMonstruo==3) {
				entorno.dibujarImagen(monstruo2Der, x, y, 0, 1.3);
			}
			if(contDerMonstruo==4 || contDerMonstruo==5 || contDerMonstruo==6) {
				entorno.dibujarImagen(monstruo2Der, x, y, 0, 1.3);
			}
			if(contDerMonstruo==7 || contDerMonstruo==8 || contDerMonstruo==9) {
				entorno.dibujarImagen(monstruo3Der, x, y, 0, 1.3);
			}
			if(contDerMonstruo==10 || contDerMonstruo==11 || contDerMonstruo==12) {
				entorno.dibujarImagen(monstruo4Der, x, y, angulo, 1.3);
				contDerMonstruo=1;
			}
		}
		if(this.lado==2 && !congelado()) {
			if(contIzqMonstruo==1 || contIzqMonstruo==2 || contIzqMonstruo==3) {
				entorno.dibujarImagen(monstruo2Izq, x, y, 0, 1.3);
			}
			if(contIzqMonstruo==4 || contIzqMonstruo==5 || contIzqMonstruo==6) {
				entorno.dibujarImagen(monstruo3Izq, x, y, 0, 1.3);
			}
			if(contIzqMonstruo==7 || contIzqMonstruo==8 || contIzqMonstruo==9) {
				entorno.dibujarImagen(monstruo4Izq, x, y, 0, 1.3);
				contIzqMonstruo=1;
			}
		}			
	}

	public void moverIzq(boolean izquierda){
		if(contDer==0) {
			entorno.dibujarImagen(magoParado, x, y, 0, 1.3);
		}
		if(izquierda){
			this.x-=3;
		}
		if(izquierda) {	
			contIzq++;
			if(contIzq==2 || contIzq==3) {
				entorno.dibujarImagen(magoRunIzq1, x, y, 0, 1.3);
			}
			if(contIzq==4 || contIzq==5) {
				entorno.dibujarImagen(magoRunIzq2, x, y, 0, 1.3);
			}
			if(contIzq==6 || contIzq==7) {
				entorno.dibujarImagen(magoRunIzq3, x, y, 0, 1.3);
			}
			if(contIzq==8 || contIzq==9) {
				entorno.dibujarImagen(magoRunIzq4, x, y, 0, 1.3);
			}
			if(contIzq==10 || contIzq==11) {
				entorno.dibujarImagen(magoRunIzq5, x, y, 0, 1.3);
			}
			if(contIzq==12 || contIzq==13) {
				entorno.dibujarImagen(magoRunIzq6, x, y, 0, 1.3);
			}
			if(contIzq==14 || contIzq==15) {
			entorno.dibujarImagen(magoRunIzq7, x, y, 0, 1.3);
			}
			if(contIzq==16) {
				entorno.dibujarImagen(magoRunIzq8, x, y, 0, 1.3);
				contIzq=2;
			}
		}
	}
		
		
		
	public void moverDer(boolean derecha){
		if(contDer==0) {
			entorno.dibujarImagen(magoParado, x, y, 0, 1.3);
			}
		if(derecha){
			this.x+=3;
		}
		if(derecha) {
			contDer++;
				
			if(contDer==2 || contDer==3) {
				entorno.dibujarImagen(magoRunDer1, x, y, 0, 1.3);
			}
			if(contDer==4 || contDer==5) {
				entorno.dibujarImagen(magoRunDer2, x, y, 0, 1.3);
			}
			if(contDer==6 || contDer==7) {
				entorno.dibujarImagen(magoRunDer3, x, y, 0, 1.3);
			}
			if(contDer==8 || contDer==9) {
				entorno.dibujarImagen(magoRunDer4, x, y, 0, 1.3);
			}
			if(contDer==10 || contDer==11) {
				entorno.dibujarImagen(magoRunDer5, x, y, 0, 1.3);
			}
			if(contDer==12 || contDer==13) {
				entorno.dibujarImagen(magoRunDer6, x, y, 0, 1.3);
			}
			if(contDer==14 || contDer==15) {
				entorno.dibujarImagen(magoRunDer7, x, y, 0, 1.3);
			}
			if(contDer==16) {
				entorno.dibujarImagen(magoRunDer8, x, y, 0, 1.3);
				contDer=1;
				}
		}
		if(this.direccion=='C') {
			entorno.dibujarImagen(magoParado, x, y, 0, 1.3);
			
		}
	}

	public void dibujarCongelado() {
		if(congelado() && this.direccion=='D') {
			entorno.dibujarImagen(monstruoCongeladoDer, x, y, 0, 1.3);
		}
		if(congelado() && this.direccion=='I') {
			entorno.dibujarImagen(monstruoCongeladoIzq, x, y, 0, 1.3);
		}
	}

	public void setCayo(){
		if (Colisiones.Caer(this, plataformas)) {
			this.cayo=true;
			entorno.dibujarImagen(magoCayendo, x, y, 0, 1.3);
		}
	}
}
