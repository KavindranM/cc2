package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CarModel;
import com.example.demo.Repository.StudRepository;
import com.example.demo.Service.StudService;

@CrossOrigin
@RestController
public class StudController {
	@Autowired
	StudRepository serviceRepository;
	@Autowired
	StudService service;
@GetMapping("/get")
List<CarModel> getList(){
	return serviceRepository.findAll();
}
@PostMapping("/post")
public CarModel create(@RequestBody CarModel stu) {
	return serviceRepository.save(stu);
}
@PutMapping("/car/{id}")
public Optional<CarModel>putbyid(@PathVariable int id){
	return service.putStud(id);
}
@DeleteMapping("/de/{id}")
public String delete(@PathVariable int id)
{
	return service.deleteDetails(id);
}

}




