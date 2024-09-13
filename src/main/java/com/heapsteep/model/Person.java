package com.heapsteep.model;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Cacheable
public class Person implements java.io.Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private Integer age;
}
