package com.sharath.juice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharath.juice.dto.Juicedto;
import com.sharath.juice.repo.JuiceRepo;

@RestController
public class JuiceController {
	@Autowired
	private JuiceRepo repo;
	private Object flovor;

	@PostMapping("/saveAll")
	public ResponseEntity<List<Juicedto>> saveAll(@RequestBody Juicedto... dtos) {
		List<Juicedto> list = new ArrayList<Juicedto>();
		for (Juicedto d : dtos) {
			repo.save(d);
			list.add(d);
		}
		return new ResponseEntity<>(list, HttpStatus.CREATED);

	}

	@GetMapping("/readAll")
	public ResponseEntity<List<Juicedto>> readAll() {

		List<Juicedto> all = repo.findAll();

		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@GetMapping("readByName/{name}")
	public ResponseEntity<Juicedto> readByName(@PathVariable String name) {

		Juicedto d = repo.findByNameIgnoreCase(name);

		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@GetMapping("readByNameAndFlovor/{name}/{flovor}")
	public ResponseEntity<Juicedto> readByNameAndFlovor(@PathVariable String name, @PathVariable String flovor) {

		Juicedto d = repo.findByNameAndFlovorIgnoreCase(name, flovor);
		if (d == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@GetMapping("readByNameAndId/{name}/{id}")
	public ResponseEntity<Juicedto> readByNameAndId(@PathVariable String name, @PathVariable int id) {

		Juicedto d = repo.findByNameAndId(name, id);
		if (d == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@GetMapping("readById/{id}")
	public ResponseEntity<Juicedto> readById(@PathVariable int id) {

		Juicedto d = repo.findById(id).orElse(null);
		if (d == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@PutMapping("/update/{name}/{id}")
	public ResponseEntity<String> updatePriceByNameAndId(@PathVariable String name, @PathVariable int id,
			@RequestBody Map<String, Integer> priceMap) {

		int price = priceMap.get("price");

		List<Juicedto> body = readAll().getBody();

		for (Juicedto d : body) {
			if (name.equalsIgnoreCase(d.getName()) && id == d.getId()) {

				d.setPrice(price);
				repo.save(d);
			}
		}
		return new ResponseEntity<String>("updated", HttpStatus.OK);

	}

//	@PutMapping("/update/{name}/{id}")
//	public ResponseEntity<Juicedto> updatePriceByNameAndId(@PathVariable String name, @PathVariable int id,
//			@RequestBody Map<String, Integer> priceMap) {
//		int price = priceMap.get("price");
//		List<Juicedto> ls = readAll().getBody();
//
//		for (Juicedto entity : ls) {
//			if (name.equalsIgnoreCase(entity.getName()) && id == entity.getId()) {
//				entity.setPrice(price);
//				repo.save(entity);
//			}
//
//		}
//
//		return ResponseEntity.status(HttpStatus.OK).build();
//
//	}

	@DeleteMapping("/delete/{name}/{id}")
	public ResponseEntity<String> deleteByNameAndId(@PathVariable String name, @PathVariable int id) {

		List<Juicedto> body = readAll().getBody();

		for (Juicedto d : body) {
			if (name.equalsIgnoreCase(d.getName()) && id == d.getId()) {

				repo.delete(d);
			}
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);

	}

}
