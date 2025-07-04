package com.heapsteep.controller;

import com.heapsteep.model.Person;
import com.heapsteep.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api")
public class MyController {
	@Autowired
	MyService myService;

	@GetMapping("/getPersons")
	public Iterable<Person> getPersons() {
		return myService.getPersons();
	}
	
	@PostMapping("/addPerson")
    //@ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person){
        return myService.addPerson(person);
    }

	@PutMapping("/updatePerson/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable String id){
		return myService.updatePerson(person,id);
	}

	@GetMapping("/getPersonById/{id}")
	public Person getPersonById(@PathVariable String id){
		return myService.getPersonById(id);
	}

	@DeleteMapping("/deletePerson/{id}")
	public void deletePerson(@PathVariable String id) {
		myService.deletePerson(id);
	}
}
