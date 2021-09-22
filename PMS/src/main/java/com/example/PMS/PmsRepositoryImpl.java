package com.example.PMS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PmsRepositoryImpl implements PmsRepositoryCustom{

	@Autowired
	PmsRepository repository;
	
	@Override
	public List<PmsBean> findAllByProduct(String pizProduct) {
		
		List<PmsBean> pProducts= new ArrayList<PmsBean>();
		List<PmsBean> records= repository.findAll();
		
		for(PmsBean items: records)
		{
			if(items.getpProduct().equalsIgnoreCase(pizProduct))
			{
				pProducts.add(items);
			}
		}
		return pProducts;
	}
}
