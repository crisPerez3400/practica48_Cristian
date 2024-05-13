
import coches.Autos;
import coches.Auto;
import coches.Transmision;
import java.io.*;
import java.util.*;
import javax.xml.bind.*;;

public class main {

	public static void main(String[] args) {
		
		try {

			// Obtener datos del xml
			JAXBContext conexto;
			conexto = JAXBContext.newInstance(Autos.class);
			Unmarshaller um = conexto.createUnmarshaller();
			Autos coches = (Autos) um.unmarshal (new File("src\\main\\resources\\Coches.xml"));

			//Preparacion para leer y escribir xml (En uno nuevo para mantener el base)

			Marshaller m = conexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); //Para que escriba el documento indentado 
			m.marshal(coches, new File("src\\main\\resources\\Coches1.xml"));
				

			try {
				Scanner entrada = new Scanner(System.in);
				Scanner parada = new Scanner(System.in);
				Boolean consola = true;	
				while (consola == true) {
					System.out.println("\nDara la tecla enter para acceder a la consola");
					parada.nextLine();
					System.out.println("\nPorfavor, elija una de las siguientes opciones mediante el uso de números enteros:\n");
					System.out.println("1. Mostrar el catálogo entero.\n" + "2. Añadir nuevos coches al catálogo.\n" 
					+ "3. Buscar coches mediante el tipo de marca.\n" + "4. Salir de la consola.\n");
					int numero = entrada.nextInt();
					entrada.nextLine();
			        
					switch (numero) {
					    case 1:
					    	coches.imprimirAutos();
                            break;
                        case 2:
                        	Transmision transmision = new Transmision(1);
                        	int identificadorfinal =  Integer.parseInt(coches.getAuto().get((coches.getAuto().size())-1).getIdentificacion()) + 1;
                        	//String identificadorfinal =  coches.getAuto().get((coches.getAuto().size())-1).getIdentificacion();
                        	String identificador = ("00" + identificadorfinal);
                        	Auto nuevoauto = new Auto(transmision,identificador);
                        	coches.añadirAutos(nuevoauto);
                        	m.marshal(coches, new File("src\\main\\resources\\Coches1.xml"));
                        	break;
                        case 3:
                        	try {
                        		ArrayList<String> modelos = new ArrayList<String>();
                        		System.out.println("Elija que coches quieres ver según su marca mediante el uso de números enteros:\n");                
                        		//Nos coge todos los modelos que existen, pero sin repetirlos
                        		for (Auto coche : coches.getAuto()) {
                        			if (!modelos.contains(coche.getMarca())) {
                        				modelos.add(coche.getMarca());
                        			}
                        		}
                        		// Nos muestra todos los tipos de marcas que hay
                        		for (int i = 0; i <modelos.size(); i++) {
                        			System.out.println((i+1) + ". " + modelos.get(i));
                        		}
                        		int numero1 = entrada.nextInt();
                        		String modelo = coches.getAuto().get(numero1-1).getMarca();
                        		
                        		// Recorre los cohces que hay y muestra solo los que coinciden con la marca que le hemos dado
                        		for (Auto coche : coches.getAuto()) {
                        				if (coche.getMarca().equals(modelo)) {
                                        coche.imprimirAuto();
                                    } 
                        		}
                        	} catch (InputMismatchException | IndexOutOfBoundsException e) {
                        		System.out.println("Debes usar números enteros y que esten dentro de las opciones");
                        	}
                        	break;
                        case 4:
                        	consola = false;
                            break;
                        default:
                        	System.out.println("Procure que el dato que hayas insertado este dentro de las opciones posibles");
					}
				}	
				parada.close();
				entrada.close();
			} catch (InputMismatchException e) {
				System.out.println("Procure que el dato que hayas insertado sea un número entero");
			}
			

			//Imprimir mediante xml
			m.marshal(coches, System.out);

			//Buscar datos en el xml		
		} catch (JAXBException | InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}