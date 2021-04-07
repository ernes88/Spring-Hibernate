package inversionOfControl;

public class JefeEmpleado implements Empleados{

	//Creación de campo de clase encapsulado de tipo CreacionInformes que va a contener el objeto de tipo Informe que le manda Spring y que se construye en el archivo de configuración xml
	private CreacionInformes informeNuevo;
	
	public JefeEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	public String getTareas(){
		return "Gestiono las cuestiones relativas a mis empelados de sección";
	}

	//Cuando la dependencia ha sido insertada, ya es posible utilizar este método pues informeNuevo está ya inicializado.
	@Override
	public String getInformes() {
		return "Informe creado por el Jefe: "+informeNuevo.getInforme();
	}
	
	
	
	
	
}




