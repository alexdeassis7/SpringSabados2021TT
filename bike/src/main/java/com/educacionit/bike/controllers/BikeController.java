package com.educacionit.bike.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.educacionit.bike.models.Bike;
import com.educacionit.bike.repositories.BikeRepository;

@RestController
//mediante la anotacion @RestController sera suficiente para que spring 
//la publique como Spring Rest Service 

//URI Base : es la url de la cual van a desprenderse el conjunto de End Points
@RequestMapping("api/v1/bikes") // localhost:puerto/api/v1/bikes
public class BikeController {
	/// inyectamos el Repositorio
	@Autowired
	private BikeRepository bk;

	// este End point me retornara el listado completo de registros
	// que se encuentran en la base de datos SQLite en la tabla Bike
	@GetMapping
	public List<Bike> lista() {
		// utilizamos el repositorio para obtener todos los registro de la tabla
		// esto seria como ejecutar la consulta siguiente :
		// select * from bike;
		return bk.findAll();
	}

	// este end point me retorna un registro de la tabla bike mediante su id
	// el id sera recibido en la url del end point
	// http://localhost:puerto/api/v1/bikes/{id}
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Bike getBike(@PathVariable("id") Long id) {
//		System.out.println("recibimos {por path variable el id : " + id);
//		if (bk.existsById(id)) {
//		    return bk.getB(id);
//		}else {
//			return null;
//		}
//	
		return bk.getOne(id);
	}
	
	//Este metodo recibe en el cuerpo de la peticion http un 
	//JSON que sera persistido en la tabla bike de la db sqlite 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Bike bike) {
		
		bk.save(bike);
	}
	

}
