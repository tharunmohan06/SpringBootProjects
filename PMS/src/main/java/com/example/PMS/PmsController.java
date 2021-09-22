package com.example.PMS;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PmsController {
	
	AtomicInteger counter= new AtomicInteger();
	@Autowired
	PmsRepository repository;
	
	@Autowired
	PmsAddService pmsservice;
	
	
	@PostMapping("/addpizza")
	public ResponseEntity<PmsAddResponse> addPizza(@RequestBody PmsBean pms)
	{
		HttpHeaders header= new HttpHeaders();
		String con= pms.getpProduct()+counter.incrementAndGet();
		PmsAddResponse add= new PmsAddResponse();
		
		if (!pmsservice.checkIfProductExist(con))
		{
			pms.setpId(con);
			repository.save(pms);
			
			add.setId(con);
			add.setMsg("Success: Product is Added");
			header.add("Unique", con);
			return new ResponseEntity<PmsAddResponse>(add,header,HttpStatus.CREATED);
		}
		else
		{
			add.setId(con);
			add.setMsg("Product Already Exists");
			return new ResponseEntity<PmsAddResponse>(add,header,HttpStatus.ACCEPTED);
		}		
	}
	
	
	@GetMapping("/getpizza/{pid}")
	public PmsBean getPizzaById(@PathVariable(value="pid")String pid)
	{
		try{
		PmsBean pms= repository.findById(pid).get();
		return pms;
		
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
	
	
	@GetMapping("/getpizza")
	public List<PmsBean> getPizzaByProduct(@RequestParam(value="productname")String pizProduct)
	{
		return repository.findAllByProduct(pizProduct);
	}
	
	
	@PutMapping("/updatepizza/{pid}")
	public ResponseEntity<PmsBean> updatePizza(@PathVariable(value="pid")String pid,@RequestBody PmsBean pms)
	{
		PmsBean pmsrecord= repository.findById(pid).get();
		pmsrecord.setpProduct(pms.getpProduct());
		pmsrecord.setpPrice(pms.getpPrice());
		repository.save(pmsrecord);
		
		return new ResponseEntity<PmsBean>(pmsrecord,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletepizza")
	public ResponseEntity<String> deletePizza(@RequestBody PmsBean pms)
	{
		try {
		PmsBean pmsDel= repository.findById(pms.getpId()).get();
		repository.delete(pmsDel);
		return new ResponseEntity<>("Pizza Record Deleted",HttpStatus.CREATED);
		
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}	
	}
	
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllPizza()
	{
		repository.deleteAll();
		return new ResponseEntity<>("All Product Record Deleted",HttpStatus.CREATED);
	}
}
