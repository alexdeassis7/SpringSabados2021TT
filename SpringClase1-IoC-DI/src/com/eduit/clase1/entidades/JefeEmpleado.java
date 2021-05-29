package com.eduit.clase1.entidades;

import com.eduit.clase1.intefaces.IEmpleados;

public class JefeEmpleado implements IEmpleados {

	// Sobreescribo el metodo de la inteface
	@Override
	public String getTareas() {
		return "Soy un Jefe Empleado , y me encargo de controlar y hacer que obedezcan ..... o si no renuncian ";
	}

	@Override
	public String getInforme() {

		return "";
	}

}
