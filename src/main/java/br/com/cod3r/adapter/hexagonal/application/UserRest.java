package br.com.cod3r.adapter.hexagonal.application;

import br.com.cod3r.adapter.hexagonal.core.model.User;
import br.com.cod3r.adapter.hexagonal.core.ports.UserRepository;
import br.com.cod3r.adapter.hexagonal.core.usecases.UserService;
import br.com.cod3r.adapter.hexagonal.infrastructure.UserMemoryDatabaseAdapter;

import java.util.Map;

public class UserRest {

	private UserService userService;
	
	public UserRest() {
		UserRepository userRepository = new UserMemoryDatabaseAdapter();
		userService = new UserService(userRepository);
	}

	public Integer post(Map<String, String> values) {
		User user = new User(values.get("name"), values.get("email"), values.get("password"));
		userService.saveUser(user);
		return 201;
	}
	
	public Integer get() {
		userService.getAllUsers().forEach(System.out::println);
		return 200;
	}
}
