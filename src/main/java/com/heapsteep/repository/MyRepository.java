package com.heapsteep.repository;

import com.heapsteep.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends CrudRepository<Person,String>{
}
