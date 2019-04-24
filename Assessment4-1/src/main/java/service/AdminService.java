package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Administrator;
import repository.AdminRepository;

@Service

public class AdminService {
	
private final AdminRepository adminRepository;

public AdminService(AdminRepository adminRepository)
{
	this.adminRepository= adminRepository;
}
	
	public void saveMyAdmin(Administrator admin)
	{
		adminRepository.save(admin);
	}
	
	public List<Administrator> showAllAdministrators()
	{
		List<Administrator> admins = new ArrayList<Administrator>();
		for(Administrator admin:adminRepository.findAll())
		{
			admins.add(admin);
		}
		return admins;
	}

	public void editAdmin(int id)
	{
		adminRepository.findById(id);
	}
	
	public Administrator findByUsernameAndPassword(String username, String password)
	{
		return adminRepository.findByUsernameAndPassword(username, password);
	}
}