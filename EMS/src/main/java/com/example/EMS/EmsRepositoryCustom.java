package com.example.EMS;

import java.util.List;

public interface EmsRepositoryCustom {
	
	List<EmsBean> findAllByEname(String eName);
}
