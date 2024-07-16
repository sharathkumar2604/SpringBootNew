package com.sharath.juice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharath.juice.dto.Juicedto;

public interface JuiceRepo extends JpaRepository<Juicedto , Integer> {

	Juicedto findByNameIgnoreCase(String name);

	Juicedto findByNameAndFlovorIgnoreCase(String name, String flovor);

	Juicedto findByNameAndId(String name, int id);


}
