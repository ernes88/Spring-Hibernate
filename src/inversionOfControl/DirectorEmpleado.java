package inversionOfControl;

public class DirectorEmpleado implements Empleados {

	//Creaci�n de campo de clase encapsulado de tipo CreacionInformes
	private CreacionInformes informeNuevo;
	
	//Creaci�n de un constructor para la implementaci�n de la inyecci�n de la dependencia/objeto Informe en la clase DirectorEmpleado
	public DirectorEmpleado(CreacionInformes informeNuevo){
		this.informeNuevo=informeNuevo;
	}
	
	
	
	@Override
	public String getTareas() {
		return "Gestionar la plantila de la empresa";
	}

	@Override
	public String getInformes() {
		return "Informe creado por el Director: "+informeNuevo.getInforme();
	}

}
