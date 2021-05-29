package com.eduit.clase1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduit.clase1.entidades.JefeEmpleado;
import com.eduit.clase1.entidades.SecretarioEmpleado;
import com.eduit.clase1.intefaces.IEmpleados;

public class DemoUsoEmpleado {

	public static void main(String[] args) {
		// creamos objetos de tipo empleado

		JefeEmpleado e1 = new JefeEmpleado();

		// e creo una referencia a la abstraccion
		IEmpleados e2 = new JefeEmpleado();
		IEmpleados e3 = new SecretarioEmpleado();
		//el problema que se plantea aqui es que si quiero crear un objeto de un tipo diferente me veo obligado 
//		a modificar  el codigo y/o definir una nueva clase 
		//por eje: si quiero dejar de usar una clase deberia eliminarla 

		
		//uso de los objetos creados 
		System.out.println("empleado e1 : " + e1.getTareas());
		System.out.println("empleado e2 : " + e2.getTareas());
		System.out.println("empleado e3 : " + e3.getTareas());
		
		System.out.println("Demo IOC Spring XML");
		//AHORA HACEMOS LO MISMO PERO CON EL CONTENEDOR DE SPRING
		
		//PASO 1 ) Cargar el xml de configuracion
		//primero creamos el contexto y le pasamos por parametro el nombre del archivo con extension ".xml"
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//PASO 2 ) Pedirle el beans al archivo .xml , enviandole por parametro el alias o id 
		//y en segundo lugar le enviamos el nombre de la abstraccion (interface)
		IEmpleados alex = contexto.getBean("miEmpleado" , IEmpleados.class);
		
		//Paso 3 )  Utilizar el objeto solicitado a gusto ...
		System.out.println("utilizamos el bean : " + alex.getTareas());
		
		
		//DEMO INYECCION DEPENDENCIA : la ventaja de esto es que ahora pdoemos 
		//reutilizarlo en otra clase como por ejemplo jefeEmpleado
		System.out.println("Utilizamos la Inyeccion de dependencia " + alex.getInforme()) ;
		
		//Paso 4 ) cerramos el contexto y asi liberamos los recursos 
		contexto.close();
		
		
	}

}
