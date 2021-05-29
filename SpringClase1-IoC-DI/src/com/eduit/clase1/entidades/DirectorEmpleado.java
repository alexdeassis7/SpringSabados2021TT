package com.eduit.clase1.entidades;

import com.eduit.clase1.intefaces.CreacionInformes;
import com.eduit.clase1.intefaces.IEmpleados;

public class DirectorEmpleado implements IEmpleados {

	// creacion de atributo del tipo CreacionInformes(interface) ,
//	para la inyeccion de dependencia
	private CreacionInformes informeNuevo;

	// creacion de un constructor que inyectara la dependencia
	public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		// utilizamos el metodo getInforme() de la inteface
		return "Informe creado por el director : " + informeNuevo.getInforme();
	}

	@Override
	public String getInforme() {
		return null;
	}

}
