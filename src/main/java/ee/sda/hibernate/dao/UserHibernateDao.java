package ee.sda.hibernate.dao;

import java.util.List;

import ee.sda.hibernate.dao.interfaces.UserDao;
import ee.sda.hibernate.entities.User;

public class UserHibernateDao extends AbstractDao<User,Long> implements UserDao {

	public List<User> findByFirstName(String firstName) {
		//add implementation here...
		return null;
	}


}
