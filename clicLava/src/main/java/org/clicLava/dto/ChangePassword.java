package org.clicLava.dto;

public class ChangePassword {
	
	private String password;
	private String npassword;
	
	// 1. Contrstructores
	public ChangePassword(String password, String npassword) {
		super();
		this.password = password;
		this.npassword = npassword;
	} // constructor 
	
	public ChangePassword() {
		
	} // constructor vacío
	
	// 2. Getters and setter
	public String getPassword() {
		return password;
	} // getPassword

	public void setPassword(String password) {
		this.password = password;
	} // setPassword

	public String getNpassword() {
		return npassword;
	} // getNpassword

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	} // setNpassword
	
	// 3. toString
	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npassword=" + npassword + "]";
	} // toString
	
} // class ChangePassword
