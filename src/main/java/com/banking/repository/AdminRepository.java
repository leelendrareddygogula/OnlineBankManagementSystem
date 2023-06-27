package com.banking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String>
{
	@Query("select a from Admin a where username=?1 and password=?2")
	public Admin checkLoginCredentials(String username, String password);
}
