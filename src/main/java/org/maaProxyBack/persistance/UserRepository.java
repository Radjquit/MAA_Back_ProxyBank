package org.maaProxyBack.persistance;

import java.util.List;

import org.maaProxyBack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUsernameAndPassword(String username, String password);

}
