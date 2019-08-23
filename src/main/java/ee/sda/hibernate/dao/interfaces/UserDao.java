package ee.sda.hibernate.dao.interfaces;

import java.util.List;

import ee.sda.hibernate.entities.User;

public interface UserDao extends Dao<User,Long>{

	public List<User> findByFirstName(String firstName);
}
