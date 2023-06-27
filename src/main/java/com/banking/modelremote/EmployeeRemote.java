package com.banking.modelremote;

import java.util.List;

import com.banking.entity.Employee;

public interface EmployeeRemote 
{
	public String addNewEmployee(Employee employee);
	public Long getMaxID();
	public List<Employee> getAllEmployees();
	public String deleteEmployee(long id);
	public Employee findEmployee(long id);
	public String updateEmployeeDetails(Employee employee);
	public Employee checkEmployeeLogin(int id, String password);
	public String changeEmployeePassword(int id, String password, String curPassword);
	public long getEmployeeCount();
}
