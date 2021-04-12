package inversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoInitDestroy {

	public static void main(String[] args) {
		
		//carga xml de configuraci�n
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContextInitDestroy.xml");
		
		//Pedir el bean
		DirectorEmpleado federico = contexto.getBean("miDirectorEmpleado", DirectorEmpleado.class);
		
		//Generar un informe. Ac� en la consola se mostrar� el contenido del informe, como es normal, pero lo nuevo est� en que antes de mostrar eso mostrar� el mensaje escrito dentro del m�todo init y luego despu�s del mensaje del informe mostrar� el mensaje escrito dentro del destroy.
		System.out.println(federico.getInformes());
		
		//Cerrar el contexto
		contexto.close();
	}
}
