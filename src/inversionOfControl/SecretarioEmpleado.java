package inversionOfControl;

public class SecretarioEmpleado implements Empleados{
	
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

	//Creaci�n de campo de clase encapsulado de tipo CreacionInformes
	private CreacionInformes informeNuevo;
	
	//Creaci�n del m�todo setter para inyectar la dependencia Informe
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
