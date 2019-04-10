
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 
 * Esta clase es la que se encarga de crear la estructura log que almacena automaticamente el historial de conversacion, además de
 * crear el archivo de texto en caso de ser requerido por el usuario. Finalmente tambien puede abrir un archivo de texto en caso
 * de ser necesario.
 * 
 * @version 1.0
 * @since 1.0
 *
 */

public class Mensaje {
	
	public ArrayList<String> log = new ArrayList<String>();
	public ArrayList<String> horaRate = new ArrayList<String>();
	public List<Integer> notasUsuario = new ArrayList<>();
	public List<Integer> notasChatbot = new ArrayList<>();
	
	/**
	 * 
	 * @param listaPromedio es una lista de numeros enteros que almacenan las notas dadas por los usuarios con el comando !rate
	 * @return el promedio con tipo de dato double para que puedan haber decimales
	 */
	
	public double promedio(List<Integer> listaPromedio) {
		double auxSuma=0;
		double promedio;
		for(int i = 0; i < listaPromedio.size(); i++) {
			auxSuma= auxSuma + listaPromedio.get(i);
		}
		promedio = auxSuma / listaPromedio.size();
		return promedio;
	}
	
	/**
	 * 
	 * @param listaDesviacion es una lista de numeros enteros que almacenan las notas dadas por el usuario con el comando !rate
	 * @return la desviacion estandar de todas las notas ingresadas como tipo de dato double para que puedan haber decimales.
	 */
	
	public double desviacionEstandar(List<Integer> listaDesviacion) {
		double varianza = 0.0;
		double desviacion = 0.0;
		
		for(int i = 0; i< listaDesviacion.size() ; i++) {
			double rango;
			rango = Math.pow(listaDesviacion.get(i) - promedio(listaDesviacion), 2);
			varianza = varianza + rango;
		}
		
		varianza = varianza / listaDesviacion.size();
		desviacion = Math.sqrt(varianza);
		return desviacion;
		
	}
	
	/**
	 * Este método es el encargado de crear el archivo de texto que almacena el historial de conversacion que ha tenido el usuario
	 * con el chatbot
	 * 
	 */
	
	public void crearLog(){
		
		Date date = new Date();
		DateFormat fileFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
		String fileName = fileFormat.format(date)+ ".log";
		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter(fileName);
			pw = new PrintWriter(fichero);			
			for(int i=0; i<log.size(); i++) {
				pw.println(log.get(i));
			}
			for(int i=0; i<horaRate.size();i++) {
				pw.println(horaRate.get(i) + " Usuario:" + notasUsuario.get(i) + " Chatbot:" + notasChatbot.get(i));
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != fichero) {
					fichero.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}		
	}
	
	/**
	 * 
	 * @param nombreArchivo es un String que contiene el nombre del archivo que el usuario desea abrir.
	 */
	
	public void leerLog(String nombreArchivo) {
		log.clear();
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;	    
	    String fileName = nombreArchivo;
	    try {

	       archivo = new File (fileName);
	       fr = new FileReader (archivo);
	       br = new BufferedReader(fr);
	       String linea;
	       while((linea=br.readLine())!=null) {	    	   
	    	   log.add(linea);
	           System.out.println(linea);    	   
	       }	    	  
	    }
	    catch(Exception e){
	       e.printStackTrace();
	    }finally{
	       try{                    
	          if( null != fr ){   
	             fr.close();     
	          }                  
	       }catch (Exception e2){ 
	          e2.printStackTrace();
	       }
	    }
	}
	
}

