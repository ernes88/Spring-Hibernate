package inversionOfControl;

public class DirectorEmpleado implements Empleados {

	//Creaci�n de los campos que usa el objeto de tipo SecretarioEmpleado
	private String nombreEmpresa;
	private String email;
		
	//Creaci�n de m�todos getters y setters para estos dos campos.
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	
	//Creaci�n de campo de clase encapsulado de tipo CreacionInformes que se usa para inyectar las dependencias
	private CreacionInformes informeNuevo;

	
	//Creaci�n de un constructor para la implementaci�n de la inyecci�n de la dependencia/objeto Informe en la clase DirectorEmpleado
	public DirectorEmpleado(CreacionInformes informeNuevo){
		this.informeNuevo=informeNuevo;
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
	
	@Override
	public String getTareas() {
		return "Gestionar la plantila de la empresa";
	}

	@Override
	public String getInformes() {
		return "Informe creado por el Director: "+informeNuevo.getInforme();
	}
	
	
	//m�todo init. Ejecutar tareas antes de que el bean este disponible
	public void init(){
		System.out.println("Se est�n ejecutando las tareas previas antes de que el bean" + 
	" este disponible");
	}
	
	
	//m�todo destroy. Ejecutar tareas despu�s de que el bean haya sido utilizado. 
	public void destroy(){
		System.out.println("Se est�n ejecutando las tareas a realizar despu�s de que el bean" + 
				" haya sido utilizado");
	}
}
