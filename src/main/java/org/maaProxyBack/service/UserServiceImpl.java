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
		String role;
		if ("manager".equals(user.getRole())) {
			role = "manager";
			return dao.findByUsernameAndPasswordAndRole(user.getUsername(), user.getPassword(), role);			
		}
		else if ("advisor".equals(user.getRole())) {
			role = "advisor";
			return dao.findByUsernameAndPasswordAndRole(user.getUsername(), user.getPassword(), role);			
		} else {
			return null;
			
		}
	}

	@Override
	public User save(User user) {
		return dao.save(user);
	}


}
