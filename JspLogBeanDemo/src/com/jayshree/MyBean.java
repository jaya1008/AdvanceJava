package com.jayshree;

public class MyBean {

	private String uname, pname;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public boolean validate(){
		if(uname.equals("admin") && pname.equals("1234")){
			return true;
		}
		
		return false;
	}
}
