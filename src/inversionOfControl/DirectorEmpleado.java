package inversionOfControl;

public class DirectorEmpleado implements Empleados {

	//Creación de campo de clase encapsulado de tipo CreacionInformes
	private CreacionInformes informeNuevo;
	
	//Creación de un constructor para la implementación de la inyección de la dependencia/objeto Informe en la clase DirectorEmpleado
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
