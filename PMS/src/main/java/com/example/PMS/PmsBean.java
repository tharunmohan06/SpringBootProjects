package com.example.PMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name="pmstab")

public class PmsBean {
	
	@Id
	@Column(name="pid")	
	private String pId;
	
	@Column(name="pproduct")
	private String pProduct;
	
	@Column(name="pprice")
	private String pPrice;
	
	public String getpProduct() {
		return pProduct;
	}
	
	public void setpProduct(String pProduct) {
		this.pProduct = pProduct;
	}
	
	public String getpId() {
		return pId;
	}
	
	public void setpId(String pId) {
		this.pId = pId;
	}
	
	public String getpPrice() {
		return pPrice;
	}
	
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
}
