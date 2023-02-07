package com.techpalle;

public class StudentData 
{
	
	private int sno;
	private String sname;
	private String sub;
	private String email;
	
	public StudentData(int sno, String sname, String sub, String email) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sub = sub;
		this.email = email;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "StudentData [sno=" + sno + ", sname=" + sname + ", sub=" + sub + ", email=" + email + "]";
	} 
}
