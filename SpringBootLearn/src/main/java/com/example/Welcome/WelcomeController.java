package com.example.Welcome;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	WelcomePojo wel= new WelcomePojo();
	AtomicInteger counter= new AtomicInteger();
	
	@GetMapping("/welcome")
	public WelcomePojo welcomeUser(@RequestParam(value="name")String name) {
		
		wel.setUserID(counter.incrementAndGet());
		wel.setUserMSG("Welcome Dear Customer "+name);
		return wel;
	}
	
	//hit below url to test the code,
	  //http://localhost:8080/welcome?name=Tharun
}
