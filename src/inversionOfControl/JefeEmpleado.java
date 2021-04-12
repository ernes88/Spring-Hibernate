package inversionOfControl;

public class JefeEmpleado implements Empleados{

	//Creaci�n de los campos que usa el objeto de tipo SecretarioEmpleado
	private String nombreEmpresa;
	private String email;
		
	//Creaci�n de m�todos getters y setters para estos dos campos.
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	//Creaci�n de campo de clase encapsulado de tipo CreacionInformes que va a contener el objeto de tipo Informe que le manda Spring y que se construye en el archivo de configuraci�n xml
	private CreacionInformes informeNuevo;
	
	//Creaci�n de un constructor para la implementaci�n de la inyecci�n de la dependencia/objeto Informe en la clase JefeEmpleado
	public JefeEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	public String getTareas(){
		return "Gestionar las cuestiones relativas a los empleados";
	}

	//Cuando la dependencia ha sido insertada, ya es posible utilizar este m�todo pues informeNuevo est� ya inicializado.
	@Override
	public String getInformes() {
		return "Informe creado por el Jefe: "+informeNuevo.getInforme();
	}
	
	
}




