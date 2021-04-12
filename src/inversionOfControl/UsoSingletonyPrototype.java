package inversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoSingletonyPrototype {

	public static void main(String[] args) {
		
		//carga xml de configuraci�n
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContextSingletonPrototype.xml");
		
		//Petici�n de beans al contenedor Spring.
		SecretarioEmpleado maria=contexto.getBean("miSecretarioEmpleado",SecretarioEmpleado.class);
		
		SecretarioEmpleado pedro=contexto.getBean("miSecretarioEmpleado",SecretarioEmpleado.class);
		
		//Como por defecto Spring trabaja bajo el patr�n Singleton, los dos beans pedro y jose apuntan al mismo objeto de tipo SecretarioEmpleado, que es �nico.
		System.out.println(maria);
		System.out.println(pedro);
		//El resultado de imprimir as� directamente los objetos es que la consola te muestra el detalle de los dos beans y la posici�n en memoria que ocupan, que es:
		//inversionOfControl.SecretarioEmpleado@26aa12dd
		//inversionOfControl.SecretarioEmpleado@26aa12dd
		//la cual es la misma, o sea es el mismo objeto de tipo SecretarioEmpleado.
		
		if(maria==pedro){
			System.out.println("Los dos beans apuntan al mismo objeto, se est� usando el patr�n Singleton por defecto");
		}
		else{
			System.out.println("Los dos beans no apuntan al mismo objeto, se est� usando el patr�n Prototype");
		}
		
	
	
		//Cerrar el recurso
		contexto.close();
	}

}
