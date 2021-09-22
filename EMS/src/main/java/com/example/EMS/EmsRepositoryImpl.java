package com.example.EMS;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EmsRepositoryImpl implements EmsRepositoryCustom{
	
	@Autowired
	EmsRepository repository;
	
	@Override
	public List<EmsBean> findAllByEname(String eName) {
		
		List<EmsBean> eNames= new ArrayList<EmsBean>();
		List<EmsBean> emprecords= repository.findAll();
		
		for (EmsBean items: emprecords)
		{
			if(items.geteName().equalsIgnoreCase(eName))
			{
				eNames.add(items);
			}
		}
		
		return eNames;	
	}
}
