package org.maaProxyBack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.maaProxyBack.persistance.ClientPersistance;
import org.maaProxyBack.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MaaProxyBackApplicationTests {
	@Autowired
	ClientPersistance repo;
	private ClientServiceImpl service;
	
	@BeforeEach
	public void setUp() {
		service = new ClientServiceImpl();
		service.setDao(repo);
	}
	
	@Test
	void save_should_create_a_Client() {
		
		
	}

}
