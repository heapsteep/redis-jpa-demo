package com.heapsteep.service;

import com.heapsteep.model.Person;
import com.heapsteep.repository.MyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
public class MyService {

	Logger logger = LoggerFactory.getLogger(MyService.class);
	@Autowired
    MyRepository myRepository;

	public Iterable<Person> getPersons() {
		return myRepository.findAll();
	}

	public Person addPerson(Person person) {
        return myRepository.save(person);
    }

	public Person updatePerson(Person person, String id) {
		Person person2 = myRepository.findById(id).get();
		person2.setName(person.getName());
		person2.setAge(person.getAge());

		return myRepository.save(person2);
	}

	@Cacheable(cacheNames = "cacheStore", key = "#id")
	public Person getPersonById(String id) {
		Person person = myRepository.findById(id).get();
		//Person person2 = myRepository.findById(id).get();
		logger.info("person: " + person);
		//logger.info("person2: " + person2);
		return person;
	}

	public void deletePerson(String id) {
		myRepository.deleteById(id);
	}
}
