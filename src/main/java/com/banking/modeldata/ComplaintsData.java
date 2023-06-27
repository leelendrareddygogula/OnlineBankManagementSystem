package com.banking.modeldata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Complaints;
import com.banking.modelremote.ComplaintsRemote;
import com.banking.repository.ComplaintsRepository;

@Service
public class ComplaintsData implements ComplaintsRemote
{
	@Autowired
	private ComplaintsRepository complaintsRepository;

	@Override
	public String addNewComplaint(Complaints complaints) 
	{
		try
		{
			complaintsRepository.save(complaints);
			return "Complaint Added Successfully";
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return "Please check for error(s)";
		}
	}
	
	public List<Complaints> getAllComplaints()
	{
		return (List<Complaints>) complaintsRepository.findAll();
	}
	
	public void deleteComplaint(int id)
	{
		complaintsRepository.deleteById(id);
	}

	@Override
	public Complaints getComplaintDetails(int cust) 
	{
		Complaints complaints = new Complaints();
		complaints = complaintsRepository.getComplaintDetails(cust);
		return complaints;
	}
	
}
