package com.example.PMS;

import java.util.List;

public interface PmsRepositoryCustom {
	
	List<PmsBean> findAllByProduct(String pizProduct);

}
