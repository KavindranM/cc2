package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.CarModel;

@Repository
public interface StudRepository extends JpaRepository<CarModel,Integer> {

	

}
