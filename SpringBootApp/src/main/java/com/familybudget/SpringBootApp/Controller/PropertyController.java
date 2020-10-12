package com.familybudget.SpringBootApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.familybudget.SpringBootApp.Service.PropertiesService;
import com.familybudget.SpringBootApp.model.peroperties;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class PropertyController {
	
	@Autowired
	PropertiesService pers;
	
	@GetMapping("/Preporities")
	public ResponseEntity<List<peroperties>> get() {
		List<peroperties> list =pers.list();
		return new ResponseEntity<List<peroperties>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/Preporities")
	public ResponseEntity<peroperties> save(@RequestBody peroperties perst)	{
		peroperties per=pers.save(perst);		
		return new ResponseEntity<peroperties>(per,HttpStatus.OK);
	}
	
	@GetMapping("/Preporities/{id}")
	
	public ResponseEntity<peroperties> findbyid(@PathVariable("id") long id){
		
		peroperties per=pers.findByID(id);		
		return new ResponseEntity<peroperties>(per,HttpStatus.OK);
	}
	
	@GetMapping("/Prepority/{id}")
	
	public ResponseEntity<List<peroperties>> findbyusername(@PathVariable("id") long id){
		
		List<peroperties> per=pers.findByUsersId(id);
		return new ResponseEntity<List<peroperties>>(per,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/Preporities/{id}")
	
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		pers.deleteByID(id);
		return new ResponseEntity<String>("Peroperty Deleted",HttpStatus.OK);
	}
	
	@PutMapping("/Preporities/{id}")
	public ResponseEntity<peroperties> update(@PathVariable("id") long id,@RequestBody peroperties perst){
		peroperties per=pers.update(id, perst);		
		return new ResponseEntity<peroperties>(per,HttpStatus.OK);
		
	}
}
