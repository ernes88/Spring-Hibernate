package inversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoInitDestroy {

	public static void main(String[] args) {
		
		//carga xml de configuración
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContextInitDestroy.xml");
		
		//Pedir el bean
		DirectorEmpleado federico = contexto.getBean("miDirectorEmpleado", DirectorEmpleado.class);
		
		//Generar un informe. Acá en la consola se mostrará el contenido del informe, como es normal, pero lo nuevo está en que antes de mostrar eso mostrará el mensaje escrito dentro del método init y luego después del mensaje del informe mostrará el mensaje escrito dentro del destroy.
		System.out.println(federico.getInformes());
		
		//Cerrar el contexto
		contexto.close();
	}
}
