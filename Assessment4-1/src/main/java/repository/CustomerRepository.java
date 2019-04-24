package repository;

import org.springframework.data.repository.CrudRepository;

import model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	
	public Customer findByUsernameAndPassword(String username, String password);
}