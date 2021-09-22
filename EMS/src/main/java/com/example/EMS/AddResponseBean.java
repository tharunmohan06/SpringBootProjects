package com.example.EMS;

import org.springframework.stereotype.Component;

@Component
public class AddResponseBean {
	
	private String msg;
	private String eid;
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getEid() {
		return eid;
	}
	
	public void setEid(String eid) {
		this.eid = eid;
	}
}
