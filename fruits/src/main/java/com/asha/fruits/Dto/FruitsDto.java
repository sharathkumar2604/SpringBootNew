package com.asha.fruits.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="fruits")
public class FruitsDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String fruit_color;
	private String price;

	public FruitsDto() {
		System.out.println("dto default constructor");
	}

	public FruitsDto(Integer id, String name, String fruit_color, String price) {
		this.id = id;
		this.name = name;
		this.fruit_color = fruit_color;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFruit_color() {
		return fruit_color;
	}

	public void setFruit_color(String fruit_color) {
		this.fruit_color = fruit_color;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FruitsDto [id=" + id + ", name=" + name + ", fruit_color=" + fruit_color + ", price=" + price + "]";
	}

}
