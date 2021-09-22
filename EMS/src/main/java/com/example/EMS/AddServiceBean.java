package com.example.EMS;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddServiceBean {

	@Autowired
	EmsRepository repository;
	
	public boolean checkEmpAlreadyExist(String eid)
	{
		Optional<EmsBean> ems= repository.findById(eid);
		
		if (ems.isPresent())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
