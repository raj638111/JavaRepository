package com.rj.a7_DOMAIN;

public class Department {

	private int departmentId;
	private String departmentName;
	
	//Default Constructor
	public Department() {
		//# http://stackoverflow.com/questions/7625783/jsonmappingexception-no-suitable-constructor-found-for-type-simple-type-class
	}
	
	//Constructor
	public Department(int id, String name) {
		this.departmentId = id;
		this.departmentName = name;
	}
	
	//Department ID
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	//Department Name
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
