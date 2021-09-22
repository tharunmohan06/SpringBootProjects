package com.example.PMS;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmsAddService {
	
	@Autowired
	PmsRepository repository;
	
	public boolean checkIfProductExist(String pid)
	{
		Optional<PmsBean> pms= repository.findById(pid);
		
		if(pms.isPresent())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
