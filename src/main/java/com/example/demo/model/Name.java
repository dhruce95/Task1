package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class Name {
	
	@NotBlank(message = "Either \'name\' is not present or \'name\' shouldn't be blank!")
	public String name;
	@NotBlank(message = "Either \'surname\' is not present or \'surname\' shouldn't be blank!")
	public String surname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "Name [name=" + name + ", surname=" + surname + "]";
	}
}
