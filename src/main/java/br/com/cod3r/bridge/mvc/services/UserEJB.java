package br.com.cod3r.bridge.mvc.services;

import br.com.cod3r.bridge.mvc.dao.UserDao;
import br.com.cod3r.bridge.mvc.model.User;

public class UserEJB extends UserService {

	public UserEJB(UserDao userDao) {
		super(userDao);
	}

	@Override
	public void save(User user) {
		System.out.println("Starting a save operation through EJB Protocol!");
		userDao.save(user);
	}
}
