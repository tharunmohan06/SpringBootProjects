package com.example.EMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name="emstab")

public class EmsBean {
	
	@Id
	@Column(name="eid")
	private String eId;
	
	@Column(name="ename")
	private String eName;
	
	@Column(name="esal")
	private String eSal;
	
	public String geteId() {
		return eId;
	}
	
	public void seteId(String eId) {
		this.eId = eId;
	}
	
	public String geteName() {
		return eName;
	}
	
	public void seteName(String eName) {
		this.eName = eName;
	}
	
	public String geteSal() {
		return eSal;
	}
	
	public void seteSal(String eSal) {
		this.eSal = eSal;
	}
}
