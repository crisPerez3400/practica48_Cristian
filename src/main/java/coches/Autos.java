package coches;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="autos")
@XmlType(propOrder = {"auto"})
@XmlAccessorType(XmlAccessType.FIELD)


public class Autos{
	//@XmlElementWrapper (name = "autos")
	//@XmlElement (name = "auto")
	private ArrayList<Auto> auto = new ArrayList();
	public Autos(){}
	public Autos(ArrayList<Auto> auto){
		this.auto = auto;
	}
	public ArrayList<Auto> getAuto() {
		return auto;
	}
	public void setAuto(ArrayList<Auto> auto) {
		this.auto = auto;
	}
	
	public void imprimirAutos() {
		for(int i=0;i<auto.size();i++) {
            auto.get(i).imprimirAuto();
        }
	}
	
	public void añadirAutos(Auto nuevoauto) {
		this.auto.add(nuevoauto);
	}
	
	
}