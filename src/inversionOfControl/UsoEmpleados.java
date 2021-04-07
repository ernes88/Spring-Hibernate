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
	
		//2.Pedirle al archivo xml el bean creado dentro del mismo para crear un objeto de ese tipo. Se usa m�todo getBean que toma como argumento el id o alias del bean y tambi�n el nombre de la interface  
		Empleados juan=contexto.getBean("miEmpleado", Empleados.class);
		
		//3.Uilizar el bean creado
		System.out.println(juan.getTareas());
		System.out.println(juan.getInformes());
		
		//4.Cerrar el contexto
		contexto.close();
	}

}
