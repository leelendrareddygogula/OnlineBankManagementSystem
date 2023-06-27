package com.banking.modeldata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Employee;
import com.banking.modelremote.EmployeeRemote;
import com.banking.repository.EmployeeRepository;

@Service
public class EmployeeData implements EmployeeRemote
{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public String addNewEmployee(Employee employee) 
	{
		String s = null;
		try
		{
			employeeRepository.save(employee);
			s = "Employee Record Added Successfully! ";
		}
		catch (Exception e) 
		{
			s = "Entry Unsuccessful, May have entered a duplicate value or More Digits than required in Aadhar or Phone Number or Pan Card Number";
			System.out.println(e);
		}
		return s;
	}
	
	@Override
	public Long getMaxID() 
	{
		long empId = employeeRepository.getMaxID();
		return empId;
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees;
	}

	@Override
	public String deleteEmployee(long id) 
	{
		Employee employee = new Employee();
		try
		{
			employee = employeeRepository.findById((int) id).get();
		}
		catch(Exception e)
		{
			employee = null;
		}
		if(employee != null)
		{
			employeeRepository.deleteById((int) id);
			return "Employee Record Deleted Successfully!";
		}
		return "Employee Record Not Found";
	}

	@Override
	public Employee findEmployee(long id) 
	{
		Employee employee = employeeRepository.findById((int) id).get();
		return employee;
	}

	@Override
	public String updateEmployeeDetails(Employee employee) 
	{
		Employee employee2 = new Employee();
		try
		{
			employee2 = employeeRepository.findById((int) employee.getEmployeeId()).get();
		}
		catch(Exception e)
		{
			employee2 = null;
		}
		employee.setAadharNumber(employee2.getAadharNumber());
		employee.setPanCardNumber(employee2.getPanCardNumber());
		employee.setGender(employee2.getGender());
		employee.setName(employee2.getName());
		employee.setPassword(employee2.getPassword());
		if(employee2 != null)
		{
			employeeRepository.save(employee);
			return "Employee Record Updated Successfully!";
		}
		return "Employee Record Not Found";
	}

	@Override
	public Employee checkEmployeeLogin(int id, String password) 
	{
		Employee employee = employeeRepository.checkEmployeeLogin(id, password);
		return employee;
	}

	@Override
	public String changeEmployeePassword(int id, String password, String curPassword) 
	{
		String s = null;
		try
		{
			employeeRepository.updatePassword(id, password, curPassword);
			s = "Password Change is Successfull if you have entered Right Password";
		}
		catch (Exception e) 
		{
			s = "Incorrect Combination";
			System.out.println(e);
		}
		return s;
	}

	@Override
	public long getEmployeeCount() 
	{
		return employeeRepository.count();
	}
	
}
