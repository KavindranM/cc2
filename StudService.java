package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.CarModel;
import com.example.demo.Repository.StudRepository;

@Service
public class StudService {
@Autowired
StudRepository repository;

public Optional<CarModel>getStud(int id){
	return repository.findById(id);
}
public Optional<CarModel>putStud(int id){
	return repository.findById(id);
}



public String updateDetails(CarModel stu)
{
	repository.save(stu);
	return "updated";
}
public  String deleteDetails(int id)
{
	if(repository.existsById(id)) {
	repository.deleteById(id);
	return "deleted";
	}
	else {
		return "ID DOES NOT EXIST";
	}
}
public List<CarModel>setPages(@PathVariable int offset,@PathVariable int pageSize){
	Page<CarModel>page=repository.
			findAll(PageRequest.of(offset, pageSize));
	return page.getContent();
	
}
public List<CarModel>getSort(String make){
	return repository.findAll(Sort.by(Sort.Direction.DESC,make));
}
public String update(int id,CarModel c) {
	if(repository.existsById(id)) {
		CarModel temp=repository.getReferenceById(id);
		temp.setId(id);
		temp.setModel(c.getModel());
		temp.setMake(c.getMake());
		temp.setProduction_year(c.getProduction_year());
		temp.setEngine(c.getEngine());
		temp.setFuel(c.getFuel());
		repository.save(temp);
		return "updated";	
	}
	return "";
}
}
