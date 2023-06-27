package com.banking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.banking.entity.Complaints;

public interface ComplaintsRepository extends CrudRepository<Complaints, Integer>
{
	@Query("select compl from Complaints compl where id=?1")
	public Complaints getComplaintDetails(int custId);
}
