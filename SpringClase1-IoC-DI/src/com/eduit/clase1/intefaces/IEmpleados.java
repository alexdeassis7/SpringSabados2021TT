package com.eduit.clase1.intefaces;

//creamos una Abstraccion , que tiene el metodo getTareas() y getInforme()
public interface IEmpleados {

	public String getTareas();

	// este metodo lo utilizaremos para la DI (inyeccion de dependencias)
	public String getInforme();

}
