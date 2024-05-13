package coches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.annotation.*;
@XmlRootElement(name="transmision")
@XmlType(propOrder = {"tipo", "velocidad"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Transmision {
	private static Scanner scanner = new Scanner(System.in);
	//@XmlElement(name = "tipo")
	private String tipo;
	@XmlElement(name = "velocidades")
	private Integer velocidad;
	public Transmision(){;
	}
	
	public Transmision(String tipo,Integer velocidad){
		this.tipo = tipo;
		this.velocidad = velocidad;
	}
	
	public Transmision(int numero) {
		if (numero == 1) {
			this.tipo = crearTipo();
	        this.velocidad = crearVelocidad(); 
	        //scanner.close();
	        //Si cierro un scanner de cualquier tipo, parece cerrar todos.
		}
	}
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}
	
	public String crearTipo() {
		try {
			System.out.println("Elige el tipo de la transmision que desees de entre las siguientes");
			ArrayList<String> tipostransmision = new ArrayList<String>(Arrays.asList("manual", "automática"));
	    	for (int i = 0; i < tipostransmision.size(); i++) {
	    		System.out.println((i+1) + ". " + tipostransmision.get(i));
	    	}
	    	int numero = scanner.nextInt();
	    	scanner.nextLine();
	    	String tipotransmision = tipostransmision.get(numero-1);
	    	return tipotransmision;
		} catch (InputMismatchException | IndexOutOfBoundsException e) {
			System.out.println("Debes usar números enteros y que esten dentro de las opciones");
			return crearTipo();
		}
	}
	
	public Integer crearVelocidad() {
			try {
            System.out.println("Elige la velocidad de la transmision que desees");
            int velocidad = scanner.nextInt();
            scanner.nextLine();
            return velocidad;
        } catch (InputMismatchException e) {
            System.out.println("Debes usar números enteros");
            return crearVelocidad();}
	}
}