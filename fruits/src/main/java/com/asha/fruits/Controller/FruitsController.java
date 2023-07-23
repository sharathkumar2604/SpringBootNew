package com.asha.fruits.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitsController {

	@GetMapping("/fruits")
	public static String fruits()
	{
		return "eat a apple a day keep docter away";
	}
}
