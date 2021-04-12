package inversionOfControl;

public class JefeEmpleado implements Empleados{

	//Creación de los campos que usa el objeto de tipo SecretarioEmpleado
	private String nombreEmpresa;
	private String email;
		
	//Creación de métodos getters y setters para estos dos campos.
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
	
	
	
	//Creación de campo de clase encapsulado de tipo CreacionInformes que va a contener el objeto de tipo Informe que le manda Spring y que se construye en el archivo de configuración xml
	private CreacionInformes informeNuevo;
	
	//Creación de un constructor para la implementación de la inyección de la dependencia/objeto Informe en la clase JefeEmpleado
	public JefeEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	public String getTareas(){
		return "Gestionar las cuestiones relativas a los empleados";
	}

	//Cuando la dependencia ha sido insertada, ya es posible utilizar este método pues informeNuevo está ya inicializado.
	@Override
	public String getInformes() {
		return "Informe creado por el Jefe: "+informeNuevo.getInforme();
	}
	
	
}




