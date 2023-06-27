package com.banking.modeldata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Admin;
import com.banking.modelremote.AdminRemote;
import com.banking.repository.AdminRepository;

@Service
public class AdminData implements AdminRemote
{
	@Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin checkAdminLogin(String username, String password) 
	{
		Admin admin = adminRepository.checkLoginCredentials(username, password);
		return admin;
	}
	
}
