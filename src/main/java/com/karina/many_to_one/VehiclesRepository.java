package com.karina.many_to_one;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles,Integer> {

	List<Vehicles> findByVid(int vid);

	List<Vehicles> findByVname(String vname);

}
