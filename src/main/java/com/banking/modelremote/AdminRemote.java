package com.banking.modelremote;

import com.banking.entity.Admin;

public interface AdminRemote 
{
	public Admin checkAdminLogin(String username, String password);
}
