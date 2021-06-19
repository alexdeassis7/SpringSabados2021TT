package com.educacionit.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.bike.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
