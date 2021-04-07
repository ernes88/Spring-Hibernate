package inversionOfControl;

public class SecretarioEmpleado implements Empleados{
	
	//Creación de campo de clase encapsulado de tipo CreacionInformes
	private CreacionInformes informeNuevo;
	
	public SecretarioEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	public String getTareas(){
		return "Gestionar la agenda de los jefes";
	}

	@Override
	public String getInformes() {
		return "Informe creado por el Secretario: "+informeNuevo.getInforme();
	}
}
