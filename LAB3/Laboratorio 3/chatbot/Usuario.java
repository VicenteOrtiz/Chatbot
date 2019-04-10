
/**
 * La clase usuario es la contiene la informaci�n relevante de la persona que utiliza el programa.
 * 
 * @version 1.0
 * @since 1.0
 *
 */

public class Usuario {
	
	private String nombre;
	private String ID;
	
	/**
	 * 
	 * @param name corresponde a un String que almacena el nombre del usuario
	 */
	public void set_nombre(String name) {
		nombre = name;
	}
	
	/**
	 * 
	 * @param id corresponde a un String que almacena el ID del usuario
	 */
	
	public void set_ID(String id) {
		ID = id;
	}
	
	/**
	 * 
	 * 
	 * @return este m�todo retorna el nombre como tipo de dato String.
	 */
	public String get_Nombre() {
		return nombre;
	}
	
	
	/**
	 * 
	 * 
	 * @return este m�todo retorna el ID como tipo de dato String.
	 */
	public String get_ID() {
		return ID;
	}

}
