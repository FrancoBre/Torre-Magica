package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Personaje personaje;
	private Plataforma [] plataformas= new Plataforma [9];
	private Personaje [] enemigos = new Personaje [4] ; 
	private Hechizo [] hechizos = new Hechizo [3]; 
	private int indice;
	private Image fondo;
	// Variables y métodos propios de 
	
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		int anchopantalla=700;
		int altopantalla=900;
		
		int anchoPersonaje=50;
		int altoPersonaje=50;
		int xPersonaje=anchopantalla/2;
		int yPersonaje=130;
		
		fondo= Herramientas.cargarImagen("./juego/fondo-2.png");
		
		this.entorno = new Entorno(this, "Escapa de los pro vida", anchopantalla, altopantalla);
		
		// Inicializar lo que haga falta para el juego
		// ...
		
		plataformas[0]= new Plataforma(100,25,200,50,entorno);
		plataformas[1]= new Plataforma(610,25,200,50,entorno);
		plataformas[2]= new Plataforma(350,180,400,50,entorno);
		plataformas[3]= new Plataforma(100,360,250,50,entorno);
		plataformas[4]= new Plataforma(610,360,250,50,entorno);
		plataformas[5]= new Plataforma(350,540,300,50,entorno);
		plataformas[6]= new Plataforma(350,720,400,50,entorno);
		plataformas[7]= new Plataforma(100,886,200,50,entorno);
		plataformas[8]= new Plataforma(610,886,200,50,entorno);
		
		enemigos [0]= new Personaje (40,40,200,310, entorno,Color.CYAN,null,plataformas);
		enemigos [1]= new Personaje (40,40,575,310, entorno,Color.CYAN,null,plataformas);
		enemigos [2]= new Personaje (40,40,320,490, entorno,Color.CYAN,null,plataformas);
		enemigos [3]= new Personaje (40,40,380,490, entorno,Color.CYAN,null,plataformas);
		
		hechizos[0]= new Hechizo(20, 10, entorno,900,50,personaje);
		hechizos[1]= new Hechizo(20, 10, entorno,900,50,personaje);
		hechizos[2]= new Hechizo(20, 10, entorno,900,50,personaje);

		indice=0;
		personaje= new Personaje(altoPersonaje, anchoPersonaje, xPersonaje, yPersonaje,entorno,Color.GREEN,hechizos[indice],plataformas);
			
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		personaje.dibujarPersonaje();
		entorno.dibujarImagen(fondo, 350, 450, 0, 1);
		personaje.dibujarCongelado();
		
		for(int i=0;i<enemigos.length;i++) {
			enemigos[i].dibujarPersonaje();
		}
		
		if(!Colisiones.Caer(personaje, plataformas)){
			personaje.moverIzq(entorno.estaPresionada(entorno.TECLA_IZQUIERDA));
			personaje.moverDer(entorno.estaPresionada(entorno.TECLA_DERECHA));	
		}
		
		personaje.tocaBordes();
		
		personaje.TP();
		
		personaje.setAngulo();
		
		for(int i=0;i<enemigos.length;i++){	
			for(int j=0;j<hechizos.length;j++) {
				if (Colisiones.ColisionHechizoPersonaje(enemigos[i], hechizos[j])) {	//se fija si algun hechizo colisiona con un monstruo
					enemigos[i].setTimer(300);			//inicializa el timer para que el hechizo deje de hacer efecto
					hechizos[j].setActivado(false);
					}
				}
			if (Colisiones.ColisionPersonajePersonaje(personaje,enemigos[i])&& enemigos[i].congelado()) { //si el personaje colisiona con un enemigo congelado
				enemigos[i].setMuerto();				//el enemigo congelado muere (queda paralizado por mucho tiempo)
				if(personaje.getX()<enemigos[i].getX()) {			
					enemigos[i].setLadoManual(1);			//si personaje esta a la izq lo empuja a la derecha
				}
				if(personaje.getX()>enemigos[i].getX()) {	
					enemigos[i].setLadoManual(2);			//si personaje esta a la der lo empuja a la izquierda
				}
			}

			enemigos[i].decrementarTimer();			//con cada repeticion del ciclo y el tick, el tiempo pasa
			
			personaje.muertePersonaje(enemigos[i]);		//se fija si un monstruo te mata	
			
			Colisiones.Caer(enemigos[i], plataformas);		//permite que los monstruos caigan
			
			enemigos[i].TP();			//permite que los monstruos vuelvan a aparecer arriba

			if ((enemigos[i].getTimer()==0  && !Colisiones.Caer(enemigos[i], plataformas)) ||
			(enemigos[i].getMuerto() && !Colisiones.Caer(enemigos[i], plataformas))) {	
				enemigos[i].movEnemigo();		//cuando el timer llega a 0, o el monstruo muere, el monstruo vuelve a moverse
			}
				
			for (int j=0;j<enemigos.length;j++) {
				if (!enemigos[i].equals(enemigos[j])) {
					if (enemigos[i].getMuerto() && Colisiones.ColisionPersonajePersonaje(enemigos[i],enemigos[j])) { //si un enemigo muerto toca a uno vivo, lo mata
						enemigos[j].setMuerto();
						if(enemigos[i].getX()<enemigos[j].getX()) {			
							enemigos[j].setLadoManual(1);			
						}
						if(enemigos[i].getX()>enemigos[j].getX()) {	
							enemigos[j].setLadoManual(2);									
							}
					}
					if ((!enemigos[i].getMuerto() && !enemigos[j].getMuerto())|| (enemigos[i].getMuerto() && enemigos[j].getMuerto())) {
						Colisiones.noSuperposicion(enemigos[i], enemigos[j]);	//analiza que 2 monstruos no se superpongan infinitamente (si estan los 2 vivos o los 2 muertos)
					}	
				}
			}
			
						
		}
	
		if (hechizos[indice].getActivado()) {
			if (indice<3) {
				indice++;
			}
			if (indice==3) {
				indice=0;
			}
		}

		personaje.setHechizo(hechizos[indice]);

		
		personaje.setDisparo(true);			//	Se ejecuta Colisiones.Caer(personaje, plataformas); lo que permite que el personaje caiga
											//  ademas de la a activacion e independizacion del disparo, pasando al proximo de la lista
		for (int i=0;i<hechizos.length;i++) {
			if(hechizos[i].getActivado()) {
				hechizos[i].dibujarHechizo();
				if(hechizos[i].getX()>700 || hechizos[i].getX()<0) {
					hechizos[i].setActivado(false);		
				}
			}
			else {
				hechizos[i].setX(personaje.getX());
				hechizos[i].setY(personaje.getY());
			}
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
