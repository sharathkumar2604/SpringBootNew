package com.asha.fruits.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.asha.fruits.Dto.FruitsDto;
import com.asha.fruits.Service.FruitsService;


@RestController
public class FruitsController
{

	private static final Logger logger = LoggerFactory.getLogger(FruitsController.class);
	@Autowired
	private FruitsService service;

	
	 
	@PostMapping("/insert")
	
	public ResponseEntity<String> insert(@RequestBody FruitsDto dto)
	{
		String status = service.insert(dto);
		logger.error("this is a error message");
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/readById/{id}")
	public ResponseEntity<FruitsDto>readById(@PathVariable Integer id)
	{
		FruitsDto fruitsById = service.readById(id);
		logger.debug("hello");
		  
		return new ResponseEntity<>(fruitsById,HttpStatus.OK);
	}	
	
	@GetMapping("/readAll")
	public ResponseEntity<List<FruitsDto>> readaAll()
	{
		List<FruitsDto> allFruits= service.readAll();
		logger.info("we taking the request and showing the response");
	      logger.warn("i will not give anywarning");
	      logger.error("okay");
		return new ResponseEntity<List<FruitsDto>>(allFruits,HttpStatus.OK);
	}

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody FruitsDto dto)
    {
    	String status = service.insert(dto);
		return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
   public ResponseEntity<String> deleteFruits(@PathVariable Integer id)
    {
    	String deleteById = service.deleteById(id);
		return new ResponseEntity<>(deleteById,HttpStatus.OK);
   
    }
    
}
