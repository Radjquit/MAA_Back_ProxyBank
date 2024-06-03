package org.maaProxyBack.service;

import org.maaProxyBack.model.User;
import org.maaProxyBack.persistance.UserPersistance;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private UserPersistance dao;
	
	public UserServiceImpl(UserPersistance dao) {
		this.dao = dao;
	}

	@Override
	public User signin(User user) {
		return dao.signin(user);
	}

}
