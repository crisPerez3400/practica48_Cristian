package coches;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.annotation.*;
@XmlRootElement(name="auto")
@XmlType(propOrder = {"identificacion","marca", "modelo", "año", "color", "tipo_motor", "cilindrada", "potencia", "transmision"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Auto {
	private static Scanner scannerauto = new Scanner(System.in);
	@XmlAttribute(name = "id", required = true)
	private String identificacion;
	//@XmlElement(name = "marca")
	private String marca;
	//@XmlElement(name = "modelo")
	private String modelo;
	//@XmlElement(name = "año")
	private Integer año;
	//@XmlElement(name = "color")
	private String color;
	//@XmlElement(name = "tipo_motor")
	private String tipo_motor;
	//@XmlElement(name = "cilindrada")
	private String cilindrada;
	//@XmlElement(name = "potencia")
	private String potencia;
	//@XmlElement(name = "transmision")
	private Transmision transmision;

	
	public Auto(){}
	public Auto(String identificacion,String marca, String modelo, Integer año, 
			String color, String tipo_motor, String cilindrada, String potencia,
			Transmision  transmision){
		this.identificacion = identificacion;
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.color = color;
		this.tipo_motor = tipo_motor;
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.transmision = transmision;
	}
	
	public Auto(Transmision transmision, String identificador) {
		this.transmision = transmision;
		this.identificacion = identificador;
		this.crearMarca();
		this.crearModelo();
		this.crearAño();
		this.crearColor();
		this.crearTipo_motor();
		this.crearCilindrada();
		this.crearPotencia();
	}
	
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTipo_motor() {
		return tipo_motor;
	}
	public void setTipo_motor(String tipo_motor) {
		this.tipo_motor = tipo_motor;
	}
	public String getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}
	public String getPotencia() {
		return potencia;
	}
	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	
	public Transmision getTransmision() {
		return transmision;
	}
	public void setTransmision(Transmision transmision) {
		this.transmision = transmision;
	}
	
	
	public void crearMarca() {
		System.out.println("De que marca es el auto");
		this.marca = scannerauto.nextLine();
	}
	
	public void crearModelo() {
        System.out.println("Que modelo es el auto");
        this.modelo = scannerauto.nextLine();
    }
	
	public void crearAño() {
		try {
		System.out.println("De que año es el auto");
        this.año = scannerauto.nextInt();
        scannerauto.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Debe introducir un numero");
            scannerauto.nextLine();
            this.crearAño();
		};
	}

	public void crearColor() {
        System.out.println("De que color es el auto");
        this.color = scannerauto.nextLine();
    }
	
	public void crearTipo_motor() {
		System.out.println("Que tipo de motor tiene el auto");
        this.tipo_motor = scannerauto.nextLine();;
	}
	
	public void crearCilindrada() {
		System.out.println("De que tipo de cilindrada es el auto");
        this.cilindrada = scannerauto.nextLine();;
	}
	
	public void crearPotencia() {
		System.out.println("Que potencia tiene el auto");
        this.potencia = scannerauto.nextLine();;
	}
	
	
	
	
	
	
	public void imprimirAuto() {
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println("La marca del auto es " + this.marca);
		System.out.println("El modelo del auto es " + this.modelo);
		System.out.println("El año del auto es " + this.año);
		System.out.println("El color del auto es " + this.color);
		System.out.println("El tipo de motor del auto es " + this.tipo_motor);
		System.out.println("La cilindrada del auto es " + this.cilindrada);
		System.out.println("La potencia del auto es " + this.potencia);
		if (this.transmision.getVelocidad() != null) {
			System.out.println("La velocidad de la transmision del auto es " + this.transmision.getVelocidad());
		}
		System.out.println("El tipo de la transmision del auto es " + this.transmision.getTipo());
		
	}
}
