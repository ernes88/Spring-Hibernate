package inversionOfControl;

public class SecretarioEmpleado implements Empleados{
	
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

	//Creación de campo de clase encapsulado de tipo CreacionInformes
	private CreacionInformes informeNuevo;
	
	//Creación del método setter para inyectar la dependencia Informe
	public void setInformeNuevo(CreacionInformes informeNuevo) {
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
