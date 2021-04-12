//En este ejemplo, tenemos esta aplicaci�n que saca por pantalla la funci�n de tres tipos de objetos. 
//Originalmente nuestra aplicaci�n solo trabajaba con un objeto de tipo JefeEmpleado, si queremos que trabaje
//con otros objetos tenemos que modificar nuestra aplicaci�n, o sea crear otra clase SecretarioEmpleado
//por ejemplo y modificar nuestra clase principal. Ac� es donde entra a jugar Spring con su concepto de 
//Inversion of Control(IoC). Utilizando este concepto, el contenedor de Spring es quien proporciona estos objetos
//que se van necesitando, no tenemos nosotros que modificar nuestra clase cada vez que se necesite un objeto de 
//nuevo tipo. Para poder utilizar el contenedor de Spring necesitamos crear un archivo de configuraci�n. 

package inversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {
		/*Esta ser�a la forma de trabajar tradicional sin Spring. Para poder usar en mi clase un objeto de una de las clases que cree tengo que instanciarlas
		
		//Creaci�n de objetos de tipo Empleado
		Empleados empleado1=new JefeEmpleado();
		
		//Creaci�n de un objeto SecretarioEmpleado
		Empleados empleado2=new SecretarioEmpleado();
		
		//Creaci�n de un objeto de tipo DirectorEmpleado
		Empleados empleado3=new DirectorEmpleado();
		
		//Uso de los objetos creados usando el getter 
		System.out.println(empleado2.getTareas());
		
		*/
		
		//Trabajando con Spring.
		//No tengo que instanciar las clases para poder utilizar el m�todo getTareas() puesto que lo hago con el mismo objeto de la Interface
		//En el caso de que tegamos muchas clases, o sea muchos distintos tipos de empleados se reduce c�digo ya que no tenemos que istanciar muchas clases en nuestra calse principal, clases que puede que en muchos momentos no tengamos que usar.
		
		//1.Cargar archivo XML creando objeto de tipo ClassPathXmlApplicationContext que toma como argumento el archivo xml creado anteriormente 
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
	
		//2.Pedirle al archivo xml el bean creado dentro del mismo para crear un objeto de ese tipo. Se usa m�todo getBean que toma como argumento el id o alias del bean y tambi�n el nombre de la clase del objeto a recepcionar.
		JefeEmpleado juan=contexto.getBean("miJefeEmpleado", JefeEmpleado.class);
		DirectorEmpleado ana=contexto.getBean("miDirectorEmpleado", DirectorEmpleado.class);
		
		
		
		
		//3.Uilizar los beans creados para el caso de un objeto JefeEmpleado y otro DirectorEmpleado
		System.out.println("---------------Mostrando las tareas e informes del objeto JefeEmpleado Juan----------------");
		System.out.println(juan.getTareas());
		System.out.println(juan.getInformes());
		System.out.println("Nombre de la empresa: "+juan.getNombreEmpresa());
		System.out.println("Direcci�n email del departamento de Jefatura de Secci�n: "+juan.getEmail());
		System.out.println();
		
		
		
			
		System.out.println("---------------Mostrando las tareas e informes del objeto DirectorEmpleado Ana----------------");	
		System.out.println(ana.getTareas());
		System.out.println(ana.getInformes());
		System.out.println("Nombre de la empresa: "+ana.getNombreEmpresa());
		System.out.println("Direcci�n email del departamento de Direcci�n: "+ana.getEmail());
		System.out.println();
		
		
		
		
		//A partir de aqu� utilizamos un m�todo setter para inyectar una dependencia para el caso del SecretarioEmpleado.
		Empleados pedro=contexto.getBean("miSecretarioEmpleado",Empleados.class);		//getBean() crea un objeto de tipo Empleados.class, ya que esto se le paso como segundo par�metro, en base al bean que le llega que es de tipo SecretarioEmpleado. Como SecretarioEmpleado implementa Empleados, pues el objeto Empleados pedro puede contener el bean que le llega desde el xml
		
		
		System.out.println("---------------Mostrando las tareas e informes del objeto SecretarioEmpleado Pedro----------------");	
		System.out.println(pedro.getTareas());
		System.out.println(pedro.getInformes());
		System.out.println();
		
	
		
		
		
		//pedro es un objeto de tipo Empleados, y en la interfaz Empleados solo est�n los m�todos getTareas() y getInformes(), por tanto a pesar de que en el bean que le est� llegando del xml tiene la info para dos campos de secretarioEmpleados, como estos son campos de la clase hija, y los getter generados que nos permitir�an obtener el valor de estos son tambi�n de la clase hija pues la padre Empleados no tiene acceso a los mismo. 
		//la soluci�n es utilizar clases hijas para contener el bean:
		
		SecretarioEmpleado maria=contexto.getBean("miSecretarioEmpleado",SecretarioEmpleado.class);
		
		System.out.println("---------------Mostrando las tareas e informes del objeto SecretarioEmpleado Mar�a----------------");	
		//Notar ac� como mar�a tiene acceso a sus m�todos getNombreEmpresa y getEmail, pero adem�s a los de la interfaz que implementa (o sea Empleados), que son getTareas, y getInformes. 
		System.out.println(maria.getTareas());
		System.out.println(maria.getInformes());
		System.out.println("Nombre de la empresa: "+maria.getNombreEmpresa());
		System.out.println("Direcci�n email del departamento de Secretar�a: "+maria.getEmail());
		System.out.println();
		
		
		
		
		
		SecretarioEmpleado juana=contexto.getBean("miSecretarioEmpleado2",SecretarioEmpleado.class);
		
		System.out.println("---------------Mostrando las tareas e informes del objeto SecretarioEmpleado Juana----------------");	
		//Notar ac� como mar�a tiene acceso a sus m�todos getNombreEmpresa y getEmail, pero adem�s a los de la interfaz que implementa (o sea Empleados), que son getTareas, y getInformes. 
		System.out.println(juana.getTareas());
		System.out.println(juana.getInformes());
		System.out.println("Nombre de la empresa: "+juana.getNombreEmpresa());
		System.out.println("Direcci�n email del departamento de Secretar�a: "+juana.getEmail());
		System.out.println();
		
		
		
			
		JefeEmpleado tomas=contexto.getBean("miJefeEmpleado2", JefeEmpleado.class);
		
		System.out.println("---------------Mostrando las tareas e informes del objeto JefeEmpleado Tomas----------------");		
		System.out.println(tomas.getTareas());
		System.out.println(tomas.getInformes());
		System.out.println("Nombre de la empresa: "+tomas.getNombreEmpresa());
		System.out.println("Direcci�n email del departamento de Jefatura de Secci�n: "+tomas.getEmail());
		System.out.println();
		
		
	
		
		
		
		DirectorEmpleado maritza=contexto.getBean("miDirectorEmpleado2", DirectorEmpleado.class);
		System.out.println("---------------Mostrando las tareas e informes del objeto DirectorEmpleado Maritza----------------");			
		System.out.println(maritza.getTareas());
		System.out.println(maritza.getInformes());
		System.out.println("Nombre de la empresa: "+maritza.getNombreEmpresa());
		System.out.println("Direcci�n email del departamento de Jefatura de Secci�n: "+maritza.getEmail());
		System.out.println();
		
		
		
		
		
		//4.Cerrar el contexto
		contexto.close();
	}

}
