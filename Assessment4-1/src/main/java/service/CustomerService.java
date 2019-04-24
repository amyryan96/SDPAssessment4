package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Administrator;
import model.Customer;
import repository.AdminRepository;
import repository.CustomerRepository;

@Service

public class CustomerService {
	
private final CustomerRepository custRepository;

public CustomerService(CustomerRepository custRepository)
{
	this.custRepository = custRepository;
}
	
	public void saveCust(Customer cust)
	{
		custRepository.save(cust);
	}
	
	public List<Customer> showAllCustomers()
	{
		List<Customer> custs = new ArrayList<Customer>();
		for(Customer cust:custRepository.findAll())
		{
			custs.add(cust);
		}
		return custs;
	}

	public void editCust(int id)
	{
		custRepository.findById(id);
	}
	
	public Customer findByUsernameAndPassword(String username, String password)
	{
		return custRepository.findByUsernameAndPassword(username, password);
	}
}