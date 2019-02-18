package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.AcceptedDAO;
import gr.hua.dit.entity.Accepted;

@Service
public class AcceptedServiceImpl implements AcceptedService {

	
	@Autowired
	private AcceptedDAO acceptedDAO;
	
	@Override
	@Transactional
	public List<Accepted> getAccepted() {
		return acceptedDAO.getAccepted();
	}

	@Override
	@Transactional
	public void saveAccepted(Accepted accepted) {
		acceptedDAO.saveAccepted(accepted);

	}

	@Override
	@Transactional
	public Accepted getAccepted(int am) {
		return acceptedDAO.getAccepted(am);
	}

	@Override
	@Transactional
	public void deleteAccepted(int am) {
		acceptedDAO.deleteAccepted(am);

	}

}
