package repository;

import org.springframework.data.repository.CrudRepository;

import model.Administrator;

public interface AdminRepository extends CrudRepository<Administrator, Integer> {

	
	public Administrator findByUsernameAndPassword(String username, String password);
}