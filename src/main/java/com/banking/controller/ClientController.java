package com.banking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.entity.Account;
import com.banking.entity.Admin;
import com.banking.entity.Complaints;
import com.banking.entity.Customer;
import com.banking.entity.Employee;
import com.banking.entity.Transaction;
import com.banking.modelremote.AccountRemote;
import com.banking.modelremote.AdminRemote;
import com.banking.modelremote.ComplaintsRemote;
import com.banking.modelremote.CustomerRemote;
import com.banking.modelremote.EmployeeRemote;
import com.banking.modelremote.TransactionRemote;

@Controller
public class ClientController 
{
	@Autowired
	private AdminRemote adminRemote;
	@Autowired
	private EmployeeRemote employeeRemote;
	@Autowired
	private CustomerRemote customerRemote;
	@Autowired
	private AccountRemote accountRemote;
	@Autowired
	private ComplaintsRemote complaintsRemote;
	@Autowired
	private TransactionRemote transactionRemote;
	
	@GetMapping("/")
	public String navigateToHome()
	{
		return "index";
	}
	
	@GetMapping("/home")
	public String navigateToHomeURL()
	{
		return "index";
	}
	
	@GetMapping("/checkadminlogin")
	public ModelAndView navigateToAdminLogin()
	{
		ModelAndView modelAndView = new ModelAndView("adminlogin");
		return modelAndView;
	}
	
	@PostMapping("/admin")
	public ModelAndView checkAdminLogin(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		String username = request.getParameter("adminusername");
		String password = request.getParameter("adminpassword");
		Admin admin = new Admin();
		admin = adminRemote.checkAdminLogin(username, password);
		if(admin != null)
		{
			modelAndView.setViewName("adminHome");
		}
		else
		{
			modelAndView.setViewName("adminlogin");
			modelAndView.addObject("adminerrormessage", "Incorrect Combination");
		}
		return modelAndView;
	}
	
	@GetMapping("/admin/addemployee")
	public ModelAndView addEmployeeNavigation()
	{
		ModelAndView modelAndView = new ModelAndView("addEmployee", "employee", new Employee());
		return modelAndView;
	}
	
	@PostMapping("/admin/addnewemployee")
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee)
	{
		ModelAndView modelAndView = new ModelAndView();
		String outmessage = employeeRemote.addNewEmployee(employee);
		modelAndView.setViewName("addEmployee");
		Long maxEmpId = employeeRemote.getMaxID();
		modelAndView.addObject("message", outmessage + " with ID "+ maxEmpId);
		return modelAndView;
	}
	
	@GetMapping("/adminhome")
	public ModelAndView navigateToAdminHome()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminHome");
		return modelAndView;
	}
	
	@GetMapping("/admin/updateemployee")
	public String updateEmployee()
	{
		return "UpdateEmployee";
	}
	
	@PostMapping("/admin/updateemployeerecord")
	public ModelAndView updateEmployeeRecord(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = new Employee();
		int id = Integer.parseInt(request.getParameter("updateempid"));
		String city = request.getParameter("updateempcity");
		String doorno = request.getParameter("updateempdoorno");
		String landmark = request.getParameter("updateemplandmark");
		String pincode = request.getParameter("updateemppincode");
		String contactNum = request.getParameter("updateempcontnum");
		employee.setEmployeeId(id);
		employee.setCity(city);
		employee.setDoorNo(doorno);
		employee.setLandmark(landmark);
		employee.setPincode(pincode);
		employee.setContactNumber(contactNum);
		String string = employeeRemote.updateEmployeeDetails(employee);
		modelAndView.setViewName("UpdateEmployee");
		modelAndView.addObject("updatemsg", string);
		 return modelAndView;
	}
	
	@GetMapping("/admin/deleteemployee")
	public String deleteEmployee() 
	{
		return "DeleteEmployee";
	}
	
	@PostMapping("/admin/deleteemployeerecord")
	public ModelAndView deleteEmployeeRecord(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		long deleteEmp = Long.parseLong(request.getParameter("deleteemployeeid"));
		String st = employeeRemote.deleteEmployee(deleteEmp);
		modelAndView.setViewName("DeleteEmployee");
		modelAndView.addObject("empdelmsg", st);
		return modelAndView;
	}
	@GetMapping("/admin/getallemployeedetails")
	public ModelAndView getAllEmployees()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GetAllEmployeeDetails");
		List<Employee> employees = employeeRemote.getAllEmployees();
		modelAndView.addObject("employees", employees);
		return modelAndView;
	}
	
	@GetMapping("/admin/dashboard")
	public ModelAndView adminDashBoard()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AdminDashboard");
		modelAndView.addObject("accountscount", accountRemote.getCountOfAccounts());
		modelAndView.addObject("customerscount", customerRemote.getAllCustomersCount());
		modelAndView.addObject("transactionscount", transactionRemote.getAllTransactionsCount());
		modelAndView.addObject("employeecount", employeeRemote.getEmployeeCount());
		return modelAndView;
	}
	
	@GetMapping("/checkemployeelogin")
	public String navigateToEmployeeLogin()
	{
		return "EmployeeLogin";
	}
	
	@PostMapping("/employee")
	public ModelAndView checkEmployeeLogin(HttpServletRequest request) 
	{
		ModelAndView modelAndView = new ModelAndView();
		int id =  Integer.parseInt(request.getParameter("employeeloginid"));
		String passsword = request.getParameter("employeeloginpassword");
		Employee employee = employeeRemote.checkEmployeeLogin(id, passsword);
		if(employee != null)
		{
			modelAndView.setViewName("EmployeeHome");
			modelAndView.addObject("employeeid", id);
		}
		else
		{
			modelAndView.addObject("emploginfail", "Incorrect Comination");
			modelAndView.setViewName("EmployeeLogin");
		}
		return modelAndView;
	}
	
	@GetMapping("/employee/home")
	public String navigateToEmployeeHome() 
	{
		return "EmployeeHome";
	}
	@GetMapping("/employee/changepassword")
	public ModelAndView navigateToChangeEmployeePassword(/*@RequestParam("id") int id*/)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ChangePassword");
