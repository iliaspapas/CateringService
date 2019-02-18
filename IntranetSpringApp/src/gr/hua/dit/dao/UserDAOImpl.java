package gr.hua.dit.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import gr.hua.dit.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(user);

	}

	@Override
	public List<User> getUser() {
				// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query
				Query<User> query = currentSession.createQuery("from User order by username", User.class);

				// execute the query and get the results list
				List<User> user = query.getResultList();

				// return the results
				return user;
	}

	@Override
	public void saveRole(User user, String role) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				NativeQuery sql = currentSession.createNativeQuery("INSERT INTO authorities(username,authority) VALUES('"
						+ user.getUsername() + "', '" + role + "')");
				sql.executeUpdate();

	}

	@Override
	public User getUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return User
		User user = currentSession.get(User.class, username);
		return user;
	}

}
