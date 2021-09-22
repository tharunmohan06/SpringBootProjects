package com.example.Calc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("add/{num1}/{num2}")
	public int addNumbers(@PathVariable int num1, @PathVariable int num2)
	{
		return num1+num2;
	
	}
	
	@GetMapping("multiply/{num1}/{num2}")
	public int multNumbers(@PathVariable int num1, @PathVariable int num2)
	{
		return num1*num2;
	}
	
	//hit below url's to test the code,
	  //http://localhost:8080/multiply/10/2
	  //http://localhost:8080/add/10/20

}
