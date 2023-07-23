package com.asha.watches.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="watches1")

public class WatchesDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String watch_for;
//	private String cost;
	
	
	
	public WatchesDto() {
	}



	public WatchesDto(Integer id, String name, String watch_for) {
		this.id = id;
		this.name = name;
		this.watch_for = watch_for;
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



	public String getWatch_for() {
		return watch_for;
	}



	public void setWatch_for(String watch_for) {
		this.watch_for = watch_for;
	}



	@Override
	public String toString() {
		return "WatchesDto [id=" + id + ", name=" + name + ", watch_for=" + watch_for + "]";
	}

	
	
}
