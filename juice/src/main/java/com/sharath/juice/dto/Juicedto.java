package com.sharath.juice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Juicedto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String flovor;
	
	private int price;

	public Juicedto() {
	}

	public Juicedto(String name, String flovor, int price) {
		this.name = name;
		this.flovor = flovor;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFlovor() {
		return flovor;
	}

	public int getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFlovor(String flovor) {
		this.flovor = flovor;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "JuiceDto [id=" + id + ", name=" + name + ", flovor=" + flovor + ", price=" + price + "]";
	}
	
	
	
}
