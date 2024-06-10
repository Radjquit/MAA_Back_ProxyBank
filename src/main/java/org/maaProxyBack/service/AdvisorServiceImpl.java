package org.maaProxyBack.service;

import java.util.List;
import java.util.Optional;

import org.maaProxyBack.model.Advisor;
import org.maaProxyBack.persistance.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvisorServiceImpl implements AdvisorService {
	AdvisorRepository dao;
	
	private AdvisorServiceImpl(AdvisorRepository dao) {
		this.dao = dao;
	}

	@Override
	public List<Advisor> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Advisor> getById(long id) {
		return dao.findById(id);
	}

	@Override
	public Advisor update(Advisor advisor) {
		return dao.save(advisor);
	}

	@Override
	public Advisor save(Advisor advisor) {
		return dao.save(advisor);
	}

	@Override
	public void deleteById(long id) {
		dao.deleteById(id);
		
	}

}
