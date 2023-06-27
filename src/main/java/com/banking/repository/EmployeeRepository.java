package com.banking.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{
	@Query("select max(employeeId) from Employee")
	public long getMaxID();
	
	@Query("select e from Employee e where employeeId = ?1 and password = ?2")
	public Employee checkEmployeeLogin(int id, String password);
	
	@Transactional
	@Modifying
	@Query("update Employee e set e.password = ?2 where e.employeeId =?1 and e.password = ?3")
	public int updatePassword(int id, String newPassword, String currPassword);
}
