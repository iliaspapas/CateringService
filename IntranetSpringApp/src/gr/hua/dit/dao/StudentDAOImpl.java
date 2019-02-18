package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Student> query = currentSession.createQuery("from Student order by Username", Student.class);

		// execute the query and get the results list
		List<Student> student = query.getResultList();

		// return the results
		return student;
	}

	@Override
	public Student getStudent(int username) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return student
		Student student = currentSession.get(Student.class, username);
		return student;
	}

	@Override
	public void deleteStudent(int username) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the student
		Student student = currentSession.get(Student.class, username);
		// delete student
		currentSession.delete(student);

	}

	@Override
	public void saveStudent(Student student) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the student
		currentSession.save(student);

	}

	@Override
	public void updateStudent(Student student) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//update student
		currentSession.saveOrUpdate(student);

	}

}
