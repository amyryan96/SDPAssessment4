package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Customer;
import service.CustomerService;

public class RestController {
	
	@Autowired
	private CustomerService custService;
	
	
	/*@GetMapping("/")
	public String hello()
	{
		return "This is the Home Page";
	}*/
	
	@GetMapping("/savecust")
	public String saveCust(@RequestParam String  username, @RequestParam String password, @RequestParam String address)
	{
		
		Customer cust = new Customer(username, password, address);
		custService.saveCust(cust);
		return "Customer is Saved";
	}

}