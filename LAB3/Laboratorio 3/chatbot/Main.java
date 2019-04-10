//xpackage chatbot;



import java.text.DateFormat;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * La clase Main es la que permite tener una conversación directa con el Chatbot.
 * 
 * @Author Vicente I. Ortiz Arancibia
 * @version 1.0
 * @since 1.0
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		int aux = 0;
		int seed;
		int estadoConversacion = 0;
		Chatbot Chatbot1 = new Chatbot();
		Usuario Usuario1 = new Usuario();
		Mensaje Mensaje1 = new Mensaje();
		
		System.out.println("¡Bienvenido al asistente virtual de Vo'Confia!");
		System.out.println("- Aqui podrás conversar con uno de nuestros ejecutivos para tener información respecto a los preservativos que vendemos");
		System.out.println("- Esperamos tengas una buena experiencia, ¡que tengas un buen día!");
		System.out.println();
		
		while(aux==0) {
			
			Date date = new Date();	
			
			DateFormat id = new SimpleDateFormat("yyyyHHddMMssmm");
			
			DateFormat hourdateFormat = new SimpleDateFormat("[dd/MM/yyyy HH:mm:ss] ");
			System.out.print(hourdateFormat.format(date) + "Usuario> ");
	
			String user_message = hourdateFormat.format(date) + "Usuario> ";
					
			String entradaTeclado = "";
			Scanner entradaEscaner = new Scanner(System.in);
			entradaTeclado = entradaEscaner.nextLine();
			
			String oracionS = entradaTeclado;
			user_message = user_message + entradaTeclado;
			Mensaje1.log.add(user_message);
			
			String[] oracionL = oracionS.split(" ");
				
			
			if(oracionL[0].equals("!beginDialog")) {
				
				if(estadoConversacion == 0) {
					estadoConversacion = 1;
					
					Usuario1.set_ID(id.format(date));
					
					if(oracionL.length == 2) {
						seed = Integer.parseInt(oracionL[1]);
						Chatbot1.intPerson(seed);
						Chatbot1.set_perso(oracionL[1]);
					}else {
						Chatbot1.set_perso("Predeterminada");
					}
					
					System.out.println("[USER ID: " + Usuario1.get_ID() + " | PERSONALIDAD: "+ Chatbot1.get_intPerson() + "]");
					 Mensaje1.log.add("[INICIO DE CHAT]");
					 Mensaje1.log.add("[USER ID: " + Usuario1.get_ID() + "]");
					 Mensaje1.log.add("[PERSONALIDAD: " + Chatbot1.get_intPerson() + "]");
					
					Chatbot1.beginDialog();
					Mensaje1.log.add(Chatbot1.dime_respuesta());
					System.out.println(Chatbot1.dime_respuesta());
				}else {
					System.out.println("Ya hay una conversación en desarrollo. Porfavor finalizar para iniciar una nueva.");
				}
			}else if(oracionL[0].equals("!endDialog")) {
				if(estadoConversacion==1){
					estadoConversacion = 0;
					Chatbot1.endDialog();
					Mensaje1.log.add(Chatbot1.dime_respuesta());
					System.out.println(Chatbot1.dime_respuesta());
				}else{
					System.out.println("No has iniciado una conversacion, porfavor usar comando !beginDialog");
				}
				
			}else if(oracionL[0].equals("!saveLog")) {
				Mensaje1.crearLog();
			}else if(oracionL[0].equals("!loadLog")) {
				Mensaje1.leerLog(oracionL[1]);
			}else if(oracionL[0].equals("exit")) {
				aux = 1;
			}else if(oracionL[0].equals("!rate")) {
				
				Mensaje1.horaRate.add(hourdateFormat.format(date));
				Mensaje1.notasChatbot.add(Integer.parseInt(oracionL[1]));
				Mensaje1.notasUsuario.add(Integer.parseInt(oracionL[2]));
				System.out.println(hourdateFormat.format(date)+"Se han registrado tus notas. Chatbot: " + Integer.parseInt(oracionL[1]) + " Usuario: " + Integer.parseInt(oracionL[2]));
				
			}else if(oracionL[0].equals("!chatbotPerformance")) {
				System.out.print("Las notas del Usuario son: ");
				for(int y = 0; y < Mensaje1.notasUsuario.size(); y++) {
					System.out.print(" " + Mensaje1.notasUsuario.get(y));
				}
				System.out.println();
				System.out.print("Las notas del Chatbot son: ");
				for(int w = 0; w < Mensaje1.notasChatbot.size(); w++) {
					System.out.print(" "+Mensaje1.notasChatbot.get(w));
				}
				System.out.println();
				
				System.out.println("El promedio del usuario es: " + Mensaje1.promedio(Mensaje1.notasUsuario));
				System.out.println("La desviacion estandar del usuario es: " + Mensaje1.desviacionEstandar(Mensaje1.notasUsuario));
				
				System.out.println("El promedio del chatbot es: " + Mensaje1.promedio(Mensaje1.notasChatbot));
				System.out.println("La desviacion estandar del chatbot es: " + Mensaje1.desviacionEstandar(Mensaje1.notasChatbot));
				
			}else {
				if(estadoConversacion==1){
					Chatbot1.respuesta(oracionL);
					Mensaje1.log.add(Chatbot1.dime_respuesta());
					System.out.println(Chatbot1.dime_respuesta());
				}else{
					System.out.println("No se ha iniciado un chatbot, porfavor ingrese comando !beginDialog");
				}
				
			}
			
		}

	}
	

}
