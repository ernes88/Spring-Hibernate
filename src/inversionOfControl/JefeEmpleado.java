package inversionOfControl;

public class JefeEmpleado implements Empleados{

	//Creaci�n de campo de clase encapsulado de tipo CreacionInformes que va a contener el objeto de tipo Informe que le manda Spring y que se construye en el archivo de configuraci�n xml
	private CreacionInformes informeNuevo;
	
	public JefeEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	public String getTareas(){
		return "Gestiono las cuestiones relativas a mis empelados de secci�n";
	}

	//Cuando la dependencia ha sido insertada, ya es posible utilizar este m�todo pues informeNuevo est� ya inicializado.
	@Override
	public String getInformes() {
		return "Informe creado por el Jefe: "+informeNuevo.getInforme();
	}
	
	
	
	
	
}




