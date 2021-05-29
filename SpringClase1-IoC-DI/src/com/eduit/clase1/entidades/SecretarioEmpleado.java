package com.eduit.clase1.entidades;

import com.eduit.clase1.intefaces.CreacionInformes;
import com.eduit.clase1.intefaces.IEmpleados;

public class SecretarioEmpleado implements IEmpleados {

	private CreacionInformes informeNuevo;

	@Override
	public String getTareas() {
		return "Soy un Secretario y me encanta obedecer a mi superior como tambien gestionar su agenda.....";
	}

	@Override
	public String getInforme() {
		return "";
	}

	// Generamos un Setters para poder usar la inyeccion de dependencias
	// mediante el Tag <property>
	public void setInformeNuevo(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
}
