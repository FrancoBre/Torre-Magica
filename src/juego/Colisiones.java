package juego;

public class Colisiones {

	public static boolean ColisionPersonajePlataforma(Personaje personaje, Plataforma[] plataformas) {
		boolean aux=false;
		for(int i=0;i<plataformas.length;i++) { 
			if(personaje.getBase()==plataformas[i].getSuperficie() && personaje.getLadoIzq()<=plataformas[i].getLadoDer()
			&& personaje.getLadoDer()>=plataformas[i].getLadoIzq()) {
				aux=true;
				break;
			}
		}
		return aux;
	}
	
	public static boolean Caer(Personaje personaje, Plataforma[] plataformas){	
		if(!Colisiones.ColisionPersonajePlataforma(personaje, plataformas)  && personaje.getX()<700 && personaje.getX()>0) {	
			personaje.setY(personaje.getY()+1);
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean ColisionPersonajePersonaje(Personaje personaje, Personaje enemigo) {
		boolean aux=false;
			if((personaje.getLadoIzq()<=enemigo.getLadoDer() && personaje.getLadoDer()>=enemigo.getLadoIzq())
			&& (personaje.getBase()>=enemigo.getSupercifie() && personaje.getSupercifie()<=enemigo.getBase())) {
				aux=true;
			}
			return aux;
	}
	
	public static boolean ColisionHechizoPersonaje(Personaje enemigo,Hechizo hechizo) {
		boolean aux=false;
		if((hechizo.getLadoIzq()<=enemigo.getLadoDer() && hechizo.getLadoDer()>=enemigo.getLadoIzq())
		&& (hechizo.getBase()>=enemigo.getSupercifie() && hechizo.getSupercifie()<=enemigo.getBase())) {
				aux=true;
			}
		return aux;
	} 
	
	public static void noSuperposicion(Personaje enemigo1, Personaje enemigo2) {
		if (ColisionPersonajePersonaje(enemigo1, enemigo2) && enemigo1.getLado()==enemigo2.getLado() && !enemigo1.equals(enemigo2)) {
			enemigo1.setLadoManual(1);
			enemigo2.setLadoManual(2);
		}
	}
	
}