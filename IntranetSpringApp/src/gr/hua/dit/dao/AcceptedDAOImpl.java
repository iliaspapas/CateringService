package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Accepted;
import gr.hua.dit.entity.Forms;

@Repository
public class AcceptedDAOImpl implements AcceptedDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Accepted> getAccepted() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Accepted> query = currentSession.createQuery("from Accepted order by Score", Accepted.class);

		// execute the query and get the results list
		List<Accepted> accepted = query.getResultList();

		// return the results
		return accepted;
	}

	@Override
	public void saveAccepted(Accepted accepted) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// save the form
				currentSession.save(accepted);

	}

	@Override
	public Accepted getAccepted(int am) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Accepted
		Accepted accepted = currentSession.get(Accepted.class, am);
		return accepted;
	}

	@Override
	public void deleteAccepted(int am) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		
		// find the accepted
		Accepted accepted = currentSession.get(Accepted.class,am);
		// delete accepted
		currentSession.delete(accepted);

	}

}