//		modelAndView.addObject("empidval", id);
		return modelAndView;
	}
	
	@PostMapping("/employee/changepwd")
	public ModelAndView changeEmployeePassword(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("empid"));
		String currPwd = request.getParameter("empcurpwd");
		String newPwd = request.getParameter("emppwd");
		try
		{
			String s = employeeRemote.changeEmployeePassword(id, newPwd, currPwd);
			modelAndView.setViewName("EmployeeLogin");
		}
		catch(Exception e)
		{
			System.out.println(e);
			modelAndView.addObject("empidval", id);
			modelAndView.addObject("updmsg", "Incorrect Password");
			modelAndView.setViewName("ChangePassword");
		}
		return modelAndView;
	}
	
	@GetMapping("/employee/newcutomeraccount/customerdetails")
	public ModelAndView navigateToNewCustomerAccount(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("CustomerDetails", "customerdetails", new Customer());
		return modelAndView;
	}
	
	@PostMapping("/employee/newcutomeraccount/customeraccount")
	public ModelAndView saveCustomerDetails(@ModelAttribute("customerdetails") Customer customer)
	{
		ModelAndView modelAndView = new ModelAndView();
		String s = customerRemote.addNewCustomer(customer);
		String us = "Customer Record Added Successfully";
		if(s.equals(us))
		{
			int id = customerRemote.getMaxCustomerID();
			modelAndView.setViewName("CustomerAccountDetails");
			modelAndView.addObject("custID", id);
		}
		else
		{
			modelAndView.setViewName("CustomerDetails");
			modelAndView.addObject("customerdetailserrmsg", s);
		}
		return modelAndView;
	}
	
	@GetMapping("/employee/newaccountforcustomer")
	public ModelAndView navigateToAddOnlyAccountForExistingCustomer()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("NewAccountForExistingCustomer");
		modelAndView.addObject("cidlist", customerRemote.getAllCustomerIDS());
		return modelAndView;
	}
	
	@PostMapping("/employee/existingcustomernewaccount")
	public ModelAndView addOnlyAccountForExistingCustomer(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		String branch = request.getParameter("branchname");
		double balance = Double.parseDouble(request.getParameter("openbalance"));
		int custId = Integer.parseInt(request.getParameter("customerid"));
		Account account = new Account();
		account.setBalance(balance);
		account.setBranch(branch);
		account.setCustomerId(custId);
		String s = accountRemote.createCustomerAccount(account);
		int accNum = accountRemote.getMaxAccountNumber();
		if(s.equals("Account Created Successfully"))
		{
			modelAndView.setViewName("AccountCreationSuccessful");
			modelAndView.addObject("accountcreation", s + " with account Number " + accNum);
		}
		else
		{
			modelAndView.setViewName("NewAccountForExistingCustomer");
			modelAndView.addObject("cidlist", customerRemote.getAllCustomerIDS());
			modelAndView.addObject("accountcreation", s);
		}
		return modelAndView;
	}
	
	@PostMapping("/employee/customeraccountdetails")
	public ModelAndView createNewCustomerAccount(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		Account account = new Account();
		String branchName = request.getParameter("branchname");
		double openingBalance = Double.parseDouble(request.getParameter("openbalance"));
		int customerId = Integer.parseInt(request.getParameter("customerid"));
		account.setBalance(openingBalance);
		account.setCustomerId(customerId);
		account.setBranch(branchName);
		String s = accountRemote.createCustomerAccount(account);
		String sam = "Account Created Successfully";
		int accNum = accountRemote.getMaxAccountNumber();
		if(s.equals(sam))
		{
			modelAndView.setViewName("AccountCreationSuccessful");
			modelAndView.addObject("accountcreation", s + " with account Number " + accNum);
		}
		else
		{
			modelAndView.addObject("accountcreation", s);
			modelAndView.addObject("custID", customerId);
			modelAndView.setViewName("CustomerAccountDetails");
		}
		return modelAndView;
	}
	
	
	
	@GetMapping("/employee/getcustomerdetails")
	public String navigateToCustomerAndAccountDetails(HttpServletRequest request)
	{
		return "ViewAccountAndCustomerDetails";
	}
	
	@PostMapping("/employee/customerandaccountdetailslist")
	public ModelAndView getCustomerAccountandCustomerDetails(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		int custId = Integer.parseInt(request.getParameter("customergetid"));
		Customer customer = customerRemote.getCustomerDetails(custId);
		if(customer != null)
		{
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customer);
			modelAndView.setViewName("ViewCustomerAccountsAndDetailsList");
			modelAndView.addObject("cid",custId);
			modelAndView.addObject("customers",customers);
			List<Account> accounts = accountRemote.allAccounts(custId);
			modelAndView.addObject("accounts", accounts);
		}
		else
		{
			modelAndView.setViewName("ViewAccountAndCustomerDetails");
			modelAndView.addObject("invlmsg","Customer ID not found");
		}
		return modelAndView;
	}
	
	@GetMapping("/employee/maketransaction")
	public String navigateToTransactionPage()
	{
		return "MakeATransaction";
	}
	
	@PostMapping("/employee/transaction")
	public ModelAndView makeATransaction(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("TransactionStatus");
		Long fromAccount = Long.parseLong(request.getParameter("fromaccount"));
		Long toAccount = Long.parseLong(request.getParameter("toaccount"));
		double amount = Double.parseDouble(request.getParameter("transferamount"));
		String s = transactionRemote.makeTransaction(fromAccount, toAccount, amount);
		modelAndView.addObject("transactionmsg", s);
		return modelAndView;
	}
	
	@GetMapping("/employee/addordeductfunds")
	public ModelAndView navigateToCustomerFundsPage()
	{
		ModelAndView modelAndView = new ModelAndView("AddOrRemoveFunds");
		List<Account> accounts = accountRemote.getAllAccounts();
		modelAndView.addObject("accounts", accounts);
		return modelAndView;
	}
	
	@PostMapping("/employee/crdrfunds")
	public ModelAndView makeCreditOrDebit(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		String operation = request.getParameter("operation");
		long accnum = Long.parseLong(request.getParameter("accountnumber"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		modelAndView.setViewName("AddOrRemoveFunds");
		modelAndView.addObject("accounts", accountRemote.getAllAccounts());
		if(operation.equals("credit"))
		{
			if(accountRemote.getAccountById(accnum) != null)
			{
				Account account = accountRemote.getAccountById(accnum);
				account.setBalance(amount + account.getBalance());
				accountRemote.createCustomerAccount(account);
				modelAndView.addObject("transactionmsg", "Funds Added Successfully");
			}
			else
			{
				modelAndView.addObject("transactionmsg", "Please Select Account Number");
			}
		}
		else if(operation.equals("debit")) 
		{
			if(accountRemote.getAccountById(accnum) != null)
			{
				Account account = accountRemote.getAccountById(accnum);
				double currbalance = account.getBalance();
				if((currbalance - amount) > 0)
				{
					account.setBalance(currbalance - amount);
					accountRemote.createCustomerAccount(account);
					modelAndView.addObject("transactionmsg", "Amount Withdrawl is Successfull");
				}
				else
				{
					modelAndView.addObject("transactionmsg", "Insufficient Funds For Withdrawal");
				}
			}
			else
			{
				modelAndView.addObject("transactionmsg", "Please Select Account Number");
			}
		}
		else
		{
			modelAndView.addObject("transactionmsg", "Select A Valid Transaction Operation");
		}
		return modelAndView;
	}
	@GetMapping("/checkcustomerlogin")
	public String navigateToCustomerLogin()
	{
		return "CustomerLogin";
	}
	
	@PostMapping("/customer")
	public ModelAndView checkCustomerLogin(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		int custId = Integer.parseInt(request.getParameter("logincustomerid"));
		String custPass = request.getParameter("logincustomerpassword");
		Customer customer = new Customer();
		customer = customerRemote.getCustomerDetails(custId);
		if(customer != null && customer.getPassword().equals(custPass))
		{
			modelAndView.setViewName("CustomerHome");
			modelAndView.addObject("c", customer);
		}
		else
		{
			modelAndView.setViewName("CustomerLogin");
			modelAndView.addObject("errormess", "Invalid Combination");
		}
		return modelAndView;
	}
	
	@GetMapping("/customer/home")
	public ModelAndView naviagateToCustomerHome(@RequestParam("custid") int cid)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CustomerHome");
		modelAndView.addObject("c", customerRemote.getCustomerDetails(cid));
		return modelAndView;
	}
	
	@GetMapping("/customer/updatecustomerpassword")
	public ModelAndView naviagateToCustomerProfileUpdate(@RequestParam("custid") int cid)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdateCustomerProfile");
		Customer customer = customerRemote.getCustomerDetails(cid);
		modelAndView.addObject("c",customer);
		modelAndView.addObject(modelAndView);
		return modelAndView;
	}
	
	@PostMapping("/customer/changepassword")
	public ModelAndView changeCustomerPassword(@RequestParam("custid") int cid, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		Customer customer = customerRemote.getCustomerDetails(cid);
		String currpwd = request.getParameter("currpwd");
		String newpwd = request.getParameter("newpwd");
		if(customer.getPassword().equals(currpwd))
		{
			customer.setPassword(newpwd);
			customerRemote.addNewCustomer(customer);
			modelAndView.setViewName("CustomerLogin");
			modelAndView.addObject("errormess", "Password Changed Successfully, Please Login again with your new password");
		}
		else
		{
			modelAndView.setViewName("CustomerLogin");
			modelAndView.addObject("errormess", "Incorrect Current Password, Please Login Again");
		}
		return modelAndView;
	}
	
	@GetMapping("/customer/transactions")
	public ModelAndView navigateToSelectAccount(@RequestParam("custid") int cid)
	{
		ModelAndView modelAndView = new ModelAndView();
		List<Account> accounts = accountRemote.allAccounts(cid);
		modelAndView.setViewName("SelectAccountForTransactions");
		modelAndView.addObject("accounts", accounts);
		modelAndView.addObject("c", customerRemote.getCustomerDetails(cid));
		return modelAndView;
	}
	
	@PostMapping("/customer/getalltransations")
	public ModelAndView getAllAccountTransactions(@RequestParam("custid") int cid, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CustomerTransactions");
		Customer customer = customerRemote.getCustomerDetails(cid);
		modelAndView.addObject("c", customer);
		long accountnum = Long.parseLong(request.getParameter("accountnum"));
		List<Transaction> transactions = transactionRemote.getAllTransactionsOfAccount(accountnum);
		modelAndView.addObject("transactions",transactions);
		return modelAndView;
	}
	
	@GetMapping("/customer/maketransaction")
	public ModelAndView navigateToTransactionPageOfCustomer(@RequestParam("custid") long cid)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("SelectTransactionAccount");
		modelAndView.addObject("c", customerRemote.getCustomerDetails((int) cid));
		List<Account> accounts = accountRemote.allAccounts((int)cid);
		modelAndView.addObject("accounts", accounts);
		return modelAndView;
	}
	
	@PostMapping("/customer/entertransactiondetails")
	public ModelAndView enterAccountDetails(HttpServletRequest request, @RequestParam("custid") long cid)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CustomerTransaction");
		modelAndView.addObject("c", customerRemote.getCustomerDetails((int) cid));
		long fromAccount = Long.parseLong(request.getParameter("acnum"));
		modelAndView.addObject("fromaccount", fromAccount);
		return modelAndView;
	}
	
	@PostMapping("/customer/transaction")
	public ModelAndView makeTransaction(@RequestParam("custid") long cid, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CustomerTransactionStatus");
		modelAndView.addObject("c", customerRemote.getCustomerDetails((int) cid));
		long fromAccount = Long.parseLong(request.getParameter("fromtransfer"));
		long toAccount = Long.parseLong(request.getParameter("totransfer"));
		double balance = Double.parseDouble(request.getParameter("amountfortrans"));
		String s = transactionRemote.makeTransaction(fromAccount, toAccount, balance);
		modelAndView.addObject("transactionmsg",s);
		return modelAndView;
	}
	
	@GetMapping("/helpdesk")
	public String navigateToHelpDesk()
	{
		return "Helpdesk";
	}
	
	@GetMapping("/feedback")
	public String navigateToFeedBack()
	{
		return "Feedback";
	}
}
