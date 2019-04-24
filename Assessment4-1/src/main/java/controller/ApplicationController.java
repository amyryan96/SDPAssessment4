package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Customer;
import service.CustomerService;

@Controller
public class ApplicationController {

	@Autowired
	CustomerService custService;
	
	@RequestMapping("/")
	public String welcome(HttpServletRequest request)
	{
		//request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request)
	{
		request.setAttribute("mode", "MODE_REGISTER");
		return "register";
	}
	
	@PostMapping("/savecust")
	public String registerCust(@ModelAttribute Customer cust, BindingResult bindingResult, HttpServletRequest request)
	{
		custService.saveCust(cust);
		request.setAttribute("mode", "MODE_HOME");
		return "customerHP";
	}
	
	@GetMapping("/showcusts")
	public String showAllCustomer(HttpServletRequest request)
	{
		request.setAttribute("custs", custService.showAllCustomers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	/*@RequestMapping("/editcust")
	public String editCust(@RequestParam int id, HttpServletRequest request)
	{
		request.setAttribute("custs", custService.editCust(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	*/
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		request.setAttribute("mode", "MODE_LOGIN");
		return "login";
	}
	
	@RequestMapping("/logincust")
	public String loginCust(@ModelAttribute Customer cust, HttpServletRequest request)
	{
		String username = cust.getUsername();
		String password = cust.getPassword();
		
		if(custService.findByUsernameAndPassword(username,password)!=null)
		{
			cust = custService.findByUsernameAndPassword(username,password);
			HttpSession session = request.getSession();
			session.setAttribute("cust", cust);
			if(request.getParameter("username").equalsIgnoreCase("admin@gmail.com")) {
				return "homepage";
			}else {
				return "customerHP";
			}
		
		}
		else {
			request.setAttribute("error", "I'm sorry this Username or Password is incorrect");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}
	}
}