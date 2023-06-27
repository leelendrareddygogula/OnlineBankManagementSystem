package com.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin 
{
	@Id
	@Column(unique = true, nullable = false, length = 20)
	private String username;
	@Column(nullable = false, length = 20)
	private String password;
}
