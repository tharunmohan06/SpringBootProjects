package com.example.EMS;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class EmsApplicationTests {
	
	AtomicInteger counter= new AtomicInteger();

	@Autowired
	EmsController con;
	
	@MockBean
	EmsRepository repository;
	
	@MockBean
	AddServiceBean service;
	
	void contextLoads() {
	
	}
	
	
	@Test
	public void addEmployeeMock()
	{
		//when(service.checkEmpAlreadyExist(EmsBeanDataPayload().geteName()+counter.getAndIncrement())).thenReturn(false);
		when(service.checkEmpAlreadyExist(EmsBeanDataPayload().geteName()+counter.getAndIncrement())).thenReturn(true);
				
		ResponseEntity resp= con.addEmployee(EmsBeanDataPayload());
		System.out.println(resp.getStatusCode());
		//assertEquals(resp.getStatusCode(), HttpStatus.CREATED);
		assertEquals(resp.getStatusCode(), HttpStatus.ACCEPTED);
		  	  
		AddResponseBean ad=(AddResponseBean) resp.getBody();
		//assertEquals("Success: Employee is Added", ad.getMsg());
		assertEquals("Employee Already Exists", ad.getMsg());
	}
	
	
	public EmsBean EmsBeanDataPayload()
	{
		EmsBean ems= new EmsBean();
		ems.seteName("Sonu");
		ems.seteSal("50000");
		return ems;
	}

}
