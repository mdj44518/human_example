package org.study.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Student {
	private String sName;
	private String sId;
	private String sPw;
	private String address;
	private String email;
	private Date birthDay;
	private int majorCode;

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsPw() {
		return sPw;
	}

	public void setsPw(String sPw) {
		this.sPw = sPw;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public void setBirthDay(String birthDay) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date date = sdFormat.parse(birthDay);
			this.birthDay = new Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(int majorCode) {
		this.majorCode = majorCode;
	}

	@Override
	public String toString() {
		return "Student [sName=" + sName + ", sId=" + sId + ", address=" + address + ", email=" + email + ", birthDay="
				+ birthDay + ", majorCode=" + majorCode + "]";
	}

}
