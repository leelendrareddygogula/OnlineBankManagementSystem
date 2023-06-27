package com.banking.modelremote;

import java.util.List;

import com.banking.entity.Complaints;

public interface ComplaintsRemote 
{
	public String addNewComplaint(Complaints complaints);
	public List<Complaints> getAllComplaints();
	public void deleteComplaint(int id);
	public Complaints getComplaintDetails(int cust);
}
