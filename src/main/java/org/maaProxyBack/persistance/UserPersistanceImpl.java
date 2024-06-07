package org.maaProxyBack.persistance;

import java.util.HashMap;

import org.maaProxyBack.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserPersistanceImpl implements UserPersistance{
    private UserRepository userRepo;

    
    public UserPersistanceImpl(UserRepository userRepo) {
    	this.userRepo = userRepo;
    }

	


	@Override
	public User signin(User user) {
        System.out.println(user.toString()+ "Persistance");
		return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());

	}

}
