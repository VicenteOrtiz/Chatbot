

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Esta clase es la que almacena las palabras que el chatbot es capaz de entender, como tambi�n las respuestas que el chatbot
 * da en funci�n a la entrada que le brinda el usuario. Adem�s almacena la personalidad del chatbot que se le da con seed.
 * 
 * @version 1.0
 * @since 1.0
 */

public class Chatbot {
	
	private String personalidad;
	private String answer;
	private int intPersonalidad = 0;
	
	private Date date = new Date();
	private DateFormat hourdateFormat = new SimpleDateFormat("[dd/MM/yyyy HH:mm:ss] ");
	
	private String[] informacion = {"informacion", "info", "Informacion", "informacion", "informacion?"};
	private String[] Rinformacion = {"Tenemos las siguientes promociones: \\n 3 preservativos x $1.000 \\n 12 preservativos x $3.600 \\n 18 preservativos x $5.400 \\n 36 preservativos x $10.000 \\n Entregamos en estaciones de metro y en Universidad de Santiago",
									 "Estimado, le invito a revisar el fanpage, ya que est� toda la informaci�n publicada ah�.",
									 "Te invito a revisar nuestra maravillosa fanpage de Facebook, que contienen todas nuestras alegres publicaciones, y la maravillosa informacion que requieres"};
	private String[] lugar = {"donde", "donde?", "Donde", "lugar"};
	private String[] Rlugar = {"Entregamos en los siguientes metros: \\n L1: Desde Baquedano a Manquehue. \\n L6: Desde los Leones a �u�oa. \\n L4: Desde Plaza ega�a a Tobalaba \\n Y tambi�n entregamos en USACH y en Plaza �u�oa sin minimo de compras.",
							   "Depende del dia y la hora.",
							   "Podemos coordinar para que el lugar de entrega sea lo m�s optimo para usted."};

	private String[] solicitarCompra = {"comprar", "comprar?", "comprar,", "pedido", "pedido?", "pedido,"};
	private String[] RsolicitarCompra = {"Perfecto, cuantos necesitas?",
							             "Ya.",
							             "Me parece estupendo, cuantos vas a adquirir?"};
	

	private String[] precios = {"valores", "valores?", "valores,", "precios", "precios,", "precios?"};
	private String[] Rprecios = {"Tenemos las siguientes promociones: \\n 3 preservativos x $1.000 \\n 12 preservativos x $3.600 \\n 18 preservativos x $5.400 \\n 36 preservativos x $10.000",
			                     "3 x $1.000 \\n 12 x $3.600 \\n 18 x $5.400 \\n 36 x $10.000",
			                     "Precios? tenemos los mejores del mercado. 3 x $1000 ; 12 x $3.600 ; 18 x $5.400 ; 36 x $10.000"};

	
	private String[] confirmarCompra = {"necesito", "encargar", "encargar?"};
	private String[] RCCompra = {"Perfecto, dejeme confirmar si hay stock disponible",
								 "Deja revisar si me quedan.",
								 "Seria tan amable usted de esperarme para revisar si me quedan porfavor"};
	

	private String[] diahora = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
	private String[] Rdiahora = {"Buenisima, ese dia entregamos en Los Leones, �u�oa, Tobalaba y Plaza Ega�a.. cual te acomoda m�s?",
								 "Ya ese d�a entregamos en Los Leones, �u�oa, Tobalaba y Plaza Ega�a.. donde?",
								 "Que hermoso d�a para salir de compras! Ese dia entregamos en los siguientes metros: Los Leones, �u�oa, Tobalaba y Plaza Ega�a"};

	private String[] lugares = {"leones", "�u�oa", "tobalaba", "ega�a"};
	private String[] Rlugares = {"Ya bac�n, te los dejo reservados entonces.. nos vemos!",
			                     "Ya, nos vemos. Chao.",
			                     "No te vas a arrepentir, te los deje apartados.. gracias por comprar!"};

	private String[] hold = {"espero"};
	private String[] Rhold = {"Consulte, y si nos queda stock!, para cuando te gustar�a agendar?",
			                  "Ya, nos queda. Cuando quieres hacer la transaccion?",
			                  "Revise en nuestro maravillosa bodega, y si nos queda.. cuando te gustar�a hacer la compra? (:"};

	private String[] negacion = {"no","No","No,","no,"};
	private String[] Rnegacion = {"Bueno, cualquier cosa no dude en contactarnos nuevamente, que le vaya bien!",
			                      "Ok, adios.",
			                      "Que tengas un maravilloso d�a! Que dios este contigo."};

	/**
	 * 
	 * @param semilla es un entero que entrega el Usuario, y que ayuda a definir la personalidad del chatbot
	 * Este m�todo almacena en el atributo "intPersonalidad" un 1 o un 2, en funcion al resultado que de el Random.
	 */
	
