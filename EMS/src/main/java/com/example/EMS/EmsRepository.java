package com.example.EMS;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmsRepository extends JpaRepository<EmsBean, String>,EmsRepositoryCustom
{
	//first parameter is bean class name
	//second parameter is the data type of primary key
}
