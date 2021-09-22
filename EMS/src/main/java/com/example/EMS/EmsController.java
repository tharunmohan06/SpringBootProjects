package com.example.EMS;

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
public class EmsController {
	
	AtomicInteger counter= new AtomicInteger();
	@Autowired
	EmsRepository repository;
	
	@Autowired
	AddServiceBean emsservice;
	
	
	@GetMapping("/getEmployee/{eid}")
	public EmsBean getEmployeeById(@PathVariable(value="eid")String eid)
	{
		try {
			EmsBean ems= repository.findById(eid).get();
			return ems;			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}	
	}
	
	
	@GetMapping("/getEmployee")
	public List<EmsBean> getEmployeeByName(@RequestParam(value="EmployeeName")String empName)
	{
	  return repository.findAllByEname(empName);
	}
	
	
	@PostMapping("/addEmployee")
	public ResponseEntity<AddResponseBean> addEmployee(@RequestBody EmsBean ems)
	{
		HttpHeaders header= new HttpHeaders();
		AddResponseBean add= new AddResponseBean();
		String con= ems.geteName()+counter.getAndIncrement();

		if (!emsservice.checkEmpAlreadyExist(con))
		{
			ems.seteId(con);
			repository.save(ems);
			
			add.setEid(con);
			add.setMsg("Success: Employee is Added");
			header.add("Unique", con);
			return new ResponseEntity<AddResponseBean>(add,header,HttpStatus.CREATED);
		}
		else
		{
			add.setEid(con);
			add.setMsg("Employee Already Exists");
			header.add("Unique", con);
			return new ResponseEntity<AddResponseBean>(add,header,HttpStatus.ACCEPTED);
		}
	}
	
	
	@PutMapping("/updateEmployee/{eid}")
	public ResponseEntity<EmsBean> updateEmployee(@PathVariable(value="eid")String eid,@RequestBody EmsBean ems)
	{
		EmsBean emsrecord= repository.findById(eid).get();
		emsrecord.seteName(ems.geteName());
		emsrecord.seteSal(ems.geteSal());
		repository.save(emsrecord);
		
		return new ResponseEntity<EmsBean>(emsrecord,HttpStatus.OK);		
	}
	 
	
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<String> deleteEmployee(@RequestBody EmsBean ems)
	{
		try {
			EmsBean emsdel= repository.findById(ems.geteId()).get();
			repository.delete(emsdel);
			return new ResponseEntity<>("Employee Record Deleted",HttpStatus.CREATED);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}			
	}
	

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllEmployees()
	{
		repository.deleteAll();
		return new ResponseEntity<>("All Employee Record Deleted",HttpStatus.CREATED);
	}
}