	public void intPerson(int semilla) { 
		
		Random generator = new Random(semilla);	    
	    int aux = generator.nextInt(2) + 1;
		intPersonalidad = aux;
	}
	
	/**
	 * 
	 * @return este m�todo retorna intPersonalidad con tipo de dato int
	 */
	
	public int get_intPerson() {
		return intPersonalidad;
	}
	
	/**
	 * 
	 * @param opcion es un String que ayuda a definir la personalidad del chatbot
	 */
	
	public void set_perso(String opcion) {
		personalidad = opcion;
	}
	
	/**
	 * 
	 * @return este m�todo retorna personalidad como un tipo de dato String
	 */
	
	public String get_perso() {
		return personalidad;
	}
	
	/**
	 * @return este m�todo define el horario de comienzo del flujo conversacional del chatbot y muestra el mensaje inicial.
	 */
	
	public void beginDialog() {
		date = new Date();
		answer = hourdateFormat.format(date) + "Chatbot> Hola! como te puedo ayudar el d�a de hoy?";		
	}
	
	/**
	 * @return este m�todo da el mensaje de despedida del chatbot, adem�s de mostrar la hora de termino de la conversacion.
	 */
	
	public void endDialog() {
		date = new Date();
		answer = hourdateFormat.format(date) + "Chatbot> Gracias por preferir Vo'Confia, hasta pronto! #SexualidadResponsable";
	}
	
	/**
	 * 
	 * Este m�todo es el que se encarga de analizar las palabras de una oraci�n ingresada por el usuario, y ver si alguna de ellas
	 * coinciden con las palabras que el chatbot esta configurado para entender.
	 * 
	 * @param oracion es un arreglo de String que contiene las palabras de la oraci�n que entrego el usuario para conversar con el
	 * chatbot.
	 * 
	 */
	
	public void respuesta(String[] oracion) {
		int largo = oracion.length;
		int aux = 0;
		date = new Date();
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<informacion.length; j++) {
				if(oracion[i].equals(informacion[j])) {
					answer = hourdateFormat.format(date) + "Chatbot> " + Rinformacion[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<lugar.length; j++) {
				if(oracion[i].equals(lugar[j])) {
					//answer = hourdateFormat.format(date) + "Chatbot> Entregamos en la UdeS, y en diferentes estaciones de metro";
					answer = hourdateFormat.format(date) + "Chatbot> " + Rlugar[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<solicitarCompra.length; j++) {
				if(oracion[i].equals(solicitarCompra[j])) {
					//answer = hourdateFormat.format(date) + "Chatbot> Buenisima, cuantos quieres?";
					answer = hourdateFormat.format(date) + "Chatbot> " + RsolicitarCompra[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<precios.length; j++) {
				if(oracion[i].equals(precios[j])) {
					//answer = hourdateFormat.format(date) + "Chatbot> Buenisima, cuantos quieres?";
					answer = hourdateFormat.format(date) + "Chatbot> " + Rprecios[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<confirmarCompra.length; j++) {
				if(oracion[i].equals(confirmarCompra[j])) {
					//answer = hourdateFormat.format(date) + "Chatbot> Buenisima, cuantos quieres?";
					answer = hourdateFormat.format(date) + "Chatbot> " + RCCompra[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<diahora.length; j++) {
				if(oracion[i].equals(diahora[j])) {
					//answer = hourdateFormat.format(date) + "Chatbot> Buenisima, cuantos quieres?";
					answer = hourdateFormat.format(date) + "Chatbot> " + Rdiahora[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<lugares.length; j++) {
				if(oracion[i].equals(lugares[j])) {
					//answer = hourdateFormat.format(date) + "Chatbot> Buenisima, cuantos quieres?";
					answer = hourdateFormat.format(date) + "Chatbot> " + Rlugares[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<hold.length; j++) {
				if(oracion[i].equals(hold[j])) {
					//answer = hourdateFormat.format(date) + "Chatbot> Buenisima, cuantos quieres?";
					answer = hourdateFormat.format(date) + "Chatbot> " + Rhold[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		for(int i=0; i<largo; i++) {
			for(int j=0; j<negacion.length; j++) {
				if(oracion[i].equals(negacion[j])) {
					//answer = hourdateFormat.format(date) + "Chatbot> Buenisima, cuantos quieres?";
					answer = hourdateFormat.format(date) + "Chatbot> " + Rnegacion[intPersonalidad];
					aux = 1;
				}
			}
		}
		
		if(aux == 0) {
			date = new Date();
			answer = hourdateFormat.format(date) + "Chatbot> No te entendi su mensaje.";
		}
			
		
		
		//return "no entendi niuna wea perkinazo y la ctm, tu mama es maraca y era";
		
		
	}
	
	/**
	 * 
	 * @return este m�todo retorna la respuesta que dar� el chatbot en funcion a lo qeu se le ingreso.
	 */
	
	public String dime_respuesta() { //GETTER
		return answer;
	}
	
	

}
