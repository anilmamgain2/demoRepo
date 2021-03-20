package com.test;

public class Employee {

	private String name;
	
	private String empId;
	
	private Integer salary;
	
	private String dept;
	
	private char gender;

	public Employee(String name, String empId, Integer salary, String dept,char gender) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
		this.dept = dept;
		this.gender=gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", salary=" + salary + ", dept=" + dept + ", gender="
				+ gender + "]";
	}

	
}
