package com.asha.watches.watchController;

import java.util.List;

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

import com.asha.watches.Dto.WatchesDto;
import com.asha.watches.service.WatchesService;

@RestController
public class WatchesController {

	@Autowired
	private WatchesService service;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody WatchesDto dto) {
		String status = service.insert(dto);

		return new ResponseEntity<String>(status, HttpStatus.CREATED);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<WatchesDto> read(@PathVariable Integer id) {
		WatchesDto byId = service.getById(id);
		return new ResponseEntity<>(byId, HttpStatus.OK);

	}

	@GetMapping("/readAll")
	public ResponseEntity<List<WatchesDto>> readAll() {
		List<WatchesDto> allWatches = service.getAllWatches();
		return new ResponseEntity<>(allWatches, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody WatchesDto dto) {
		String status = service.insert(dto);
		return new ResponseEntity<>(status, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteWatches(@PathVariable Integer id) {
		String deleteById = service.deleteById(id);
		return new ResponseEntity<>(deleteById, HttpStatus.OK);

	}

}
