package gr.hua.dit.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.entity.Forms;

@Repository
public class FormsDAOImpl implements FormsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Forms> getForms() {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query
				Query<Forms> query = currentSession.createQuery("from Forms order by Am", Forms.class);

				// execute the query and get the results list
				List<Forms> forms = query.getResultList();

				// return the results
				return forms;
	}

	@Override
	public void saveForm(Forms forms) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the form
		currentSession.save(forms);
		
	}

	@Override
	public Forms getForm(int Am) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// get and return Form
				Forms forms = currentSession.get(Forms.class, Am);
				return forms;
	}

	@Override
	public void deleteForm(int Am) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				
				// find the form
				Forms forms = currentSession.get(Forms.class,Am);
				// delete form
				currentSession.delete(forms);
		
	}

}
