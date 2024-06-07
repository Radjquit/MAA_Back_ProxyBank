package org.maaProxyBack.service;

import org.maaProxyBack.model.User;
import org.maaProxyBack.persistance.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository dao;
	
	public UserServiceImpl(UserRepository dao) {
		this.dao = dao;
	}

	@Override
	public User signin(User user) {
        System.out.println(user.toString()+ "Persistance");
		return dao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public User save(User user) {
		return dao.save(user);
	}

}
